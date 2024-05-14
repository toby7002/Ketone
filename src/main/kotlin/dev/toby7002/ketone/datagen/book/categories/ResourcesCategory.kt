package dev.toby7002.ketone.datagen.book.categories

import com.klikli_dev.modonomicon.api.datagen.BookProvider
import com.klikli_dev.modonomicon.api.datagen.CategoryProvider
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel
import dev.toby7002.ketone.datagen.book.entries.PolishedQuartzEntry
import dev.toby7002.ketone.datagen.book.entries.TinyCharcoalEntry
import dev.toby7002.ketone.datagen.book.entries.TinyCoalEntry
import dev.toby7002.ketone.registry.ItemRegistry

class ResourcesCategory(parent: BookProvider, categoryId: String) :
    CategoryProvider(parent, categoryId) {
    override fun generateEntryMap(): Array<String> {
        return arrayOf("m____________________", "a_b__________________")
    }

    override fun generateEntries() {
        add(PolishedQuartzEntry(this).generate("m".first()))
        add(TinyCoalEntry(this).generate("a".first()))
        add(TinyCharcoalEntry(this).generate("b".first()))
    }

    override fun generateCategory(): BookCategoryModel {
        lang().add(context().categoryName(), "Resources")

        return BookCategoryModel.create(modLoc(context().categoryId()), context().categoryName())
            .withIcon(ItemRegistry.POLISHED_QUARTZ.asItem())
            .withSortNumber(1)
    }
}
