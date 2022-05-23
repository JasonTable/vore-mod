package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

public class GetDimensionTPIDProcedure {
	public static String execute(LevelAccessor world) {
		String dimid = "";
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (Level.OVERWORLD)) {
			dimid = "minecraft:overworld";
		} else if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (Level.NETHER)) {
			dimid = "minecraft:the_nether";
		} else if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (Level.END)) {
			dimid = "minecraft:the_end";
		} else if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
				new ResourceLocation("vore_mod:belly")))) {
			dimid = "vore_mod:belly";
		} else {
			dimid = (("" + (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD)).replace("]", ""))
					.replace("ResourceKey[minecraft:dimension / ", "");
		}
		return dimid;
	}
}
