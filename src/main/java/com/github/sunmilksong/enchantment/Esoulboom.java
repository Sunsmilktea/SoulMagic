package com.github.sunmilksong.enchantment;

import com.github.sunmilksong.init.ModEnchant;
import com.github.sunmilksong.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * @author Sunmilksong
 */
public class Esoulboom extends Ebase {


    public Esoulboom(String name) {
        super(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON,
                new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});


        this.setName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        ModEnchant.ENCHANTMENTS.add(this);
    }


    @Override
    public int getMaxLevel() {

        return 3;
    }


    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        //附魔台附魔的最小等级
        return 16 + enchantmentLevel * 5;
    }


    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        //附魔台附魔的最大等级
        return 21 + enchantmentLevel * 5;
    }

}
