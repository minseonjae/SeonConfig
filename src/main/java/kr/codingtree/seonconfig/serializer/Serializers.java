package kr.codingtree.seonconfig.serializer;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class Serializers {

    @Getter
    private ArrayList<ValueSerializer> list = new ArrayList<>();

    public boolean register(ValueSerializer<?> serializer) {
        if (isRegistered(serializer)) {
            return false;
        }
        list.add(serializer);
        return true;
    }
    public boolean unregister(Object object) {
        if (!isRegistered(object)) {
            return false;
        }
        if (!list.remove(object)) {
            for (int i = 0; i < list.size(); i++) {
                ValueSerializer serializer = list.get(i);
                if ((object instanceof Class && object.equals(serializer.getGenericClass()))
                        || object.getClass().equals(serializer.getGenericClass())) {
                    if (list.remove(serializer)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
    public boolean isRegistered(Object object) {
        if (object == null) return false;
        for (int i = 0; i < list.size(); i++) {
            ValueSerializer serializer = list.get(i);
            if ((object instanceof Class && object.equals(serializer.getGenericClass()))
                    || object.getClass().equals(serializer.getGenericClass())) {
                return true;
            }
        }
        return false;
    }

    public ValueSerializer getSerializer(Object object) {
        if (object == null) return null;
        for (int i = 0; i < list.size(); i++) {
            ValueSerializer serializer = list.get(i);
            if ((object instanceof Class && object.equals(serializer.getGenericClass()))
                    || object.getClass().equals(serializer.getGenericClass())) {
                return serializer;
            }
        }
        return null;
    }
}
