package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.DefaultSection;

import lombok.Getter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultConfig implements DefaultSection {

    @Getter
    protected HashMap<String, Object> defaults = new LinkedHashMap<>();

    public void addDefault(String key, Object value) {
        if (key == null || key.length() < 1) {
            throw new NullPointerException("key is marked non-null but is null");
        }

        Iterator<String> iterator = defaults.keySet().iterator();

        while (iterator.hasNext()) {
            String ikey = iterator.next();

            if (ikey.startsWith(key + ".")) {
                iterator.remove();
            }
        }

        defaults.put(key, value);
    }
    public void addDefaults(Map<String, Object> map) {
        map.forEach((key, value) -> addDefault(key, value));
    }

    public Object getDefault(String key) {
        return defaults.get(key);
    }

    public boolean isDefault(String key) {
        if (key == null || key.length() < 1) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        return defaults.containsKey(key);
    }

    public void clearDefaults() {
        defaults.clear();
    }

}
