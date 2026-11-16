package com.golf.gavan;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GavanMod.MODID)
public class GavanMod {
    public static final String MODID = "gavaninfinity";

    public GavanMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(bus);   // ต้องมาก่อน Items (block item ถูกลงทะเบียนที่นี่)
        ModItems.ITEMS.register(bus);
        ModEntities.ENTITIES.register(bus);
        ModTabs.TABS.register(bus);
    }
}
