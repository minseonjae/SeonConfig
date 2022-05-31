package kr.codingtree.seonconfig.section;

import java.util.List;
import java.util.Map;

public interface ConfigSection {

    void set(String key, Object value);
    void addAll(Map<String, Object> map);

    boolean contains(String key);

    List<String> getKeys();
    List<String> getKeys(String key);

}
