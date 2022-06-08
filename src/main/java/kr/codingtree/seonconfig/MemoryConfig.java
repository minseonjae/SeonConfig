package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.section.*;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public abstract class MemoryConfig extends DefaultConfig implements ConfigSection, GetSection, CheckSection, ListSection, MapSection {

    @Getter
    protected HashMap<String, Object> values = new LinkedHashMap<>();

    @Override
    public void set(String key, Object value) {
        if (key == null || key.length() < 1) {
            throw new NullPointerException("key is marked non-null but is null");
        }

        Iterator<String> iterator = values.keySet().iterator();

        while (iterator.hasNext()) {
            String ikey = iterator.next();

            if (ikey.startsWith(key + ".")) {
                iterator.remove();
            }
        }

        values.put(key, value);
    }
    @Override
    public void addAll(Map<String, Object> map) {
        map.forEach((key, value) -> set(key, value));
    }

    @Override
    public boolean contains(String key) {
        if (key == null || key.length() < 1) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        return values.containsKey(key);
    }

    @Override
    public List<String> getKeys() {
        ArrayList<String> list = new ArrayList<>();

        Iterator<String> iterator = values.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();

            if (!key.contains(".") && !list.contains(key)) {
                list.add(key);
            }
        }

        return list;
    }
    @Override
    public List<String> getKeys(String key) {
        if (key == null || key.length() < 1) {
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
    public Object get(String key) {
        if (key == null || key.length() < 1) {
            throw new NullPointerException("key is marked non-null but is null");
        }

        return values.get(key);
    }
    @Override
    public Object get(String key, Object def) {
        if (key == null || key.length() < 1) {
            throw new NullPointerException("key is marked non-null but is null");
        }

        return values.getOrDefault(key, def);
    }

    @Override
    public String getString(String key, String def) {
        Object value = get(key);
        return value == null ? def : value.toString();
    }
    @Override
    public String getString(String key) {
        Object value = getDefault(key);
        return getString(key, value == null ? null : value.toString());
    }

    @Override
    public boolean getBoolean(String key, boolean def) {
        Object value = get(key);
        return value == null ? def : Boolean.parseBoolean(value.toString());
    }
    @Override
    public boolean getBoolean(String key) {
        Object value = getDefault(key);
        return getBoolean(key, value == null ? false : Boolean.parseBoolean(value.toString()));
    }

    @Override
    public int getInt(String key, int def) {
        Integer value = modifyInteger(get(key));
        return value != null ? value : 0;
    }
    @Override
    public int getInt(String key) {
        Integer value = modifyInteger(getDefault(key));
        return getInt(key, value != null ? value : 0);
    }

    @Override
    public long getLong(String key, long def) {
        Long value = modifyLong(get(key));
        return value != null ? value : 0;
    }
    @Override
    public long getLong(String key) {
        Long value = modifyLong(getDefault(key));
        return getLong(key, value != null ? value : 0);
    }

    @Override
    public float getFloat(String key, float def) {
        Float value = modifyFloat(get(key));
        return value != null ? value : 0;
    }
    @Override
    public float getFloat(String key) {
        Float value = modifyFloat(getDefault(key));
        return getFloat(key, value != null ? value : 0);
    }

    @Override
    public double getDouble(String key, double def) {
        Double value = modifyDouble(get(key));
        return value != null ? value : 0;
    }
    @Override
    public double getDouble(String key) {
        Double value = modifyDouble(getDefault(key));
        return getDouble(key, value != null ? value : 0);
    }

    @Override
    public boolean isList(String key) {
        Object value = get(key);
        return value != null && value instanceof List;
    }
    @Override
    public boolean isInt(String key) {
        return modifyInteger(get(key)) != null;
    }
    @Override
    public boolean isLong(String key) {
        return modifyLong(get(key)) != null;
    }
    @Override
    public boolean isFloat(String key) {
        return modifyFloat(get(key)) != null;
    }
    @Override
    public boolean isDouble(String key) {
        return modifyDouble(get(key)) != null;
    }

    @Override
    public List getList(String key, List def) {
        Object value = get(key);
        return value != null && value instanceof List ? (List) value : def;
    }
    @Override
    public List getList(String key) {
        Object value = getDefault(key);
        return getList(key, value != null && value instanceof List ? (List) value : new ArrayList<>());
    }

    @Override
    public List<String> getStringList(String key, List<String> def) {
        Object value = get(key);
        return value != null && value instanceof List ? ((List<?>) value).stream().map(o -> o.toString()).collect(Collectors.toList()) : def;
    }
    @Override
    public List<String> getStringList(String key) {
        List<?> value = getList(key);
        return value.stream().map(o -> o.toString()).collect(Collectors.toList());
    }

    @Override
    public List<Boolean> getBooleanList(String key, List<Boolean> def) {
        Object value = get(key);
        return value != null && value instanceof List ? ((List<?>) value).stream().map(o -> Boolean.parseBoolean(o.toString())).collect(Collectors.toList()) : def;
    }
    @Override
    public List<Boolean> getBooleanList(String key) {
        List<?> value = getList(key);
        return value.stream().map(o -> Boolean.parseBoolean(o.toString())).collect(Collectors.toList());
    }

    @Override
    public List<Integer> getIntegerList(String key, List<Integer> def) {
        Object value = get(key);

        if (value != null && value instanceof List) {
            ArrayList<Integer> list = new ArrayList<>();

            Iterator<?> iterator = ((List<?>) value).iterator();
            while (iterator.hasNext()) {
                Integer i = modifyInteger(iterator.next());

                if (i != null) {
                    list.add(i);
                }
            }
            return list;
        }
        return def;
    }
    @Override
    public List<Integer> getIntegerList(String key) {
        List<?> value = getList(key);
        ArrayList<Integer> list = new ArrayList<>();

        Iterator<?> iterator = ((List<?>) value).iterator();
        while (iterator.hasNext()) {
            Integer i = modifyInteger(iterator.next());

            if (i != null) {
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public List<Long> getLongList(String key, List<Long> def) {
        Object value = get(key);

        if (value != null && value instanceof List) {
            ArrayList<Long> list = new ArrayList<>();

            Iterator<?> iterator = ((List<?>) value).iterator();
            while (iterator.hasNext()) {
                Long l = modifyLong(iterator.next());

                if (l != null) {
                    list.add(l);
                }
            }
            return list;
        }
        return def;
    }
    @Override
    public List<Long> getLongList(String key) {
        List<?> value = getList(key);
        ArrayList<Long> list = new ArrayList<>();

        Iterator<?> iterator = ((List<?>) value).iterator();
        while (iterator.hasNext()) {
            Long l = modifyLong(iterator.next());

            if (l != null) {
                list.add(l);
            }
        }
        return list;
    }

    @Override
    public List<Float> getFloatList(String key, List<Float> def) {
        Object value = get(key);

        if (value != null && value instanceof List) {
            ArrayList<Float> list = new ArrayList<>();

            Iterator<?> iterator = ((List<?>) value).iterator();
            while (iterator.hasNext()) {
                Float f = modifyFloat(iterator.next());

                if (f != null) {
                    list.add(f);
                }
            }
            return list;
        }
        return def;
    }
    @Override
    public List<Float> getFloatList(String key) {
        List<?> value = getList(key);
        ArrayList<Float> list = new ArrayList<>();

        Iterator<?> iterator = ((List<?>) value).iterator();
        while (iterator.hasNext()) {
            Float f = modifyFloat(iterator.next());

            if (f != null) {
                list.add(f);
            }
        }
        return list;
    }

    @Override
    public List<Double> getDoubleList(String key, List<Double> def) {
        Object value = get(key);

        if (value != null && value instanceof List) {
            ArrayList<Double> list = new ArrayList<>();

            Iterator<?> iterator = ((List<?>) value).iterator();
            while (iterator.hasNext()) {
                Double d = modifyDouble(iterator.next());

                if (d != null) {
                    list.add(d);
                }
            }
            return list;
        }
        return def;
    }
    @Override
    public List<Double> getDoubleList(String key) {
        List<?> value = getList(key);
        ArrayList<Double> list = new ArrayList<>();

        Iterator<?> iterator = ((List<?>) value).iterator();
        while (iterator.hasNext()) {
            Double f = modifyDouble(iterator.next());

            if (f != null) {
                list.add(f);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> getMap(String key, Map<String, Object> def) {
        HashMap<String, Object> map = organizedMap(values);
        Object value = null;

        if (key.contains(".")) {
            String[] keySplit = key.split("\\.");

            int i = 0;
            while (i < keySplit.length - 1) {
                value = map.get(keySplit[i]);

                if (value != null && value instanceof Map) {
                    map = (HashMap<String, Object>) value;
                } else {
                    break;
                }
                i++;
            }

            if (i == keySplit.length - 1) {
                value = map.get(keySplit[keySplit.length - 1]);
            }
        } else {
            value = map.get(key);
        }
        return value != null && value instanceof Map ? (Map<String, Object>) value : def;
    }
    @Override
    public Map<String, Object> getMap(String key) {
        Object value = getDefault(key);
        return getMap(key, value != null && value instanceof Map ? (Map) value : new LinkedHashMap());
    }

    protected HashMap<String, Object> addDefaultValues(HashMap<String, Object> originalMap) {
        HashMap<String, Object> map = new LinkedHashMap<>(originalMap);

        defaults.forEach((key, value) -> {
            if (!originalMap.containsKey(key)) {
                map.put(key, value);
            }
        });

        return map;
    }

    protected HashMap<String, Object> organizedMap(HashMap<String, Object> originalMap) {
        HashMap<String, Object> map = new LinkedHashMap<>();

        originalMap.forEach((key, value) -> {
            if (key.contains(".")) {
                String[] keySplit = key.split("\\.");

                HashMap<String, Object> parent = null, child = null;

                for (int i = 0; i < keySplit.length; i++) {
                    String childName = keySplit[i];
                    Object childObject = i < 1 ? map.get(childName) : child.get(childName);

                    if (i < 1) {
                        parent = (childObject == null ? new LinkedHashMap<>() : (HashMap<String, Object>) childObject);
                        child = parent;
                    } else if (i >= keySplit.length - 1) {
                        child.put(childName, value);
                        map.put(keySplit[0], parent);
                    } else if (childObject instanceof HashMap || childObject == null) {
                        HashMap<String, Object> tempChild = (childObject == null ? new LinkedHashMap<>() : (HashMap<String, Object>) childObject);
                        child.put(childName, child = tempChild);
                    }
                }
            } else {
                map.put(key, value);
            }
        });

        return map;
    }

    private Integer modifyInteger(Object value) {
        if (value == null) return null;
        try {
            return Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }
    private Long modifyLong(Object value) {
        if (value == null) return null;
        try {
            return Long.parseLong(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }
    private Float modifyFloat(Object value) {
        if (value == null) return null;
        try {
            return Float.parseFloat(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }
    private Double modifyDouble(Object value) {
        if (value == null) return null;
        try {
            return Double.parseDouble(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
