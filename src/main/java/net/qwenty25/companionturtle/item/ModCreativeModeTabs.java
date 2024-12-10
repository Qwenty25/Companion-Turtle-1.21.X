package net.qwenty25.companionturtle.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qwenty25.companionturtle.CompanionTurtle;
import net.qwenty25.companionturtle.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CompanionTurtle.MOD_ID);

    public static final Supplier<CreativeModeTab> FUN_ITEMS_TAB = CREATIVE_MOD_TAB.register("fun_items_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MARACAS.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CompanionTurtle.MOD_ID,"companion_turtle_tab"))
                    .title(Component.translatable("creativetab.companionturtle.fun_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MARACAS);
                        output.accept(ModItems.SPICY_SAUCE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> COMPANION_TURTLE_TAB = CREATIVE_MOD_TAB.register("companion_turtle_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.EMPTY_JAR))
                    .title(Component.translatable("creativetab.companionturtle.companion_turtle"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MARACAS);
                        output.accept(ModItems.SPICY_SAUCE);
                        output.accept(ModBlocks.EMPTY_JAR);
                        output.accept(ModBlocks.GUACAMOLE_JAR);
                        output.accept(ModBlocks.TSAVORITE_ORE);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TAB.register(eventBus);
    }
}
