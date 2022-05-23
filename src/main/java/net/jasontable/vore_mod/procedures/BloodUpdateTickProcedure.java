package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModBlocks;

public class BloodUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getFluidState().isSource()) {
			world.setBlock(new BlockPos(x, y, z), VoreModModBlocks.SCAB.get().defaultBlockState(), 3);
		}
	}
}
