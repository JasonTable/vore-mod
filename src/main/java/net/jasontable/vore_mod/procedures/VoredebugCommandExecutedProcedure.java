package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Registry;

import net.jasontable.vore_mod.init.VoreModModGameRules;

import java.util.HashMap;

public class VoredebugCommandExecutedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		double xx = 0;
		double ix = 0;
		double iy = 0;
		double iz = 0;
		double zz = 0;
		double thex = 0;
		double thez = 0;
		if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("placebelly")) {
			if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
					new ResourceLocation("vore_mod:belly")))) {
				entity.getPersistentData().putString("bellyDest", (cmdparams.containsKey("1") ? cmdparams.get("1").toString() : ""));
				BellyPlayerEntersDimensionProcedure.execute(world, x, z, entity);
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("You must be in the belly dimension to do this."), (false));
			}
		} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("destroy")) {
			DestroyBellyProcedure.execute(world, (Math.floor(x / 48) * 48), 0, (Math.floor(z / 48) * 48), entity);
		} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("gun")) {
			if (world instanceof Level _level)
				_level.getGameRules().getRule(VoreModModGameRules.SHRINKGUNALLOWED)
						.set((!world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.SHRINKGUNALLOWED)), _level.getServer());
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(
						("Shrink gun use is now set to " + world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.SHRINKGUNALLOWED))),
						(false));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Usage: /voredebug <command>"), (false));
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Vore debug commands:"), (false));
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("placebelly [name] - places belly in the belly dimension"), (false));
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("gun - toggles the use of shrink guns in this world/server"), (false));
		}
	}
}
