package net.doctorcjack.jackomelons.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.item.Wearable;

public class CarvedMelon extends OrientableBlock implements Wearable {
    protected CarvedMelon() {
        super(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN));
    }
}
