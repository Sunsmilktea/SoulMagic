package com.github.sunmilktea.enchantment;

import com.github.sunmilktea.init.ModEnchant;
import com.github.sunmilktea.util.Reference;
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

