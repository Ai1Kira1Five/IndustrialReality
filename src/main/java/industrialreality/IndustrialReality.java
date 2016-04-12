package industrialreality;

import biomes.BiomeLoader;
import common.interfaces.ICompatModule;
import common.util.CompatManager;
import common.util.LogHelper;
import common.util.ModInfo;
import common.util.VersionChecker;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gui.GuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import world.WorldTypeIR;

/**
 * Created by Àðò¸ì on 10.04.2016.
 */

@Mod(modid = IndustrialReality.MODID, version = IndustrialReality.VERSION, name = IndustrialReality.NAME, dependencies = IndustrialReality.DEPENDENCIES)
public class IndustrialReality {
    public static final String MODID = "Idustrial_Reality";
    public static final String VERSION = "0.1.12";
    public static final String NAME = "Idustrial Reality";
    public static final String DEPENDENCIES = "after:IC2";

    @Mod.Instance("Idustrial_Reality")
    public static IndustrialReality instance;
    public static final WorldTypeIR IR_Default = new WorldTypeIR("IR_WT");
    public VersionChecker versionChecker;
    public static LogHelper logHelper = new LogHelper(new ModInfo());
    public static final String messagePipeline = null;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        event.getModMetadata().version = "0.1.12";
        instance = this;
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);

        BiomeLoader.load();

        String path = event.getSuggestedConfigurationFile().getAbsolutePath().replace("Idustrial_Reality", "IdustrialReality");
        for(ICompatModule compatModule : CompatManager.INSTANCE.compatModules){
            compatModule.preInit(event);
        }
        //RecipeConfigManager.load(event.getModConfigurationDirectory());
        this.versionChecker = new VersionChecker("Idustrial_Reality", new ModInfo());
        this.versionChecker.checkVersionThreaded();
        logHelper.info("PreInitialization Complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        //ModBlocks.init();

        //ModFluids.init();

        //ModItems.init();

        //ModParts.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        if(FMLCommonHandler.instance().getEffectiveSide().isClient()){
            MinecraftForge.EVENT_BUS.register(new GuiFactory(Minecraft.getMinecraft(), MinecraftServer.getServer()));
        }

        logHelper.info("PostInitialization Complete");
    }
}
