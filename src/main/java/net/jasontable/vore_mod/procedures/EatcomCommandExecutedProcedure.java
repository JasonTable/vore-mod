package net.jasontable.vore_mod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.Util;

import java.util.HashMap;

public class EatcomCommandExecutedProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		if (entity.hasPermissions(3)) {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent(
							(entity.getDisplayName().getString() + " used eat " + (cmdparams.containsKey("0") ? cmdparams.get("0").toString() : ""))),
							ChatType.SYSTEM, Util.NIL_UUID);
			}
			entity.getPersistentData().putString("bellyDest", (cmdparams.containsKey("0") ? cmdparams.get("0").toString() : ""));
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null)
					_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
							"execute in vore_mod:belly run tp @s ~ ~ ~");
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("This is a debug command for OPs only."), (false));
		}
	}
}
