package com.github.sunmilktea.fluids;

import com.github.sunmilktea.blocks.material.Materials;
import com.github.sunmilktea.init.ModBlocks;
import com.github.sunmilktea.init.ModItems;
import com.github.sunmilktea.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author SUNMILKSONG
 */
public class FluidBlockSoul extends BlockFluidClassic {

    @ParametersAreNonnullByDefault

    public FluidBlockSoul(String name, Fluid fluid, Material material, MapColor mapColor) {
        super(fluid, new Materials(MapColor.WATER));
        this.setDefaultState(blockState.getBaseState().withProperty(LEVEL, 0));

        this.setTranslationKey(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));

    }

    @Override
    public void neighborChanged(@Nonnull IBlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull Block adjacentBlock, @Nonnull BlockPos adjacentPos) {
        super.neighborChanged(state, world, pos, adjacentBlock, adjacentPos);

        adjacentEvent(world, pos, state);
    }

    @Override
    public void onBlockAdded(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        super.onBlockAdded(world, pos, state);

        adjacentEvent(world, pos, state);
    }

    //相邻事件
    private void adjacentEvent(World world, BlockPos pos, IBlockState state) {

        boolean isCold = true;
        boolean shouldCreateBlock = false;

        if (this.material == Material.LAVA) {

            for (EnumFacing soul : EnumFacing.values()) {
                if (soul != EnumFacing.DOWN) {
                    IBlockState offset = world.getBlockState(pos.offset(soul));
                    if (offset.getMaterial().isLiquid() && !(offset.getBlock() instanceof FluidBlockSoul) && (offset.getBlock() instanceof BlockFluidBase)) {
                        int temp = offset.getBlock() instanceof BlockFluidBase ?
                                BlockFluidBase.getTemperature(world, pos.offset(soul)) :
                                (offset.getMaterial() == Material.LAVA ? FluidRegistry.LAVA.getTemperature() :
                                        offset.getMaterial() == Material.WATER ? FluidRegistry.WATER.getTemperature() : 100);
                        isCold = temp <= 300;
                        shouldCreateBlock = true;
                        break;
                    }
                }
            }
            if (shouldCreateBlock) {
                if (isCold) {
                    world.setBlockState(pos, Blocks.ICE.getDefaultState());
                } else {
                    world.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());
                }
            }
        }
    }
}