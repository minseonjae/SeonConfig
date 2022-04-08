package kr.codingtree.seonconfig.serializer.bukkit;

import kr.codingtree.seonconfig.serializer.ValueSerializer;

import org.bukkit.inventory.ItemStack;

public class ItemStackSerializer extends ValueSerializer<ItemStack> {

    @Override
    public String serializer(ItemStack value) {
        return (value.getDurability() != 0 ? value.getTypeId() + ":" + value.getDurability() : value.getTypeId()) + (value.getAmount() > 1 ? " " + value.getAmount() : "");
    }

    @Override
    public ItemStack deserializer(String value) {
        int typeId = 0, amount = 1;
        short durability = 0;

        if (value.contains(" ")) {
            String[] ca = value.split(" ");
            value = ca[0];
            amount = Integer.parseInt(ca[1]);
        }

        if (value.contains(":")) {
            String[] cd = value.split(":");
            value = cd[0];
            durability = Short.parseShort(cd[1]);
        }

        typeId = Integer.parseInt(value);

        return new ItemStack(typeId, amount, durability);
    }
}
