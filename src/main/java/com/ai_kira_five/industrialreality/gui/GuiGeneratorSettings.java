package com.ai_kira_five.industrialreality.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiScreen;

/**
 * Created by Àðò¸ì on 12.04.2016.
 */
public class GuiGeneratorSettings extends GuiScreen {
    //private final GuiCreateWorld createWorldGui;
    public GuiButton BUTTON_DONE;
    public GuiButton BUTTON_CATEGORY;
    public GuiButton BUTTON_BIOMELIST;
    public GuiButton BUTTON_WORLDSETTINGS;
    public int CATEGORY = 1;
    public String[] categories;
    public int generatorSelected = -1;

    public GuiGeneratorSettings(GuiCreateWorld guiCreateWorld, String field_146334_a) {
    }
}
