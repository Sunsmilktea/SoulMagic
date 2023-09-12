package com.github.sunmilksong.proxy;

import com.github.sunmilksong.items.ItemSeed;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

/**
 * @author SUNMILKSONG
 */
public class ClientProxy extends CommonProxy {

    @SideOnly(Side.CLIENT)
    public static void modelRegistery(Item item, int meta) {

        ModelResourceLocation modelResourceLocation =
                new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
    }
}

