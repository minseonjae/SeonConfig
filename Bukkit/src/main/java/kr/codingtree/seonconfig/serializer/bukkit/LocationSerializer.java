package kr.codingtree.seonconfig.serializer.bukkit;

import kr.codingtree.seonconfig.serializer.ValueSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationSerializer extends ValueSerializer<Location> {

    @Override
    public String serializer(Location value) {
        return value.getWorld().getName() + ", "
                + (Math.round(value.getX() * 1000) / 1000) + ", "
                + (Math.round(value.getY() * 1000) / 1000) + ", "
                + (Math.round(value.getZ() * 1000) / 1000)
                + (value.getYaw() != 0 && value.getPitch() != 0 ? (", " + (Math.round(value.getYaw() * 1000) / 1000) + ", " + (Math.round(value.getPitch() * 1000) / 1000)) : "");
    }

    @Override
    public Location deserializer(String value) {
        String[] l = value.split(", ");
        if (l.length == 4)
            return new Location(Bukkit.getWorld(l[0]), Double.parseDouble(l[1]), Double.parseDouble(l[2]), Double.parseDouble(l[3]));
        else if (l.length == 6)
            return new Location(Bukkit.getWorld(l[0]), Double.parseDouble(l[1]), Double.parseDouble(l[2]), Double.parseDouble(l[3]), Float.parseFloat(l[4]), Float.parseFloat(l[5]));
        return null;
    }
}
