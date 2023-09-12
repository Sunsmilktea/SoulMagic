package com.github.sunmilksong.fluids;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.util.Reference;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author SUNMILKSONG
 */
public class FluidSoul extends BlockFluidClassic {
    @ParametersAreNonnullByDefault
    public FluidSoul(String name, Fluid fluid, Material material, MapColor mapColor) {
        super(fluid, material, mapColor);

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
    }
}
