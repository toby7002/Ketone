package dev.toby7002.ketone

import com.google.common.base.Supplier
import dev.toby7002.ketone.items.GlassCutter
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem

class KItems {
    companion object {
        val POLISHED_QUARTZ: DeferredItem<Item> = Ketone.ITEMS.register("polished_quartz", Supplier{ GlassCutter()}
        )
        val GLASS_CUTTER: DeferredItem<Item> = Ketone.ITEMS.registerSimpleItem(
            "glass_cutter", Item.Properties()
        )

        fun registerItems() {}
    }

}