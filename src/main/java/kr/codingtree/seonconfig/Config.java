package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.ConfigSection;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;

public class Config extends DefaultConfig implements ConfigSection {

    @Getter
    protected HashMap<String, Object> values = new HashMap<>();

    @Override
    public List<String> getKeys() {
        ArrayList<String> list = new ArrayList<>();

        Iterator<String> iterator = values.keySet().iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();

            if (!s.contains(".") && !list.contains(s)) {
                list.add(s);
            }

        }
        return list;
    }
    @Override
    public List<String> getKeys(String key) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }

        ArrayList<String> list = new ArrayList<>();

        Iterator<String> iterator = values.keySet().iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();

            if (s.startsWith(key + ".")) {
                s = s.substring(key.length() + 1);

                if (s.contains(".")) {
                    s = s.substring(0, s.indexOf("."));
                }
                if (!list.contains(s)) {
                    list.add(s);
                }
            }
        }
        return list;
    }

    @Override
    public void set(String key, Object value) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
    }
    @Override
    public void addAll(Map<String, Object> map) {

    }

    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }

        return false;
    }

    @Override
    public boolean isList(String key) {
        return false;
    }
    @Override
    public boolean isString(String key) {
        return false;
    }
    @Override
    public boolean isBoolean(String key) {
        return false;
    }
    @Override
    public boolean isShort(String key) {
        return false;
    }
    @Override
    public boolean isInt(String key) {
        return false;
    }
    @Override
    public boolean isLong(String key) {
        return false;
    }
    @Override
    public boolean isFloat(String key) {
        return false;
    }
    @Override
    public boolean isDouble(String key) {
        return false;
    }

    @Override
    public Object get(String key) {
        return null;
    }
    @Override
    public String getString(String key) {
        return null;
    }
    @Override
    public boolean getBoolean(String key) {
        return false;
    }
    @Override
    public short getShort(String key) {
        return 0;
    }
    @Override
    public int getInt(String key) {
        return 0;
    }
    @Override
    public long getLong(String key) {
        return 0;
    }
    @Override
    public float getFloat(String key) {
        return 0;
    }
    @Override
    public double getDouble(String key) {
        return 0;
    }

    @Override
    public List<?> getList(String key) {
        return null;
    }
    @Override
    public List<String> getStringList(String key) {
        return null;
    }
    @Override
    public List<Boolean> getBooleanList(String key) {
        return null;
    }
    @Override
    public List<Short> getShortList(String key) {
        return null;
    }
    @Override
    public List<Integer> getIntegerList(String key) {
        return null;
    }
    @Override
    public List<Long> getLongList(String key) {
        return null;
    }
    @Override
    public List<Float> getFloatList(String key) {
        return null;
    }
    @Override
    public List<Double> getDoubleList(String key) {
        return null;
    }

    @Override
    public Object get(String key, Object def) {
        return null;
    }
    @Override
    public String getString(String key, String def) {
        return null;
    }
    @Override
    public boolean getBoolean(String key, boolean def) {
        return false;
    }
    @Override
    public short getShort(String key, short def) {
        return 0;
    }
    @Override
    public int getInt(String key, int def) {
        return 0;
    }
    @Override
    public long getLong(String key, long def) {
        return 0;
    }
    @Override
    public float getFloat(String key, float def) {
        return 0;
    }
    @Override
    public double getDouble(String key, double def) {
        return 0;
    }

    @Override
    public List<?> getList(String key, List<?> def) {
        return null;
    }
    @Override
    public List<String> getStringList(String key, List<String> def) {
        return null;
    }
    @Override
    public List<Boolean> getBooleanList(String key, List<Boolean> def) {
        return null;
    }
    @Override
    public List<Short> getShortList(String key, List<Short> def) {
        return null;
    }
    @Override
    public List<Integer> getIntegerList(String key, List<Integer> def) {
        return null;
    }
    @Override
    public List<Long> getLongList(String key, List<Long> def) {
        return null;
    }
    @Override
    public List<Float> getFloatList(String key, List<Float> def) {
        return null;
    }
    @Override
    public List<Double> getDoubleList(String key, List<Double> def) {
        return null;
    }

    @Override
    public String saveToString() {
        return null;
    }
}
