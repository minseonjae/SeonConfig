package kr.codingtree.seonconfig.section;

public interface CheckSection {

    boolean isList(String key);
    boolean isInt(String key);
    boolean isLong(String key);
    boolean isFloat(String key);
    boolean isDouble(String key);

}
