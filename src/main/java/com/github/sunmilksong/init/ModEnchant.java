package com.github.sunmilksong.init;

import com.github.sunmilksong.enchantment.Esoulboom;
import com.github.sunmilksong.enchantment.Esoulstop;
import net.minecraft.enchantment.Enchantment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunmilksong
 */
public class ModEnchant {

    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<>();

    public static final Esoulstop SOUL_STOP = new Esoulstop("soul_stop");
    public static final Esoulboom SOUL_BOOM = new Esoulboom("soul_boom");

}
