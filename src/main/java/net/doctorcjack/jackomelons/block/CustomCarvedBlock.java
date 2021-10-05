package net.doctorcjack.jackomelons.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;

public class CustomCarvedBlock extends CarvedPumpkinBlock {

    protected CustomCarvedBlock(Settings settings) {
        super(settings);
    }
}