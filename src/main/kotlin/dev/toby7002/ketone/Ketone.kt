package dev.toby7002.ketone

import com.mojang.logging.LogUtils
import dev.toby7002.ketone.datagen.DataGen
import dev.toby7002.ketone.registry.BlockRegistry
import dev.toby7002.ketone.registry.ItemRegistry
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.level.block.entity.BlockEntityType
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

@Mod(Ketone.MOD_ID)
class Ketone(modEventBus: IEventBus) {
    companion object {
        const val MOD_ID: String = "ketone"
        val LOGGER = LogUtils.getLogger()
        val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(MOD_ID)
        val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(MOD_ID)
        val BLOCK_ENTITIES: DeferredRegister<BlockEntityType<*>> =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MOD_ID)
        val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID)

        val KETONE_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> =
            CREATIVE_MODE_TABS.register("ketone_tab") { ->
                CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.$MOD_ID"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon { ItemRegistry.GLASS_CUTTER.get().defaultInstance }
                    .displayItems { _: ItemDisplayParameters, output: CreativeModeTab.Output ->
                        ITEMS.entries.map { it.get() }.forEach(output::accept)
                        BLOCKS.entries.map { it.get() }.forEach(output::accept)
                    }
                    .build()
            }
    }

    init {
        modEventBus.addListener(this::commonSetup)
        modEventBus.addListener(DataGen::gatherData)
        BLOCKS.register(modEventBus)
        ITEMS.register(modEventBus)
        CREATIVE_MODE_TABS.register(modEventBus)
        BLOCK_ENTITIES.register(modEventBus)
        ItemRegistry.init()
        BlockRegistry.init()
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        LOGGER.info("It works!")
    }
}
