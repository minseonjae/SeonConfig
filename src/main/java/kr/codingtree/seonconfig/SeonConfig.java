package kr.codingtree.seonconfig;

import kr.codingtree.seonconfig.annotation.ConfigExclude;
import kr.codingtree.seonconfig.annotation.ConfigName;
import kr.codingtree.seonconfig.serializer.Serializers;
import kr.codingtree.seonconfig.serializer.ValueSerializer;
import lombok.SneakyThrows;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class SeonConfig {

    @SneakyThrows(Exception.class)
    public SeonConfig(Object clazz, Class<? extends FileConfig> fileConfig) {
        if (clazz instanceof Class) {
            data = ((Class<?>) clazz).newInstance();
        } else data = clazz;

        config = fileConfig.newInstance();

        for (Field field : data.getClass().getDeclaredFields()) {
            if (field.getAnnotation(ConfigExclude.class) == null) {
                field.setAccessible(true);

                Object value = serializer(field, data);

                if (value != null) {
                    ConfigName configName = field.getAnnotation(ConfigName.class);

                    config.addDefault(configName != null ? configName.value() : field.getName(), value);
                }
            }
        }
    }

    private FileConfig config;
    private Object data;

    @SneakyThrows(Exception.class)
    public void load(File file) {
        config.load(file);

        for (Field field : data.getClass().getDeclaredFields()) {
            if (field.getAnnotation(ConfigExclude.class) == null) {
                field.setAccessible(true);

                Object value = field.get(data);

                ConfigName configName = field.getAnnotation(ConfigName.class);

                if (value instanceof Map) {
                    Type type = field.getGenericType();

                    if (type instanceof ParameterizedType) {
                        Type[] types = ((ParameterizedType) type).getActualTypeArguments();

                        if (types.length == 2) {
                            ValueSerializer keySerializer = Serializers.getSerializer(types[0]),
                                    valueSerializer = Serializers.getSerializer(types[1]);

                            if ((keySerializer == null && !isDefaultClass(types[0].getTypeName())) || (valueSerializer == null && !isDefaultClass(types[1].getTypeName()))) {
                                continue;
                            }

                            Map<String, Object> configData = config.getMap(configName == null ? field.getName() : configName.value());
                            Map map = (Map) value.getClass().newInstance();

                            for (Map.Entry<String, Object> entry : configData.entrySet()) {
                                map.put(
                                        keySerializer == null ? entry.getKey() : keySerializer.deserializer(entry.getKey()),
                                        valueSerializer == null ? entry.getValue() : valueSerializer.deserializer(entry.getValue().toString())
                                );
                            }
                        }
                    }
                } else if (value instanceof Collection) {
                    Type type = field.getGenericType();

                    if (type instanceof ParameterizedType) {
                        Type[] types = ((ParameterizedType) type).getActualTypeArguments();

                        if (types.length == 1) {
                            ValueSerializer serializer = Serializers.getSerializer(types[0]);

                            if (serializer == null && !isDefaultClass(types[0].getTypeName())) {
                                continue;
                            }

                            Collection<String> configData = config.getStringList(configName == null ? field.getName() : configName.value());
                            Collection list = (Collection) value.getClass().newInstance();

                            for (Object fv : configData) {
                                list.add(serializer == null ? fv.toString() : serializer.deserializer(fv.toString()));
                            }

                            field.set(data, list);
                        }
                    }
                } else {
                    ValueSerializer serializer = Serializers.getSerializer(value);

                    if (serializer == null && !isDefaultClass(value.getClass().getPackage().getName())) {
                        continue;
                    }

                    Object configData = config.get(configName == null ? field.getName() : configName.value());

                    field.set(data, serializer == null ? configData : serializer.deserializer(configData.toString()));
                }
            }
        }
    }
    public void save(File file) {
        for (Field field : data.getClass().getDeclaredFields()) {
            if (field.getAnnotation(ConfigExclude.class) == null) {
                field.setAccessible(true);
                Object value = serializer(field, data);

                if (value != null) {
                    ConfigName configName = field.getAnnotation(ConfigName.class);

                    config.set(configName != null ? configName.value() : field.getName(), value);
                }
            }
        }

        config.save(file);
    }

    @SneakyThrows(Exception.class)
    private Object serializer(Field field, Object clazz) {
        Object value = field.get(clazz);

        if (value instanceof Map) {
            Type type = field.getGenericType();

            if (type instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) type).getActualTypeArguments();

                if (types.length == 2) {
                    ValueSerializer keySerializer = Serializers.getSerializer(types[0]),
                            valueSerializer = Serializers.getSerializer(types[1]);

                    if (isDefaultClass(types[0].getTypeName()) && isDefaultClass(types[1].getTypeName())) {
                        return value;
                    } else if ((keySerializer == null && !isDefaultClass(types[0].getTypeName())) || (valueSerializer == null && !isDefaultClass(types[1].getTypeName()))) {
                        return null;
                    }

                    Map map = (Map) value;
                    LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

                    for (Object fv : map.entrySet()) {
                        Map.Entry entry = (Map.Entry) fv;
                        dataMap.put(
                                keySerializer == null ? entry.getKey().toString() : keySerializer.serializer(entry.getKey()),
                                valueSerializer == null ? entry.getValue().toString() : valueSerializer.serializer(entry.getValue())
                        );
                    }

                    return dataMap;
                }
            }
        } else if (value instanceof Collection) {
            Type type = field.getGenericType();

            if (type instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) type).getActualTypeArguments();

                if (types.length == 1) {
                    ValueSerializer serializer = Serializers.getSerializer(types[0]);

                    if (serializer == null && !isDefaultClass(types[0].getTypeName())) {
                        return null;
                    }

                    Collection collection = (Collection) value;
                    ArrayList<String> list = new ArrayList<>();

                    for (Object fv : collection) {
                        list.add(serializer == null ? fv.toString() : serializer.serializer(fv));
                    }

                    return list;
                }
            }
        } else if (Serializers.isRegistered(value)) {
            return Serializers.getSerializer(value).serializer(value);
        }
        return isDefaultClass(value.getClass().getPackage().getName()) ? value : null;
    }

    private boolean isDefaultClass(String name) {
        return name.startsWith("java.lang");
    }
}