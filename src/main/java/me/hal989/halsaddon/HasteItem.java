package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import static me.hal989.halsaddon.HALsAddon.*;

public class HasteItem extends SlimefunItem {
    public HasteItem(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
    @Override
    public void preRegister() {

        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        if (event.getPlayer().isSneaking()){
        Player p = event.getPlayer();
        event.cancel();
        if(p.getInventory().containsAtLeast(SlimefunItems.ENDER_LUMP_1, 1)) {
            if (p.getGameMode() != GameMode.CREATIVE) {
                p.getInventory().removeItem(SlimefunItems.ENDER_LUMP_1);
            }
            ItemMeta meta = event.getItem().getItemMeta();
            ((Damageable) meta).setDamage(((Damageable) meta).getDamage()-2);
            event.getItem().setItemMeta(meta);

        }
        else {
                if(event.getItem()==endStonePickaxe){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &5 Endstone Pickaxe &9requires more ender lumps to repair itself!"));
            }
            if(event.getItem()==endStoneAxe){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &5 Endstone Axe &9requires more ender lumps to repair itself!"));
            }
            if(event.getItem()==endStoneShovel){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &5 Endstone Shovel &9requires more ender lumps to repair itself!"));
            }
            if(event.getItem()==endStoneSword){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &5 Endstone Sword &9requires more ender lumps to repair itself!"));
            }
            if(event.getItem()==endStoneHoe){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Your &5 Endstone Hoe &9requires more ender lumps to repair itself!"));
            }


        }}
    }
}

