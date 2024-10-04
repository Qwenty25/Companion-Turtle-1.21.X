package net.qwenty25.companionturtle.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qwenty25.companionturtle.CompanionTurtle;
import net.qwenty25.companionturtle.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CompanionTurtle.MOD_ID);

    public static final DeferredBlock<Block> GUACAMOLE_JAR = registerBlock("guacamole_jar",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.2f).requiresCorrectToolForDrops().sound(SoundType.GLASS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
