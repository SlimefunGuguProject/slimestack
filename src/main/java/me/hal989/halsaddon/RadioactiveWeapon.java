package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import org.bukkit.inventory.ItemStack;

public class RadioactiveWeapon extends SlimefunItem implements Radioactive {

    public RadioactiveWeapon(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        disenchantable = false;
    }

    @Override
    public Radioactivity getRadioactivity() {
        return Radioactivity.VERY_DEADLY;
    }
}