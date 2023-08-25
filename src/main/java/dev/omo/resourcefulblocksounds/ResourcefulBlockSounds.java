package dev.omo.resourcefulblocksounds;

import dev.omo.resourcefulblocksounds.loading.RBSResourceLoader;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourcefulBlockSounds implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Resourceful Block Sounds");
	public static Identifier getId(String path) {
		return new Identifier("resourceful_block_sounds", path);
	}

	@Override
	public void onInitialize() {
		ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new RBSResourceLoader());
	}
}
