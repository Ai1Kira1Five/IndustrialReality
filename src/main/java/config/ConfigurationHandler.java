package config;

import common.util.DropProperties;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

import java.util.*;

/**
 * Created by Àðò¸ì on 11.04.2016.
 */
public class ConfigurationHandler {
    public static Map<Integer, List<DropProperties>> dropsList = new HashMap();

    public static Configuration config;
    public static int[] biomeIDs = new int[1];

    public static void init(FMLPreInitializationEvent event)
    {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();

        dropParser(config.get("Industrial_Mob_Farm", "Overworld", defaultDropsOverworld, "Overworld drops - Chance->Mod Id:Item Id@Metadata#Biome type required").getStringList(), 0);
        dropParser(config.get("Industrial_Mob_Farm", "Nether", defaultDropsNether, "Nether drops - Chance->Mod Id:Item Id@Metadata#Biome type required").getStringList(), -1);
        dropParser(config.get("Industrial_Mob_Farm", "End", defaultDropsEnd, "End drops - Chance->Mod Id:Item Id@Metadata#Biome type required").getStringList(), 1);

        config.save();

        for (int c = 0; c < biomeIDs.length; c++){
            biomeIDs[c] = (5 + c);
        }
        try
        {
            config.load();

            biomeIDs[0] = config.get("3 - Common Biomes", "IR_Nether", 5).getInt();

            config.save();
        }
        catch (Exception e)
        {
            for (int c = 0; c < biomeIDs.length; c++){
                biomeIDs[c] = (5 + c);
            }
        }
        finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    public static void dropParser(String[] rawDrops, int dimensionID)
    {
        List<DropProperties> list = new ArrayList();
        for (String drop : rawDrops){
            String[] splitAux = drop.split("->");
            double dropChance = Double.parseDouble(splitAux[0]);

            splitAux = new String[] { (String) (splitAux.length > 1 ? splitAux[1].split(":") : "") };
            String modID = splitAux[0];

            splitAux = new String[] { (String) (splitAux.length > 1 ? splitAux[1].split("@") : "") };
            String itemID = splitAux[0];

            splitAux = new String[] { (String) (splitAux.length > 1 ? splitAux[1].split("#") : "") };
            int metaData = Integer.parseInt(splitAux[0]);

            List<String> biomeTypes = new ArrayList();
            if (splitAux.length > 1){
                biomeTypes = Arrays.asList(splitAux[1].split(","));
            }
            if (GameRegistry.findItem(modID, itemID) != null) {
                list.add(new DropProperties(new ItemStack(GameRegistry.findItem(modID, itemID), 1, metaData), dropChance, biomeTypes));
            }
        }

    }

    private static final String[] defaultDropsOverworld = { "0.2->minecraft:rotten_flesh@0#", "0.2->minecraft:bone@0#", "0.15->minecraft:spider_eye@0#", "0.15->minecraft:gunpowder@0#", "0.08->minecraft:slime_ball@0#SWAMP", "0.1->minecraft:string@0#", "0.03->minecraft:ender_pearl@0#" };
    private static final String[] defaultDropsNether = { "0.2->minecraft:rotten_flesh@0#", "0.1->minecraft:blaze_rod@0#", "0.05->minecraft:magma_cream@0#", "0.05->minecraft:ghast_tear@0#" };
    private static final String[] defaultDropsEnd = { "0.2->minecraft:ender_pearl@0#" };
}
