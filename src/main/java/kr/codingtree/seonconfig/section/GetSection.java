package kr.codingtree.seonconfig.section;

import java.util.List;
import java.util.Set;

public interface GetSection {

    Set<String> getKeys();
    Set<String> getKeys(String key);

    Object get(String key);
    List<?> getList(String key);

    String getString(String key);
    List<String> getStringList(String key);

    Integer getInt(String key);
    List<Integer> getIntegerList(String key);

    Long getLong(String key);
    List<Long> getLongList(String key);

    Short getShort(String key);
    List<Short> getShortList(String key);

    Float getFloat(String key);
    List<Float> getFloatList(String key);

    Double getDouble(String key);
    List<Double> getDoubleList(String key);

    default Object get(String key, Object def) {
        Object value = get(key);
        return value != null ? value : def;
    }
    default List<?> getList(String key, List<?> def) {
        List<?> value = getList(key);
        return value != null ? value : def;
    }

    default String getString(String key, String def) {
        String value = getString(key);
        return value != null ? value : def;
    }
    default List<String> getStringList(String key, List<String> def) {
        List<String> value = getStringList(key);
        return value != null ? value : def;
    }

    default Integer getInt(String key, int def) {
        Integer value = getInt(key);
        return value != null ? value : def;
    }
    default List<Integer> getIntegerList(String key, List<Integer> def) {
        List<Integer> value = getIntegerList(key);
        return value != null ? value : def;
    }

    default Long getLong(String key, long def) {
        Long value = getLong(key);
        return value != null ? value : def;
    }
    default List<Long> getLongList(String key, List<Long> def) {
        List<Long> value = getLongList(key);
        return value != null ? value : def;
    }

    default Short getShort(String key, short def) {
        Short value = getShort(key);
        return value != null ? value : def;
    }
    default List<Short> getShortList(String key, List<Short> def) {
        List<Short> value = getShortList(key);
        return value != null ? value : def;
    }

    default Float getFloat(String key, float def) {
        Float value = getFloat(key);
        return value != null ? value : def;
    }
    default List<Float> getFloatList(String key, List<Float> def) {
        List<Float> value = getFloatList(key);
        return value != null ? value : def;
    }

    default Double getDouble(String key, double def) {
        Double value = getDouble(key);
        return value != null ? value : def;
    }
    default List<Double> getDoubleList(String key, List<Double> def) {
        List<Double> value = getDoubleList(key);
        return value != null ? value : def;
    }

}
