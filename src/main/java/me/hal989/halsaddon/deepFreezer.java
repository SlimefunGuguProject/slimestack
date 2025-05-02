package me.hal989.halsaddon;


import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.stream.Collectors;

import static me.hal989.halsaddon.HALsAddon.*;

public class deepFreezer extends MultiBlockMachine {

    public deepFreezer() {
        super(
                enderItemGroup,
                DEEPFREEZER,
                new ItemStack[]{null, null, null, null, new ItemStack(Material.SNOW_BLOCK), null, new ItemStack(Material.PACKED_ICE), new ItemStack(Material.DISPENSER), new ItemStack(Material.PACKED_ICE)},
                new ItemStack[]{
                        new ItemStack(Material.ICE, 4), new ItemStack(Material.PACKED_ICE),
                        new ItemStack(Material.PACKED_ICE, 4), new ItemStack(Material.BLUE_ICE),
                        new ItemStack(Material.SNOWBALL, 8), new ItemStack(Material.SNOW)

                },
                BlockFace.SELF
        );
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        return recipes.stream().map(items -> items[0]).collect(Collectors.toList());
    }

    @Override
    public void onInteract(Player p, Block b) {
        Block dispBlock = b.getRelative(BlockFace.DOWN);
        Dispenser disp = (Dispenser) dispBlock.getState();
        Inventory inv = disp.getInventory();

        for (ItemStack item : inv.getContents()) {
            for (ItemStack recipeInput : RecipeType.getRecipeInputs(this)) {
                if (recipeInput != null && SlimefunUtils.isItemSimilar(item, recipeInput, true)) {
                    ItemStack output = RecipeType.getRecipeOutput(this, recipeInput);
                    Inventory outputInv = findOutputInventory(output, dispBlock, inv);

                    if (outputInv != null) {
                        ItemStack removing = item.clone();
                        removing.setAmount(recipeInput.getAmount());
                        inv.removeItem(removing);

                        craft(p, output, outputInv);
                    } else {
                        Slimefun.getLocalization().sendMessage(p, "machines.full-inventory", true);
                    }

                    return;
                }
            }
        }

        Slimefun.getLocalization().sendMessage(p, "machines.unknown-material", true);
    }

    private void craft(Player p, ItemStack output, Inventory outputInv) {
        for (int i = 0; i < 4; i++) {
            int j = i;

            Bukkit.getScheduler().runTaskLater(Slimefun.instance(), () -> {
                if (j < 3) {
                    p.getWorld().playSound(p.getLocation(), j == 1 ? Sound.ITEM_ARMOR_EQUIP_DIAMOND : Sound.ITEM_ARMOR_EQUIP_TURTLE, 1F, j == 0 ? 1F : 2F);
                } else {
                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1F, 1F);
                    outputInv.addItem(output);
                }
            }, i * 20L);
        }
    }

}
