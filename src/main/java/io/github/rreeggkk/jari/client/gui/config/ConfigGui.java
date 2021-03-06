package io.github.rreeggkk.jari.client.gui.config;

/*
 * Creates a config GUI for your mod. This requires an mcmod.info file with the correct modid. These are dummy sections that don't do anything.
 */

import io.github.rreeggkk.jari.common.reference.ModInformation;
import io.github.rreeggkk.jari.common.util.ConfigHandler;
import io.github.rreeggkk.jari.common.util.TextHelper;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(parentScreen), ModInformation.ID,
				false, false, TextHelper.localize("gui." + ModInformation.ID
						+ ".config.title"));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<IConfigElement> getConfigElements(GuiScreen parent) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		// Adds sections declared in ConfigHandler. toLowerCase() is used
		// because the configuration class automatically does this, so must we.
		list.addAll(new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());
		
		return list;
	}
}