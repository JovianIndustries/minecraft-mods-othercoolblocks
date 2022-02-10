package com.uzihead.minecraft.othercoolblocks.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;

public final class ExpandedCraftingTable extends Block{
    public ExpandedCraftingTable(Properties prop) {
        super(prop.color(MaterialColor.WOOD).destroyTime(1f).explosionResistance(1f));
    }
}
