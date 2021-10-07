package net.doctorcjack.jackomelons.block;

import net.doctorcjack.jackomelons.JackOMelons;
import net.doctorcjack.jackomelons.item.WearableBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block JACK_O_MELON = registerBlock("jack_o_melon", new JackOMelon());
    public static final Block CARVED_MELON = registerBlock("carved_melon", new CarvedMelon());

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(JackOMelons.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        if(name.equals("carved_melon")) {
            return Registry.register(Registry.ITEM, new Identifier(JackOMelons.MOD_ID, name),
                    new WearableBlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS).equipmentSlot(stack -> EquipmentSlot.HEAD)));
        } else {
            return Registry.register(Registry.ITEM, new Identifier(JackOMelons.MOD_ID, name),
                    new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        }
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + JackOMelons.MOD_ID);
    }
}
