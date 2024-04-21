package dev.toby7002.ketone.datagen.book.categories

import com.klikli_dev.modonomicon.api.datagen.BookProvider
import com.klikli_dev.modonomicon.api.datagen.CategoryProvider
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel
import dev.toby7002.ketone.KItems
import dev.toby7002.ketone.datagen.book.entries.PolishedQuartzEntry

class ResourcesCategory(parent: BookProvider, categoryId: String) :
    CategoryProvider(parent, categoryId) {
    override fun generateEntryMap(): Array<String> {
        return arrayOf(
            "m____________________",
        )
    }

    override fun generateEntries() {
        add(PolishedQuartzEntry(this).generate("m".first()))
    }

    override fun generateCategory(): BookCategoryModel {
        lang().add(context().categoryName(), "Resources")

        return BookCategoryModel.create(modLoc(context().categoryId()), context().categoryName())
            .withIcon(KItems.POLISHED_QUARTZ.asItem())
            .withSortNumber(1)
    }
}
