package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BowShootHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.weapons.SlimefunBow;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShulkerBow extends SlimefunBow {
    public ShulkerBow(ItemGroup category, SlimefunItemStack item, ItemStack[] recipe) {
        super(category, item, recipe);
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
