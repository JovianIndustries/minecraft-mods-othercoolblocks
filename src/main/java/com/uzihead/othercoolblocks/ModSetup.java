package com.uzihead.othercoolblocks;

import com.uzihead.othercoolblocks.OCBRegistration.RegistryEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

public class ModSetup {

    public static final String TAB_NAME = "OtherCoolBlocks";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(RegistryEvents.EXPANDED_CRAFTING_TABLE_ITEM.get());
        }
    };
    
    public static void init(FMLCommonSetupEvent event){
    }
}