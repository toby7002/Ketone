package dev.toby7002.ketone.datagen.lang

import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.block.AngelBlock
import dev.toby7002.ketone.block.RainMaker
import dev.toby7002.ketone.item.*
import dev.toby7002.ketone.registry.BlockRegistry
import dev.toby7002.ketone.registry.ItemRegistry
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Item
import net.neoforged.neoforge.common.data.LanguageProvider

class EnglishLangProvider(output: PackOutput) : LanguageProvider(output, Ketone.MOD_ID, "en_us") {
    override fun addTranslations() {
        add("itemGroup.ketone", "Ketone")
        val map = HashMap<String, Item>()

        map[GlassCutter.DISPLAY_NAME] = ItemRegistry.GLASS_CUTTER.get()
        map[IceBreaker.DISPLAY_NAME] = ItemRegistry.ICE_BREAKER.get()
        map[PolishedQuartz.DISPLAY_NAME] = ItemRegistry.POLISHED_QUARTZ.get()
        map[AngelBlock.DISPLAY_NAME] = BlockRegistry.ANGEL_BLOCK.asItem()
        map[TinyCoal.DISPLAY_NAME] = ItemRegistry.TINY_COAL.get()
        map[TinyCharcoal.DISPLAY_NAME] = ItemRegistry.TINY_CHARCOAL.get()
        map[RainMaker.DISPLAY_NAME] = BlockRegistry.RAIN_MAKER.asItem()

        map.forEach { (key, value) -> add(value, key) }
    }
}
