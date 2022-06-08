package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.FileSection;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class FileConfig extends MemoryConfig implements FileSection {

    @Override
    @SneakyThrows(IOException.class)
    public void load(File file) {
        if (!file.exists()) {
            save(file);
        }

        @Cleanup FileInputStream fis = new FileInputStream(file);
        @Cleanup InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        @Cleanup BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) sb.append(line + "\n");

        values.clear();

        HashMap<String, Object> map = stringToMap(sb.toString());

        valuesToDot(null, values, map);

        if (defaults.size() > 0) save(file);
    }

    @Override
    @SneakyThrows(IOException.class)
    public void save(File file) {
        if (!file.exists()) {
            if (file.getPath().contains("\\")) new File(file.getPath().substring(0, file.getPath().lastIndexOf("\\"))).mkdirs();
            file.createNewFile();
        }

        @Cleanup FileOutputStream fos = new FileOutputStream(file);
        @Cleanup OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        @Cleanup BufferedWriter bw = new BufferedWriter(osw);

        bw.write(saveToString());
    }

    private void valuesToDot(String parentKey, Map<String, Object> values, Map<String, Object> loadValues) {
        loadValues.forEach((key, value) -> {
            String pkey;

            if (parentKey != null) {
                pkey = parentKey + "." + key;
            } else {
                pkey = key;
            }

            if (value instanceof Map) {
                valuesToDot(pkey, values, (Map<String, Object>) value);
            } else {
                values.put(pkey, value);
            }
        });
    }

    @Override
    public abstract String saveToString();

    @Override
    public abstract HashMap<String, Object> stringToMap(String mapString);
}
