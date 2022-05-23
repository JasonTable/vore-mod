package net.jasontable.vore_mod.procedures;

import net.minecraft.world.entity.Entity;

import net.jasontable.vore_mod.VoreModMod;

public class ChangeToAVProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double thex = 0;
		double thez = 0;
		thex = Math.floor(entity.getPersistentData().getDouble("bellyX") / 48) * 48;
		thez = Math.floor(entity.getPersistentData().getDouble("bellyZ") / 48) * 48;
		VoreModMod.LOGGER.info("[Vore Mod] Your belly origin is X: " + thex + "Z: " + thez);
		if ((entity.getPersistentData().getString("bellyType")).equals("animal")) {
			entity.getPersistentData().putDouble("bellyX", (thex + 4));
			entity.getPersistentData().putDouble("bellyY", 14);
			entity.getPersistentData().putDouble("bellyZ", (thez + 10));
		} else if ((entity.getPersistentData().getString("bellyType")).equals("anthro")
				|| (entity.getPersistentData().getString("bellyType")).equals("rotten")) {
			entity.getPersistentData().putDouble("bellyX", (thex + 16));
			entity.getPersistentData().putDouble("bellyY", 3);
			entity.getPersistentData().putDouble("bellyZ", (thez + 10));
		}
		entity.getPersistentData().putString("eatText", "[eatee] got shoved up [eater]'s ass");
	}
}
