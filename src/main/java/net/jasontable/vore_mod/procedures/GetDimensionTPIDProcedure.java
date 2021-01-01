package net.jasontable.vore_mod.procedures;

import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.world.dimension.BellyDimension;
import net.jasontable.vore_mod.VoreModModElements;
import net.jasontable.vore_mod.VoreModMod;

import java.util.Map;

@VoreModModElements.ModElement.Tag
public class GetDimensionTPIDProcedure extends VoreModModElements.ModElement {
	public GetDimensionTPIDProcedure(VoreModModElements instance) {
		super(instance, 42);
	}

	public static String executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure GetDimensionTPID!");
			return "";
		}
		Entity entity = (Entity) dependencies.get("entity");
		String dimid = "";
		if (((entity.dimension.getId()) == (0))) {
			dimid = (String) "minecraft:overworld";
		} else if (((entity.dimension.getId()) == (-1))) {
			dimid = (String) "minecraft:the_nether";
		} else if (((entity.dimension.getId()) == (1))) {
			dimid = (String) "minecraft:the_end";
		} else if (((entity.dimension.getId()) == (BellyDimension.type.getId()))) {
			dimid = (String) "vore_mod:belly";
		} else {
			dimid = (String) "error";
			VoreModMod.LOGGER.error("[Vore Mod] Error: unknown dimension");
		}
		return (dimid);
	}
}
