package me.hal989.halsaddon;

import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

import static me.hal989.halsaddon.HALsAddon.*;

public class KillHandler implements Listener {
    public KillHandler(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onKill(EntityDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        if (e.getEntityType() == EntityType.SHULKER){
            e.getDrops().remove(Trapped_ShulkerBox);
            e.getDrops().remove(Levitation_Tome);

            double RNG = Math.random();
            if (RNG>=0.05&&RNG<0.1){
                e.getDrops().add(Trapped_ShulkerBox);
            }
            if (RNG>=0.1&&RNG<0.15){
                e.getDrops().add(Levitation_Tome);
            }


        }
        if ((e.getEntityType() == EntityType.ENDERMAN)&&(e.getEntity().getCustomName().equals(ChatColors.color("&5Endermega")))){
            double RNG = Math.random();
            if (RNG<0.2){
                e.getDrops().add(endermegaLeggings);
            }
            if (RNG>=0.2&&RNG<0.4){
                e.getDrops().add(endermegaBoots);
            }
            if (RNG>=0.4&&RNG<0.6){
                e.getDrops().add(endermegaChestplate);
            }
            if (RNG>=0.6&&RNG<0.8){
                e.getDrops().add(endermegaHelmet);
            }
            if (RNG>=0.8){
                e.getDrops().add(endermegaHelmet);
            }
            e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            RNG = Math.random();
            if (RNG<0.2){
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            if (RNG>=0.2&&RNG<0.4){
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            if (RNG>=0.4&&RNG<0.6){
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            if (RNG>=0.6&&RNG<0.8){
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            if (RNG>=0.8){
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
        }
    }

}
