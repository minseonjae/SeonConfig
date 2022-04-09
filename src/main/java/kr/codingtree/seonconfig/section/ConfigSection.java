package kr.codingtree.seonconfig.section;

import java.util.Map;

public interface ConfigSection extends CheckSection, FileSection {

    void set(String key, Object value);
    void set(Map<String, Object> map);

    boolean contains(String key);

    void clear();

}
