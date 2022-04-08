package kr.codingtree.seonconfig.section;

import java.io.File;
import java.util.Map;

public interface ConfigSection extends CheckSection {

    void set(String key, Object value);
    void set(Map<String, Object> map);

    boolean contains(String key);

    void clear();

    void load(File file);
    void save(File file);

    String saveToString();

}
