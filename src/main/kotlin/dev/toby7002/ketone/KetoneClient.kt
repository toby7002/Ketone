package dev.toby7002.ketone

import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers

class KetoneClient {

    /**
     * @Mod.EventBusSubscriber( modid = Ketone.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value =
     *   [Dist.CLIENT] )
     */
    companion object {
        @SubscribeEvent fun onClientSetup(event: FMLClientSetupEvent) {}

        @SubscribeEvent fun registerRenderers(event: RegisterRenderers) {}
    }
}
