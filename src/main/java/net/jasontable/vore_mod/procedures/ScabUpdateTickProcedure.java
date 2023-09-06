package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModBlocks;

public class ScabUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("vore_mod:belly")))) {
			world.setBlock(BlockPos.containing(x, y, z), VoreModModBlocks.FLESHBLOCK.get().defaultBlockState(), 3);
		}
	}
}
