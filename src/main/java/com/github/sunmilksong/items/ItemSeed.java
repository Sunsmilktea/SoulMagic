package com.github.sunmilksong.items;


import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;


/**
 * @author SUNMILKSONG
 */

@ParametersAreNonnullByDefault
public class ItemSeed extends ItemBase {

    private final Block plants;

    private final Block plantBlock;

    public ItemSeed(String name, Block plants, Block plantBlock) {
        super(name);

        this.plants = plants;
        this.plantBlock = plantBlock;
    }

    /**
     * onItemUses
     * 使用物品的方法
     *
     * @return EnumActionResult
     */
    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        //获取左手物品,主手放置,副手无效
        ItemStack itemstack = player.getHeldItem(hand);

        //获取当前块位置
        IBlockState state = worldIn.getBlockState(pos);

        //获取耕地方块
        if (state.getBlock() == this.plantBlock

                //EnumFacing.UP表示种植时站立的方位，up表示站在方块顶部种植，如果是其他值则需要站在对应面种植
                //但最后作物始终朝上
                && facing == EnumFacing.UP

                //传入pos pos参数由EnumFacing.UP通过offset转换成pos,传入EnumFacing.UP,传入物品堆
                //检查当前玩家是否能够破坏或放置方块与这个方块在特定的位置上，朝向也固定，并且与其他方块之间有一定的距离。
                && player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {

            //在世界中放置作物,获取默认状态
            /*
            将指定位置（pos）上方（up()）的方块替换成预设的植物（this.plants.getDefaultState()）。
            其中，worldIn 是一个 Instance 用于修改特定的世界实例，
            pos 是指定方块的位置，up() 代表上方的方块位置，
            this.plants.getDefaultState() 则是获取要放置植物的默认状态。
            */
            worldIn.setBlockState(pos.up(), this.plants.getDefaultState());

            if (player instanceof EntityPlayerMP) {

                //标准事件触发器
                //事件类型放置方块(通过物品放置)
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos.up(), itemstack);
            }

            itemstack.shrink(1);

            return EnumActionResult.SUCCESS;

        } else {

            return EnumActionResult.FAIL;
        }
    }
}