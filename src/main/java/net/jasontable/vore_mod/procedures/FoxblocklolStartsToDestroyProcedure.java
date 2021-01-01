package net.jasontable.vore_mod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.VoreModModElements;

import java.util.Map;

@VoreModModElements.ModElement.Tag
public class FoxblocklolStartsToDestroyProcedure extends VoreModModElements.ModElement {
	public FoxblocklolStartsToDestroyProcedure(VoreModModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FoxblocklolStartsToDestroy!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("<Fox> Nooooo what are ya doing!?!?"), (false));
		}
	}
}
