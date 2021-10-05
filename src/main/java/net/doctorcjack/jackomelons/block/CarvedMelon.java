package net.doctorcjack.jackomelons.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class CarvedMelon extends OrientableBlock {
    protected CarvedMelon() {
        super(FabricBlockSettings.of(Material.SOLID_ORGANIC)
                .strength(1.0f, 1.0f)
                .breakByTool(FabricToolTags.AXES)
                .sounds(BlockSoundGroup.WOOD));
    }
}
