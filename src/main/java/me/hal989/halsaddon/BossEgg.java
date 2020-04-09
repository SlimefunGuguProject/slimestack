package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import me.mrCookieSlime.Slimefun.cscorelib2.inventory.ItemUtils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BossEgg extends SlimefunItem {

    public BossEgg(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {

        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }
    private void onItemRightClick(PlayerRightClickEvent event) {
        event.cancel();
        Player p = event.getPlayer();
        ItemStack item = event.getItem();
        Location loc = p.getTargetBlock(null, 8).getLocation();
        Enderman enderman = (Enderman) loc.getWorld().spawnEntity(loc, EntityType.ENDERMAN);
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 10000, 25));
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 2));
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, 2));
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000, 1));
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200));
        enderman.setCustomName(ChatColors.color("&5Endermega"));
        ItemUtils.consumeItem(event.getItem(), false);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SHULKER_BULLET_HIT, 1, 1);
        p.getWorld().playSound(p.getLocation(), Sound.MUSIC_DISC_WARD, 1, 2);
    }
}
