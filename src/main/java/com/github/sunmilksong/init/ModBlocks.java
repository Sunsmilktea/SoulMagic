package com.github.sunmilksong.init;

import com.github.sunmilksong.blocks.*;
import com.github.sunmilksong.blocks.material.Materials;
import com.github.sunmilksong.fluids.FluidSoul;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUNMILKSONG
 */
public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final BlockBase SOLID_STATE_SOUL = new
            BlockTransparent("solid_state_soul", Materials.IRON, SoundType.GLASS);

    public static final BlockBase SOUL_SAND = new
            BlockFarm("soul_sand", Materials.SAND, SoundType.SAND);

    //挖掘等级: 0是木,1是石/金,2是铁,3是钻石,4是下界合金

    public static final BlockBase SOLID_ORE = new
            BlockOre("soul_ore", "pickaxe", 2, 0.5f, Materials.ROCK, SoundType.STONE);

    //作物

    public static final BlockCrop SOUL_CROP = new
            BlockCrop("soul_crop");

    //流体块

    public static final FluidSoul SPIRIT = new
            FluidSoul("spirit_block", ModFluids.SPIRIT, Materials.SPIRIT, MapColor.SNOW);
}

