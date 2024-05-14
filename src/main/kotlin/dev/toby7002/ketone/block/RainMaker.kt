package dev.toby7002.ketone.block

import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.shapes.BooleanOp
import net.minecraft.world.phys.shapes.Shapes
import net.minecraft.world.phys.shapes.VoxelShape


class RainMaker: Block(Properties.of()) {
    companion object {
        const val NAME: String = "rain_maker"
        const val DISPLAY_NAME: String = "Rain Maker"
    }

    @Deprecated("Deprecated in Java")
    override fun onPlace(
        pState: BlockState,
        pLevel: Level,
        pPos: BlockPos,
        pOldState: BlockState,
        pMovedByPiston: Boolean
    ) {
        if(pLevel is ServerLevel) {
            pLevel.setWeatherParameters(
                0,
                12000,
                true,
                false
            )
        }
        pLevel.destroyBlock(pPos, false)
    }
}