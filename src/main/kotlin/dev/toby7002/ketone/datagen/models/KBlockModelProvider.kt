package dev.toby7002.ketone.datagen.models

import dev.toby7002.ketone.Ketone
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.BlockModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class KBlockModelProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) :
    BlockModelProvider(output, Ketone.MOD_ID, existingFileHelper) {
    override fun registerModels() {}
}
