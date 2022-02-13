package com.uzihead.minecraft.othercoolblocks;

import com.uzihead.minecraft.othercoolblocks.block.ExpandedCraftingTable;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.uzihead.minecraft.othercoolblocks.OtherCoolBlocks.MODID;

public class OCBRegistry{
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        private static Block BLOCK_EXPANDED_CRAFTING_TABLE = null ;

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            OtherCoolBlocks.LOGGER.info(MODID + ":registerBlocks");
            BLOCK_EXPANDED_CRAFTING_TABLE = new ExpandedCraftingTable(BlockBehaviour.Properties.of(Material.WOOD)).setRegistryName(MODID, "expanded_crafting_table");
            blockRegistryEvent.getRegistry().register(BLOCK_EXPANDED_CRAFTING_TABLE);
            OtherCoolBlocks.LOGGER.info("%sRegistered: ".formatted(MODID), BLOCK_EXPANDED_CRAFTING_TABLE.getName());
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event){
            var blockItem = new ItemNameBlockItem(BLOCK_EXPANDED_CRAFTING_TABLE.setRegistryName(MODID, "expanded_crafting_table_tile"), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
            event.getRegistry().register(blockItem);
        }
    }
}
