package com.github.sunmilktea.items;

import com.github.sunmilktea.init.ModItems;
import com.github.sunmilktea.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author SUNMILKSONG
 */
public class ItemBase extends Item {

    public ItemBase(String name) {
        super();

        this.setTranslationKey(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);
    }
}