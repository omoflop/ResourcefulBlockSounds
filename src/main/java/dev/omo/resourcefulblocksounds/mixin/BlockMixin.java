package dev.omo.resourcefulblocksounds.mixin;

import dev.omo.resourcefulblocksounds.duck.BlockAccessor;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.BlockSoundGroup;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin implements BlockAccessor {

	@Unique @Nullable
	private BlockSoundGroup customSoundGroup;

	@Inject(method = "getSoundGroup", at = @At("HEAD"), cancellable = true)
	public void getSoundGroup(BlockState state, CallbackInfoReturnable<BlockSoundGroup> cir) {
		if (customSoundGroup != null) {
			cir.setReturnValue(customSoundGroup);
		}
	}

	@Override
	public void resourcefulBlockSounds$setBlockSoundGroup(BlockSoundGroup blockSoundGroup) {
		customSoundGroup = blockSoundGroup;
	}
}
