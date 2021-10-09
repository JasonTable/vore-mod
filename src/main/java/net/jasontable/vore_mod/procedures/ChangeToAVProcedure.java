package net.jasontable.vore_mod.procedures;

import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.VoreModMod;

import java.util.Map;

public class ChangeToAVProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure ChangeToAV!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double thex = 0;
		double thez = 0;
		thex = (double) (Math.floor(((entity.getPersistentData().getDouble("bellyX")) / 48)) * 48);
		thez = (double) (Math.floor(((entity.getPersistentData().getDouble("bellyZ")) / 48)) * 48);
		System.out.println((("[Vore Mod] Your belly origin is X: ") + "" + (thex) + "" + ("Z: ") + "" + (thez)));
		if ((((entity.getPersistentData().getString("bellyType"))).equals("animal"))) {
			entity.getPersistentData().putDouble("bellyX", (thex + 4));
			entity.getPersistentData().putDouble("bellyY", 14);
			entity.getPersistentData().putDouble("bellyZ", (thez + 10));
		} else if (((((entity.getPersistentData().getString("bellyType"))).equals("anthro"))
				|| (((entity.getPersistentData().getString("bellyType"))).equals("rotten")))) {
			entity.getPersistentData().putDouble("bellyX", (thex + 16));
			entity.getPersistentData().putDouble("bellyY", 3);
			entity.getPersistentData().putDouble("bellyZ", (thez + 10));
		}
		entity.getPersistentData().putString("eatText", "[eatee] got shoved up [eater]'s ass");
	}
}
