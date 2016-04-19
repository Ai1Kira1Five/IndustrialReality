package com.ai_kira_five.industrialreality.gui;

import com.ai_kira_five.industrialreality.IndustrialReality;
import com.ai_kira_five.industrialreality.common.util.ModInfo;
import com.ai_kira_five.industrialreality.config.ConfigurationHandler;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Àðò¸ì on 11.04.2016.
 */
public class ModGuiConfig extends GuiConfig{
    public ModGuiConfig(GuiScreen parentScreen){
        super(parentScreen,
                new ConfigElement(ConfigurationHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                ModInfo.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }
}
