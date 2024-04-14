package dev.toby7002.ketone.items

import dev.toby7002.ketone.KBlocks
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionResult
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.context.UseOnContext
import net.neoforged.neoforge.common.Tags.Blocks

class AngelBlockItem : BlockItem(KBlocks.ANGEL_BLOCK.get(), Properties()) {
    override fun useOn(pContext: UseOnContext): InteractionResult {
        val level = pContext.level
        val player = pContext.player
        val pos = pContext.clickedPos

        if (level.getBlockState(pos).`is`(net.minecraft.world.level.block.Blocks.AIR)) {
            player?.sendSystemMessage(Component.literal("OH WOW"))
            level.setBlock(pos, KBlocks.ANGEL_BLOCK.get().defaultBlockState(), 3)
            if (player != null) {
                if (!player.isCreative) {
                    player.mainHandItem.shrink(1)
                }
            }
        }

        return InteractionResult.PASS
    }
}