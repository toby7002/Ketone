package dev.toby7002.ketone.client.renderers

import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.blocks.entity.AngelBlockEntity
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedBlockGeoModel
import software.bernie.geckolib.renderer.GeoBlockRenderer

class AngelBlockRenderer(context: BlockEntityRendererProvider.Context) :
    GeoBlockRenderer<AngelBlockEntity>(
        DefaultedBlockGeoModel(ResourceLocation(Ketone.MOD_ID, "angel_block"))
    )
