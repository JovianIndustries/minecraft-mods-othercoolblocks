package com.uzihead.othercoolblocks.datagen;
import com.uzihead.othercoolblocks.OCBRegistration.RegistryEvents;
import com.uzihead.othercoolblocks.OtherCoolBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OCBBlockStates extends BlockStateProvider {

    public OCBBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, OtherCoolBlocks.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        //simpleBlock(RegistryEvents.EXPANDED_CRAFTING_TABLE_BLOCK.get());
    }
}