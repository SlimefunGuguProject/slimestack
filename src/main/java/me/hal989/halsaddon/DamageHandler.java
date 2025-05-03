package me.hal989.halsaddon;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import static me.hal989.halsaddon.HALsAddon.endermegaBoots;
import static me.hal989.halsaddon.HALsAddon.endermegaChestplate;
import static me.hal989.halsaddon.HALsAddon.endermegaHelmet;
import static me.hal989.halsaddon.HALsAddon.endermegaLeggings;
import static me.hal989.halsaddon.HALsAddon.isEndermegaEnraged;

public class DamageHandler implements Listener {
    public DamageHandler(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntityType().equals(EntityType.PLAYER)) {
            Player p = (Player) e.getEntity();
            ItemStack boots = p.getInventory().getBoots();//what is in each slot
            ItemStack leggings = p.getInventory().getLeggings();
            ItemStack chestplate = p.getInventory().getChestplate();
            ItemStack helmet = p.getInventory().getHelmet();


            if ((SlimefunUtils.isItemSimilar(boots, endermegaBoots, true)) && (SlimefunUtils.isItemSimilar(leggings, endermegaLeggings, true)) && //checking if endermega
                    (SlimefunUtils.isItemSimilar(chestplate, endermegaChestplate, true)) && (SlimefunUtils.isItemSimilar(helmet, endermegaHelmet, true))) {
                if (endermegaHelmet.getItem().canUse(p, true)) { //is it unlocked?
                    double xposition = (Math.random() * ((8) + 1)) + 0; //time to teleport
                    double zposition = (Math.random() * ((8) + 1)) + 0;
                    if (Math.random() > 0.5) {
                        xposition *= -1; //positive or negative x
                    }
                    if (Math.random() > 0.5) {
                        zposition *= -1; //same for z
                    }
                    p.teleport(new Location(p.getWorld(), p.getLocation().getX() + xposition, p.getLocation().getY(), p.getLocation().getZ() + zposition, p.getLocation().getYaw(), p.getLocation().getPitch()));
                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1); //sound
                }

            }


        } else if (e.getEntityType().equals(EntityType.ENDERMAN)) {
            if (e.getEntity().getCustomName() == null) return;
            if (e.getEntity().getCustomName().equals(ChatColors.color("&5末影巨兽"))) { //endermega abilities

                Location loc = e.getEntity().getLocation();
                Enderman enderman = (Enderman) e.getEntity();
                enderman.setCarriedBlock(null); //because it looks weird
                double RNG = Math.random();
                if (RNG >= 0.1 && RNG < 0.5) {
                    enderman.getWorld().playSound(enderman.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 1, 2);
                    Endermite endermite = (Endermite) loc.getWorld().spawnEntity(loc, EntityType.ENDERMITE);
                    endermite.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 3));//yay endermites
                    endermite.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 10000, 2));
                    endermite.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 1));
                }
                if (enderman.getHealth() < 40) {
                    RNG = Math.random();
                    if (RNG >= 0.3 && RNG < 0.5) {
                        enderman.getWorld().playSound(enderman.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 1, 2);
                        Endermite endermite = (Endermite) loc.getWorld().spawnEntity(loc, EntityType.ENDERMITE); //bonus chance for endermites when enraged
                        endermite.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 3));
                        endermite.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 10000, 2));
                        endermite.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 1));
                    }
                    if (RNG > 0.6 && RNG < 0.7) {
                        enderman.getWorld().playSound(enderman.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 1, 1);
                        enderman.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 60, 1)); //special attack #2
                        enderman.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 60, 200));
                        enderman.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, -1));
                        enderman.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 60, -1));

                    }

                    if (!isEndermegaEnraged) {
                        isEndermegaEnraged = true;
                        for (Entity n : enderman.getNearbyEntities(10.0, 10.0, 10.0)) {
                            if (n instanceof LivingEntity && (n instanceof Player)) {
                                n.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5末影巨兽 &e变得 &4更加狂暴了!")); //alert everyone fighting it only once

                            }
                        }
                    }
                }
            }
        }
    }
}
