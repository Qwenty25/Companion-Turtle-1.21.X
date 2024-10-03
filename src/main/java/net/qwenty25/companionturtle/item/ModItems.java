package net.qwenty25.companionturtle.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qwenty25.companionturtle.CompanionTurtle;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CompanionTurtle.MOD_ID);

    public static final DeferredItem<Item> MARACAS = ITEMS.register("maracas",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPICY_SAUCE = ITEMS.register("spicy_sauce",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
