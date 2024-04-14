package dev.toby7002.ketone.blocks

import com.mojang.serialization.MapCodec
import dev.toby7002.ketone.blocks.entity.AngelBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.FluidState


class AngelBlock() : Block(Properties.of()), EntityBlock {
    companion object {
        const val NAME: String = "angel_block"
    }

    override fun newBlockEntity(p0: BlockPos, p1: BlockState): BlockEntity {
        return AngelBlockEntity(p0, p1)
    }

    override fun getRenderShape(pState: BlockState): RenderShape {
        return RenderShape.ENTITYBLOCK_ANIMATED
    }

    override fun onDestroyedByPlayer(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        willHarvest: Boolean,
        fluid: FluidState
    ): Boolean {
        level.destroyBlock(pos, true)
        player.addItem(this.asItem().defaultInstance)
        return false
    }
}