package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LevitationTome extends SlimefunItem {

    public LevitationTome(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {

        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        event.cancel();
        if (p.getFoodLevel() >= 2) {
            if (p.getGameMode() != GameMode.CREATIVE) {
                FoodLevelChangeEvent drainFood = new FoodLevelChangeEvent(p, p.getFoodLevel() - 2);
                Bukkit.getPluginManager().callEvent(drainFood); //drain food
                p.setFoodLevel(drainFood.getFoodLevel());
            }
            p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 0)); //levitation effect
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SHULKER_BULLET_HIT, 1, 1);
        } else {
            Slimefun.getLocalization().sendMessage(p, "messages.hungry", true); //hunger message
        }
    }
}