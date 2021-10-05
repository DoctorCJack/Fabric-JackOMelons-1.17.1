package net.doctorcjack.jackomelons.item;

import net.doctorcjack.jackomelons.JackOMelons;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(JackOMelons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering ModItems for " + JackOMelons.MOD_ID);
    }
}
