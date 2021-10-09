package net.jasontable.vore_mod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;

import net.jasontable.vore_mod.VoreModMod;

import java.util.Map;

public class GetDimensionTPIDProcedure {
	public static String executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VoreModMod.LOGGER.warn("Failed to load dependency world for procedure GetDimensionTPID!");
			return "";
		}
		IWorld world = (IWorld) dependencies.get("world");
		String dimid = "";
		if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD))) {
			dimid = (String) "minecraft:overworld";
		} else if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.THE_NETHER))) {
			dimid = (String) "minecraft:the_nether";
		} else if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.THE_END))) {
			dimid = (String) "minecraft:the_end";
		} else if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey
				.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("vore_mod:belly"))))) {
			dimid = (String) "vore_mod:belly";
		} else {
			dimid = (String) ((("" + ((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD))).replace("]", ""))
					.replace("ResourceKey[minecraft:dimension / ", ""));
		}
		return dimid;
	}
}
