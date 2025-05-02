package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import org.bukkit.entity.EntityType;
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
        if (e.getEntity().getCustomName() == null) return;
        if (e.getEntityType() == EntityType.SHULKER) {
            e.getDrops().remove(Trapped_ShulkerBox);
            e.getDrops().remove(Levitation_Tome);

            double RNG = Math.random();
            if (RNG >= 0.05 && RNG < 0.1) {
                e.getDrops().add(Trapped_ShulkerBox); //Rare drops for the shulker
            }
            if (RNG >= 0.1 && RNG < 0.15) {
                e.getDrops().add(Levitation_Tome); //5% chance for each
            }


        }
        if ((e.getEntityType() == EntityType.ENDERMAN) && (e.getEntity().getCustomName().equals(ChatColors.color("&5Endermega")))) {
            double RNG = Math.random();
            if (RNG < 0.25) {
                e.getDrops().add(endermegaLeggings); //Drop a piece of the endermega set
            }
            if (RNG >= 0.25 && RNG < 0.5) {
                e.getDrops().add(endermegaBoots);
            }
            if (RNG >= 0.5 & RNG < 0.75) {
                e.getDrops().add(endermegaChestplate);
            }
            if (RNG >= 0.75) {
                e.getDrops().add(endermegaHelmet);
            }
            RNG = Math.random();
            if (RNG < 0.3) {
                e.getDrops().add(enderBlade); //And a weapon from the pool (or a head, rarely)
            }
            if (RNG >= 0.3 && RNG < 0.6) {
                e.getDrops().add(irregularbow);
            }
            if (RNG >= 0.6 & RNG < 0.7) {
                e.getDrops().add(endermegaHead);
            }
            if (RNG >= 0.7) {
                e.getDrops().add(enderstaffTier2);
            }
            e.getDrops().add(SlimefunItems.ENDER_LUMP_3); //Drop 2-6 ender lumps
            RNG = Math.random();
            if (RNG < 0.2) {
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            if (RNG >= 0.2 && RNG < 0.4) {
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            if (RNG >= 0.4 && RNG < 0.6) {
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            if (RNG >= 0.6 && RNG < 0.8) {
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            if (RNG >= 0.8) {
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
                e.getDrops().add(SlimefunItems.ENDER_LUMP_3);
            }
            isEndermegaEnraged = false; //allow for another boss
        }
    }

}
