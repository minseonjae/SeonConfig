package kr.codingtree.seonconfig.serializer.bukkit;

import kr.codingtree.seonconfig.serializer.Serializers;
import kr.codingtree.seonconfig.serializer.ValueSerializer;

public class BukkitSerializerRegisterer {

    public static void registerSerializer() {
        register(new ItemStackSerializer());
        register(new LocationSerializer());
    }

    private static void register(ValueSerializer serializer) {
        Serializers.register(serializer);
    }

}
