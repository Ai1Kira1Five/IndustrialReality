package com.ai_kira_five.industrialreality.gui;

import com.ai_kira_five.industrialreality.IndustrialReality;
import com.ai_kira_five.industrialreality.common.util.ModInfo;
import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Set;

/**
 * Created by Àðò¸ì on 11.04.2016.
 */
public class GuiFactory extends Gui implements IModGuiFactory{
    private Minecraft mc;
    private static final ResourceLocation texturepath = new ResourceLocation(ModInfo.MOD_ID + ":textures/gui/GuiHealPlayer.png");

    private WeakReference<MinecraftServer> server;
    private static final DecimalFormat timeFormatter = new DecimalFormat("########0");

    public GuiFactory(Minecraft mc, MinecraftServer server){
        this.mc = mc;
        this.server = new WeakReference(server);
    }

    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return null;
    }

    @Override
    public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    @Override
    public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element) {
        return null;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderExperienceBar(RenderGameOverlayEvent event)
    {
        double worldTickTime = GuiFactory.mean(MinecraftServer.getServer().worldTickTimes.get(Minecraft.getMinecraft().thePlayer.dimension)) * 1.0E-6D;
        double worldTPS = Math.min(1000.0/worldTickTime, 20);

        if (event.type != RenderGameOverlayEvent.ElementType.ALL)
        {
            if (event.type == RenderGameOverlayEvent.ElementType.HEALTH) {
                event.setCanceled(true);
            }
            if (event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT) {
                event.setCanceled(true);
            }
            if (event.type == RenderGameOverlayEvent.ElementType.FOOD) {
                event.setCanceled(true);
            }
            if (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE) {
                event.setCanceled(true);
            }
            if (event.type == RenderGameOverlayEvent.ElementType.AIR) {
                event.setCanceled(true);
            }
        }
        int xPos = 2;
        int yPos = 2;

        int size = 159;
        int sizefood = 134;
        int sizeox = 90;

        Calendar calendar = Calendar.getInstance();

        GL11.glEnable(3042);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008);
        this.mc.getTextureManager().bindTexture(texturepath);
        drawTexturedModalRect(xPos, yPos + 6, 0, 0, 256, 128);

        int size2 = (int)(size / this.mc.thePlayer.getMaxHealth() * this.mc.thePlayer.getHealth());
        drawTexturedModalRect(xPos + 4, yPos + 27, 0, 240, size2, 16);

        int size2food = sizefood / 18 * this.mc.thePlayer.getFoodStats().getFoodLevel();
        drawTexturedModalRect(xPos + 4, yPos + 49, 0, 223, size2food, 17);

        int size2ox = (int)(sizeox / this.mc.thePlayer.getAir());
        drawTexturedModalRect(xPos + 4, yPos + 5, 0, 89, size2ox, 14);

        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        this.mc.fontRenderer.drawString(this.mc.thePlayer.getDisplayName(), xPos + 6, yPos + 12, 49689);
        this.mc.fontRenderer.drawString(String.format(timeFormatter.format(worldTickTime)) + ":" + String.format(timeFormatter.format(worldTPS)), xPos + 100, yPos + 12, 16081);

        //this.mc.fontRenderer.drawString("Air:" + this.mc.thePlayer.getAir(), xPos +15, yPos +75, -1);
        this.mc.fontRenderer.drawString("Heal: " + (int)this.mc.thePlayer.getHealth() + "/" + (int)this.mc.thePlayer.getMaxHealth(), xPos + 55, yPos + 31, -1);
        this.mc.fontRenderer.drawString("Food: " + this.mc.thePlayer.getFoodStats().getFoodLevel() + "/" + 20, xPos + 40, yPos + 54, -1);

        this.mc.fontRenderer.drawString(calendar.getTime().getHours() + ":" + calendar.getTime().getMinutes(), xPos + 90, yPos + 74, -1);
        this.mc.fontRenderer.drawString(String.valueOf(mc.getMinecraft().thePlayer.experienceLevel) + " " + "lvl" + " " + "on " + (int)(100.0F * this.mc.thePlayer.experience) + "%", xPos + 6, yPos + 74, 9306321);
    }

    private static long mean(long[] values)
    {
        long sum = 0l;
        for (long v : values)
        {
            sum+=v;
        }

        return sum / values.length;
    }
}
