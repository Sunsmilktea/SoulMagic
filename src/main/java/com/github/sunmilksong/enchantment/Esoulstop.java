package com.github.sunmilksong.enchantment;

import com.github.sunmilksong.init.ModEnchant;
import com.github.sunmilksong.util.Reference;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * @author Sunmilksong
 */
public class Esoulstop extends Ebase {
    public Esoulstop(String name) {
        super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON,
                new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});


        this.setName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        ModEnchant.ENCHANTMENTS.add(this);
    }


}

