package com.github.sunmilktea.util.handlers;

import com.github.sunmilktea.init.ModBlocks;
import com.github.sunmilktea.init.ModEnchant;
import com.github.sunmilktea.init.ModFluids;
import com.github.sunmilktea.init.ModItems;
import com.github.sunmilktea.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import static com.github.sunmilktea.proxy.CommonProxy.setRegisterNames;

/**
 * @author SUNMILKSONG
 */
@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> BlockRegister = event.getRegistry();

        for (Fluid fluid : ModFluids.FLUIDS) {
            FluidRegistry.registerFluid(fluid);
            FluidRegistry.addBucketForFluid(fluid);
        }

        for (Block block : ModBlocks.BLOCKS) {
            BlockRegister.register(block);
        }
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> ItemRegister = event.getRegistry();

        //普通物品
        ItemRegister.register(ModItems.SOUL);
        ItemRegister.register(ModItems.SOUL_SEED);
        //方块物品
        ItemRegister.register(setRegisterNames(ModItems.SOLID_STATE_SOUL));
        ItemRegister.register(setRegisterNames(ModItems.SOLID_ORE));
        ItemRegister.register(setRegisterNames(ModItems.SOUL_SAND));
    }

    @SubscribeEvent
    public static void onEnchantment(RegistryEvent.Register<Enchantment> event) {
        IForgeRegistry<Enchantment> EnchantmentRegister = event.getRegistry();

        EnchantmentRegister.register(ModEnchant.SOUL_STOP);
        EnchantmentRegister.register(ModEnchant.SOUL_BOOM);

    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void setModelRegistery(ModelRegistryEvent event) {

        //普通物品
        ClientProxy.setModelBlocksItems(ModItems.SOUL);
        ClientProxy.setModelBlocksItems(ModItems.SOUL_SEED);
        //方块物品
        ClientProxy.setModelBlocksItems(ModItems.SOLID_STATE_SOUL);
        ClientProxy.setModelBlocksItems(ModItems.SOLID_ORE);
        ClientProxy.setModelBlocksItems(ModItems.SOUL_SAND);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void setFluidModelRegister(ModelRegistryEvent event) {
        ClientProxy.setModelFluid(ModBlocks.SPIRIT, "spirit_fluid");
    }
}
