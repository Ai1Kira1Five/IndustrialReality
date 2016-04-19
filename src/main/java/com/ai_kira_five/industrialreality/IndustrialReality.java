package com.ai_kira_five.industrialreality;


import com.ai_kira_five.industrialreality.biomes.BiomeLoader;
import com.ai_kira_five.industrialreality.common.interfaces.ICompatModule;
import com.ai_kira_five.industrialreality.common.util.CompatManager;
import com.ai_kira_five.industrialreality.common.util.LogHelper;
import com.ai_kira_five.industrialreality.common.util.ModInfo;
import com.ai_kira_five.industrialreality.common.util.VersionChecker;
import com.ai_kira_five.industrialreality.gui.GuiFactory;
import com.ai_kira_five.industrialreality.proxy.CommonProxy;
import com.ai_kira_five.industrialreality.world.WorldTypeIR;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Àðò¸ì on 10.04.2016.
 */

@Mod(modid = ModInfo.MOD_ID, version = ModInfo.MOD_VERSION, name = ModInfo.MOD_NAME, dependencies = ModInfo.MOD_DEPENDENCUIES)
public class IndustrialReality
{
    @Mod.Instance(ModInfo.MOD_ID)
    public static IndustrialReality instance;
    public static final WorldTypeIR IR_Default = new WorldTypeIR("IR_WT");
    public VersionChecker versionChecker;
    public static LogHelper logHelper = new LogHelper(new ModInfo());
    public static final String messagePipeline = null;

    @SidedProxy(clientSide = ModInfo.PROXY_LOC + "ClientProxy", serverSide = ModInfo.PROXY_LOC + "CommonProxy")
    public static CommonProxy proxy;

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
