package dev.toby7002.ketone.items

import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.item.*
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState

class IceBreaker : Item(Properties()) {
    companion object {
        const val NAME: String = "ice_breaker"
    }

    override fun useOn(pContext: UseOnContext): InteractionResult {
        val level = pContext.level
        val pos = pContext.clickedPos
        val blockState = level.getBlockState(pos)

        if (
            blockState.`is`(Blocks.ICE) ||
                blockState.`is`(Blocks.BLUE_ICE) ||
                blockState.`is`(Blocks.PACKED_ICE)
        ) {
            level.destroyBlock(pos, true)
            level.addFreshEntity(
                ItemEntity(
                    level,
                    pos.x.toDouble(),
                    pos.y.toDouble(),
                    pos.z.toDouble(),
                    blockState.block.asItem().defaultInstance
                )
            )
            return InteractionResult.SUCCESS
        }

        return InteractionResult.FAIL
    }

    override fun getDestroySpeed(pStack: ItemStack, pState: BlockState): Float {
        return 0f
    }
}
