package com.github.sunmilksong.blocks;

import com.github.sunmilksong.blocks.material.Materials;
import com.github.sunmilksong.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

/**
 * @author SUNMILKSONG
 */

@ParametersAreNonnullByDefault
public class BlockFarm extends BlockBase {

    ////声明BlockFarm类的构造函数
    public BlockFarm(String name, Material material, SoundType sound) {
        super(name, material, sound);
        //设置BlockFarm的默认方块状态
        this.setDefaultState(this.blockState.getBaseState());
        //设置BlockFarm的定时器
        this.setTickRandomly(true);
    }

    public static void turnToSand(World worldIn, BlockPos pos) {
        //设置BlockFarm的默认方块状态为Sand
        worldIn.setBlockState(pos, Blocks.SAND.getDefaultState());
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        //如果BlockFarm的默认状态为Water或者Spirit，则将其转换为Sand
        if (!this.hasLiquidOrBlock(worldIn, pos)) {
            turnToSand(worldIn, pos);
        }
    }


    public boolean hasLiquidOrBlock(World worldIn, BlockPos pos) {

        boolean hasWater = false;
        boolean hasSoul = false;

        //遍历BlockFarm的所有可能的位置
        for (BlockPos.MutableBlockPos bM : BlockPos.getAllInBoxMutable(pos.add(-1, 0, -1), pos.add(1, -1, 1))) {

            //如果BlockFarm的位置的状态为Water，则将其设置为true
            if (worldIn.getBlockState(bM).getMaterial() == Material.WATER) {
                hasWater = true;
            }

            //如果BlockFarm的位置的状态为Spirit，则将其设置为true
            if (worldIn.getBlockState(bM).getMaterial() == Materials.SPIRIT) {
                hasSoul = true;
            }
        }
        //返回是否有水和灵魂粘浆
        return hasWater && hasSoul;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        //调用父类的neighborChanged方法
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);

        //如果BlockFarm的上方的状态为Solid，则将其转换为Sand
        if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) {
            turnToSand(worldIn, pos);
        }

    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        //调用父类的onBlockAdded方法
        super.onBlockAdded(worldIn, pos, state);

        //如果BlockFarm的上方的状态为Solid，则将其转换为Sand
        if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) {
            turnToSand(worldIn, pos);
        }
    }

    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        //调用父类的getItemDropped方法
        return Blocks.SAND.getItemDropped(Blocks.SAND.getDefaultState(), rand, fortune);
    }
}