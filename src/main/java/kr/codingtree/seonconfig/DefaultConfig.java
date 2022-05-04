package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.DefaultSection;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DefaultConfig implements DefaultSection {

    @Getter
    protected HashMap<String, Object> defaults = new HashMap<>();

    public void addDefault(String key, Object value) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }

        String pkey = key + ".";

        Iterator<String> iterator = defaults.keySet().iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();

            if (s.length() > 0 && s.startsWith(pkey)) {

            }
        }

        defaults.put(key, value);
    }
    public void addDefaults(Map<String, Object> map) {
        defaults.putAll(map);
    }

    public Object getDefault(String key) {
        return defaults.get(key);
    }

    public boolean isDefault(String key) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        return defaults.containsKey(key);
    }

    public void clearDefaults() {
        defaults.clear();
    }

}
