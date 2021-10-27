package net.jasontable.vore_mod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.world.ShrinkGunAllowedGameRule;
import net.jasontable.vore_mod.VoreModMod;

import java.util.Map;
import java.util.HashMap;

public class VoredebugCommandExecutedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure VoredebugCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				VoreModMod.LOGGER.warn("Failed to load dependency cmdparams for procedure VoredebugCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				VoreModMod.LOGGER.warn("Failed to load dependency x for procedure VoredebugCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				VoreModMod.LOGGER.warn("Failed to load dependency y for procedure VoredebugCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				VoreModMod.LOGGER.warn("Failed to load dependency z for procedure VoredebugCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VoreModMod.LOGGER.warn("Failed to load dependency world for procedure VoredebugCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double xx = 0;
		double ix = 0;
		double iy = 0;
		double iz = 0;
		double zz = 0;
		double thex = 0;
		double thez = 0;
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("placebelly"))) {
			if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
					new ResourceLocation("vore_mod:belly"))))) {
				entity.getPersistentData().putString("bellyDest", (new Object() {
					public String getText() {
						String param = (String) cmdparams.get("1");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()));
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					BellyPlayerEntersDimensionProcedure.executeProcedure($_dependencies);
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You must be in the belly dimension to do this."), (false));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("destroy"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (Math.floor((x / 48)) * 48));
				$_dependencies.put("y", 0);
				$_dependencies.put("z", (Math.floor((z / 48)) * 48));
				DestroyBellyProcedure.executeProcedure($_dependencies);
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("gun"))) {
			if (world instanceof World) {
				((World) world).getGameRules().get(ShrinkGunAllowedGameRule.gamerule).set(
						(!(world.getWorldInfo().getGameRulesInstance().getBoolean(ShrinkGunAllowedGameRule.gamerule))), ((World) world).getServer());
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Shrink gun use is now set to ") + ""
						+ ((world.getWorldInfo().getGameRulesInstance().getBoolean(ShrinkGunAllowedGameRule.gamerule))))), (false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Usage: /voredebug <command>"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Vore debug commands:"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("placebelly [name] - places belly in the belly dimension"),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("gun - toggles the use of shrink guns in this world/server"),
						(false));
			}
		}
	}
}
