package com.uzihead.othercoolblocks;

import com.uzihead.othercoolblocks.block.ExpandedCraftingTableBlock;
import com.uzihead.othercoolblocks.network.PacketHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

//    public static final Tag.Named<BlockEntityType<?>> blacklisted
//        = ForgeTagHandler.makeWrapperTag(ForgeRegistries.BLOCK_ENTITIES, new ResourceLocation(MODID,"blacklisted"));
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    //private static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    
    public static Configs.Server SERVER;
    public static ForgeConfigSpec SERVER_SPEC;
    
    public OtherCoolBlocks() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_SPEC);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    static {
        final Pair<Configs.Server, ForgeConfigSpec> specPair2 = new ForgeConfigSpec.Builder().configure(Configs.Server::new);
        SERVER_SPEC = specPair2.getRight();
        SERVER = specPair2.getLeft();
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

    public static <T extends IForgeRegistryEntry<T>> void register(T obj, String name, IForgeRegistry<T> registry) {
        OtherCoolBlocks.LOGGER.info(MODID + ":registerItems");
        registry.register(obj.setRegistryName(new ResourceLocation(MODID, name)));
        OtherCoolBlocks.LOGGER.info("%sRegistered: ".formatted(MODID), obj.getRegistryName());
    }
    
    @ObjectHolder(MODID)
    public static class Objects {
        public static final ExpandedCraftingTableBlock expanded_crafting_table = null;
    }
}
