package com.uzihead.othercoolblocks;

import com.uzihead.othercoolblocks.block.ExpandedCraftingTableBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class OCBRegistry{
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            BlockBehaviour.Properties wood = BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE);
            OtherCoolBlocks.register(new ExpandedCraftingTableBlock(wood), "expanded_crafting_table", blockRegistryEvent.getRegistry());
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event){
            Item.Properties ecsProp = new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS);
            OtherCoolBlocks.register(new BlockItem(OtherCoolBlocks.Objects.expanded_crafting_table, ecsProp), "expanded_crafting_table", event.getRegistry());
        }
    }
}
