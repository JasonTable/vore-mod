package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.jasontable.vore_mod.init.VoreModModGameRules;
import net.jasontable.vore_mod.VoreModMod;

public class GetDimensionTPIDProcedure {
	public static String execute(LevelAccessor world) {
		String dimid = "";
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
			dimid = "minecraft:overworld";
		} else if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.NETHER) {
			dimid = "minecraft:the_nether";
		} else if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.END) {
			dimid = "minecraft:the_end";
		} else if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("vore_mod:belly")))) {
			dimid = "vore_mod:belly";
		} else {
			dimid = (("" + (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD)).replace("]", "")).replace("ResourceKey[minecraft:dimension / ", "");
		}
		if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
			VoreModMod.LOGGER.info((("" + (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD)).replace("]", "")).replace("ResourceKey[minecraft:dimension / ", ""));
		}
		return dimid;
	}
}
