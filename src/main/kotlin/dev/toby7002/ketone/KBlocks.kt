package dev.toby7002.ketone

import com.google.common.base.Supplier
import dev.toby7002.ketone.blocks.AngelBlock
import dev.toby7002.ketone.items.AngelBlockItem
import net.minecraft.world.item.BlockItem
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem

class KBlocks {
    companion object {
        val ANGEL_BLOCK: DeferredBlock<Block> =
            Ketone.BLOCKS.register("angel_block", Supplier { AngelBlock() })
        val ANGEL_BLOCK_ITEM: DeferredItem<BlockItem> =
            Ketone.ITEMS.register("angel_block", Supplier { AngelBlockItem() })

        fun init() {}
    }
}
