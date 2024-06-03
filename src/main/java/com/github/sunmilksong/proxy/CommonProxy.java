package com.github.sunmilktea.proxy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Objects;

/**
 * @author SUNMILKSONG
 */
public class CommonProxy {
    /**
     * 设置注册名
     */
    public static Item setRegisterNames(ItemBlock item) {
        item.setRegistryName(Objects.requireNonNull(item.getBlock().getRegistryName()));
        return item;
    }
}

