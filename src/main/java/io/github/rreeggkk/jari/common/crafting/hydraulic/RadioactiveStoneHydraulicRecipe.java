package io.github.rreeggkk.jari.common.crafting.hydraulic;

import io.github.rreeggkk.jari.JARI;
import io.github.rreeggkk.jari.common.block.BlockRegistry;
import io.github.rreeggkk.jari.common.item.ItemRegistry;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RadioactiveStoneHydraulicRecipe implements IHydraulicRecipe {

	private static HashMap<String, Double> outputChance = new HashMap<String, Double>();

	static {
		addOutputElement("Thorium-232", 1.00);

		addOutputElement("Uranium-235", 0.15);
		addOutputElement("Uranium-238", 0.90);
	}

	public static void addOutputElement(String element, double chance) {
		outputChance.put(element, chance);
	}

	public static void removeOutputElement(String element) {
		outputChance.remove(element);
	}

	public static HashMap<String, Double> getOutputChances() {
		return outputChance;
	}

	@Override
	public int getRequiredEnergy() {
		return 5000;
	}

	@Override
	public int getRequiredWater() {
		return 1000;
	}

	@Override
	public boolean isInput(ItemStack input) {
		return input.getItem() == Item
				.getItemFromBlock(BlockRegistry.blockRadioactiveStone);
	}

	@Override
	public ItemStack getResult(ItemStack input) {
		HashMap<String, Double> elements = new HashMap<String, Double>();

		for (int i = 0; i < 3 + JARI.random.nextInt(4); i++) {
			for (String s : outputChance.keySet()) {
				if (outputChance.get(s) > JARI.random.nextDouble()) {
					if (!elements.containsKey(s)) {
						elements.put(s, 0.0);
					}
					elements.put(s, elements.get(s) + JARI.random.nextDouble()
							* 3 + 1);
				}
			}
		}

		ItemStack stack = new ItemStack(ItemRegistry.metalLump);

		for (String s : elements.keySet()) {
			ItemRegistry.metalLump.addMetalToLump(stack, s, elements.get(s));
		}

		return stack;
	}
}
