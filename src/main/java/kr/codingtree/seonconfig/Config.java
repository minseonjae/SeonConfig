package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.ConfigSection;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Config implements ConfigSection {

    private LinkedHashMap<String, Object> dataMap = new LinkedHashMap<>();

    @Override
    public void set(String key, Object value) {
        String[] keys = key.split("\\.");
        LinkedHashMap<String, Object> map = dataMap;

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
    public void set(Map<String, Object> map) {
        dataMap.putAll(map);
    }

    @Override
    public boolean contains(String key) {
        String[] keys = key.split("\\.");
        LinkedHashMap<String, Object> map = dataMap;

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
    public void clear() {
        dataMap.clear();
    }

    @Override
    public void load(File file) {

    }

    @Override
    public void save(File file) {

    }

    @Override
    public String saveToString() {
        return null;
    }

    @Override
    public Set<String> getKeys() {
        return dataMap.keySet();
    }

    @Override
    public Set<String> getKeys(String key) {
        if (key.contains(".")) {
            String[] keys = key.split("\\.");
            LinkedHashMap<String, Object> map = dataMap;

            for (int i = 0; i < keys.length - 1; i++) {
                Object obj = map.get(keys[i]);

                if (obj instanceof LinkedHashMap) {
                    map = (LinkedHashMap) obj;
                } else {
                    return false;
                }
            }
            return map.containsKey(keys[keys.length - 1]);
        } else {
            return getKeys();
        }
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public List<?> getList(String key) {
        return null;
    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public List<String> getStringList(String key) {
        return null;
    }

    @Override
    public Integer getInt(String key) {
        return null;
    }

    @Override
    public List<Integer> getIntegerList(String key) {
        return null;
    }

    @Override
    public Long getLong(String key) {
        return null;
    }

    @Override
    public List<Long> getLongList(String key) {
        return null;
    }

    @Override
    public Short getShort(String key) {
        return null;
    }

    @Override
    public List<Short> getShortList(String key) {
        return null;
    }

    @Override
    public Float getFloat(String key) {
        return null;
    }

    @Override
    public List<Float> getFloatList(String key) {
        return null;
    }

    @Override
    public Double getDouble(String key) {
        return null;
    }

    @Override
    public List<Double> getDoubleList(String key) {
        return null;
    }

}
