package com.uzihead.othercoolblocks;

import com.uzihead.othercoolblocks.block.ExpandedCraftingTableBlock;
import com.uzihead.othercoolblocks.network.PacketHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OtherCoolBlocks.MODID)
public class OtherCoolBlocks
{
    public static final String MODID = "othercoolblocks";
    public static final Logger LOGGER = LogManager.getLogger();
    
    
    public OtherCoolBlocks() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        OCBRegistration.RegistryEvents.init();
        modBus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modBus.addListener(ClientSetup :: init));
        
        // Register the setup method for modloading
        modBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        modBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        modBus.addListener(this::processIMC);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
    }
    
    private void setup(final FMLCommonSetupEvent event)    {
        // some preinit code
        PacketHandler.registerMessages(MODID);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("OtherCoolBlocks", "InitializingOCB", () -> { LOGGER.info("Hello from OCB"); return "Hello, I am Other Cool Blocks!";});
    }

    private void processIMC(final InterModProcessEvent event)    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
    
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
