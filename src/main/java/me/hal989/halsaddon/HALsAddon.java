package me.hal989.halsaddon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class HALsAddon extends JavaPlugin implements SlimefunAddon {
    public static SlimefunItemStack Trapped_ShulkerBox;
    public static SlimefunItemStack Levitation_Tome;
    public static SlimefunItemStack endStonePickaxe;
    public static SlimefunItemStack endStoneAxe;
    public static SlimefunItemStack endStoneShovel;
    public static SlimefunItemStack endStoneSword;
    public static SlimefunItemStack endStoneHoe;
    public static SlimefunItemStack endermegaEgg;
    public static RecipeType BOSS_DROP;
    public static SlimefunItemStack endermegaHelmet;
    public static SlimefunItemStack endermegaChestplate;
    public static SlimefunItemStack endermegaLeggings;
    public static SlimefunItemStack endermegaBoots;
    public static SlimefunItemStack enderstaffTier2;
    public static SlimefunItemStack enderBlade;
    public static SlimefunItemStack irregularbow;
    public static SlimefunItemStack endermegaHead;
    public static SlimefunItemStack DEEPFREEZER;
    public static Boolean isEndermegaEnraged;
    public static RecipeType DEEP_FREEZER;
    public static ItemGroup enderItemGroup;


    @Override
    public void onEnable() {
        NamespacedKey categoryId = new NamespacedKey(this, "ender_items");
        CustomItemStack categoryItem = new CustomItemStack(Material.END_STONE, "&5末地拓展");
    
        enderItemGroup = new ItemGroup(categoryId, categoryItem);
        DEEPFREEZER = new SlimefunItemStack("DEEPFREEZER", Material.BLUE_ICE, "&b急冻机", "", "&a以极低温度冻结物品");
        isEndermegaEnraged = false;
        Trapped_ShulkerBox = new SlimefunItemStack("TRAPPED_SHULKERBOX", Material.SHULKER_BOX, "&f陷阱潜影箱", "", "&f尝试打开箱子的人将", "&f获得漂浮效果，持续5秒。");
        endermegaEgg = new SlimefunItemStack("ENDERMEGA_EGG", Material.ENDERMAN_SPAWN_EGG, "&5末影巨兽刷怪蛋");
    
        SlimefunItemStack end_staff = new SlimefunItemStack("ENDER_STAFF", Material.STICK, "&6元素法杖 - &5&o末影", "", "&7元素：&5&o末影", "", "&e右键 &7传送。");
        SlimefunItemStack levitation_bow = new SlimefunItemStack("LEVITATION_BOW", Material.BOW, "&d漂浮弓", "", "&f被此弓射中的敌人将被发射到空中！");
        SlimefunItemStack ender_crossbow = new SlimefunItemStack("ENDER_CROSSBOW", Material.BOW, "&5末影弩", "", "&f用此弓射中的敌人将与你交换位置！");
        end_staff.addUnsafeEnchantment(Enchantment.CHANNELING, 1);
        SlimefunItemStack FrozenBar_1 = new SlimefunItemStack("FROZEN_BAR_1", Material.IRON_INGOT, "&5冰冻锭 &d(33%)");
        SlimefunItemStack EndFragment = new SlimefunItemStack("END_FRAGMENT", Material.IRON_NUGGET, "&d末影碎片");
        SlimefunItemStack Compressed_EndFragment = new SlimefunItemStack("COMPRESSED_END_FRAGMENT", Material.IRON_NUGGET, "&d压缩末影碎片");
        SlimefunItemStack FrozenBar_2 = new SlimefunItemStack("FROZEN_BAR_2", Material.IRON_INGOT, "&5冰冻锭 &d(66%)");
        SlimefunItemStack FrozenBar_Full = new SlimefunItemStack("FROZEN_BAR_FULL", Material.IRON_INGOT, "&5冰冻锭");
        SlimefunItemStack Blistering_Blade = new SlimefunItemStack("BLISTERING_BLADE", Material.GOLDEN_SWORD, "&6灼烧之刃", "", LoreBuilder.radioactive(Radioactivity.VERY Deadly), LoreBuilder.HAZMAT_SUIT_REQUIRED);
        Blistering_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
        Blistering_Blade.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);
        Blistering_Blade.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 3);
        Blistering_Blade.addUnsafeEnchantment(Enchantment.DURABILITY, 10); // 灼烧之刃
        SlimefunItemStack Freezing_Blade = new SlimefunItemStack("FREEZING_BLADE", Material.DIAMOND_SWORD, "&b冰冻之刃");
        Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
        Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 3);
        Freezing_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 3);
        Freezing_Blade.addUnsafeEnchantment(Enchantment.DURABILITY, 5); // 冰冻之刃
        SlimefunItemStack Equal_Blade = new SlimefunItemStack("EQUILIBRIUM", Material.IRON_SWORD, "&9平衡之刃", "", "&f很少有人能获得这把剑，且几乎没人有能力挥舞它。", "", LoreBuilder.radioactive(Radioactivity.VERY Deadly), LoreBuilder.HAZMAT_SUIT_REQUIRED);
        Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
        Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 3);
        Equal_Blade.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 3);
        Equal_Blade.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);
        Equal_Blade.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 3);
        Equal_Blade.addUnsafeEnchantment(Enchantment.DURABILITY, 10); // 平衡之刃
        Levitation_Tome = new SlimefunItemStack("LEVITATION_TOME", Material.ENCHANTED_BOOK, "&f法术书 (&b反重力&f)", "", "&e右键 &f- 获得短暂的悬浮效果");
        SlimefunItemStack Ground_Tome = new SlimefunItemStack("GROUND_TOME", Material.ENCHANTED_BOOK, "&f法术书 (&8重力强化&f)", "", "&e右键 &f- 强化附近所有实体的重力");
        SlimefunItemStack Obsidian_Shield = new SlimefunItemStack("OBSIDIAN_SHIELD", Material.SHIELD, "&f黑曜石盾牌");
        Obsidian_Shield.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
    
        endStonePickaxe = new SlimefunItemStack("ENDSTONE_PICKAXE", Material.GOLDEN_PICKAXE, "&f末地石镐", "", "&eShift右键 &f- 消耗一个末影结晶", "&f以恢复镐的2点耐久。");
        endStoneShovel = new SlimefunItemStack("ENDSTONE_SHOVEL", Material.GOLDEN_SHOVEL, "&f末地石锹", "", "&eShift右键 &f- 消耗一个末影结晶", "&f以恢复锹的2点耐久。");
        endStoneSword = new SlimefunItemStack("ENDSTONE_SWORD", Material.GOLDEN_SWORD, "&f末地石剑", "", "&eShift右键 &f- 消耗一个末影结晶", "&f以恢复剑的2点耐久。");
        endStoneAxe = new SlimefunItemStack("ENDSTONE_AXE", Material.GOLDEN_AXE, "&f末地石斧", "", "&eShift右键 &f- 消耗一个末影结晶", "&f以恢复斧的2点耐久。");
        endStoneHoe = new SlimefunItemStack("ENDSTONE_HOE", Material.GOLDEN_HOE, "&f末地石锄", "", "&eShift右键 &f- 消耗一个末影结晶", "&f以恢复锄的2点耐久。");
        BOSS_DROP = new RecipeType(new NamespacedKey(this, "boss_drop"), new CustomItemStack(Material.DIAMOND_SWORD, "&cBoss掉落物"), null, "", "&r击败指定的Boss以获得此物品");
    
        // 末影巨兽掉落物
        endermegaHelmet = new SlimefunItemStack("ENDERMEGA_HELMET", Material.LEATHER_HELMET, Color.BLACK, "&5末影巨兽头盔", "", "&5末影巨兽&d的力量流淌于这套装备之中...", "", "&b套装效果：受到攻击时传送");
        endermegaHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        endermegaHelmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        endermegaHelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 8);
        endermegaChestplate = new SlimefunItemStack("ENDERMEGA_CHESTPLATE", Material.LEATHER_CHESTPLATE, Color.BLACK, "&5末影巨兽胸甲", "", "&5末影巨兽&d的力量流淌于这套装备之中...", "", "&b套装效果：受到攻击时传送");
        endermegaChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        endermegaChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        endermegaChestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 8);
        endermegaLeggings = new SlimefunItemStack("ENDERMEGA_LEGGINGS", Material.LEATHER_LEGGINGS, Color.BLACK, "&5末影巨兽护腿", "", "&5末影巨兽&d的力量流淌于这套装备之中...", "", "&b套装效果：受到攻击时传送");
        endermegaLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        endermegaLeggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        endermegaLeggings.addUnsafeEnchantment(Enchantment.DURABILITY, 8);
        endermegaBoots = new SlimefunItemStack("ENDERMEGA_BOOTS", Material.LEATHER_BOOTS, Color.BLACK, "&5末影巨兽靴子", "", "&5末影巨兽&d的力量流淌于这套装备之中...", "", "&b套装效果：受到攻击时传送");
        endermegaBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        endermegaBoots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        endermegaBoots.addUnsafeEnchantment(Enchantment.DURABILITY, 8);
    
        enderstaffTier2 = new SlimefunItemStack("ENDER_STAFF_2", Material.BLAZE_ROD, "&6元素法杖 - &5&o末影 &0(&a精通&0)", "", "&7元素：&5&o末影", "", "&e右键 &7传送", "&a精通 - 范围翻倍");
        enderstaffTier2.addUnsafeEnchantment(Enchantment.CHANNELING, 1);
        enderBlade = new SlimefunItemStack("ENDER_BLADE", Material.IRON_SWORD, "&5末影剑", "", "&eShift右键 &f- 消耗一些耐久", "&f将你传送到3格高的空中。");
        irregularbow = new SlimefunItemStack("IRREGULAR_BOW", Material.BOW, "&1反规则弓");
        irregularbow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 4);
    
        endermegaHead = new SlimefunItemStack("ENDERMEGA_HEAD", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmJjZjNmNTc4NzE5NmQyNTZjMTA0ZmZmYWU4ZTUyNjUyNDIyMjJlMjEzOGE1N2ExNjY2YzE1YjVmNmM4N2I5OCJ9fX0=", "&e末影巨兽头颅", "&7纯粹用于装饰。");
        // 多方块结构
    
        DEEP_FREEZER = new RecipeType(new NamespacedKey(this, "deepfreezer"), DEEPFREEZER);
        new deepFreezer().register(this);


        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        // Slimefun4 also already comes with a bundled version of bStats
        // You can use bStats to collect usage data about your plugin
        // More info: https://bstats.org/getting-started
        // Set bStatsId to the id of your plugin
        new KillHandler(this);
        new TeleportHandler(this);
        new DamageHandler(this);


        // Create a new Category
        // This ItemGroup will use this ItemStack

//Defining Items


// Recipes
        ItemStack[] enderStaff_recipe = {
                null, null, SlimefunItems.ENDER_RUNE,
                null, SlimefunItems.STAFF_ELEMENTAL, null,
                SlimefunItems.STAFF_ELEMENTAL, null, null
        };
//Endstone Tools
        ItemStack[] endstonePickaxeRecipe = {
                new ItemStack(Material.END_STONE), new ItemStack(Material.END_STONE), new ItemStack(Material.END_STONE),
                null, new ItemStack(Material.BLAZE_ROD), null,
                null, new ItemStack(Material.BLAZE_ROD), null
        };
        ItemStack[] endstoneShovelRecipe = {
                null, new ItemStack(Material.END_STONE), null,
                null, new ItemStack(Material.BLAZE_ROD), null,
                null, new ItemStack(Material.BLAZE_ROD), null
        };
        ItemStack[] endstoneHoeRecipe = {
                null, new ItemStack(Material.END_STONE), new ItemStack(Material.END_STONE),
                null, new ItemStack(Material.BLAZE_ROD), null,
                null, new ItemStack(Material.BLAZE_ROD), null
        };

        ItemStack[] endstoneAxeRecipe = {
                null, new ItemStack(Material.END_STONE), new ItemStack(Material.END_STONE),
                null, new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.END_STONE),
                null, new ItemStack(Material.BLAZE_ROD), null
        };

        ItemStack[] endstoneSwordRecipe = {
                null, new ItemStack(Material.END_STONE), null,
                null, new ItemStack(Material.END_STONE), null,
                null, new ItemStack(Material.BLAZE_ROD), null
        };
        HasteItem endstoneHoeItem = new HasteItem(enderItemGroup, endStoneHoe, RecipeType.ENHANCED_CRAFTING_TABLE, endstoneHoeRecipe); //endstone tools
        HasteItem endstoneShovelItem = new HasteItem(enderItemGroup, endStoneShovel, RecipeType.ENHANCED_CRAFTING_TABLE, endstoneShovelRecipe);
        HasteItem endstoneAxeItem = new HasteItem(enderItemGroup, endStoneAxe, RecipeType.ENHANCED_CRAFTING_TABLE, endstoneAxeRecipe);
        HasteItem endstonePickaxeItem = new HasteItem(enderItemGroup, endStonePickaxe, RecipeType.ENHANCED_CRAFTING_TABLE, endstonePickaxeRecipe);
        HasteItem endstoneSwordItem = new HasteItem(enderItemGroup, endStoneSword, RecipeType.ENHANCED_CRAFTING_TABLE, endstoneSwordRecipe);
        endstoneAxeItem.register(this);
        endstonePickaxeItem.register(this);
        endstoneShovelItem.register(this);
        endstoneHoeItem.register(this);
        endstoneSwordItem.register(this);

        new ItemStack(Material.REDSTONE_BLOCK);
        new ItemStack(Material.SHULKER_BOX);
        new ItemStack(Material.TRIPWIRE_HOOK);

        ItemStack[] Obsidian_Shield_recipe = {
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.SHIELD), new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN)
        };
        ItemStack[] shulkerHead = {
                null, null, null,
                null, new CustomItemStack(SkullUtil.getByBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFkMzUzNGQyMWZlODQ5OTI2MmRlODdhZmZiZWFjNGQyNWZmZGUzNWM4YmRjYTA2OWU2MWUxNzg3ZmYyZiJ9fX0="), "&d潜影贝"), null,
                null, null, null //shulker drop for recipes
        };
        ItemStack[] endermegaDrop = {
                null, null, null,
                null, new CustomItemStack(SkullUtil.getByBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmJjZjNmNTc4NzE5NmQyNTZjMTA0ZmZmYWU4ZTUyNjUyNDIyMjJlMjEzOGE1N2ExNjY2YzE1YjVmNmM4N2I5OCJ9fX0="), "&5末影巨兽"), null,
                null, null, null //endermega head for recipes
        };

        ItemStack[] Ground_Tome_recipe = {
                SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.ANVIL), SlimefunItems.ENDER_LUMP_2, //ground tome recipe
                SlimefunItems.ENDER_LUMP_2, SlimefunItems.MAGICAL_BOOK_COVER, SlimefunItems.ENDER_LUMP_2,
                SlimefunItems.ENDER_LUMP_2, null, SlimefunItems.ENDER_LUMP_2
        };
        SlimefunItem Obsidian_Shield_item = new SlimefunItem(enderItemGroup, Obsidian_Shield, RecipeType.ENHANCED_CRAFTING_TABLE, Obsidian_Shield_recipe);
        Obsidian_Shield_item.register(this);
        ItemStack[] Ender_Crossbow_recipe = {
                SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_RUNE,
                SlimefunItems.ENDER_RUNE, new ItemStack(Material.CROSSBOW), SlimefunItems.ENDER_RUNE,
                SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_RUNE
        };

        EnderStaff endStaff = new EnderStaff(enderItemGroup, end_staff, RecipeType.MAGIC_WORKBENCH, enderStaff_recipe);
        endStaff.register(this);
        LevitationTome Levitation_Tome_item = new LevitationTome(enderItemGroup, Levitation_Tome, RecipeType.MOB_DROP, shulkerHead);
        Levitation_Tome_item.register(this);
        GroundTome Ground_Tome_item = new GroundTome(enderItemGroup, Ground_Tome, RecipeType.MAGIC_WORKBENCH, Ground_Tome_recipe);
        Ground_Tome_item.register(this);
        ItemStack[] shulkerBow_recipe = {
                null, SlimefunItems.STAFF_ELEMENTAL, new ItemStack(Material.CHORUS_FRUIT),
                end_staff, null, new ItemStack(Material.CHORUS_FRUIT),
                null, SlimefunItems.STAFF_ELEMENTAL, new ItemStack(Material.CHORUS_FRUIT)
        };
        ShulkerBow shulker_bow = new ShulkerBow(enderItemGroup, levitation_bow, shulkerBow_recipe); //Shulker Bow
        shulker_bow.register(this);
        EnderBow ender_crossbow_item = new EnderBow(enderItemGroup, ender_crossbow, Ender_Crossbow_recipe); //Ender Crossbow
        ender_crossbow_item.register(this);
        TrappedShulker Trapped_ShulkerBox_item = new TrappedShulker(enderItemGroup, Trapped_ShulkerBox, RecipeType.MOB_DROP, shulkerHead); //Trapped Shulker Box
        Trapped_ShulkerBox_item.register(this);
// End Bars & Fragments

        ItemStack[] EndFragment_recipe = {
                SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.END_STONE), SlimefunItems.ENDER_LUMP_3,
                new ItemStack(Material.END_STONE), new ItemStack(Material.CHORUS_FRUIT), new ItemStack(Material.END_STONE),
                SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.END_STONE), SlimefunItems.ENDER_LUMP_3
        };
        SlimefunItem EndFragment_item = new SlimefunItem(enderItemGroup, EndFragment, RecipeType.MAGIC_WORKBENCH, EndFragment_recipe);
        EndFragment_item.register(this); //End Fragment
        ItemStack[] FrozenBar1_recipe = {
                SlimefunItems.GOLD_24K, EndFragment, null,
                null, null, null,
                null, null, null
        };
        ItemStack[] CompressedEndFragment_recipe = { //compressed end fragment
                EndFragment, EndFragment, null,
                EndFragment, EndFragment, null,
                null, null, null,
        };
        //SlimefunItem DragonBreathAlt_Recipe = new SlimefunItem(enderItemGroup, (SlimefunItemStack) new ItemStack(Material.DRAGON_BREATH), RecipeType.GRIND_STONE, DragonBreath_Recipe);
        //DragonBreathAlt_Recipe.register(this);
        SlimefunItem CompressedEndFragment_Item = new SlimefunItem(enderItemGroup, Compressed_EndFragment, RecipeType.MAGIC_WORKBENCH, CompressedEndFragment_recipe);
        CompressedEndFragment_Item.register(this); //compressed end fragment
        SlimefunItem FrozenBar1_item = new SlimefunItem(enderItemGroup, FrozenBar_1, RecipeType.MAGIC_WORKBENCH, FrozenBar1_recipe);
        FrozenBar1_item.register(this); //Frozen Bar (33%)
        ItemStack[] FrozenBar2_recipe = {
                null, new ItemStack(Material.SHULKER_SHELL), null,
                new ItemStack(Material.SHULKER_SHELL), FrozenBar_1, new ItemStack(Material.SHULKER_SHELL),
                null, new ItemStack(Material.SHULKER_SHELL), null
        };
        SlimefunItem FrozenBar2_item = new SlimefunItem(enderItemGroup, FrozenBar_2, DEEP_FREEZER, FrozenBar2_recipe);
        FrozenBar2_item.register(this); //Frozen Bar (66%)
        ItemStack[] FrozenBar_Full_recipe = {
                new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH),
                new ItemStack(Material.DRAGON_BREATH), FrozenBar_2, new ItemStack(Material.DRAGON_BREATH),
                new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH), new ItemStack(Material.DRAGON_BREATH)
        };
        SlimefunItem FrozenBar_Full_item = new SlimefunItem(enderItemGroup, FrozenBar_Full, DEEP_FREEZER, FrozenBar_Full_recipe);
        FrozenBar_Full_item.register(this); //Frozen Bar (Full)
        ItemStack[] Blistering_Blade_recipe = {
                null, SlimefunItems.BLISTERING_INGOT_3, null,
                null, SlimefunItems.BLISTERING_INGOT_3, null,
                null, new ItemStack(Material.STICK), null,
        };
        RadioactiveWeapon Blistering_Blade_item = new RadioactiveWeapon(enderItemGroup, Blistering_Blade, RecipeType.ENHANCED_CRAFTING_TABLE, Blistering_Blade_recipe);
        Blistering_Blade_item.register(this); //Blistering Blade
        ItemStack[] Freezing_Blade_recipe = {
                null, FrozenBar_Full, null,
                null, FrozenBar_Full, null,
                null, new ItemStack(Material.STICK), null,
        };
        SlimefunItem Freezing_Blade_item = new SlimefunItem(enderItemGroup, Freezing_Blade, DEEP_FREEZER, Freezing_Blade_recipe);
        Freezing_Blade_item.register(this); //Freezing Blade
        ItemStack[] endermegaEggRecipe = {
                SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_RUNE,
                EndFragment, new ItemStack(Material.EGG), EndFragment,
                SlimefunItems.ENDER_RUNE, SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_RUNE,
        };
        ItemStack[] Equilibrium_Blade_recipe = {
                null, Freezing_Blade, null,
                null, Blistering_Blade, null,
                null, new ItemStack(Material.STICK), null,
        };
        RadioactiveWeapon Equilibrium_Blade_item = new RadioactiveWeapon(enderItemGroup, Equal_Blade, DEEP_FREEZER, Equilibrium_Blade_recipe);
        Equilibrium_Blade_item.isDisenchantable();
        Equilibrium_Blade_item.register(this); //Equilibrium

        //Endermega stuff

        BossEgg endermegaEggItem = new BossEgg(enderItemGroup, endermegaEgg, RecipeType.ANCIENT_ALTAR, endermegaEggRecipe);
        endermegaEggItem.register(this);

        SlimefunItem endermegaHelmetItem = new SlimefunItem(enderItemGroup, endermegaHelmet, BOSS_DROP, endermegaDrop); //endermega set
        endermegaHelmetItem.register(this);
        SlimefunItem endermegaChestplateItem = new SlimefunItem(enderItemGroup, endermegaChestplate, BOSS_DROP, endermegaDrop);
        endermegaChestplateItem.register(this);
        SlimefunItem endermegaLeggingsItem = new SlimefunItem(enderItemGroup, endermegaLeggings, BOSS_DROP, endermegaDrop);
        endermegaLeggingsItem.register(this);
        SlimefunItem endermegaBootsItem = new SlimefunItem(enderItemGroup, endermegaBoots, BOSS_DROP, endermegaDrop);
        endermegaBootsItem.register(this);
        EnderStaff2 enderstaffTier2Item = new EnderStaff2(enderItemGroup, enderstaffTier2, BOSS_DROP, endermegaDrop); //ender staff tier 2
        enderstaffTier2Item.register(this);
        EnderBlade enderBladeItem = new EnderBlade(enderItemGroup, enderBlade, BOSS_DROP, endermegaDrop); //ender blade
        enderBladeItem.register(this);
        SlimefunItem enderHeadItem = new SlimefunItem(enderItemGroup, endermegaHead, BOSS_DROP, endermegaDrop); //ender head
        enderHeadItem.register(this);
        SlimefunItem irregularBowItem = new SlimefunItem(enderItemGroup, irregularbow, BOSS_DROP, endermegaDrop);
        irregularBowItem.register(this); //irregular bow
        //Research
        NamespacedKey ender_fragments_research_id = new NamespacedKey(this, "ender_fragments_r");
        Research ender_fragments_research = new Research(ender_fragments_research_id, 425989, "末影碎片", 13);
        ender_fragments_research.addItems(EndFragment_item, CompressedEndFragment_Item);
        ender_fragments_research.register();

        NamespacedKey frozen_bars_research_id = new NamespacedKey(this, "frozen_bars_research");
        Research frozen_bars_research = new Research(frozen_bars_research_id, 425990, "急冻条", 40);
        frozen_bars_research.addItems(FrozenBar1_item, FrozenBar2_item, FrozenBar_Full_item);
        frozen_bars_research.register();

        NamespacedKey ShulkerBow_research_id = new NamespacedKey(this, "shulkerbow_research");
        Research ShulkerBow_research = new Research(ShulkerBow_research_id, 425991, "潜影贝的弓", 20);
        ShulkerBow_research.addItems(shulker_bow);
        ShulkerBow_research.register();

        NamespacedKey EndStaff_research_id = new NamespacedKey(this, "enderstaff_research");
        Research EnderStaff_research = new Research(EndStaff_research_id, 425992, "末影法杖", 21);
        EnderStaff_research.addItems(endStaff);
        EnderStaff_research.register();

        NamespacedKey Hot_and_cold_research_id = new NamespacedKey(this, "hot_and_cold_research");
        Research Hot_cold_research = new Research(Hot_and_cold_research_id, 425993, "极端温度武器化", 35);
        Hot_cold_research.addItems(Equilibrium_Blade_item, Freezing_Blade_item, Blistering_Blade_item);
        Hot_cold_research.register();

        NamespacedKey endstoneToolsID = new NamespacedKey(this, "endstone_tools_research");
        Research endstoneToolsResearch = new Research(endstoneToolsID, 425994, "末地石工具", 18);
        endstoneToolsResearch.addItems(endstoneAxeItem, endstonePickaxeItem, endstonePickaxeItem, endstoneShovelItem, endstoneSwordItem, endstoneHoeItem);
        endstoneToolsResearch.register();

        NamespacedKey endermegaID = new NamespacedKey(this, "endermega_research");
        Research endermegaResearch = new Research(endermegaID, 425995, "战斗的末影巨兽", 34);
        endermegaResearch.addItems(endermegaBootsItem, endermegaLeggingsItem, endermegaChestplateItem, endermegaHelmetItem, endermegaEggItem, enderstaffTier2Item, enderBladeItem, enderHeadItem, irregularBowItem);
        endermegaResearch.register();

        NamespacedKey deepfreezerID = new NamespacedKey(this, "deepfreezer_research");
        Research deepfreezerResearch = new Research(deepfreezerID, 425996, "利用绝对零度", 30);
        deepfreezerResearch.addItems(SlimefunItem.getByItem(DEEPFREEZER)); //Deep freezer research
        deepfreezerResearch.register();

        NamespacedKey obsidianID = new NamespacedKey(this, "obsidian_shield_research");
        Research obsidianShieldResearch = new Research(obsidianID, 425997, "黑曜石盾牌", 18);
        obsidianShieldResearch.addItems(Obsidian_Shield_item); //Obsidian Shield
        obsidianShieldResearch.register();

        new NamespacedKey(this, "intensify_gravity_research");
        Research intenseGravityResearch = new Research(obsidianID, 425997, "改变重力", 20);
        intenseGravityResearch.addItems(Ground_Tome_item); //Ground Tome
        intenseGravityResearch.register();
    }


    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return "https://github.com/balugaq/end-combat/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }
}


