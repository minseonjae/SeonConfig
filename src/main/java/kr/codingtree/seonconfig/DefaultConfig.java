package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.DefaultSection;

import lombok.NonNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultConfig implements DefaultSection {

    private LinkedHashMap<String, Object> defaults = new LinkedHashMap<>();

    @Override
    public void addDefault(@NonNull String key, Object value) {
        defaults.put(key, value);
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
        return defaults.containsValue(key);
    }

    @Override
    public void clearDefaults() {
        defaults.clear();
    }

}
