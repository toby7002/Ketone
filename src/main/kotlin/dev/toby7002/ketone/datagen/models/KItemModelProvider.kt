package dev.toby7002.ketone.datagen.models

import dev.toby7002.ketone.Items
import dev.toby7002.ketone.Ketone
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class KItemModelProvider(output: PackOutput,
                         existingFileHelper: ExistingFileHelper
) : ItemModelProvider(output, Ketone.MOD_ID, existingFileHelper) {
    override fun registerModels() {
        basicItem(Items.GLASS_CUTTER.get())
        basicItem(Items.POLISHED_QUARTZ.get())
    }

}