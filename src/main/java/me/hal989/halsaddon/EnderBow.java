package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.implementation.items.weapons.SlimefunBow;
import me.mrCookieSlime.Slimefun.Objects.handlers.BowShootHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

public class EnderBow extends SlimefunBow {
    public EnderBow(SlimefunItemStack item, ItemStack[] recipe) {
        super(item, recipe);
    }
    @Override
    public BowShootHandler onShoot() {
        return (e, n) -> {
        Location enemy_pos = new Location(n.getWorld(), n.getLocation().getX(), n.getLocation().getY(), n.getLocation().getZ(), n.getLocation().getYaw(), n.getLocation().getPitch());
        Location player_pos = new Location(e.getEntity().getWorld(), e.getEntity().getLocation().getX(),  e.getEntity().getLocation().getY(),  e.getEntity().getLocation().getZ(),  e.getEntity().getLocation().getYaw(),  e.getEntity().getLocation().getPitch());
        n.teleport(player_pos);
        e.getEntity().teleport(enemy_pos);
        n.getWorld().playSound(n.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        };
    }
}
