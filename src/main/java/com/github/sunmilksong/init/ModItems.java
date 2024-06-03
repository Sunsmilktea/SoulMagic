package com.github.sunmilktea.init;

import com.github.sunmilktea.items.ItemBase;
import com.github.sunmilktea.items.ItemSeed;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.ArrayList;
import java.util.List;


/**
 * @author SUNMILKSONG
 */
public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<>();
    //普通物品

    public static final ItemBase SOUL = new ItemBase("soul");

    public static final ItemSeed SOUL_SEED = new ItemSeed("soul_seed", ModBlocks.SOUL_CROP, ModBlocks.SOUL_SAND);

    //public static final ItemBase DIR = new ItemBase("soul_dir");

    //物品方块

    public static final ItemBlock SOLID_STATE_SOUL = new ItemBlock(ModBlocks.SOLID_STATE_SOUL);

    public static final ItemBlock SOLID_ORE = new ItemBlock(ModBlocks.SOLID_ORE);

    public static final ItemBlock SOUL_SAND = new ItemBlock(ModBlocks.SOUL_SAND);


}

