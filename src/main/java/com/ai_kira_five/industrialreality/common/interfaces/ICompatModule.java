package com.ai_kira_five.industrialreality.common.interfaces;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Created by Àðò¸ì on 11.04.2016.
 */
public interface ICompatModule {
    public abstract void preInit(FMLPreInitializationEvent paramFMLPreInitializationEvent);

    public abstract void init(FMLInitializationEvent paramFMLInitializationEvent);

    public abstract void postInit(FMLPostInitializationEvent paramFMLPostInitializationEvent);

    public abstract void serverStarting(FMLServerStartingEvent paramFMLServerStartingEvent);

}
