package com.uzihead.othercoolblocks.datagen;

import com.uzihead.othercoolblocks.OCBRegistration;
import com.uzihead.othercoolblocks.OtherCoolBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.uzihead.othercoolblocks.OtherCoolBlocks.MODID;

public class OCBItemTags extends ItemTagsProvider {
    public OCBItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.CHESTS)
            .add(OCBRegistration.RegistryEvents.EXPANDED_CRAFTING_TABLE_ITEM.get());
    }

    @Override
    public String getName() {
        return "Tutorial Tags";
    }
}
