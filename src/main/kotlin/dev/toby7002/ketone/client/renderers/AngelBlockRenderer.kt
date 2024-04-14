package dev.toby7002.ketone.client.renderers

import dev.toby7002.ketone.blocks.entity.AngelBlockEntity
import dev.toby7002.ketone.client.models.AngelBlockModel
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import software.bernie.geckolib.renderer.GeoBlockRenderer


class AngelBlockRenderer(context: BlockEntityRendererProvider.Context):
    GeoBlockRenderer<AngelBlockEntity>(AngelBlockModel())