package com.uzihead.othercoolblocks.datagen;

import com.uzihead.othercoolblocks.OCBRegistration;
import com.uzihead.othercoolblocks.OCBRegistration.RegistryEvents;
import com.uzihead.othercoolblocks.OtherCoolBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.uzihead.othercoolblocks.OtherCoolBlocks.MODID;

public class OCBItemModels extends ItemModelProvider {
    public OCBItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //withExistingParent(RegistryEvents.EXPANDED_CRAFTING_TABLE_ITEM.get().getRegistryName().getPath(), modLoc("block/expanded_crafting_table"));
    }
}
