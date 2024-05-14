package dev.toby7002.ketone.item

import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.item.*
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.common.Tags

class GlassCutter : Item(Properties()) {
    companion object {
        const val NAME: String = "glass_cutter"
        const val DISPLAY_NAME = "Glass Cutter"
    }

    override fun useOn(pContext: UseOnContext): InteractionResult {
        val level = pContext.level
        val pos = pContext.clickedPos
        val blockState = level.getBlockState(pos)

        if (blockState.`is`(Tags.Blocks.GLASS)) {
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
