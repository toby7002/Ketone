package dev.toby7002.ketone.items

import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.item.*
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState

class IceBreaker : Item(Properties()), Tier {
    companion object {
        const val NAME: String = "ice_breaker"
    }

    override fun useOn(pContext: UseOnContext): InteractionResult {
        val level = pContext.level
        val pos = pContext.clickedPos
        val blockState = level.getBlockState(pos)

        if (
            blockState.`is`(Blocks.ICE) ||
                blockState.`is`(Blocks.BLUE_ICE) ||
                blockState.`is`(Blocks.PACKED_ICE)
        ) {
            level.destroyBlock(pos, true)
            level.addFreshEntity(
                ItemEntity(
                    level,
                    pos.x.toDouble(),
                    pos.y.toDouble(),
                    pos.z.toDouble(),
                    blockState.block.asItem().defaultInstance
                )
            )
            return InteractionResult.SUCCESS
        }

        return InteractionResult.FAIL
    }

    override fun getUses(): Int {
        return 2000
    }

    override fun getSpeed(): Float {
        return 0f
    }

    override fun getAttackDamageBonus(): Float {
        return 0f
    }

    override fun getLevel(): Int {
        return 1
    }

    override fun getDestroySpeed(pStack: ItemStack, pState: BlockState): Float {
        return 0f
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.of(Items.TORCH)
    }
}
