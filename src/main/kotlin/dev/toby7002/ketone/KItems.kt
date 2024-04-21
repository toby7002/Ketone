package dev.toby7002.ketone

import com.google.common.base.Supplier
import dev.toby7002.ketone.blocks.AngelBlock
import dev.toby7002.ketone.items.*
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem

class KItems {
    companion object {
        val POLISHED_QUARTZ: DeferredItem<Item> =
            Ketone.ITEMS.register(PolishedQuartz.NAME, Supplier { PolishedQuartz() })
        val GLASS_CUTTER: DeferredItem<Item> =
            Ketone.ITEMS.register(GlassCutter.NAME, Supplier { GlassCutter() })
        val ANGEL_BLOCK_ITEM: DeferredItem<BlockItem> =
            Ketone.ITEMS.register(AngelBlock.NAME, Supplier { AngelBlockItem() })
        val ICE_BREAKER: DeferredItem<Item> =
            Ketone.ITEMS.register(IceBreaker.NAME, Supplier { IceBreaker() })
        val GUIDEBOOK: DeferredItem<Item> =
            Ketone.ITEMS.register(Guidebook.NAME, Supplier { Guidebook() })

        fun init() {}
    }
}
