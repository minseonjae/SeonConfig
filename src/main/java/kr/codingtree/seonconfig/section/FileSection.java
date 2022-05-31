package kr.codingtree.seonconfig.section;

import java.io.File;
import java.util.HashMap;

public interface FileSection {

    void load(File file);
    void save(File file);

    String saveToString();
    HashMap<String, Object> stringToMap(String mapString);
}
