package com.github.sunmilktea.fluids;

import com.github.sunmilktea.init.ModFluids;
import com.github.sunmilktea.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

/**
 * @author SUNMILKSONG
 */
public class FluidBase extends Fluid {
    /*
    Forge给出的可继承的流体类：
    BlockFluidClassic表示经典流体,类似水和熔岩那种性质的流体。
    BlockFluidFinite表示有限流体，类似神秘时代咒波那种性质的流体。
     */

    public FluidBase(String fluidName, int density, int viscosity, int luminosity, int temperature, boolean gaseous, int color) {

        super(fluidName,
                new ResourceLocation(Reference.MOD_ID + ":fluids/" + fluidName + "_still"),
                new ResourceLocation(Reference.MOD_ID + ":fluids/" + fluidName + "_flow"),
                new ResourceLocation(Reference.MOD_ID + ":fluids/" + fluidName + "_overlay"), color);

        this.setUnlocalizedName(Reference.MOD_ID + "." + fluidName);
        this.setDensity(density);
        this.setViscosity(viscosity);
        this.setLuminosity(luminosity);
        this.setTemperature(temperature);
        this.setGaseous(gaseous);

        ModFluids.FLUIDS.add(this);
    }
}




