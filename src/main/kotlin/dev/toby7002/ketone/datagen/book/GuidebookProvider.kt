package dev.toby7002.ketone.datagen.book

import com.klikli_dev.modonomicon.api.datagen.BookProvider
import com.klikli_dev.modonomicon.api.datagen.ModonomiconLanguageProvider
import com.klikli_dev.modonomicon.api.datagen.book.BookModel
import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.datagen.book.categories.BlocksCategory
import dev.toby7002.ketone.datagen.book.categories.ResourcesCategory
import dev.toby7002.ketone.datagen.book.categories.ToolsCategory
import dev.toby7002.ketone.item.Guidebook
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation

class GuidebookProvider(packOutput: PackOutput, defaultLang: ModonomiconLanguageProvider) :
    BookProvider(Guidebook.NAME, packOutput, Ketone.MOD_ID, defaultLang) {
    override fun registerDefaultMacros() {}

    override fun generateBook(): BookModel {
        lang().add(context().bookName(), "Ketone Guidebook")
        lang().add(context().bookTooltip(), "All you need to get started with Ketone")

        val toolsCategory = ToolsCategory(this, "tools").generate()
        val resourcesCategory = ResourcesCategory(this, "resources").generate()
        val blocksCategory = BlocksCategory(this, "blocks").generate()

        val guidebook =
            BookModel.create(modLoc(context().bookId()), context().bookName())
                .withTooltip(context().bookTooltip())
                .withGenerateBookItem(false)
                .withCustomBookItem(ResourceLocation(Ketone.MOD_ID, Guidebook.NAME))
                .withCategories(listOf(resourcesCategory, toolsCategory, blocksCategory))

        return guidebook
    }
}
