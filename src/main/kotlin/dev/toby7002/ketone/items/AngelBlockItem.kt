package dev.toby7002.ketone.items

import dev.toby7002.ketone.KBlocks
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class AngelBlockItem : BlockItem(KBlocks.ANGEL_BLOCK.get(), Properties()) {

    override fun use(
        level: Level,
        player: Player,
        pUsedHand: InteractionHand
    ): InteractionResultHolder<ItemStack> {
        val pos = BlockPos(player.x.toInt(), (player.y - 1).toInt(), player.z.toInt())

        if (level.getBlockState(pos).`is`(net.minecraft.world.level.block.Blocks.AIR)) {
            level.setBlock(pos, KBlocks.ANGEL_BLOCK.get().defaultBlockState(), 3)
            if (!player.isCreative) {
                player.mainHandItem.shrink(1)
            }
        }
        return InteractionResultHolder(InteractionResult.PASS, player.mainHandItem)
    }
}
