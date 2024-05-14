package dev.toby7002.ketone.datagen.book.entries

import com.klikli_dev.modonomicon.api.datagen.CategoryProvider
import com.klikli_dev.modonomicon.api.datagen.EntryProvider
import com.klikli_dev.modonomicon.api.datagen.book.BookIconModel
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel
import com.mojang.datafixers.util.Pair
import dev.toby7002.ketone.datagen.book.models.CraftingPageModel
import dev.toby7002.ketone.item.IceBreaker
import dev.toby7002.ketone.registry.ItemRegistry
import net.minecraft.world.level.ItemLike

class IceBreakerEntry(parent: CategoryProvider) : EntryProvider(parent) {
    private val ID = IceBreaker.NAME
    private val NAME = IceBreaker.DISPLAY_NAME
    private val SHORT_DESCRIPTION = "Quartz but polished"
    private val LONG_DESCRIPTION = "This is used to make tools that involve sharpness"
    private val ITEM: ItemLike = ItemRegistry.ICE_BREAKER.get()

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
                .withRecipeId1(modLoc(IceBreaker.NAME))
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
