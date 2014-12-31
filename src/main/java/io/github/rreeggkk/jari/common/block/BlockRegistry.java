package io.github.rreeggkk.jari.common.block;

// General place to register all your blocks.

import io.github.rreeggkk.jari.common.entity.tile.TileEntityHydraulicSeparator;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry {

	// Blocks
	public static BlockHydraulicSeparator blockHydraulicSeparator;

	public static void registerBlocks() {
		GameRegistry.registerBlock(
				blockHydraulicSeparator = new BlockHydraulicSeparator(),
				"blockHydraulicSeparator");
		GameRegistry.registerTileEntity(TileEntityHydraulicSeparator.class,
				"tileHydraulicSeparator");
	}
}
