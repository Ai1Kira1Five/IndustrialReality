package com.ai_kira_five.industrialreality.common.util;

import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Àðò¸ì on 11.04.2016.
 */
public class DropProperties {
    private ItemStack itemStack;
    private double chance;
    private List<String> biomeTypes;

    public DropProperties(ItemStack itemStack, double chance, List<String> biomeTypes)
    {
        this.itemStack = itemStack;
        this.chance = chance;
        this.biomeTypes = biomeTypes;
    }

    public ItemStack getItemStack()
    {
        return this.itemStack;
    }

    public double getChance()
    {
        return this.chance;
    }

    public List<String> getBiomeTypes()
    {
        return this.biomeTypes;
    }
}
