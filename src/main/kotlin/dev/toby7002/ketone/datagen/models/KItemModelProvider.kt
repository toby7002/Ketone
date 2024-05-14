package dev.toby7002.ketone.datagen.models

import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.registry.ItemRegistry
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Item
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class KItemModelProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) :
    ItemModelProvider(output, Ketone.MOD_ID, existingFileHelper) {
    override fun registerModels() {
        val basicItems =
            listOf<Item>(
                ItemRegistry.GLASS_CUTTER.get(),
                ItemRegistry.POLISHED_QUARTZ.get(),
                ItemRegistry.ICE_BREAKER.get(),
                ItemRegistry.GUIDEBOOK.get(),
                ItemRegistry.TINY_COAL.get(),
                ItemRegistry.TINY_CHARCOAL.get()
            )

        basicItems.forEach { item -> basicItem(item) }
    }
}
