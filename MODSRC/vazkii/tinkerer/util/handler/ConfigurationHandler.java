package vazkii.tinkerer.util.handler;

import java.io.File;

import net.minecraft.potion.Potion;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import vazkii.tinkerer.lib.LibBlockIDs;
import vazkii.tinkerer.lib.LibBlockNames;
import vazkii.tinkerer.lib.LibItemIDs;
import vazkii.tinkerer.lib.LibItemNames;
import vazkii.tinkerer.lib.LibPotions;

public final class ConfigurationHandler {

	private static Configuration config;

	private static final String CATEGORY_POTIONS = "potions";
	
	private static ConfigCategory categoryPotions;
	
	public static void loadConfig(File configFile) {
		config = new Configuration(configFile);

		categoryPotions = new ConfigCategory(CATEGORY_POTIONS);
		
		config.load();

		LibItemIDs.idWandTinkerer = loadItem(LibItemNames.WAND_TINKERER, LibItemIDs.DEFAULT_WAND_TINKERER);
		LibItemIDs.idGlowstoneGas = loadItem(LibItemNames.GLOWSTONE_GAS, LibItemIDs.DEFAULT_GLOWSTONE_GAS);
		LibItemIDs.idSpellCloth = loadItem(LibItemNames.SPELL_CLOTH, LibItemIDs.DEFAULT_SPELL_CLOTH);
		LibItemIDs.idStopwatch = loadItem(LibItemNames.STOPWATCH, LibItemIDs.DEFAULT_STOPWATCH);
		
		LibBlockIDs.idGlowstoneGas = loadBlock(LibBlockNames.GLOWSTONE_GAS, LibBlockIDs.DEFAULT_GLOWSTONE_GAS);

		LibPotions.idStopwatch = loadPotion(LibPotions.NAME_STOPWATCH, LibPotions.DEFAULT_ID_STOPWATCH);
		
		config.save();
	}

	private static int loadItem(String label, int defaultID) {
		return config.getItem(label, defaultID).getInt(defaultID);
	}

	private static int loadBlock(String label, int defaultID) {
		return config.getBlock(label, defaultID).getInt(defaultID);
	}
	
	private static int loadPotion(String label, int deafultID) {
		return config.get(CATEGORY_POTIONS, label, deafultID).getInt(deafultID);
	}

}