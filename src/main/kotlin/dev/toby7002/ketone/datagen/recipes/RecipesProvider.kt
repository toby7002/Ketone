package dev.toby7002.ketone.datagen.recipes

import dev.toby7002.ketone.KBlocks
import dev.toby7002.ketone.KItems
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Blocks

class RecipesProvider(output: PackOutput) : RecipeProvider(output) {
    override fun buildRecipes(p0: RecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, KItems.POLISHED_QUARTZ)
            .requires(Items.QUARTZ, 1)
            .requires(Items.FLINT, 1)
            .unlockedBy("has_item", has(Items.FLINT))
            .save(p0)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KItems.GLASS_CUTTER, 1)
            .pattern("x")
            .pattern("y")
            .define("x".single(), KItems.POLISHED_QUARTZ.get())
            .define("y".single(), Items.STICK)
            .unlockedBy("has_item", has(KItems.POLISHED_QUARTZ.get()))
            .save(p0)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, KBlocks.ANGEL_BLOCK, 1)
            .pattern(" y ")
            .pattern("aza")
            .pattern(" y ")
            .define("y".single(), Blocks.WHITE_WOOL)
            .define("z".single(), Blocks.GOLD_BLOCK)
            .define("a".single(), Items.FEATHER)
            .unlockedBy("has_item", has(Blocks.GOLD_BLOCK.asItem()))
            .save(p0)
    }
}
