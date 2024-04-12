package dev.toby7002.ketone

import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem

class Items {
    companion object {
        val POLISHED_QUARTZ: DeferredItem<Item> = Ketone.ITEMS.registerSimpleItem(
            "polished_quartz", Item.Properties()
        )
        val GLASS_CUTTER: DeferredItem<Item> = Ketone.ITEMS.registerSimpleItem(
            "glass_cutter", Item.Properties()
        )
    }
}