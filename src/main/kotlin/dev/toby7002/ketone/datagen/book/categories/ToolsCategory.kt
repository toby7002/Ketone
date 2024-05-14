package dev.toby7002.ketone.datagen.book.categories

import com.klikli_dev.modonomicon.api.datagen.BookProvider
import com.klikli_dev.modonomicon.api.datagen.CategoryProvider
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel
import dev.toby7002.ketone.datagen.book.entries.GlassCutterEntry
import dev.toby7002.ketone.datagen.book.entries.IceBreakerEntry
import dev.toby7002.ketone.registry.ItemRegistry

class ToolsCategory(parent: BookProvider, categoryId: String) :
    CategoryProvider(parent, categoryId) {
    override fun generateEntryMap(): Array<String> {
        return arrayOf(
            "a_b__________________",
        )
    }

    override fun generateEntries() {
        add(IceBreakerEntry(this).generate("a".first()))
        add(GlassCutterEntry(this).generate("b".first()))
    }

    override fun generateCategory(): BookCategoryModel {
        lang().add(context().categoryName(), "Tools")

        return BookCategoryModel.create(modLoc(context().categoryId()), context().categoryName())
            .withIcon(ItemRegistry.ICE_BREAKER.asItem())
            .withSortNumber(2)
    }
}
