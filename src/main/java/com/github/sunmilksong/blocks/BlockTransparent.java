package com.github.sunmilktea.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author SUNMILKSONG
 */
@ParametersAreNonnullByDefault
public class BlockTransparent extends BlockBase {

    public BlockTransparent(String name, Material material, SoundType soundType) {
        super(name, material, soundType);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    /**
     * { BlockRenderLayer.CUTOUT_MIPPED}
     * 为类似树叶这样材质仅覆盖方块的一部分的方块
     * <p>
     * { BlockRenderLayer.CUTOUT}
     * 为材质中有光线可以透过部分的方块
     * <p>
     * { BlockRenderLayer.TRANSLUCENT}
     * 为材质中有半透明部分(光线可以透过一部分)的方块
     */

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    public BlockRenderLayer getBlockLayer() {

        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}

