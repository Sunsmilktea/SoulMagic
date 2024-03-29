package com.github.sunmilksong.util.handlers;

import com.github.sunmilksong.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * @author Sunmilksong
 */
@ParametersAreNonnullByDefault
public class ModelHandler {

    public static void registerModelFluid() {
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.SPIRIT), stack -> new ModelResourceLocation("soulmagic:spirit_fluid", "fluid"));
        ModelLoader.setCustomStateMapper(ModBlocks.SPIRIT, new StateMapperBase() {

            @Nonnull
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation("soulmagic:spirit_fluid", "fluid");
            }
        });
    }

    /**
     * 设置注册名
     */
    public static Item setRegisterNames(ItemBlock item) {
        item.setRegistryName(Objects.requireNonNull(item.getBlock().getRegistryName()));
        return item;
    }

}
