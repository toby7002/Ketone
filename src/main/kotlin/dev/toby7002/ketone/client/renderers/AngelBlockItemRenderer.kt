package dev.toby7002.ketone.client.renderers

import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.items.AngelBlockItem
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedBlockGeoModel
import software.bernie.geckolib.renderer.GeoItemRenderer

class AngelBlockItemRenderer() :
    GeoItemRenderer<AngelBlockItem>(
        DefaultedBlockGeoModel(ResourceLocation(Ketone.MOD_ID, "angel_block"))
    )
