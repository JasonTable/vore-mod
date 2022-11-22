package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class VDBSetBellyDestProcedure {
	public static void execute(LevelAccessor world, double x, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("bellyDest", (StringArgumentType.getString(arguments, "bellyname")));
		BellyPlayerEntersDimensionProcedure.execute(world, x, z, entity);
	}
}
