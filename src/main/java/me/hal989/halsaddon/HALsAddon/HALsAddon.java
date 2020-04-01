package me.hal989.halsaddon.HALsAddon;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

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
		NamespacedKey categoryId = new NamespacedKey(this, "cool_category");
		CustomItem categoryItem = new CustomItem(Material.EMERALD, "&4Our very cool Category");

		Category category = new Category(categoryId, categoryItem);
		
		// Create a new Slimefun ItemStack
		// This class has many constructors, it is very important that you give each item a unique id.


		SlimefunItemStack itemStack = new SlimefunItemStack("MY_ADDON_ITEM", Material.EMERALD, "&aPretty cool Emerald", "", "&7This is awesome");

// A 3x3 shape representing our recipe
		ItemStack[] recipe = {
				new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND),
				null,                               SlimefunItems.CARBONADO,            null,
				new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND)
		};

		SlimefunItem sfItem = new SlimefunItem(category, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
		sfItem.register(this);
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
