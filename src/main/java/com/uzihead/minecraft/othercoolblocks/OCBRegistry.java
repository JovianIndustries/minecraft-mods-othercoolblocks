package com.uzihead.minecraft.othercoolblocks;

import com.uzihead.minecraft.othercoolblocks.block.ExpandedCraftingTable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

import static com.uzihead.minecraft.othercoolblocks.OCBRegistry.Objects.crafting_station;
import static com.uzihead.minecraft.othercoolblocks.OtherCoolBlocks.MODID;

public class OCBRegistry{
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        private static Block block = null ;

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            OtherCoolBlocks.LOGGER.info(MODID + ":registerBlocks");
            BlockBehaviour.Properties wood = BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).noOcclusion();
            register(block = new ExpandedCraftingTable(wood), "expanded_crafting_table", blockRegistryEvent.getRegistry());
            OtherCoolBlocks.LOGGER.info("%sRegistered: ".formatted(MODID), block.getName());
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event){
            Item.Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS);
            register(new BlockItem(block, properties), "expanded_crafting_table", event.getRegistry());
        }

        private static <T extends IForgeRegistryEntry<T>> void register(T obj, String name, IForgeRegistry<T> registry) {
            registry.register(obj.setRegistryName(new ResourceLocation(MODID, name)));
        }
    }

    @ObjectHolder(MODID)
    public static class Objects {
        public static final Block crafting_station = null;
    }
}
