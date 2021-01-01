package net.jasontable.vore_mod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.VoreModModElements;

import java.util.Map;

@VoreModModElements.ModElement.Tag
public class AcidMobplayerCollidesBlockProcedure extends VoreModModElements.ModElement {
	public AcidMobplayerCollidesBlockProcedure(VoreModModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AcidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
	}
}
