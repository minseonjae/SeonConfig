package kr.codingtree.seonconfig.section;

import java.io.File;

public interface FileSection {

    void load(File file);
    void save(File file);

    String saveToString();

}
