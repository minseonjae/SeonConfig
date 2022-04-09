package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.DefaultSection;
import lombok.NonNull;

import java.util.LinkedHashMap;
import java.util.Map;


public class DefaultConfig implements DefaultSection {

    private LinkedHashMap<String, Object> defaults = new LinkedHashMap<>();

    @Override
    public void addDefault(@NonNull String key, Object value) {
        String[] keys = key.split("\\.");
        LinkedHashMap<String, Object> map = defaults;

        for (int i = 0; i < keys.length - 1; i++) {
            Object obj = map.get(keys[i]);

            if (obj instanceof LinkedHashMap) {
                map = (LinkedHashMap) obj;
            } else {
                map.put(keys[i], map = new LinkedHashMap<>());
            }
        }
        map.put(keys[keys.length - 1], value);
    }

    @Override
    public void addDefaults(Map<String, Object> map) {
        defaults.putAll(map);
    }

    @Override
    public Map<String, Object> getDefaults() {
        return defaults;
    }

    @Override
    public boolean isDefault(String key) {
        String[] keys = key.split("\\.");
        LinkedHashMap<String, Object> map = defaults;

        for (int i = 0; i < keys.length - 1; i++) {
            Object obj = map.get(keys[i]);

            if (obj instanceof LinkedHashMap) {
                map = (LinkedHashMap) obj;
            } else {
                return false;
            }
        }
        return map.containsKey(keys[keys.length - 1]);
    }

    @Override
    public void clearDefaults() {
        defaults.clear();
    }
}
