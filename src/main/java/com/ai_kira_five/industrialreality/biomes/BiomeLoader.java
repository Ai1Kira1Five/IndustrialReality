package com.ai_kira_five.industrialreality.biomes;


import com.ai_kira_five.industrialreality.api.biome.BiomeList;
import com.ai_kira_five.industrialreality.config.ConfigurationHandler;

/**
 * Created by Àðò¸ì on 12.04.2016.
 */
public class BiomeLoader
{
    public static void load()
    {
        BiomeList.COMMONneather = new BiomeCommon(ConfigurationHandler.biomeIDs[0], 3).setColor(353825).setBiomeName("IR_nether").setTemperatureRainfall(0.8f, 0.6f);
    }
}
