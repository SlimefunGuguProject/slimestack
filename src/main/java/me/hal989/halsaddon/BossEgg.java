package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import me.mrCookieSlime.Slimefun.cscorelib2.inventory.ItemUtils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.hal989.halsaddon.HALsAddon.isEndermegaEnraged;

public class BossEgg extends SlimefunItem {

    public BossEgg(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {

        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        event.cancel(); //don't want a normal enderman spawning
        Player p = event.getPlayer();
        if (!(p.getWorld().isThundering()) && !isEndermegaEnraged) {
            Location loc = p.getTargetBlock(null, 8).getLocation();
            Enderman enderman = (Enderman) loc.getWorld().spawnEntity(loc, EntityType.ENDERMAN);
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 10000, 25)); //Applying buffs to the endermega
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 2));
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, 2));
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000, 1));
            enderman.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200));
            enderman.setCustomName(ChatColors.color("&5Endermega"));
            if (p.getGameMode() != GameMode.CREATIVE) {
                ItemUtils.consumeItem(event.getItem(), false);
            } //bye spawn egg (but not if in creative)
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SHULKER_BULLET_HIT, 1, 1);
            p.getWorld().playSound(p.getLocation(), Sound.MUSIC_DISC_WARD, 1, 2); //epic boss music
        }
    }
}
