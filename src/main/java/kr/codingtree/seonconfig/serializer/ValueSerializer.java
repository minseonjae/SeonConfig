package kr.codingtree.seonconfig.serializer;

import java.lang.reflect.ParameterizedType;

public abstract class ValueSerializer<T> {

    public abstract String serializer(T value);
    public abstract T deserializer(String value);

    public final Class getGenericClass() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
