package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
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


		SlimefunItemStack end_staff = new SlimefunItemStack("ENDER_STAFF", Material.STICK, "&6Elemental Staff - &5&oEnder", "", "&7Element: &5&oEnder","","&eRight Click &7to teleport.");
		SlimefunItemStack levitation_bow = new SlimefunItemStack("LEVITATION_BOW", Material.BOW, "&dShulker Bow", "", "&7Element: &5&oEnder","","&fAny enemies hit by this bow are launched into the air!");
		end_staff.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);



// Recipes
		ItemStack[] enderStaff_recipe = {
				null, null, SlimefunItems.RUNE_ENDER,
				null, SlimefunItems.STAFF_ELEMENTAL, null,
				SlimefunItems.STAFF_ELEMENTAL, null, null
		};

		EnderStaff endStaff = new EnderStaff(category, end_staff, RecipeType.MAGIC_WORKBENCH, enderStaff_recipe);
	endStaff.register(this);
		ItemStack[] shulkerBow_recipe = {
				null, SlimefunItems.STAFF_ELEMENTAL, new ItemStack(Material.CHORUS_FRUIT),
				end_staff, null, new ItemStack(Material.CHORUS_FRUIT),
				null, SlimefunItems.STAFF_ELEMENTAL, new ItemStack(Material.CHORUS_FRUIT)
		};
		ShulkerBow shulker_bow = new ShulkerBow(levitation_bow,shulkerBow_recipe);
		shulker_bow.register(this);
// Our item is now registered

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

