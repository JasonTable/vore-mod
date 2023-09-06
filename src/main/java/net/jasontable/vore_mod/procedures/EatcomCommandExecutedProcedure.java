package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.HashMap;

public class EatcomCommandExecutedProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		if (entity.hasPermissions(3)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " used eat " + (cmdparams.containsKey("0") ? cmdparams.get("0").toString() : ""))), false);
			entity.getPersistentData().putString("bellyDest", (cmdparams.containsKey("0") ? cmdparams.get("0").toString() : ""));
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute in vore_mod:belly run tp @s ~ ~ ~");
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("This is a debug command for OPs only."), false);
		}
	}
}
