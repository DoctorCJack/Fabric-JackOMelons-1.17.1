package net.doctorcjack.jackomelons.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Wearable;

public class WearableBlockItem extends BlockItem implements Wearable {

    public WearableBlockItem(Block block, Settings settings) {
        super(block, settings);
    }
}
