package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.implementation.items.weapons.SlimefunBow;
import me.mrCookieSlime.Slimefun.Objects.handlers.BowShootHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

public class IrregularBow extends SlimefunBow {
    public IrregularBow(SlimefunItemStack item, ItemStack[] recipe) {
        super(item, recipe);
    }
    @Override
    public BowShootHandler onShoot() {
        return (e, p) -> {
            p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+3, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch()));
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1); //Teleporting the hit entity up 3 blocks
        };
    }
}