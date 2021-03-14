package com.github.sunmilksong.fluids;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.util.Reference;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author SUNMILKSONG
 */

@ParametersAreNonnullByDefault
public class FluidBlock extends BlockFluidFinite {

    public FluidBlock(String name, Fluid fluid, Material material, MapColor mapColor) {
        super(fluid, material, mapColor);

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        //ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
}


