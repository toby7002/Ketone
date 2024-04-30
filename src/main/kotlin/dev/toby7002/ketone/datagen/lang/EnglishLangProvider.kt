package dev.toby7002.ketone.datagen.lang

import dev.toby7002.ketone.KBlocks
import dev.toby7002.ketone.KItems
import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.blocks.AngelBlock
import dev.toby7002.ketone.items.*
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Item
import net.neoforged.neoforge.common.data.LanguageProvider

class EnglishLangProvider(output: PackOutput) : LanguageProvider(output, Ketone.MOD_ID, "en_us") {
    override fun addTranslations() {
        add("itemGroup.ketone", "Ketone")
        val map = HashMap<String, Item>()

        map[GlassCutter.DISPLAY_NAME] = KItems.GLASS_CUTTER.get()
        map[IceBreaker.DISPLAY_NAME] = KItems.ICE_BREAKER.get()
        map[PolishedQuartz.DISPLAY_NAME] = KItems.POLISHED_QUARTZ.get()
        map[AngelBlock.DISPLAY_NAME] = KBlocks.ANGEL_BLOCK.asItem()
        map[TinyCoal.DISPLAY_NAME] = KItems.TINY_COAL.get()
        map[TinyCharcoal.DISPLAY_NAME] = KItems.TINY_CHARCOAL.get()

        map.forEach { (key, value) -> add(value, key) }
    }
}
