package kr.codingtree.seonconfig.section;

import java.util.Map;

public interface DefaultSection {

    void addDefault(String key, Object value);
    void addDefaults(Map<String, Object> map);

    Map<String, Object> getDefaults();

    boolean isDefault(String key);

    void clearDefaults();

}
