package com.uzihead.minecraft.othercoolblocks;

import com.uzihead.minecraft.othercoolblocks.block.ExpandedCraftingTable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
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
            // register a new block here
            OtherCoolBlocks.LOGGER.info(OtherCoolBlocks.MODID + ":registerBlocks");
            var BLOCK_EXPANDED_CRAFTING_TABLE = new ExpandedCraftingTable(BlockBehaviour.Properties.of(Material.WOOD)).setRegistryName(OtherCoolBlocks.MODID, "largecraftingtable");
            blockRegistryEvent.getRegistry().register(BLOCK_EXPANDED_CRAFTING_TABLE);
            OtherCoolBlocks.LOGGER.info("%sRegistered: ".formatted(OtherCoolBlocks.MODID), BLOCK_EXPANDED_CRAFTING_TABLE.getName());
        }
    }
}
