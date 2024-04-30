package dev.toby7002.ketone.items

import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.RecipeType

class TinyCoal : Item(Properties()) {
    companion object {
        const val NAME = "tiny_coal"
    }

    override fun getBurnTime(itemStack: ItemStack, recipeType: RecipeType<*>?): Int {
        return 200
    }
}
