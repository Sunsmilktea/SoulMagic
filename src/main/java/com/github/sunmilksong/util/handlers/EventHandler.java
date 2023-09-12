package com.github.sunmilksong.util.handlers;

import com.github.sunmilksong.init.ModEnchant;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author Sunmilksong
 */
@ParametersAreNonnullByDefault
public class EventHandler {


    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        Entity source = event.getSource().getImmediateSource();
        if (source instanceof EntityPlayer && !source.world.isRemote) {
            EntityPlayer player = (EntityPlayer) source;
            ItemStack heldItemMainhand = player.getHeldItemMainhand();

            int enlevel = EnchantmentHelper.getEnchantmentLevel(ModEnchant.SOUL_BOOM, heldItemMainhand);

            if (enlevel > 0) {
                Entity target = event.getEntity();
                target.world.createExplosion(null,
                        target.posX, target.posY, target.posZ, 2 * enlevel, false);
            }

        }
    }
}
