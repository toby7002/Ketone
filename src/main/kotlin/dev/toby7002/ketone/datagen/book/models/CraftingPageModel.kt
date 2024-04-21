package dev.toby7002.ketone.datagen.book.models

import com.klikli_dev.modonomicon.api.datagen.book.page.BookRecipePageModel
import net.minecraft.resources.ResourceLocation

class CraftingPageModel<T : BookRecipePageModel<T>>() :
    BookRecipePageModel<T>(ResourceLocation("modonomicon", "crafting_recipe")) {}
