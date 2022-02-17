package com.uzihead.othercoolblocks;

import com.uzihead.othercoolblocks.block.ExpandedCraftingTableBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;

import static com.uzihead.othercoolblocks.OtherCoolBlocks.MODID;

public class OCBRegistration {
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        
        private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
        private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
        
        
        public static final BlockBehaviour.Properties ECT_BLOCK_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE);
        public static final Item.Properties ECT_ITEM_PROP = new Item.Properties().tab(ModSetup.ITEM_GROUP);
        
        public static final RegistryObject<Block> EXPANDED_CRAFTING_TABLE_BLOCK = BLOCKS.register("expanded_crafting_table", () -> new ExpandedCraftingTableBlock(ECT_BLOCK_PROPERTIES));
        public static final RegistryObject<Item> EXPANDED_CRAFTING_TABLE_ITEM = fromBlock(EXPANDED_CRAFTING_TABLE_BLOCK);
        
        public static void init(){
            IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
            BLOCKS.register(bus);
            ITEMS.register(bus);
        }

        public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block){
            return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ECT_ITEM_PROP));
        }

//        @ObjectHolder(MODID)
//        public static class Objects {
//            public static final ExpandedCraftingTableBlock expanded_crafting_table = null;
//        }
        
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            BlockBehaviour.Properties wood = BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE);
//            register(new ExpandedCraftingTableBlock(wood), "expanded_crafting_table", blockRegistryEvent.getRegistry());
//        }
//
//        @SubscribeEvent
//        public static void onItemRegistry(final RegistryEvent.Register<Item> event){
//            Item.Properties ecsProp = new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS);
//            register(new BlockItem(Objects.expanded_crafting_table, ecsProp), "expanded_crafting_table", event.getRegistry());
//        }
//
//
//        public static <T extends IForgeRegistryEntry<T>> void register(T obj, String name, IForgeRegistry<T> registry) {
//            OtherCoolBlocks.LOGGER.info(MODID + ":registerItems");
//            registry.register(obj.setRegistryName(new ResourceLocation(MODID, name)));
//            OtherCoolBlocks.LOGGER.info("%sRegistered: ".formatted(MODID), obj.getRegistryName());
//        }
    }
}
