package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class HALsAddon extends JavaPlugin implements SlimefunAddon {
	
	@Override
	public void onEnable() {
		// Read something from your config.yml
		Config cfg = new Config(this);

		if (cfg.getBoolean("options.auto-update")) {
			// You could start an Auto-Updater for example
		}

		// Slimefun4 also already comes with a bundled version of bStats
		// You can use bStats to collect usage data about your plugin
		// More info: https://bstats.org/getting-started
		// Set bStatsId to the id of your plugin
		int bStatsId = -1;
		new Metrics(this, bStatsId);


		// Create a new Category
		// This Category will use this ItemStack
		NamespacedKey categoryId = new NamespacedKey(this, "ender_items");
		CustomItem categoryItem = new CustomItem(Material.END_STONE, "&5Addon Jam: The End");

		Category category = new Category(categoryId, categoryItem);

		// Create a new Slimefun ItemStack
		// This class has many constructors, it is very important that you give each item a unique id.

//Defining Items
		SlimefunItemStack end_staff = new SlimefunItemStack("ENDER_STAFF", Material.STICK, "&6Elemental Staff - &5&oEnder", "", "&7Element: &5&oEnder","","&eRight Click &7to teleport.");
		SlimefunItemStack levitation_bow = new SlimefunItemStack("LEVITATION_BOW", Material.BOW, "&dShulker Bow", "","&fAny enemies hit by arrows fired by this bow are launched into the air!");
		SlimefunItemStack ender_crossbow = new SlimefunItemStack("ENDER_CROSSBOW", Material.CROSSBOW, "&5Ender Crossbow", "","&fSwitch places with any enemy hit by an arrow of this crossbow!");
			end_staff.addUnsafeEnchantment(Enchantment.CHANNELING, 1);
		SlimefunItemStack FrozenBar_1 = new SlimefunItemStack("FROZEN_BAR_1", Material.IRON_INGOT, "&5Frozen Bar &d(33%)", "");
		SlimefunItemStack EndFragment = new SlimefunItemStack("END_FRAGMENT", Material.IRON_NUGGET, "&dEnder Fragment", "");
		SlimefunItemStack Compressed_EndFragment = new SlimefunItemStack("COMPRESSED_END_FRAGMENT", Material.IRON_NUGGET, "&dCompressed Ender Fragment", "");
		SlimefunItemStack FrozenBar_2 = new SlimefunItemStack("FROZEN_BAR_2", Material.IRON_INGOT, "&5Frozen Bar &d(66%)", "");
		SlimefunItemStack FrozenBar_Full = new SlimefunItemStack("FROZEN_BAR_FULL", Material.IRON_INGOT, "&5Frozen Bar", "");
		SlimefunItemStack Blistering_Blade = new SlimefunItemStack("BLISTERING_BLADE", Material.GOLDEN_SWORD, "&6Blistering Blade", "", LoreBuilder.radioactive(Radioactivity.VERY_DEADLY), LoreBuilder.HAZMAT_SUIT_REQUIRED);
		Blistering_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,9);
		Blistering_Blade.addUnsafeEnchantment(Enchantment.FIRE_ASPECT,4);
		Blistering_Blade.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE,3);
		Blistering_Blade.addUnsafeEnchantment(Enchantment.DURABILITY,10); //Blistering Blade
		SlimefunItemStack Freezing_Blade = new SlimefunItemStack("FREEZING_BLADE", Material.DIAMOND_SWORD, "&bFreezing Blade", "");
		Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,5);
		Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS,2);
		Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD,2);
		Freezing_Blade.addUnsafeEnchantment(Enchantment.DURABILITY,5); //Freezing Blade
		SlimefunItemStack Equal_Blade = new SlimefunItemStack("EQUILIBRIUM", Material.IRON_SWORD, "&9Equilibrium", "","&fFew have obtained this sword, even fewer have" ,"&fthe capabilities to wield it.","",LoreBuilder.radioactive(Radioactivity.VERY_DEADLY), LoreBuilder.HAZMAT_SUIT_REQUIRED);
		Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,7);
		Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS,2);
		Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD,2);
		Equal_Blade.addUnsafeEnchantment(Enchantment.FIRE_ASPECT,4);
		Equal_Blade.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE,3);
		Equal_Blade.addUnsafeEnchantment(Enchantment.DURABILITY,10); //Equilibrium
		SlimefunItemStack Trapped_ShulkerBox = new SlimefunItemStack("TRAPPED_SHULKERBOX", Material.SHULKER_BOX, "&fTrapped Shulker Box", "","&fAnyone who tries to open the box will","&fget levitation for 5 seconds.");
		SlimefunItemStack Levitation_Tome = new SlimefunItemStack("LEVITATION_TOME", Material.ENCHANTED_BOOK, "&fSpell Tome (&bReverse Gravity&f)", "","&eRight Click &f- Gain a brief period of levitation");
		SlimefunItemStack Ground_Tome = new SlimefunItemStack("GROUND_TOME", Material.ENCHANTED_BOOK, "&fSpell Tome (&8Intensify Gravity&f)", "","&eRight Click &f- Intensify gravity for all nearby entities");
		SlimefunItemStack Obsidian_Shield = new SlimefunItemStack("OBSIDIAN_SHIELD", Material.SHIELD, "&fObsidian Shield", "");
		Obsidian_Shield.addUnsafeEnchantment(Enchantment.DURABILITY,5);




// Recipes
		ItemStack[] enderStaff_recipe = {
				null, null, SlimefunItems.RUNE_ENDER,
				null, SlimefunItems.STAFF_ELEMENTAL, null,
				SlimefunItems.STAFF_ELEMENTAL, null, null
		};

		ItemStack[] Trapped_ShulkerBox_recipe = {
				null, null, null,
				new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.SHULKER_BOX), new ItemStack(Material.TRIPWIRE_HOOK),
				null, null, null
		};

		ItemStack[] Obsidian_Shield_recipe = {
				new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN),
				new ItemStack(Material.OBSIDIAN), new ItemStack(Material.SHIELD), new ItemStack(Material.OBSIDIAN),
				new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN)
		};

		ItemStack[] Levitation_Tome_recipe = {
				SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.FEATHER), SlimefunItems.ENDER_LUMP_2,
				new ItemStack(Material.FEATHER), SlimefunItems.MAGICAL_BOOK_COVER, new ItemStack(Material.FEATHER),
				SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.FEATHER), SlimefunItems.ENDER_LUMP_2
		};
		ItemStack[] Ground_Tome_recipe = {
				SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.ANVIL), SlimefunItems.ENDER_LUMP_2,
				SlimefunItems.ENDER_LUMP_2, SlimefunItems.MAGICAL_BOOK_COVER, SlimefunItems.ENDER_LUMP_2,
				SlimefunItems.ENDER_LUMP_2, null, SlimefunItems.ENDER_LUMP_2
		};
		SlimefunItem Obsidian_Shield_item = new SlimefunItem(category, Obsidian_Shield, RecipeType.ENHANCED_CRAFTING_TABLE, Obsidian_Shield_recipe);
		Obsidian_Shield_item.register(this);
		ItemStack[] Ender_Crossbow_recipe = {
				SlimefunItems.RUNE_ENDER, SlimefunItems.RUNE_ENDER, SlimefunItems.RUNE_ENDER,
				SlimefunItems.RUNE_ENDER, new ItemStack(Material.CROSSBOW), SlimefunItems.RUNE_ENDER,
				SlimefunItems.RUNE_ENDER, SlimefunItems.RUNE_ENDER, SlimefunItems.RUNE_ENDER
		};

		EnderStaff endStaff = new EnderStaff(category, end_staff, RecipeType.MAGIC_WORKBENCH, enderStaff_recipe);
	endStaff.register(this);
		LevitationTome Levitation_Tome_item = new LevitationTome(category, Levitation_Tome, RecipeType.MAGIC_WORKBENCH, Levitation_Tome_recipe);
		Levitation_Tome_item.register(this);
		GroundTome Ground_Tome_item = new GroundTome(category, Ground_Tome, RecipeType.MAGIC_WORKBENCH, Ground_Tome_recipe);
		Ground_Tome_item.register(this);
		ItemStack[] shulkerBow_recipe = {
				null, SlimefunItems.STAFF_ELEMENTAL, new ItemStack(Material.CHORUS_FRUIT),
				end_staff, null, new ItemStack(Material.CHORUS_FRUIT),
				null, SlimefunItems.STAFF_ELEMENTAL, new ItemStack(Material.CHORUS_FRUIT)
		};
		ShulkerBow shulker_bow = new ShulkerBow(levitation_bow,shulkerBow_recipe); //Shulker Bow
		shulker_bow.register(this);
		EnderBow ender_crossbow_item = new EnderBow(ender_crossbow,Ender_Crossbow_recipe); //Ender Crossbow
		ender_crossbow_item.register(this);
		TrappedShulker Trapped_ShulkerBox_item = new TrappedShulker(category, Trapped_ShulkerBox, RecipeType.ENHANCED_CRAFTING_TABLE, Trapped_ShulkerBox_recipe); //Shulker Bow
		Trapped_ShulkerBox_item.register(this);
// End Bars & Fragments

		ItemStack[] EndFragment_recipe = {
				SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.END_STONE), SlimefunItems.ENDER_LUMP_3,
				new ItemStack(Material.END_STONE), new ItemStack(Material.CHORUS_FRUIT), new ItemStack(Material.END_STONE),
				SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.END_STONE), SlimefunItems.ENDER_LUMP_3
		};
		SlimefunItem EndFragment_item = new SlimefunItem(category, EndFragment, RecipeType.COMPRESSOR, EndFragment_recipe);
		EndFragment_item.register(this); //End Fragment
		ItemStack[] FrozenBar1_recipe = {
				SlimefunItems.GOLD_24K, EndFragment, null,
				null, null, null,
				null, null, null
		};
		ItemStack[] CompressedEndFragment_recipe = {
				EndFragment, EndFragment, null,
				EndFragment, EndFragment, null,
				null, null, null,
		};
		ItemStack[] DragonBreath_Recipe = {
				Compressed_EndFragment, null, null,
				null, null, null,
				null, null, null,
		};
		SlimefunItem DragonBreathAlt_Recipe = new SlimefunItem(category, (SlimefunItemStack) new ItemStack(Material.DRAGON_BREATH), RecipeType.GRIND_STONE, DragonBreath_Recipe);
		DragonBreathAlt_Recipe.register(this);
		SlimefunItem CompressedEndFragment_Item = new SlimefunItem(category, Compressed_EndFragment, RecipeType.COMPRESSOR, CompressedEndFragment_recipe);
		CompressedEndFragment_Item.register(this); //compressed end fragment
		SlimefunItem FrozenBar1_item = new SlimefunItem(category, FrozenBar_1, RecipeType.PRESSURE_CHAMBER, FrozenBar1_recipe);
		FrozenBar1_item.register(this); //Frozen Bar (33%)
		ItemStack[] FrozenBar2_recipe = {
				null, new ItemStack(Material.SHULKER_SHELL), null,
				new ItemStack(Material.SHULKER_SHELL), FrozenBar_1, new ItemStack(Material.SHULKER_SHELL),
				null, new ItemStack(Material.SHULKER_SHELL), null
		};
		SlimefunItem FrozenBar2_item = new SlimefunItem(category, FrozenBar_2, RecipeType.PRESSURE_CHAMBER, FrozenBar2_recipe);
		FrozenBar2_item.register(this); //Frozen Bar (66%)
		ItemStack[] FrozenBar_Full_recipe = {
				new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH),
				new ItemStack(Material.DRAGON_BREATH), FrozenBar_2, new ItemStack(Material.DRAGON_BREATH),
				new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH)
		};
		SlimefunItem FrozenBar_Full_item = new SlimefunItem(category, FrozenBar_Full, RecipeType.PRESSURE_CHAMBER, FrozenBar_Full_recipe);
		FrozenBar_Full_item.register(this); //Frozen Bar (Full)
		ItemStack[] Blistering_Blade_recipe = {
				null, SlimefunItems.BLISTERING_INGOT_3, null,
				null, SlimefunItems.BLISTERING_INGOT_3, null,
				null, new ItemStack(Material.STICK), null,
		};
		RadioactiveWeapon Blistering_Blade_item = new RadioactiveWeapon(category, Blistering_Blade, RecipeType.ENHANCED_CRAFTING_TABLE, Blistering_Blade_recipe);
		Blistering_Blade_item.register(this); //Blistering Blade
		ItemStack[] Freezing_Blade_recipe = {
				null, FrozenBar_Full, null,
				null, FrozenBar_Full, null,
				null, new ItemStack(Material.STICK), null,
		};
		SlimefunItem Freezing_Blade_item = new SlimefunItem(category, Freezing_Blade, RecipeType.ENHANCED_CRAFTING_TABLE, Freezing_Blade_recipe);
		Freezing_Blade_item.register(this); //Freezing Blade
		ItemStack[] Equilibrium_Blade_recipe = {
				null, Freezing_Blade, null,
				null, Blistering_Blade, null,
				null, new ItemStack(Material.STICK), null,
		};
		RadioactiveWeapon Equilibrium_Blade_item = new RadioactiveWeapon(category, Equal_Blade, RecipeType.ENHANCED_CRAFTING_TABLE, Equilibrium_Blade_recipe);
		Equilibrium_Blade_item.isDisenchantable();
		Equilibrium_Blade_item.register(this); //Equilibrium
		//Research
		NamespacedKey ender_fragments_research_id = new NamespacedKey(this, "ender_fragments_r");
		Research ender_fragments_research = new Research(ender_fragments_research_id, 425989, "Ender Fragments", 13);
		ender_fragments_research.addItems(EndFragment_item, CompressedEndFragment_Item);
		ender_fragments_research.register();

		NamespacedKey frozen_bars_research_id = new NamespacedKey(this, "frozen_bars_research");
		Research frozen_bars_research = new Research(frozen_bars_research_id, 425990, "Frozen Bars", 40);
		frozen_bars_research.addItems(FrozenBar1_item,FrozenBar2_item,FrozenBar_Full_item);
		frozen_bars_research.register();

		NamespacedKey ShulkerBow_research_id = new NamespacedKey(this, "shulkerbow_research");
		Research ShulkerBow_research = new Research(ShulkerBow_research_id, 425991, "Shulker Bow", 20);
		ShulkerBow_research.addItems(shulker_bow);
		ShulkerBow_research.register();

		NamespacedKey EndStaff_research_id = new NamespacedKey(this, "enderstaff_research");
		Research EnderStaff_research = new Research(EndStaff_research_id, 425992, "Ender Staff", 21);
		EnderStaff_research.addItems(endStaff);
		EnderStaff_research.register();

		NamespacedKey Hot_and_cold_research_id = new NamespacedKey(this, "hot_and_cold_research");
		Research Hot_cold_research = new Research(Hot_and_cold_research_id, 425993, "Weaponizing Extreme Temperatures", 35);
		Hot_cold_research.addItems(Equilibrium_Blade_item,Freezing_Blade_item,Blistering_Blade_item);
		Hot_cold_research.register();
	}



	@Override
	public void onDisable() {
		// Logic for disabling the plugin...
	}

	@Override
	public String getBugTrackerURL() {
		// You can return a link to your Bug Tracker instead of null here
		return null;
	}

	@Override
	public JavaPlugin getJavaPlugin() {
		return this;
	}

}

