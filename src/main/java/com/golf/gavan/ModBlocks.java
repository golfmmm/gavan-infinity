package com.golf.gavan;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, GavanMod.MODID);

    public static final RegistryObject<Block> GAVANIUM_ORE = reg("gavanium_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(3.5f, 4.0f),
                UniformInt.of(2, 5)));

    public static final RegistryObject<Block> DEEPSLATE_GAVANIUM_ORE = reg("deepslate_gavanium_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).strength(4.5f, 4.0f),
                UniformInt.of(2, 5)));

    public static final RegistryObject<Block> GAVANIUM_BLOCK = reg("gavanium_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5.0f, 6.0f).requiresCorrectToolForDrops()));

    private static RegistryObject<Block> reg(String name, Supplier<Block> sup) {
        RegistryObject<Block> b = BLOCKS.register(name, sup);
        ModItems.ITEMS.register(name, () -> new BlockItem(b.get(), new Item.Properties()));
        return b;
    }
}
