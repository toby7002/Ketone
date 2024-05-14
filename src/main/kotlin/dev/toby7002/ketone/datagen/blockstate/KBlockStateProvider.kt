package dev.toby7002.ketone.datagen.blockstate

import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.registry.BlockRegistry
import net.minecraft.data.PackOutput
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class KBlockStateProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) :
    BlockStateProvider(output, Ketone.MOD_ID, existingFileHelper) {
    override fun registerStatesAndModels() {
        blockWithItem(BlockRegistry.ANGEL_BLOCK.get())
        blockWithItem(BlockRegistry.RAIN_MAKER.get())
    }

    private fun blockWithItem(block: Block) {
        simpleBlockWithItem(block, cubeAll(block))
    }
}
