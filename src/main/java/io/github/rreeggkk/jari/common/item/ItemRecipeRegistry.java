package io.github.rreeggkk.jari.common.item;

import io.github.rreeggkk.jari.common.crafting.metal.MetalAddition;
import cpw.mods.fml.common.registry.GameRegistry;

/*
 * General place to do all your item related recipe things'n'stuff.
 */

public class ItemRecipeRegistry {

	private static void registerShapedRecipes() {
	}

	private static void registerShaplessRecipes() {
		GameRegistry.addRecipe(new MetalAddition());
	}

	public static void registerItemRecipes() {
		registerShapedRecipes();
		registerShaplessRecipes();
	}
}
