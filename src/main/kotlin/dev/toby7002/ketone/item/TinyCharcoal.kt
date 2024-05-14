package dev.toby7002.ketone.item

import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.RecipeType

class TinyCharcoal : Item(Properties()) {
    companion object {
        const val NAME = "tiny_charcoal"
        const val DISPLAY_NAME = "Tiny Charcoal"
    }

    override fun getBurnTime(itemStack: ItemStack, recipeType: RecipeType<*>?): Int {
        return 200
    }
}
