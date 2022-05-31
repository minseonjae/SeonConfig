package kr.codingtree.seonconfig.section;

public interface GetSection {

    Object get(String key);
    Object get(String key, Object def);

    String getString(String key, String def);
    String getString(String key);

    boolean getBoolean(String key, boolean def);
    boolean getBoolean(String key);

    int getInt(String key, int def);
    int getInt(String key);

    long getLong(String key, long def);
    long getLong(String key);

    float getFloat(String key, float def);
    float getFloat(String key);

    double getDouble(String key, double def);
    double getDouble(String key);

}
