package world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gui.GuiGeneratorSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.world.WorldType;

/**
 * Created by ���� on 12.04.2016.
 */
public class WorldTypeIR extends WorldType {
    public WorldTypeIR(String name){
        super(name);
    }

    @SideOnly(Side.CLIENT)
    public void onCustomizedButton(Minecraft instance, GuiCreateWorld guiCreateWorld)
    {
        instance.displayGuiScreen(new GuiGeneratorSettings(guiCreateWorld, guiCreateWorld.field_146334_a));
    }

    public boolean isCustomizable()
    {
        return true;
    }
}
