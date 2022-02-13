package com.uzihead.minecraft.othercoolblocks.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.extensions.IForgeBlockState;

public final class ExpandedCraftingTable extends Block{
    public ExpandedCraftingTable(Properties prop) {
        super(prop.copy(Blocks.OAK_STAIRS).noOcclusion());
    }
}
