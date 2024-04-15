package dev.toby7002.ketone.datagen.lang

import dev.toby7002.ketone.KBlocks
import dev.toby7002.ketone.KItems
import dev.toby7002.ketone.Ketone
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

class EnglishLangProvider(output: PackOutput) : LanguageProvider(output, Ketone.MOD_ID, "en_us") {
    override fun addTranslations() {
        add("itemGroup.ketone", "Ketone")
        add(KItems.GLASS_CUTTER.get(), "Glass Cutter")
        add(KItems.POLISHED_QUARTZ.get(), "Polished Quartz")
        add(KBlocks.ANGEL_BLOCK.get(), "Angel Block")
    }
}
