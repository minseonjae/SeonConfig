package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.FileSection;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class FileConfig extends MemoryConfig implements FileSection {

    @SneakyThrows(IOException.class)
    private void createFile(File file) {
        if (!file.exists()) {
            new File(file.getPath().substring(0, file.getPath().lastIndexOf("\\"))).mkdirs();
            file.createNewFile();
        }
    }

    @Override
    @SneakyThrows(IOException.class)
    public void load(File file) {
        createFile(file);

        @Cleanup FileInputStream fis = new FileInputStream(file);
        @Cleanup InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        @Cleanup BufferedReader br = new BufferedReader(isr);

        StringWriter writer = new StringWriter();

        String line;
        while ((line = br.readLine()) != null) writer.write(line);

        values.clear();

        HashMap<String, Object> map = stringToMap(writer.toString());

        valuesToDot(null, values, map);
    }

    @Override
    @SneakyThrows(IOException.class)
    public void save(File file) {
        createFile(file);

        @Cleanup FileOutputStream fos = new FileOutputStream(file);
        @Cleanup OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        @Cleanup BufferedWriter bw = new BufferedWriter(osw);

        bw.write(saveToString());
    }

    private void valuesToDot(String parentKey, Map<String, Object> values, Map<String, Object> loadValues) {
        loadValues.forEach((key, value) -> {
            String pkey;

            if (parentKey == null) {
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

    protected HashMap<String, Object> organizedMap(HashMap<String, Object> originalMap) {
        HashMap<String, Object> map = new LinkedHashMap<>();

        originalMap.forEach((key, value) -> {
            if (key.contains(".")) {
                String[] keySplit = key.split("\\.");
                HashMap<String, Object> parent = null,
                        child = null;

                for (int i = 0; i < keySplit.length; i++) {
                    String childName = keySplit[i];
                    Object childObject = i < 1 ? originalMap.get(childName) : child.get(childName);

                    if (i < 1) {
                        if (childObject instanceof HashMap || childObject == null) {
                            parent = childObject == null ? new LinkedHashMap<>() : (HashMap<String, Object>) childObject;
                            child = parent;
                        } else {
                            break;
                        }
                    } else if (i == keySplit.length - 1) {
                        child.put(childName, value);
                        map.put(keySplit[0], parent);
                    } else if (childObject instanceof HashMap || childObject == null) {
                        HashMap<String, Object> tempChild = childObject == null ? new LinkedHashMap<>() : (HashMap<String, Object>) childObject;
                        child.put(childName, child = tempChild);
                    }
                }
            } else {
                map.put(key, value);
            }
        });

        return map;
    }

    @Override
    public abstract String saveToString();

    @Override
    public abstract HashMap<String, Object> stringToMap(String mapString);
}
