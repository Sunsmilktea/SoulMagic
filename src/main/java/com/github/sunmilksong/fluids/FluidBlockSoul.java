package com.github.sunmilksong.fluids;

import com.github.sunmilksong.blocks.material.Materials;
import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.Reference;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author SUNMILKSONG
 */
public  class FluidBlockSoul extends BlockFluidClassic {

    @ParametersAreNonnullByDefault
    public FluidBlockSoul(String name, Fluid fluid, Material material, MapColor mapColor) {
        super(fluid, new Materials(MapColor.WATER));
        this.setDefaultState(blockState.getBaseState().withProperty(LEVEL, 0));

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));

    }
}
