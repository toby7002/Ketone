package dev.toby7002.ketone.datagen.book.entries

import com.klikli_dev.modonomicon.api.datagen.CategoryProvider
import com.klikli_dev.modonomicon.api.datagen.EntryProvider
import com.klikli_dev.modonomicon.api.datagen.book.BookIconModel
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel
import com.mojang.datafixers.util.Pair
import dev.toby7002.ketone.KItems
import dev.toby7002.ketone.datagen.book.models.CraftingPageModel
import dev.toby7002.ketone.items.GlassCutter
import net.minecraft.world.level.ItemLike

class GlassCutterEntry(parent: CategoryProvider) : EntryProvider(parent) {
    private val ID = GlassCutter.NAME
    private val NAME = GlassCutter.DISPLAY_NAME
    private val SHORT_DESCRIPTION = "Don't have Silk touch? Well, this is for you"
    private val LONG_DESCRIPTION = "Glasses are obtainable without using Silk touch now"
    private val ITEM: ItemLike = KItems.GLASS_CUTTER.get()

    override fun generatePages() {
        context().page("intro")
        lang().add(context().pageTitle(), NAME)
        lang().add(context().pageText(), LONG_DESCRIPTION)
        val intro =
            BookTextPageModel.create()
                .withTitle(context().pageTitle())
                .withText(context().pageText())
        add(intro)

        context().page("recipe")
        lang().add(context().pageTitle(), "Recipe")
        val recipe =
            CraftingPageModel()
                .withRecipeId1(modLoc(GlassCutter.NAME))
                .withTitle1(context().pageTitle())
        add(recipe)
    }

    override fun entryName(): String {
        return NAME
    }

    override fun entryDescription(): String {
        return SHORT_DESCRIPTION
    }

    override fun entryBackground(): Pair<Int, Int> {
        return Pair(0, 0)
    }

    override fun entryIcon(): BookIconModel {
        return BookIconModel.create(ITEM)
    }

    override fun entryId(): String {
        return ID
    }
}
