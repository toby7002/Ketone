package dev.toby7002.ketone.items

import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.RecipeType

class TinyCoal : Item(Properties()) {
    companion object {
        const val NAME = "tiny_coal"
        const val DISPLAY_NAME = "Tiny Coal"
    }

    override fun getBurnTime(itemStack: ItemStack, recipeType: RecipeType<*>?): Int {
        return 200
    }
}
