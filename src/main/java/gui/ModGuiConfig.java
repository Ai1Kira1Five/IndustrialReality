package gui;

import config.ConfigurationHandler;
import cpw.mods.fml.client.config.GuiConfig;
import industrialreality.IndustrialReality;
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
                IndustrialReality.MODID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }
}
