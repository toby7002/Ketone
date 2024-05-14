package dev.toby7002.ketone.registry

import com.google.common.base.Supplier
import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.block.AngelBlock
import dev.toby7002.ketone.block.RainMaker
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.DeferredBlock

class BlockRegistry {
    companion object {
        val ANGEL_BLOCK: DeferredBlock<Block> =
            Ketone.BLOCKS.register(AngelBlock.NAME, Supplier { AngelBlock() })
        val RAIN_MAKER: DeferredBlock<Block> = register(RainMaker.NAME, Supplier {RainMaker()})

        private fun register(name: String, supplier: Supplier<Block>): DeferredBlock<Block> {
            val block = Ketone.BLOCKS.register(name, supplier)

            Ketone.ITEMS.registerSimpleBlockItem(block)

            return block
        }
        fun init() {}
    }
}
