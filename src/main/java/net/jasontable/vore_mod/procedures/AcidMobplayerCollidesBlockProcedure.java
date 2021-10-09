package net.jasontable.vore_mod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.VoreModMod;

import java.util.Map;

public class AcidMobplayerCollidesBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure AcidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
	}
}
