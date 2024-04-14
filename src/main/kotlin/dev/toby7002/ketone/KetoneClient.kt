package dev.toby7002.ketone

import dev.toby7002.ketone.blocks.entity.KBlockEntities
import dev.toby7002.ketone.client.renderers.AngelBlockRenderer
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers


class KetoneClient {

    @Mod.EventBusSubscriber(modid = Ketone.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
    companion object {
        @SubscribeEvent
        fun registerRenderers(event: RegisterRenderers) {
            event.registerBlockEntityRenderer(
                KBlockEntities.ANGEL_BLOCK_ENTITY.get(), ::AngelBlockRenderer)}

    }
}