package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModGameRules;
import net.jasontable.vore_mod.init.VoreModModBlocks;

public class BloodUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getFluidState().isSource() && world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.CLOTTING)) {
			world.setBlock(BlockPos.containing(x, y, z), VoreModModBlocks.SCAB.get().defaultBlockState(), 3);
		}
	}
}
