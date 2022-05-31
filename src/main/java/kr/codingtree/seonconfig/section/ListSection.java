package kr.codingtree.seonconfig.section;

import java.util.List;

public interface ListSection {

    List<?> getList(String key, List<?> def);
    List<?> getList(String key);

    List<String> getStringList(String key, List<String> def);
    List<String> getStringList(String key);

    List<Boolean> getBooleanList(String key, List<Boolean> def);
    List<Boolean> getBooleanList(String key);

    List<Integer> getIntegerList(String key, List<Integer> def);
    List<Integer> getIntegerList(String key);

    List<Long> getLongList(String key, List<Long> def);
    List<Long> getLongList(String key);

    List<Float> getFloatList(String key, List<Float> def);
    List<Float> getFloatList(String key);

    List<Double> getDoubleList(String key, List<Double> def);
    List<Double> getDoubleList(String key);

}
