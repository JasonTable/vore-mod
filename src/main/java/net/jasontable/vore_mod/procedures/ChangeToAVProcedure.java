package net.jasontable.vore_mod.procedures;

import net.minecraft.world.entity.Entity;

public class ChangeToAVProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double thex = 0;
		double thez = 0;
		if (entity.getPersistentData().getBoolean("noEat")) {
			return false;
		} else if ((entity.getPersistentData().getString("bellyType")).equals("animal")
				|| (entity.getPersistentData().getString("bellyType")).equals("rotten_animal")) {
			entity.getPersistentData().putDouble("bellyOffsetX", 4);
			entity.getPersistentData().putDouble("bellyOffsetY", 14);
			entity.getPersistentData().putDouble("bellyOffsetZ", 10);
			entity.getPersistentData().putString("eatText", "[prey] got shoved up [pred]'s ass");
			return true;
		} else if ((entity.getPersistentData().getString("bellyType")).equals("anthro")
				|| (entity.getPersistentData().getString("bellyType")).equals("rotten")) {
			entity.getPersistentData().putDouble("bellyOffsetX", 16);
			entity.getPersistentData().putDouble("bellyOffsetY", 3);
			entity.getPersistentData().putDouble("bellyOffsetZ", 10);
			entity.getPersistentData().putString("eatText", "[prey] got shoved up [pred]'s ass");
			return true;
		}
		return false;
	}
}
