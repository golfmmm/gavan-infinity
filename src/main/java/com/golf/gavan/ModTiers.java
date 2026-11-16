package com.golf.gavan;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier GAVAN = new ForgeTier(
        4, 2500, 9.0f, 4.0f, 18,
        BlockTags.NEEDS_DIAMOND_TOOL,
        () -> Ingredient.of(ModItems.GAVANIUM_INGOT.get()));
}
