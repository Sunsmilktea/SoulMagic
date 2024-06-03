package com.github.sunmilktea.blocks;

import com.github.sunmilktea.blocks.material.Materials;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
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

    @Nonnull
    @Override
    public BlockRenderLayer getBlockLayer() {
        return null;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!this.hasLiquidOrBlock(worldIn, pos)) {
            turnToSand(worldIn, pos);
        }
    }

    public boolean hasLiquidOrBlock(World worldIn, BlockPos pos) {

        boolean hasWater = false;
        boolean hasSoul = false;

        Material waterMaterial = Material.WATER;
        Material soulMaterial = Materials.SPIRIT;


        for (BlockPos.MutableBlockPos bM : BlockPos.getAllInBoxMutable(pos.add(-1, 0, -1), pos.add(1, -1, 1))) {
            IBlockState blockState = worldIn.getBlockState(bM);
            if (blockState.getMaterial() == waterMaterial) {
                hasWater = true;
            }


            if (blockState.getMaterial() == soulMaterial) {
                hasSoul = true;
            }
        }
        return hasWater && hasSoul;
    }

    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Blocks.SAND.getItemDropped(Blocks.SAND.getDefaultState(), rand, fortune);
    }
}
/*@Override
 *public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
 *super.onBlockAdded(worldIn, pos, state);
 *if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) {
 *turnToSand(worldIn, pos);
 * }
 * *}
 */
