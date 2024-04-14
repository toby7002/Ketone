package dev.toby7002.ketone.blocks.entity

import dev.toby7002.ketone.KBlocks
import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.blocks.AngelBlock
import net.minecraft.world.level.block.entity.BlockEntityType
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Supplier

class KBlockEntities {
    companion object {
        val ANGEL_BLOCK_ENTITY: DeferredHolder<BlockEntityType<*>, BlockEntityType<*>> = Ketone.BLOCK_ENTITIES.register(AngelBlock.NAME) { ->
            BlockEntityType.Builder.of(::AngelBlockEntity, KBlocks.ANGEL_BLOCK.get()).build(null)
        }

        fun init() {}
    }
}