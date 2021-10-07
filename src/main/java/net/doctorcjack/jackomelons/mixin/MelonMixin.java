package net.doctorcjack.jackomelons.mixin;

import net.doctorcjack.jackomelons.JackOMelons;
import net.doctorcjack.jackomelons.block.CarvedMelon;
import net.doctorcjack.jackomelons.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MelonBlock;
import net.minecraft.datafixer.fix.ChunkPalettedStorageFix;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import javax.swing.text.html.parser.Entity;

@Mixin(MelonBlock.class)
public abstract class MelonMixin extends Block{

    public MelonMixin(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.isHolding(Items.SHEARS)) {
            if(hit.getSide().equals(Direction.UP) || hit.getSide().equals(Direction.DOWN)) {
                world.setBlockState(pos, ModBlocks.CARVED_MELON.getDefaultState().with(CarvedMelon.FACING, player.getHorizontalFacing().getOpposite()));
            } else {
                world.setBlockState(pos, ModBlocks.CARVED_MELON.getDefaultState().with(CarvedMelon.FACING, hit.getSide()));
            }
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0f, 1.0f, true);
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.MELON_SEEDS, 4)));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
