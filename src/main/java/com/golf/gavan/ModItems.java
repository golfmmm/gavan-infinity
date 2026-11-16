package com.golf.gavan;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, GavanMod.MODID);

    public static final RegistryObject<Item> GAVANIUM_INGOT =
        ITEMS.register("gavanium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_GAVANIUM =
        ITEMS.register("raw_gavanium", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LASER_BLADE =
        ITEMS.register("laser_blade",
            () -> new SwordItem(ModTiers.GAVAN, 4, -2.0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> LASER_ZABEAM =
        ITEMS.register("laser_zabeam",
            () -> new LaserZabeamItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> GAVAN_HELMET =
        ITEMS.register("gavan_helmet",
            () -> new ArmorItem(ModArmorMaterials.GAVAN, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GAVAN_CHESTPLATE =
        ITEMS.register("gavan_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GAVAN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GAVAN_LEGGINGS =
        ITEMS.register("gavan_leggings",
            () -> new ArmorItem(ModArmorMaterials.GAVAN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GAVAN_BOOTS =
        ITEMS.register("gavan_boots",
            () -> new ArmorItem(ModArmorMaterials.GAVAN, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> MAKUU_SOLDIER_SPAWN_EGG =
        ITEMS.register("makuu_soldier_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MAKUU_SOLDIER, 0x2B1A4A, 0xFF2020, new Item.Properties()));
}
