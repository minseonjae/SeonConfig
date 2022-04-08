package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.ConfigSection;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Config implements ConfigSection {

    @Override
    public void set(String key, Object value) {

    }

    @Override
    public void set(Map<String, Object> map) {

    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void load(File file) {

    }

    @Override
    public void save(File file) {

    }

    @Override
    public String saveToString() {
        return null;
    }

    @Override
    public List<String> getKeys() {
        return null;
    }

    @Override
    public List<String> getKeys(String key) {
        return null;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public List<?> getList(String key) {
        return null;
    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public List<String> getStringList(String key) {
        return null;
    }

    @Override
    public Integer getInt(String key) {
        return null;
    }

    @Override
    public List<Integer> getIntegerList(String key) {
        return null;
    }

    @Override
    public Long getLong(String key) {
        return null;
    }

    @Override
    public List<Long> getLongList(String key) {
        return null;
    }

    @Override
    public Short getShort(String key) {
        return null;
    }

    @Override
    public List<Short> getShortList(String key) {
        return null;
    }

    @Override
    public Float getFloat(String key) {
        return null;
    }

    @Override
    public List<Float> getFloatList(String key) {
        return null;
    }

    @Override
    public Double getDouble(String key) {
        return null;
    }

    @Override
    public List<Double> getDoubleList(String key) {
        return null;
    }

}
