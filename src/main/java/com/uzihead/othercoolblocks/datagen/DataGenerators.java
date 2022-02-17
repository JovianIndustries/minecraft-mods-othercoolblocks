package com.uzihead.othercoolblocks.datagen;

import com.uzihead.othercoolblocks.OtherCoolBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = OtherCoolBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new OCBRecipes(generator));
            generator.addProvider(new OCBLootTables(generator));
            OCBBlockTags blockTags = new OCBBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new OCBItemTags(generator, blockTags, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            generator.addProvider(new OCBBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new OCBItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new OCBLanguageProvider(generator, "en_us"));
        }
    }
}