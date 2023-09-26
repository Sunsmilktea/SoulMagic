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
        //获取事件的来源
        Entity source = event.getSource().getImmediateSource();
        //如果来源是一个玩家，并且不是客户端
        if (source instanceof EntityPlayer &&!source.world.isRemote) {
            //获取玩家
            EntityPlayer player = (EntityPlayer) source;
            //获取玩家的主手物品
            ItemStack heldItemMainhand = player.getHeldItemMainhand();

            //获取玩家的防御等级
            int enlevel = EnchantmentHelper.getEnchantmentLevel(ModEnchant.SOUL_BOOM, heldItemMainhand);

            //如果玩家的防御等级大于0
            if (enlevel > 0) {
                //获取目标
                Entity target = event.getEntity();
                //创建一个新的指定大小的爆炸效果
                target.world.createExplosion(null,
                        target.posX, target.posY, target.posZ, 2 * enlevel, false);
            }

        }
    }
}