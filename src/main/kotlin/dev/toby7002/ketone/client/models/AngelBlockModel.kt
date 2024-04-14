package dev.toby7002.ketone.client.models

import dev.toby7002.ketone.Ketone
import dev.toby7002.ketone.blocks.entity.AngelBlockEntity
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.GeoModel

class AngelBlockModel: GeoModel<AngelBlockEntity>() {
    override fun getModelResource(p0: AngelBlockEntity): ResourceLocation {
        return ResourceLocation(Ketone.MOD_ID, "geo/block/angel_block.geo.json")
    }

    override fun getTextureResource(p0: AngelBlockEntity): ResourceLocation {
        return ResourceLocation(Ketone.MOD_ID, "textures/block/angel_block.png")
    }

    override fun getAnimationResource(p0: AngelBlockEntity): ResourceLocation {
        return ResourceLocation(Ketone.MOD_ID, "animations/angel_block.animation.json")
    }
}