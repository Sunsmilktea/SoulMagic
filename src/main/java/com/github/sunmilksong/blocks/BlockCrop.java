package com.github.sunmilktea.blocks;

import com.github.sunmilktea.init.ModBlocks;
import com.github.sunmilktea.init.ModItems;
import com.github.sunmilktea.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;


/**
 * @author SUNMILKSONG
 */
@ParametersAreNonnullByDefault
public class BlockCrop extends BlockCrops {

    //public static final PropertyInteger CROP_AGE = PropertyInteger.create("age", 0, 7);

    public BlockCrop(String name) {
        super();

        this.setTranslationKey(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        this.setSoundType(SoundType.PLANT);

        ModBlocks.BLOCKS.add(this);
    }

    /**
     * 创建种子
     */
    @Nonnull
    @Override
    protected Item getSeed() {
        return ModItems.SOUL_SEED;
    }

    /**
     * 创建作物掉落
     */
    @Nonnull
    @Override
    protected Item getCrop() {
        return ModItems.SOUL;
    }

    protected boolean isPlantBlock(Block plantBock) {

        if (this == ModBlocks.SOUL_CROP) {
            return plantBock == ModBlocks.SOUL_SAND;
        } else {
            return false;
        }
    }

    /**
     * 允许作物种植的方块
     */
    @Override
    protected boolean canSustainBush(IBlockState state) {

        return isPlantBlock(state.getBlock());
    }

    /**
     * 维持作物生长的耕地
     */
    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {

        IBlockState plantBlock = worldIn.getBlockState(pos.down());

        //1
        boolean soulSand = plantBlock.getBlock() == ModBlocks.SOUL_SAND;
        boolean light1 = worldIn.getLight(pos) >= 5;

        //2

        //1-1
        return soulSand && light1;
    }

    /*
      设置作物生长级别的属性
       protected PropertyInteger getAgeProperty()
     */

    /**
     * 设置作物最大生长级别的属性
     */
    @Override
    public int getMaxAge() {
        if (this == ModBlocks.SOUL_CROP) {
            return 7;
        } else {
            return 0;
        }
    }

    /*
      设置作物最大生长级别的属性
      public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
     */

    /**
     * 设置骨粉的最大和最小效果
     */
    @Override
    protected int getBonemealAgeIncrease(World worldIn) {

        return MathHelper.getInt(worldIn.rand, 1, 1);
    }
}

/*
  设置作物区块状态
  protected BlockStateContainer createBlockState()
 */

