package dev.toby7002.ketone.datagen.book.entries

import com.klikli_dev.modonomicon.api.datagen.CategoryProvider
import com.klikli_dev.modonomicon.api.datagen.EntryProvider
import com.klikli_dev.modonomicon.api.datagen.book.BookIconModel
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel
import com.mojang.datafixers.util.Pair
import dev.toby7002.ketone.block.AngelBlock
import dev.toby7002.ketone.block.RainMaker
import dev.toby7002.ketone.datagen.book.models.CraftingPageModel
import dev.toby7002.ketone.registry.BlockRegistry
import net.minecraft.world.level.ItemLike

class RainMakerEntry(parent: CategoryProvider) : EntryProvider(parent) {
    private val ID = RainMaker.NAME
    private val NAME = RainMaker.DISPLAY_NAME
    private val SHORT_DESCRIPTION = "I'm God?"
    private val LONG_DESCRIPTION = "Change the weather to rain immediately"
    private val ITEM: ItemLike = BlockRegistry.RAIN_MAKER.get()

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
                .withRecipeId1(modLoc(ID))
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
