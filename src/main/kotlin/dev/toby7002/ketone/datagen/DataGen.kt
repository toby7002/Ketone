package dev.toby7002.ketone.datagen

import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.datagen.models.KItemModelProvider
import net.neoforged.neoforge.data.event.GatherDataEvent


class DataGen {
    companion object {

        fun gatherData(event: GatherDataEvent) {
            try {
                val generator = event.generator
                val output = event.generator.packOutput
                val existingFileHelper = event.existingFileHelper

                generator.addProvider(true, KItemModelProvider(output, existingFileHelper))
            } catch (e: RuntimeException) {
                Ketone.LOGGER.error("Failed to generate data", e)
            }
        }
    }
}