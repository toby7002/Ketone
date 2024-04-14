package dev.toby7002.ketone

import com.google.common.base.Supplier
import dev.toby7002.ketone.items.GlassCutter
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem

class KItems {
    companion object {
        val POLISHED_QUARTZ: DeferredItem<Item> = Ketone.ITEMS.registerSimpleItem("polished_quartz",
        )
        val GLASS_CUTTER: DeferredItem<Item> = Ketone.ITEMS.register(
            "glass_cutter", Supplier{ GlassCutter()}
        )

        fun registerItems() {}
    }

}