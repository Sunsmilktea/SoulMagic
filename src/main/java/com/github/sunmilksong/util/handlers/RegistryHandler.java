package com.github.sunmilksong.util.handlers;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModEnchant;
import com.github.sunmilksong.init.ModFluids;
import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import static com.github.sunmilksong.structure.SubstanceNe.setRegisterNames;
import static com.github.sunmilksong.util.handlers.ModelHandler.registerModelFluid;

/**
 * @author SUNMILKSONG
 */
@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> register = event.getRegistry();

        for (Fluid fluid : ModFluids.FLUIDS) {
            FluidRegistry.registerFluid(fluid);
            FluidRegistry.addBucketForFluid(fluid);
        }

        for (Block block : ModBlocks.BLOCKS) {
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> register = event.getRegistry();

        //普通物品
        register.register(ModItems.SOUL);
        register.register(ModItems.SOUL_SEED);
        //方块物品
        register.register(setRegisterNames(ModItems.SOLID_STATE_SOUL));
        register.register(setRegisterNames(ModItems.SOLID_ORE));
        register.register(setRegisterNames(ModItems.SOUL_SAND));
    }

    @SubscribeEvent
    public static void onEnchantment(RegistryEvent.Register<Enchantment> event) {
        IForgeRegistry<Enchantment> register = event.getRegistry();

        register.register(ModEnchant.SOUL_STOP);
        register.register(ModEnchant.SOUL_BOOM);

    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistery(ModelRegistryEvent event) {
        registerModelFluid();

        //普通物品
        ClientProxy.modelRegistery(ModItems.SOUL,0);
        ClientProxy.modelRegistery(ModItems.SOUL_SEED,0);
        //方块物品
        ClientProxy.modelRegistery(ModItems.SOLID_STATE_SOUL,0);
        ClientProxy.modelRegistery(ModItems.SOLID_ORE,0);
        ClientProxy.modelRegistery(ModItems.SOUL_SAND,0);
    }
}
