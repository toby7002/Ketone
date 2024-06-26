package dev.toby7002.ketone.item

import com.klikli_dev.modonomicon.book.Book
import com.klikli_dev.modonomicon.client.gui.BookGuiManager
import com.klikli_dev.modonomicon.data.BookDataManager
import com.klikli_dev.modonomicon.item.ModonomiconItem
import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.registry.ItemRegistry
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class Guidebook : ModonomiconItem(Properties()) {
    companion object {
        const val NAME: String = "guidebook"
        const val DISPLAY_NAME = "Guidebook"

        val BOOK = ResourceLocation(Ketone.MOD_ID, NAME)
    }

    override fun getName(pStack: ItemStack): Component {
        val book = BookDataManager.get().getBook(BOOK)
        if (book != null) {
            return Component.translatable(book.name)
        }

        return super.getName(pStack)
    }

    override fun use(
        pLevel: Level,
        pPlayer: Player,
        pUsedHand: InteractionHand
    ): InteractionResultHolder<ItemStack> {
        val itemInHand = pPlayer.getItemInHand(pUsedHand)

        if (pLevel.isClientSide) {

            if (itemInHand.`is`(ItemRegistry.GUIDEBOOK)) {
                val book = BookDataManager.get().getBook(BOOK)
                BookGuiManager.get().openBook(book.id)
            } else {
                Ketone.LOGGER.error("ModonomiconItem: ItemStack has no tag!")
            }
        }

        return InteractionResultHolder.sidedSuccess(itemInHand, pLevel.isClientSide)
    }

    override fun appendHoverText(
        stack: ItemStack,
        worldIn: Level?,
        tooltip: MutableList<Component>,
        flagIn: TooltipFlag
    ) {
        val book: Book = BookDataManager.get().getBook(BOOK)

        if (book.tooltip.isNotBlank()) {
            tooltip.add(Component.translatable(book.tooltip).withStyle(ChatFormatting.GRAY))
        }
    }
}
