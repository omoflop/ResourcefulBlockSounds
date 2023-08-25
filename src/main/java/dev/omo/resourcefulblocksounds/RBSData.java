package dev.omo.resourcefulblocksounds;

import dev.omo.resourcefulblocksounds.duck.BlockAccessor;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public final class RBSData {
	public static final Map<Identifier, BlockSoundGroup> customSoundGroups = new HashMap<>();

	public static void clear() {
		customSoundGroups.clear();
		for (Block block : Registries.BLOCK) {
			((BlockAccessor)block).resourcefulBlockSounds$setBlockSoundGroup(null);
		}
	}
}
