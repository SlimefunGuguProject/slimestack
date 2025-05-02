package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class EnderBlade extends SlimefunItem {
    public EnderBlade(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {

        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        if (event.getPlayer().isSneaking()) {
            Player p = event.getPlayer();
            event.cancel();
            if (p.getGameMode() != GameMode.CREATIVE) {

                ItemMeta meta = event.getItem().getItemMeta();
                ((Damageable) meta).setDamage(((Damageable) meta).getDamage() + 15);
                event.getItem().setItemMeta(meta);
            }
            p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 3, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch()));
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        }
    }
}