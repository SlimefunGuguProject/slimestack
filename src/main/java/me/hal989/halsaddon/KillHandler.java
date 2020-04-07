package me.hal989.halsaddon;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

import static me.hal989.halsaddon.HALsAddon.Levitation_Tome;
import static me.hal989.halsaddon.HALsAddon.Trapped_ShulkerBox;

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
    }

}
