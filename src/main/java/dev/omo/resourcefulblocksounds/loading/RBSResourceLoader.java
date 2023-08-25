package dev.omo.resourcefulblocksounds.loading;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.omo.resourcefulblocksounds.RBSData;
import dev.omo.resourcefulblocksounds.ResourcefulBlockSounds;
import dev.omo.resourcefulblocksounds.duck.BlockAccessor;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.util.Map;

import static dev.omo.resourcefulblocksounds.ResourcefulBlockSounds.getId;

public class RBSResourceLoader implements SimpleSynchronousResourceReloadListener {
	@Override
	public Identifier getFabricId() {
		return getId("resourceloader");
	}

	@Override
	public void reload(ResourceManager manager) {
		RBSData.clear();
		Map<Identifier, Resource> groups = manager.findResources("rbs/groups", id -> id.getPath().endsWith(".json"));
		for (Identifier id : groups.keySet()) {
			try {
				String path = id.getPath();
				Identifier groupId = new Identifier(id.getNamespace(), path.substring(11, path.length()-5));
				ResourcefulBlockSounds.LOGGER.info(groupId.toString());
				JsonObject json = JsonParser.parseReader(groups.get(id).getReader()).getAsJsonObject();

				float pitch = json.get("pitch").getAsFloat();
				float volume = json.get("volume").getAsFloat();
				String breakSound = json.get("break").getAsString();
				String stepSound = json.get("step").getAsString();
				String placeSound = json.get("place").getAsString();
				String hitSound = json.get("hit").getAsString();
				String fallSound = json.get("fall").getAsString();

				BlockSoundGroup soundGroup = new BlockSoundGroup(pitch, volume, SoundEvent.of(new Identifier(breakSound)), SoundEvent.of(new Identifier(stepSound)), SoundEvent.of(new Identifier(placeSound)), SoundEvent.of(new Identifier(hitSound)), SoundEvent.of(new Identifier(fallSound)));
				RBSData.customSoundGroups.put(groupId, soundGroup);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		Map<Identifier, Resource> lists = manager.findResources("rbs/lists", id -> id.getPath().endsWith(".json"));
		for (Identifier id : lists.keySet()) {
			try {
				JsonObject json = JsonParser.parseReader(lists.get(id).getReader()).getAsJsonObject();
				Identifier soundGroup = new Identifier(json.get("group").getAsString());
				BlockSoundGroup group = RBSData.customSoundGroups.get(soundGroup);
				JsonArray blockIds = json.getAsJsonArray("blocks");
				for (JsonElement element : blockIds) {
					Identifier blockId = new Identifier(element.getAsString());
					Block b = Registries.BLOCK.get(blockId);
					((BlockAccessor)b).resourcefulBlockSounds$setBlockSoundGroup(group);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
