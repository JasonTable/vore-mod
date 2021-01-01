package net.jasontable.vore_mod.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.VoreModModElements;

import java.util.Map;
import java.util.HashMap;

@VoreModModElements.ModElement.Tag
public class EatcomCommandExecutedProcedure extends VoreModModElements.ModElement {
	public EatcomCommandExecutedProcedure(VoreModModElements instance) {
		super(instance, 48);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EatcomCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				System.err.println("Failed to load dependency cmdparams for procedure EatcomCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		if ((entity.hasPermissionLevel((int) 3))) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(
							new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" used eat ") + "" + ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())))));
			}
			entity.getPersistentData().putString("bellyDest", (new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"execute in vore_mod:belly run tp @s ~ ~ ~");
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("This is a debug command for OPs only."), (false));
			}
		}
	}
}
