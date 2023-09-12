package com.github.sunmilksong.init;

import com.github.sunmilksong.fluids.FluidBase;
import net.minecraftforge.fluids.Fluid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUNMILKSONG
 */
public class ModFluids {

    public static final List<Fluid> FLUIDS = new ArrayList<>();

    public static final FluidBase SPIRIT = new
            FluidBase("spirit_fluid", 1000, 1000, 0, 300, false, 0xFFFFFFFF);

}

