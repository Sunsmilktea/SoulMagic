package com.github.sunmilksong.fluids;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

/**
 * @author SUNMILKSONG
 */
public class FluidNoSource extends FluidBlock {

    public FluidNoSource(String name, Fluid fluid, Material material, MapColor mapColor, int quantaPerBlock, float quantaPerBlockFloat ) {
        super(name, fluid, material, mapColor);

        this.quantaPerBlock = quantaPerBlock;
        this.quantaPerBlockFloat = quantaPerBlockFloat;
    }
}
