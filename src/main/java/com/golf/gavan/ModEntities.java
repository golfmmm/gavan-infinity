package com.golf.gavan;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GavanMod.MODID);

    public static final RegistryObject<EntityType<MakuuSoldier>> MAKUU_SOLDIER =
        ENTITIES.register("makuu_soldier",
            () -> EntityType.Builder.of(MakuuSoldier::new, MobCategory.MONSTER)
                .sized(0.6f, 1.95f).clientTrackingRange(8)
                .build(new ResourceLocation(GavanMod.MODID, "makuu_soldier").toString()));
}
