package dev.toby7002.ketone.datagen.book.categories

import com.klikli_dev.modonomicon.api.datagen.BookProvider
import com.klikli_dev.modonomicon.api.datagen.CategoryProvider
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel
import dev.toby7002.ketone.KBlocks
import dev.toby7002.ketone.datagen.book.entries.AngelBlockEntry

class BlocksCategory(parent: BookProvider, categoryId: String) :
    CategoryProvider(parent, categoryId) {
    override fun generateEntryMap(): Array<String> {
        return arrayOf(
            "a____________________",
        )
    }

    override fun generateEntries() {
        add(AngelBlockEntry(this).generate("a".first()))
    }

    override fun generateCategory(): BookCategoryModel {
        lang().add(context().categoryName(), "Blocks")

        return BookCategoryModel.create(modLoc(context().categoryId()), context().categoryName())
            .withIcon(KBlocks.ANGEL_BLOCK.asItem())
            .withSortNumber(3)
    }
}
