package dev.toby7002.ketone.items

import dev.toby7002.ketone.KBlocks
import dev.toby7002.ketone.client.renderers.AngelBlockItemRenderer
import java.util.function.Consumer
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.animatable.SingletonGeoAnimatable
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.core.animation.RawAnimation
import software.bernie.geckolib.core.`object`.PlayState
import software.bernie.geckolib.util.GeckoLibUtil
import software.bernie.geckolib.util.RenderUtils

class AngelBlockItem : BlockItem(KBlocks.ANGEL_BLOCK.get(), Properties()), GeoItem {
    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    companion object {
        val IDLE: RawAnimation = RawAnimation.begin().thenLoop("animation.angel_block.idle")
    }

    init {
        SingletonGeoAnimatable.registerSyncedAnimatable(this)
    }

    private fun idleAnimationController(state: AnimationState<AngelBlockItem>): PlayState {
        return state.setAndContinue(IDLE)
    }

    override fun use(
        level: Level,
        player: Player,
        pUsedHand: InteractionHand
    ): InteractionResultHolder<ItemStack> {
        val pos = BlockPos(player.x.toInt(), (player.y - 1).toInt(), player.z.toInt())

        if (level.getBlockState(pos).`is`(net.minecraft.world.level.block.Blocks.AIR)) {
            level.setBlock(pos, KBlocks.ANGEL_BLOCK.get().defaultBlockState(), 3)
            if (!player.isCreative) {
                player.mainHandItem.shrink(1)
            }
        }
        return InteractionResultHolder(InteractionResult.PASS, player.mainHandItem)
    }

    override fun registerControllers(p0: AnimatableManager.ControllerRegistrar) {
        p0.add(AnimationController(this, this::idleAnimationController))
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return cache
    }

    override fun getTick(itemStack: Any?): Double {
        return RenderUtils.getCurrentTick()
    }

    override fun initializeClient(consumer: Consumer<IClientItemExtensions>) {
        consumer.accept(
            object : IClientItemExtensions {
                private var renderer: AngelBlockItemRenderer? = null
                val itemStackRenderer: BlockEntityWithoutLevelRenderer?
                    get() {
                        if (this.renderer == null) this.renderer = AngelBlockItemRenderer()

                        return renderer
                    }
            }
        )
    }
}
