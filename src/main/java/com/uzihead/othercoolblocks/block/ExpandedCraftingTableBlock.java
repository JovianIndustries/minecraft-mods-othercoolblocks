package com.uzihead.othercoolblocks.block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public final class ExpandedCraftingTableBlock extends CraftingTableBlock {
    public ExpandedCraftingTableBlock(Properties prop) {
        super(prop.noOcclusion().requiresCorrectToolForDrops());
    }
}