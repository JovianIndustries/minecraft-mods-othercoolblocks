package com.uzihead.othercoolblocks.datagen;

import com.uzihead.othercoolblocks.OCBRegistration;
import com.uzihead.othercoolblocks.OtherCoolBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.uzihead.othercoolblocks.ModSetup.TAB_NAME;

public class OCBLanguageProvider extends LanguageProvider {

    public OCBLanguageProvider(DataGenerator gen, String locale) {
        super(gen, OtherCoolBlocks.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "Other Cool Blocks");
        add(OCBRegistration.RegistryEvents.EXPANDED_CRAFTING_TABLE_BLOCK.get(), "Expanded Crafting Table");
    }
}
