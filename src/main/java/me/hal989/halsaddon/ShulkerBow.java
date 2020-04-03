package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.implementation.items.weapons.SlimefunBow;
import me.mrCookieSlime.Slimefun.Objects.handlers.BowShootHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShulkerBow extends SlimefunBow {
    public ShulkerBow(SlimefunItemStack item, ItemStack[] recipe) {
        super(item, recipe);
    }
    @Override
    public BowShootHandler onShoot() {
        return (e, n) -> {
            n.getWorld().playEffect(n.getLocation(), Effect.STEP_SOUND, Material.HORN_CORAL_BLOCK);
            n.getWorld().playEffect(n.getEyeLocation(), Effect.STEP_SOUND, Material.HORN_CORAL_BLOCK);
            n.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20 * 1, 6));
        };
    }
}
