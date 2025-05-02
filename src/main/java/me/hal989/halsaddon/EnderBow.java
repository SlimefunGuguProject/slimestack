package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BowShootHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.weapons.SlimefunBow;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;

public class EnderBow extends SlimefunBow {
    public EnderBow(ItemGroup category, SlimefunItemStack item, ItemStack[] recipe) {
        super(category, item, recipe);
    }

    @Override
    public BowShootHandler onShoot() {
        return (e, n) -> {
            Projectile firedArrow = (Projectile) e.getDamager();
            Player p = (Player) firedArrow.getShooter();
            Location enemyPos = n.getLocation().clone();
            Location playerPos = p.getLocation().clone();
            n.teleport(playerPos);
            p.teleport(enemyPos);
            n.getWorld().playSound(n.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        };
    }
}
