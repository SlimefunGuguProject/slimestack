package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TrappedShulker extends SlimefunItem {

    public TrappedShulker(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        BlockUseHandler blockUseHandler = this::onBlockRightClick;
        addItemHandler(blockUseHandler);
    }

    private void onBlockRightClick(PlayerRightClickEvent event) {
        event.cancel();
        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SHULKER_BOX_CLOSE, 1, 1);
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 1));
    }

}
