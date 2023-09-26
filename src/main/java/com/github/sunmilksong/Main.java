package com.github.sunmilksong;

import com.github.sunmilksong.proxy.CommonProxy;
import com.github.sunmilksong.util.Reference;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author SUNMILKSONG
 */
@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Main {

    //定义一个Mod实例
    @Mod.Instance
    public static Main instance;

    //定义一个SidedProxy实例
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    //启用桶
    static {
        FluidRegistry.enableUniversalBucket();
    }

    //FMLPreInitializationEvent事件
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    }

    //FMLInitializationEvent事件
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

    }

    //FMLPostInitializationEvent事件
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }

}

