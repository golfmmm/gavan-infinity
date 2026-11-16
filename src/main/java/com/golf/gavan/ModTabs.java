package com.golf.gavan;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GavanMod.MODID);

    public static final RegistryObject<CreativeModeTab> GAVAN_TAB = TABS.register("gavan_tab",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.gavaninfinity"))
            .icon(() -> new ItemStack(ModItems.LASER_BLADE.get()))
            .displayItems((params, out) ->
                ModItems.ITEMS.getEntries().forEach(i -> out.accept(i.get())))
            .build());
}
