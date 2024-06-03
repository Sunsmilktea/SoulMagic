package com.github.sunmilktea.blocks;

import com.github.sunmilktea.init.ModBlocks;
import com.github.sunmilktea.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

/**
 * @author SUNMILKSONG
 */

public abstract class BlockBase extends Block {

    public BlockBase(String name, Material material, SoundType soundType) {
        super(material);

        this.setTranslationKey(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setSoundType(soundType);

        ModBlocks.BLOCKS.add(this);
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    public abstract BlockRenderLayer getBlockLayer();
}


