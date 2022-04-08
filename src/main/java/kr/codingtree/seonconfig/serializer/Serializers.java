package kr.codingtree.seonconfig.serializer;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class Serializers {

    @Getter
    private ArrayList<ValueSerializer> list = new ArrayList<>();

    public boolean register(@NonNull ValueSerializer<?> serializer) {
        if (isRegistered(serializer)) return false;

        list.add(serializer);

        return true;
    }
    public boolean unregister(@NonNull Object object) {
        if (!isRegistered(object)) return false;

        if (!list.remove(object)) {
            for (int i = 0; i < list.size(); i++) {
                if (object.equals(list.get(i).getGenericClass()))
                    if (list.remove(list.get(i)))
                        return true;
            }
            return false;
        }

        return true;
    }
    public boolean isRegistered(Object object) {
        if (object == null) return false;
        for (int i = 0; i < list.size(); i++)
            if (object.equals(list.get(i).getGenericClass()) || object.equals(list.get(i)))
                return true;

        return false;
    }
}
