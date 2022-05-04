package kr.codingtree.seonconfig.section;

import java.util.List;
import java.util.Map;

public interface ConfigSection {

    List<String> getKeys();
    List<String> getKeys(String key);

    void set(String key, Object value);
    void addAll(Map<String, Object> map);

    boolean contains(String key);

    boolean isList(String key);
    boolean isString(String key);
    boolean isBoolean(String key);
    boolean isShort(String key);
    boolean isInt(String key);
    boolean isLong(String key);
    boolean isFloat(String key);
    boolean isDouble(String key);

    Object get(String key);
    String getString(String key);
    boolean getBoolean(String key);
    short getShort(String key);
    int getInt(String key);
    long getLong(String key);
    float getFloat(String key);
    double getDouble(String key);

    List<?> getList(String key);
    List<String> getStringList(String key);
    List<Boolean> getBooleanList(String key);
    List<Short> getShortList(String key);
    List<Integer> getIntegerList(String key);
    List<Long> getLongList(String key);
    List<Float> getFloatList(String key);
    List<Double> getDoubleList(String key);

    Object get(String key, Object def);
    String getString(String key, String def);
    boolean getBoolean(String key, boolean def);
    short getShort(String key, short def);
    int getInt(String key, int def);
    long getLong(String key, long def);
    float getFloat(String key, float def);
    double getDouble(String key, double def);

    List<?> getList(String key, List<?> def);
    List<String> getStringList(String key, List<String> def);
    List<Boolean> getBooleanList(String key, List<Boolean> def);
    List<Short> getShortList(String key, List<Short> def);
    List<Integer> getIntegerList(String key, List<Integer> def);
    List<Long> getLongList(String key, List<Long> def);
    List<Float> getFloatList(String key, List<Float> def);
    List<Double> getDoubleList(String key, List<Double> def);

    String saveToString();
}
