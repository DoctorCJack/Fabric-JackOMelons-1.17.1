package net.doctorcjack.jackomelons;

import net.doctorcjack.jackomelons.block.ModBlocks;
import net.doctorcjack.jackomelons.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JackOMelons implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("jackomelons");

	public static final String MOD_ID = "jackomelons";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		UseBlockCallback.EVENT.register((player, world, hand, pos) ->
		{
			if (!player.isSpectator() && player.isHolding(Items.SHEARS) && world.getBlockState(pos.getBlockPos()).isOf(Blocks.MELON))
			{
				player.getStackInHand(hand).damage(1, player, (p) -> {p.sendToolBreakStatus(hand);});
			}
			return ActionResult.PASS;
		});

		LOGGER.info("Hello Fabric world!");
	};
}
