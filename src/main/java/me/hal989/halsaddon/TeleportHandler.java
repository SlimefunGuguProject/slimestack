package me.hal989.halsaddon;

import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import org.bukkit.Location;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TeleportHandler implements Listener {
    public TeleportHandler(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onTeleport(EntityTeleportEvent e) {
        if (e.getEntity().getCustomName().equals(ChatColors.color("&5Endermega"))){
            Location loc = e.getEntity().getLocation();
            Endermite endermite = (Endermite) loc.getWorld().spawnEntity(loc, EntityType.ENDERMITE);
            endermite.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 4));
            endermite.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, 1));
            Endermite endermite2 = (Endermite) loc.getWorld().spawnEntity(loc, EntityType.ENDERMITE);
            endermite2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 4));
            endermite2.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, 1));
            e.getEntity().setFireTicks(0);
            Enderman enderman = (Enderman) e.getEntity();
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,40,200));


        }
    }

}

