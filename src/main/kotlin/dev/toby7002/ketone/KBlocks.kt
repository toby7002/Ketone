package dev.toby7002.ketone

import com.google.common.base.Supplier
import dev.toby7002.ketone.blocks.AngelBlock
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.DeferredBlock

class KBlocks {
    companion object {
        val ANGEL_BLOCK: DeferredBlock<Block> =
            Ketone.BLOCKS.register(AngelBlock.NAME, Supplier { AngelBlock() })

        fun init() {}
    }
}
