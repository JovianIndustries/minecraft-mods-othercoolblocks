package com.uzihead.othercoolblocks.datagen;

import com.uzihead.othercoolblocks.OCBRegistration.RegistryEvents;
import com.uzihead.othercoolblocks.OtherCoolBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OCBBlockTags extends BlockTagsProvider {

    public OCBBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, OtherCoolBlocks.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_AXE)
            .add(RegistryEvents.EXPANDED_CRAFTING_TABLE_BLOCK.get());
        tag(Tags.Blocks.CHESTS)
            .add(RegistryEvents.EXPANDED_CRAFTING_TABLE_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Tutorial Tags";
    }
}