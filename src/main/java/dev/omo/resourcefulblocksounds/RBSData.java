package dev.omo.resourcefulblocksounds;

import dev.omo.resourcefulblocksounds.duck.BlockAccessor;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class RBSData {
	public static final Map<Identifier, BlockSoundGroup> customSoundGroups = new HashMap<>();

	public static void clear() {
		for (Field field : BlockSoundGroup.class.getFields()) {
			try {
				if (field.getType() == BlockSoundGroup.class && field.get(null) instanceof BlockSoundGroup soundGroup) {
					customSoundGroups.put(new Identifier("minecraft", field.getName().toLowerCase()), soundGroup);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		customSoundGroups.clear();
		for (Block block : Registries.BLOCK) {
			((BlockAccessor)block).resourcefulBlockSounds$setBlockSoundGroup(null);
		}
	}
}
