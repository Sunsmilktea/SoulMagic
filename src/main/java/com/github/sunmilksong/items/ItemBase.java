package com.github.sunmilksong.items;

import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author SUNMILKSONG
 */
public class ItemBase extends Item {

    public ItemBase(String name) {
        super();

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);
    }
}