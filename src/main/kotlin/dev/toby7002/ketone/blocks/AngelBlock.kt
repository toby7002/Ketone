package dev.toby7002.ketone.blocks

import net.minecraft.core.BlockPos
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.FluidState

class AngelBlock() : Block(Properties.of()) {
    companion object {
        const val NAME: String = "angel_block"
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
        if (!player.isCreative) {
            player.addItem(this.asItem().defaultInstance)
        }
        return false
    }
}
