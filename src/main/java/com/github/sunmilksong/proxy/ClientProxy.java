package com.github.sunmilktea.proxy;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * @author SUNMILKSONG
 */
public class ClientProxy extends CommonProxy {

    //方块，物品，方块物品模型

        @SideOnly(Side.CLIENT)
        public static void setModelBlocksItems(Item item) {

            ModelResourceLocation modelResourceLocation = new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
        }

    //流体模型

    @SideOnly(Side.CLIENT)
    public static void setModelFluid(Block block ,String fluidname) {
        Item item = Item.getItemFromBlock(block);

        ModelResourceLocation fluidModelLocation = new ModelResourceLocation("soulmagic:"+fluidname, "fluid");

        ModelLoader.setCustomMeshDefinition(item, stack -> fluidModelLocation);

        ModelLoader.setCustomStateMapper(block, new StateMapperBase() {

            @Nonnull
            @Override
            @ParametersAreNonnullByDefault
            public ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return fluidModelLocation;
            }
        });
    }
}
