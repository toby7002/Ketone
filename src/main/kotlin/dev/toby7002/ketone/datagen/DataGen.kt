package dev.toby7002.ketone.datagen

import com.klikli_dev.modonomicon.api.datagen.LanguageProviderCache
import com.klikli_dev.modonomicon.datagen.EnUsProvider
import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.datagen.blockstate.KBlockStateProvider
import dev.toby7002.ketone.datagen.book.GuidebookProvider
import dev.toby7002.ketone.datagen.lang.EnglishLangProvider
import dev.toby7002.ketone.datagen.models.KBlockModelProvider
import dev.toby7002.ketone.datagen.models.KItemModelProvider
import dev.toby7002.ketone.datagen.recipes.RecipesProvider
import net.neoforged.neoforge.data.event.GatherDataEvent

class DataGen {
    companion object {

        fun gatherData(event: GatherDataEvent) {
            try {
                val generator = event.generator
                val output = event.generator.packOutput
                val existingFileHelper = event.existingFileHelper
                val enUsCache = LanguageProviderCache("en_us")

                generator.addProvider(true, GuidebookProvider(output, enUsCache))
                generator.addProvider(true, EnUsProvider(output, enUsCache))
                generator.addProvider(true, RecipesProvider(output))
                generator.addProvider(true, KItemModelProvider(output, existingFileHelper))
                generator.addProvider(true, KBlockModelProvider(output, existingFileHelper))
                generator.addProvider(true, KBlockStateProvider(output, existingFileHelper))
                generator.addProvider(true, EnglishLangProvider(output))
            } catch (e: RuntimeException) {
                Ketone.LOGGER.error("Failed to generate data", e)
            }
        }
    }
}
