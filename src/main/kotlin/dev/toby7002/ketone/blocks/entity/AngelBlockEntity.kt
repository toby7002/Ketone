package dev.toby7002.ketone.blocks.entity

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import software.bernie.geckolib.animatable.GeoBlockEntity
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.core.animation.RawAnimation
import software.bernie.geckolib.core.`object`.PlayState
import software.bernie.geckolib.util.GeckoLibUtil
import software.bernie.geckolib.util.RenderUtils


class AngelBlockEntity(pPos: BlockPos, pBlockState: BlockState) : BlockEntity(
    KBlockEntities.ANGEL_BLOCK_ENTITY.get(), pPos,
    pBlockState
), GeoBlockEntity {
    companion object {
        val IDLE: RawAnimation = RawAnimation.begin().thenLoop("animation.angel_block.idle")
    }

    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    override fun registerControllers(p0: AnimatableManager.ControllerRegistrar) {
       p0.add(AnimationController(this, this::idleAnimationController))
    }

    private fun idleAnimationController(state: AnimationState<AngelBlockEntity>): PlayState {
        return state.setAndContinue(IDLE)
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return cache
    }

    override fun getTick(blockEntity: Any): Double {
        return RenderUtils.getCurrentTick()
    }
}