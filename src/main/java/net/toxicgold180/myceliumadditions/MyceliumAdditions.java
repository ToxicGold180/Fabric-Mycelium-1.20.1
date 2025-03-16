package net.toxicgold180.myceliumadditions;

import net.fabricmc.api.ModInitializer;

import net.toxicgold180.myceliumadditions.block.ModBlocks;
import net.toxicgold180.myceliumadditions.item.ModItemGroups;
import net.toxicgold180.myceliumadditions.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyceliumAdditions implements ModInitializer {
	public static final String MOD_ID = "myceliumadditions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}