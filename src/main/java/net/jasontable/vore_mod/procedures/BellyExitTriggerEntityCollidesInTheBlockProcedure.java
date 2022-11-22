package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModBlocks;

public class BellyExitTriggerEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double orgx = 0;
		double orgz = 0;
		double countmobb = 0;
		String exitCommandThiny = "";
		if ((world.getBlockState(new BlockPos(Math.floor(entity.getX()), Math.floor(entity.getY()), Math.floor(entity.getZ()))))
				.getBlock() == VoreModModBlocks.BELLY_EXIT_TRIGGER.get() || entity.getY() < 0) {
			ExitBellyProcedure.execute(world, entity);
		}
	}
}
