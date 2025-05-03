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
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GroundTome extends SlimefunItem {

    public GroundTome(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
            for (Entity n : event.getPlayer().getNearbyEntities(10.0, 10.0, 10.0)) {
                if (n instanceof LivingEntity && !(n instanceof ArmorStand) && !n.getUniqueId().equals(event.getPlayer().getUniqueId())) {
                    ((LivingEntity) n).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, -100)); //intense gravity for 3 seconds
                    n.getWorld().playSound(n.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
                }
            }
        } else {
            Slimefun.getLocalization().sendMessage(p, "messages.hungry", true); //hunger message
        }
    }
}