package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.net.URL;

public class SkullUtil {
    public static String getHash(ItemStack item) {
        if (item != null && (item.getType() == Material.PLAYER_HEAD || item.getType() == Material.PLAYER_WALL_HEAD)) {
            ItemMeta meta = item.getItemMeta();
            if (meta instanceof SkullMeta) {
                try {
                    URL t = ((SkullMeta) meta).getOwnerProfile().getTextures().getSkin();
                    String path = t.getPath();
                    String[] parts = path.split("/");
                    return parts[parts.length - 1];
                } catch (Throwable ignored) {
                }
            }
        }
        return null;
    }

    public static ItemStack getByBase64(String base64) {
        PlayerSkin skin = PlayerSkin.fromBase64(base64);
        return PlayerHead.getItemStack(skin);
    }

    public static ItemStack getByHash(String hash) {
        PlayerSkin skin = PlayerSkin.fromHashCode(hash);
        return PlayerHead.getItemStack(skin);
    }

    public static ItemStack getByURL(String url) {
        PlayerSkin skin = PlayerSkin.fromURL(url);
        return PlayerHead.getItemStack(skin);
    }
}
