package net.doctorcjack.jackomelons.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;

public class JackOMelon extends OrientableBlock {
    protected JackOMelon() {
        super(AbstractBlock.Settings.copy(Blocks.JACK_O_LANTERN));
    }
}
