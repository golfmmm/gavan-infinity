package com.golf.gavan;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    GAVAN("gavan", 37, new int[]{3, 6, 8, 3}, 15,
          SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f,
          () -> Ingredient.of(ModItems.GAVANIUM_INGOT.get()));

    // ลำดับของ ArmorItem.Type: HELMET, CHESTPLATE, LEGGINGS, BOOTS
    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};
    private final String name;
    private final int multiplier;
    private final int[] defense; // boots, leggings, chest, helmet (ตามลำดับ vanilla)
    private final int enchantability;
    private final SoundEvent sound;
    private final float toughness, knockback;
    private final Supplier<Ingredient> repair;

    ModArmorMaterials(String name, int multiplier, int[] defense, int enchantability,
                      SoundEvent sound, float toughness, float knockback,
                      Supplier<Ingredient> repair) {
        this.name = name; this.multiplier = multiplier; this.defense = defense;
        this.enchantability = enchantability; this.sound = sound;
        this.toughness = toughness; this.knockback = knockback; this.repair = repair;
    }

    @Override public int getDurabilityForType(ArmorItem.Type t) { return BASE_DURABILITY[t.ordinal()] * multiplier; }
    @Override public int getDefenseForType(ArmorItem.Type t) { return defense[3 - t.ordinal()]; }
    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public SoundEvent getEquipSound() { return sound; }
    @Override public Ingredient getRepairIngredient() { return repair.get(); }
    @Override public String getName() { return GavanMod.MODID + ":" + name; }
    @Override public float getToughness() { return toughness; }
    @Override public float getKnockbackResistance() { return knockback; }
}
