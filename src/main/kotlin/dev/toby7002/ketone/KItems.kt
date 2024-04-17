package dev.toby7002.ketone

import com.google.common.base.Supplier
import dev.toby7002.ketone.blocks.AngelBlock
import dev.toby7002.ketone.items.AngelBlockItem
import dev.toby7002.ketone.items.GlassCutter
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem

class KItems {
    companion object {
        val POLISHED_QUARTZ: DeferredItem<Item> =
            Ketone.ITEMS.registerSimpleItem(
                "polished_quartz",
            )
        val GLASS_CUTTER: DeferredItem<Item> =
            Ketone.ITEMS.register("glass_cutter", Supplier { GlassCutter() })
        val ANGEL_BLOCK_ITEM: DeferredItem<BlockItem> =
            Ketone.ITEMS.register(AngelBlock.NAME, Supplier { AngelBlockItem() })

        fun init() {}
    }
}
