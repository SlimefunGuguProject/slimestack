package me.hal989.halsaddon;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import me.mrCookieSlime.bstats.bukkit.Metrics;

public class HALsAddon extends JavaPlugin implements SlimefunAddon {
	public static SlimefunItemStack Trapped_ShulkerBox;
	public static SlimefunItemStack Levitation_Tome;
	public static SlimefunItemStack endStonePickaxe;
	public static SlimefunItemStack endStoneAxe;
	public static SlimefunItemStack endStoneShovel;
	public static SlimefunItemStack endStoneSword;
	public static SlimefunItemStack endStoneHoe;
	public static SlimefunItemStack endermegaEgg;
	public static RecipeType BOSS_DROP;
	public static SlimefunItemStack endermegaHelmet;
	public static SlimefunItemStack endermegaChestplate;
	public static SlimefunItemStack endermegaLeggings;
	public static SlimefunItemStack endermegaBoots;
	public static SlimefunItemStack enderstaffTier2;
	public static SlimefunItemStack enderBlade;
	public static SlimefunItemStack irregularbow;
	public static SlimefunItemStack endermegaHead;
	public static SlimefunItemStack DEEPFREEZER;
	public static Boolean isEndermegaEnraged;
	public static RecipeType DEEP_FREEZER;
	public static Category enderCategory;


	@Override
	public void onEnable() {
		NamespacedKey categoryId = new NamespacedKey(this, "ender_items");
		CustomItem categoryItem = new CustomItem(Material.END_STONE, "&5Addon Jam: The End");

		enderCategory = new Category(categoryId, categoryItem);
		DEEPFREEZER = new SlimefunItemStack("DEEPFREEZER", Material.BLUE_ICE, "&bDeep Freezer", "", "&aFreezes Items at an extreme temperature");
		isEndermegaEnraged = false;
		Trapped_ShulkerBox = new SlimefunItemStack("TRAPPED_SHULKERBOX", Material.SHULKER_BOX, "&fTrapped Shulker Box", "","&fAnyone who tries to open the box will","&fget levitation for 5 seconds.");
		endermegaEgg = new SlimefunItemStack("ENDERMEGA_EGG",Material.ENDERMAN_SPAWN_EGG,"&5Endermega Spawn Egg");

		SlimefunItemStack end_staff = new SlimefunItemStack("ENDER_STAFF", Material.STICK, "&6Elemental Staff - &5&oEnder", "", "&7Element: &5&oEnder","","&eRight Click &7to teleport.");
		SlimefunItemStack levitation_bow = new SlimefunItemStack("LEVITATION_BOW", Material.BOW, "&dShulker Bow", "","&fAny enemies hit by arrows fired by this bow are launched into the air!");
		SlimefunItemStack ender_crossbow = new SlimefunItemStack("ENDER_CROSSBOW", Material.BOW, "&5Ender Crossbow", "","&fSwitch places with any enemy hit by an arrow of this bow!");
		end_staff.addUnsafeEnchantment(Enchantment.CHANNELING, 1);
		SlimefunItemStack FrozenBar_1 = new SlimefunItemStack("FROZEN_BAR_1", Material.IRON_INGOT, "&5Frozen Bar &d(33%)");
		SlimefunItemStack EndFragment = new SlimefunItemStack("END_FRAGMENT", Material.IRON_NUGGET, "&dEnder Fragment");
		SlimefunItemStack Compressed_EndFragment = new SlimefunItemStack("COMPRESSED_END_FRAGMENT", Material.IRON_NUGGET, "&dCompressed Ender Fragment");
		SlimefunItemStack FrozenBar_2 = new SlimefunItemStack("FROZEN_BAR_2", Material.IRON_INGOT, "&5Frozen Bar &d(66%)");
		SlimefunItemStack FrozenBar_Full = new SlimefunItemStack("FROZEN_BAR_FULL", Material.IRON_INGOT, "&5Frozen Bar");
		SlimefunItemStack Blistering_Blade = new SlimefunItemStack("BLISTERING_BLADE", Material.GOLDEN_SWORD, "&6Blistering Blade", "", LoreBuilder.radioactive(Radioactivity.VERY_DEADLY), LoreBuilder.HAZMAT_SUIT_REQUIRED);
		Blistering_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,10);
		Blistering_Blade.addUnsafeEnchantment(Enchantment.FIRE_ASPECT,4);
		Blistering_Blade.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE,3);
		Blistering_Blade.addUnsafeEnchantment(Enchantment.DURABILITY,10); //Blistering Blade
		SlimefunItemStack Freezing_Blade = new SlimefunItemStack("FREEZING_BLADE", Material.DIAMOND_SWORD, "&bFreezing Blade");
		Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,4);
		Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS,3);
		Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD,3);
		Freezing_Blade.addUnsafeEnchantment(Enchantment.DURABILITY,5); //Freezing Blade
		SlimefunItemStack Equal_Blade = new SlimefunItemStack("EQUILIBRIUM", Material.IRON_SWORD, "&9Equilibrium", "","&fFew have obtained this sword, even fewer have" ,"&fthe capabilities to wield it.","",LoreBuilder.radioactive(Radioactivity.VERY_DEADLY), LoreBuilder.HAZMAT_SUIT_REQUIRED);
		Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,8);
		Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS,3);
		Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD,3);
		Equal_Blade.addUnsafeEnchantment(Enchantment.FIRE_ASPECT,4);
		Equal_Blade.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE,3);
		Equal_Blade.addUnsafeEnchantment(Enchantment.DURABILITY,10); //Equilibrium
		Levitation_Tome = new SlimefunItemStack("LEVITATION_TOME", Material.ENCHANTED_BOOK, "&fSpell Tome (&bReverse Gravity&f)", "","&eRight Click &f- Gain a brief period of levitation");
		SlimefunItemStack Ground_Tome = new SlimefunItemStack("GROUND_TOME", Material.ENCHANTED_BOOK, "&fSpell Tome (&8Intensify Gravity&f)", "","&eRight Click &f- Intensify gravity for all nearby entities");
		SlimefunItemStack Obsidian_Shield = new SlimefunItemStack("OBSIDIAN_SHIELD", Material.SHIELD, "&fObsidian Shield");
		Obsidian_Shield.addUnsafeEnchantment(Enchantment.DURABILITY,5);

		endStonePickaxe = new SlimefunItemStack("ENDSTONE_PICKAXE", Material.GOLDEN_PICKAXE, "&fEndstone Pickaxe", "","&e Shift + Right Click &f- Pay an ender lump","&fto restore 2 durability to the pickaxe.");
		endStoneShovel = new SlimefunItemStack("ENDSTONE_SHOVEL", Material.GOLDEN_SHOVEL, "&fEndstone Shovel", "","&e Shift + Right Click &f- Pay an ender lump","&fto restore 2 durability to the shovel.");
		endStoneSword = new SlimefunItemStack("ENDSTONE_SWORD", Material.GOLDEN_SWORD, "&fEndstone Sword", "","&e Shift + Right Click &f- Pay an ender lump","&fto restore 2 durability to the sword.");
		endStoneAxe = new SlimefunItemStack("ENDSTONE_AXE", Material.GOLDEN_AXE, "&fEndstone Axe", "","&e Shift + Right Click &f- Pay an ender lump","&fto restore 2 durability to the axe.");
		endStoneHoe = new SlimefunItemStack("ENDSTONE_HOE", Material.GOLDEN_HOE, "&fEndstone Hoe", "","&e Shift + Right Click &f- Pay an ender lump","&fto restore 2 durability to the hoe.");
		BOSS_DROP = new RecipeType(new NamespacedKey(this, "boss_drop"), new CustomItem(Material.DIAMOND_SWORD, "&cBoss Drop"), null, "", "&rKill the specified Boss for a chance to obtain this Item");

		//Endermega drops
		endermegaHelmet = new SlimefunItemStack("ENDERMEGA_HELMET",Material.LEATHER_HELMET, Color.BLACK,"&5Endermega Helmet","","&5Endermega&d's power flows through this set...","","&bSet bonus: Teleport when hit");
		endermegaHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,5);
		endermegaHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE,2);
		endermegaHelmet.addUnsafeEnchantment(Enchantment.DURABILITY,8);
		endermegaChestplate = new SlimefunItemStack("ENDERMEGA_CHESTPLATE",Material.LEATHER_CHESTPLATE, Color.BLACK,"&5Endermega Chestplate","","&5Endermega&d's power flows through this set...","","&bSet bonus: Teleport when hit");
		endermegaChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,5);
		endermegaChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE,2);
		endermegaChestplate.addUnsafeEnchantment(Enchantment.DURABILITY,8);
		endermegaLeggings = new SlimefunItemStack("ENDERMEGA_LEGGINGS",Material.LEATHER_LEGGINGS, Color.BLACK,"&5Endermega Leggings","","&5Endermega&d's power flows through this set...","","&bSet bonus: Teleport when hit");
		endermegaLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,5);
		endermegaLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE,2);
		endermegaLeggings.addUnsafeEnchantment(Enchantment.DURABILITY,8);
		endermegaBoots = new SlimefunItemStack("ENDERMEGA_BOOTS",Material.LEATHER_BOOTS, Color.BLACK,"&5Endermega Boots","","&5Endermega&d's power flows through this set...","","&bSet bonus: Teleport when hit");
		endermegaBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,5);
		endermegaBoots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE,2);
		endermegaBoots.addUnsafeEnchantment(Enchantment.DURABILITY,8);

		enderstaffTier2 = new SlimefunItemStack("ENDER_STAFF_2", Material.BLAZE_ROD, "&6Elemental Staff - &5&oEnder &0(&aMastery&0)", "", "&7Element: &5&oEnder","","&eRight Click &7to teleport.","&aMastery - 2x range");
		enderstaffTier2.addUnsafeEnchantment(Enchantment.CHANNELING, 1);
		enderBlade = new SlimefunItemStack("ENDER_BLADE",Material.IRON_SWORD,"&5Ender Blade","","&e Shift + Right Click &f- Use some durability","&fto teleport you 3 blocks into the air.");
		irregularbow = new SlimefunItemStack("IRREGULAR_BOW",Material.BOW,"&1Irregular Bow");
		irregularbow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,4);

		endermegaHead = new SlimefunItemStack("ENDERMEGA_HEAD","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmJjZjNmNTc4NzE5NmQyNTZjMTA0ZmZmYWU4ZTUyNjUyNDIyMjJlMjEzOGE1N2ExNjY2YzE1YjVmNmM4N2I5OCJ9fX0=","&eEnder Mega Head","&7Purely decorational.");
		//Multiblocks
		DEEP_FREEZER = new RecipeType(new NamespacedKey(this, "deepfreezer"), DEEPFREEZER);
		new deepFreezer().register(this);






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
		new KillHandler(this);
		new TeleportHandler(this);
		new DamageHandler(this);


		// Create a new Category
		// This Category will use this ItemStack

//Defining Items





// Recipes
		ItemStack[] enderStaff_recipe = {
				null, null, SlimefunItems.ENDER_RUNE,
				null, SlimefunItems.STAFF_ELEMENTAL, null,
				SlimefunItems.STAFF_ELEMENTAL, null, null
		};
//Endstone Tools
		ItemStack[] endstonePickaxeRecipe = {
				new ItemStack(Material.END_STONE), new ItemStack(Material.END_STONE), new ItemStack(Material.END_STONE),
				null, new ItemStack(Material.BLAZE_ROD), null,
				null, new ItemStack(Material.BLAZE_ROD), null
		};
		ItemStack[] endstoneShovelRecipe = {
				null, new ItemStack(Material.END_STONE), null,
				null, new ItemStack(Material.BLAZE_ROD), null,
				null, new ItemStack(Material.BLAZE_ROD), null
		};
		ItemStack[] endstoneHoeRecipe = {
				null, new ItemStack(Material.END_STONE), new ItemStack(Material.END_STONE),
				null, new ItemStack(Material.BLAZE_ROD), null,
				null, new ItemStack(Material.BLAZE_ROD), null
		};

		ItemStack[] endstoneAxeRecipe = {
				null, new ItemStack(Material.END_STONE), new ItemStack(Material.END_STONE),
				null, new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.END_STONE),
				null, new ItemStack(Material.BLAZE_ROD), null
		};

		ItemStack[] endstoneSwordRecipe = {
				null, new ItemStack(Material.END_STONE), null, 
				null, new ItemStack(Material.END_STONE), null,
				null, new ItemStack(Material.BLAZE_ROD), null
		};
		HasteItem endstoneHoeItem = new HasteItem(enderCategory, endStoneHoe, RecipeType.ENHANCED_CRAFTING_TABLE, endstoneHoeRecipe); //endstone tools
		HasteItem endstoneShovelItem = new HasteItem(enderCategory, endStoneShovel, RecipeType.ENHANCED_CRAFTING_TABLE, endstoneShovelRecipe);
		HasteItem endstoneAxeItem = new HasteItem(enderCategory, endStoneAxe, RecipeType.ENHANCED_CRAFTING_TABLE, endstoneAxeRecipe);
		HasteItem endstonePickaxeItem = new HasteItem(enderCategory, endStonePickaxe, RecipeType.ENHANCED_CRAFTING_TABLE, endstonePickaxeRecipe);
		HasteItem endstoneSwordItem = new HasteItem(enderCategory, endStoneSword, RecipeType.ENHANCED_CRAFTING_TABLE, endstoneSwordRecipe);
		endstoneAxeItem.register(this);
		endstonePickaxeItem.register(this);
		endstoneShovelItem.register(this);
		endstoneHoeItem.register(this);
		endstoneSwordItem.register(this);

		new ItemStack(Material.REDSTONE_BLOCK);
		new ItemStack(Material.SHULKER_BOX);
		new ItemStack(Material.TRIPWIRE_HOOK);

		ItemStack[] Obsidian_Shield_recipe = {
				new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN),
				new ItemStack(Material.OBSIDIAN), new ItemStack(Material.SHIELD), new ItemStack(Material.OBSIDIAN),
				new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN)
		};
		ItemStack[] shulkerHead = {
				null, null, null,
				null, new CustomItem(SkullItem.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFkMzUzNGQyMWZlODQ5OTI2MmRlODdhZmZiZWFjNGQyNWZmZGUzNWM4YmRjYTA2OWU2MWUxNzg3ZmYyZiJ9fX0="), "&dShulker"), null,
				null, null, null //shulker drop for recipes
		};
		ItemStack[] endermegaDrop = {
				null, null, null,
				null, new CustomItem(SkullItem.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmJjZjNmNTc4NzE5NmQyNTZjMTA0ZmZmYWU4ZTUyNjUyNDIyMjJlMjEzOGE1N2ExNjY2YzE1YjVmNmM4N2I5OCJ9fX0="), "&5Endermega"), null,
				null, null, null //endermega head for recipes
		};

		ItemStack[] Ground_Tome_recipe = {
				SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.ANVIL), SlimefunItems.ENDER_LUMP_2, //ground tome recipe
				SlimefunItems.ENDER_LUMP_2, SlimefunItems.MAGICAL_BOOK_COVER, SlimefunItems.ENDER_LUMP_2,
				SlimefunItems.ENDER_LUMP_2, null, SlimefunItems.ENDER_LUMP_2
		};
		SlimefunItem Obsidian_Shield_item = new SlimefunItem(enderCategory, Obsidian_Shield, RecipeType.ENHANCED_CRAFTING_TABLE, Obsidian_Shield_recipe);
		Obsidian_Shield_item.register(this);
		ItemStack[] Ender_Crossbow_recipe = {
				SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_RUNE,
				SlimefunItems.ENDER_RUNE, new ItemStack(Material.CROSSBOW), SlimefunItems.ENDER_RUNE,
				SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_RUNE
		};

		EnderStaff endStaff = new EnderStaff(enderCategory, end_staff, RecipeType.MAGIC_WORKBENCH, enderStaff_recipe);
	endStaff.register(this);
		LevitationTome Levitation_Tome_item = new LevitationTome(enderCategory, Levitation_Tome, RecipeType.MOB_DROP, shulkerHead);
		Levitation_Tome_item.register(this);
		GroundTome Ground_Tome_item = new GroundTome(enderCategory, Ground_Tome, RecipeType.MAGIC_WORKBENCH, Ground_Tome_recipe);
		Ground_Tome_item.register(this);
		ItemStack[] shulkerBow_recipe = {
				null, SlimefunItems.STAFF_ELEMENTAL, new ItemStack(Material.CHORUS_FRUIT),
				end_staff, null, new ItemStack(Material.CHORUS_FRUIT),
				null, SlimefunItems.STAFF_ELEMENTAL, new ItemStack(Material.CHORUS_FRUIT)
		};
		ShulkerBow shulker_bow = new ShulkerBow(enderCategory, levitation_bow,shulkerBow_recipe); //Shulker Bow
		shulker_bow.register(this);
		EnderBow ender_crossbow_item = new EnderBow(enderCategory, ender_crossbow,Ender_Crossbow_recipe); //Ender Crossbow
		ender_crossbow_item.register(this);
		TrappedShulker Trapped_ShulkerBox_item = new TrappedShulker(enderCategory, Trapped_ShulkerBox, RecipeType.MOB_DROP, shulkerHead); //Trapped Shulker Box
		Trapped_ShulkerBox_item.register(this);
// End Bars & Fragments

		ItemStack[] EndFragment_recipe = {
				SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.END_STONE), SlimefunItems.ENDER_LUMP_3,
				new ItemStack(Material.END_STONE), new ItemStack(Material.CHORUS_FRUIT), new ItemStack(Material.END_STONE),
				SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.END_STONE), SlimefunItems.ENDER_LUMP_3
		};
		SlimefunItem EndFragment_item = new SlimefunItem(enderCategory, EndFragment, RecipeType.COMPRESSOR, EndFragment_recipe);
		EndFragment_item.register(this); //End Fragment
		ItemStack[] FrozenBar1_recipe = {
				SlimefunItems.GOLD_24K, EndFragment, null,
				null, null, null,
				null, null, null
		};
		ItemStack[] CompressedEndFragment_recipe = { //compressed end fragment
				EndFragment, EndFragment, null,
				EndFragment, EndFragment, null,
				null, null, null,
		};
		//SlimefunItem DragonBreathAlt_Recipe = new SlimefunItem(enderCategory, (SlimefunItemStack) new ItemStack(Material.DRAGON_BREATH), RecipeType.GRIND_STONE, DragonBreath_Recipe);
		//DragonBreathAlt_Recipe.register(this);
		SlimefunItem CompressedEndFragment_Item = new SlimefunItem(enderCategory, Compressed_EndFragment, RecipeType.COMPRESSOR, CompressedEndFragment_recipe);
		CompressedEndFragment_Item.register(this); //compressed end fragment
		SlimefunItem FrozenBar1_item = new SlimefunItem(enderCategory, FrozenBar_1, RecipeType.PRESSURE_CHAMBER, FrozenBar1_recipe);
		FrozenBar1_item.register(this); //Frozen Bar (33%)
		ItemStack[] FrozenBar2_recipe = {
				null, new ItemStack(Material.SHULKER_SHELL), null,
				new ItemStack(Material.SHULKER_SHELL), FrozenBar_1, new ItemStack(Material.SHULKER_SHELL),
				null, new ItemStack(Material.SHULKER_SHELL), null
		};
		SlimefunItem FrozenBar2_item = new SlimefunItem(enderCategory, FrozenBar_2, DEEP_FREEZER, FrozenBar2_recipe);
		FrozenBar2_item.register(this); //Frozen Bar (66%)
		ItemStack[] FrozenBar_Full_recipe = {
				new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH),
				new ItemStack(Material.DRAGON_BREATH), FrozenBar_2, new ItemStack(Material.DRAGON_BREATH),
				new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH)
		};
		SlimefunItem FrozenBar_Full_item = new SlimefunItem(enderCategory, FrozenBar_Full, DEEP_FREEZER, FrozenBar_Full_recipe);
		FrozenBar_Full_item.register(this); //Frozen Bar (Full)
		ItemStack[] Blistering_Blade_recipe = {
				null, SlimefunItems.BLISTERING_INGOT_3, null,
				null, SlimefunItems.BLISTERING_INGOT_3, null,
				null, new ItemStack(Material.STICK), null,
		};
		RadioactiveWeapon Blistering_Blade_item = new RadioactiveWeapon(enderCategory, Blistering_Blade, RecipeType.ENHANCED_CRAFTING_TABLE, Blistering_Blade_recipe);
		Blistering_Blade_item.register(this); //Blistering Blade
		ItemStack[] Freezing_Blade_recipe = {
				null, FrozenBar_Full, null,
				null, FrozenBar_Full, null,
				null, new ItemStack(Material.STICK), null,
		};
		SlimefunItem Freezing_Blade_item = new SlimefunItem(enderCategory, Freezing_Blade, DEEP_FREEZER, Freezing_Blade_recipe);
		Freezing_Blade_item.register(this); //Freezing Blade
		ItemStack[] endermegaEggRecipe = {
				SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_RUNE,
				EndFragment, new ItemStack(Material.EGG), EndFragment,
				SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_RUNE,
		};
		ItemStack[] Equilibrium_Blade_recipe = {
				null, Freezing_Blade, null,
				null, Blistering_Blade, null,
				null, new ItemStack(Material.STICK), null,
		};
		RadioactiveWeapon Equilibrium_Blade_item = new RadioactiveWeapon(enderCategory, Equal_Blade, DEEP_FREEZER, Equilibrium_Blade_recipe);
		Equilibrium_Blade_item.isDisenchantable();
		Equilibrium_Blade_item.register(this); //Equilibrium

		//Endermega stuff

		BossEgg endermegaEggItem = new BossEgg(enderCategory, endermegaEgg, RecipeType.ANCIENT_ALTAR, endermegaEggRecipe);
		endermegaEggItem.register(this);

		SlimefunItem endermegaHelmetItem = new SlimefunItem(enderCategory, endermegaHelmet, BOSS_DROP, endermegaDrop); //endermega set
		endermegaHelmetItem.register(this);
		SlimefunItem endermegaChestplateItem = new SlimefunItem(enderCategory, endermegaChestplate, BOSS_DROP, endermegaDrop);
		endermegaChestplateItem.register(this);
		SlimefunItem endermegaLeggingsItem = new SlimefunItem(enderCategory, endermegaLeggings, BOSS_DROP, endermegaDrop);
		endermegaLeggingsItem.register(this);
		SlimefunItem endermegaBootsItem = new SlimefunItem(enderCategory, endermegaBoots, BOSS_DROP, endermegaDrop);
		endermegaBootsItem.register(this);
		EnderStaff2 enderstaffTier2Item = new EnderStaff2(enderCategory, enderstaffTier2, BOSS_DROP, endermegaDrop); //ender staff tier 2
		enderstaffTier2Item.register(this);
		EnderBlade enderBladeItem = new EnderBlade(enderCategory, enderBlade, BOSS_DROP, endermegaDrop); //ender blade
		enderBladeItem.register(this);
		SlimefunItem enderHeadItem = new SlimefunItem(enderCategory, endermegaHead, BOSS_DROP, endermegaDrop); //ender head
		enderHeadItem.register(this);
		SlimefunItem irregularBowItem = new SlimefunItem(enderCategory, irregularbow, BOSS_DROP, endermegaDrop);
		irregularBowItem.register(this); //irregular bow
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

		NamespacedKey endstoneToolsID = new NamespacedKey(this, "endstone_tools_research");
		Research endstoneToolsResearch = new Research(endstoneToolsID, 425994, "Endstone Tools", 18);
		endstoneToolsResearch.addItems(endstoneAxeItem,endstonePickaxeItem,endstonePickaxeItem,endstoneShovelItem,endstoneSwordItem,endstoneHoeItem);
		endstoneToolsResearch.register();

		NamespacedKey endermegaID = new NamespacedKey(this, "endermega_research");
		Research endermegaResearch = new Research(endermegaID, 425995, "Battling Endermega", 34);
		endermegaResearch.addItems(endermegaBootsItem,endermegaLeggingsItem,endermegaChestplateItem,endermegaHelmetItem,endermegaEggItem,enderstaffTier2Item,enderBladeItem,enderHeadItem,irregularBowItem);
		endermegaResearch.register();

		NamespacedKey deepfreezerID = new NamespacedKey(this, "deepfreezer_research");
		Research deepfreezerResearch = new Research(deepfreezerID, 425996, "Harnessing Extreme Cold", 30);
		deepfreezerResearch.addItems(SlimefunItem.getByItem(DEEPFREEZER)); //Deep freezer research
		deepfreezerResearch.register();

		NamespacedKey obsidianID = new NamespacedKey(this, "obsidian_shield_research");
		Research obsidianShieldResearch = new Research(obsidianID, 425997, "Obsidian Shield", 18);
		obsidianShieldResearch.addItems(Obsidian_Shield_item); //Obsidian Shield
		obsidianShieldResearch.register();

		new NamespacedKey(this, "intensify_gravity_research");
		Research intenseGravityResearch = new Research(obsidianID, 425997, "Modifying Gravity", 20);
		intenseGravityResearch.addItems(Ground_Tome_item); //Ground Tome
		intenseGravityResearch.register();
	}



	@Override
	public void onDisable() {
		// Logic for disabling the plugin...
	}

	@Override
	public String getBugTrackerURL() {
		// You can return a link to your Bug Tracker instead of null here
		return "https://github.com/Gavin296/end-combat/issues";
	}

	@Override
	public JavaPlugin getJavaPlugin() {
		return this;
	}
}


