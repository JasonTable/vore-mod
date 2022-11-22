package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.jasontable.vore_mod.init.VoreModModGameRules;
import net.jasontable.vore_mod.VoreModMod;

public class GetABellyProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double thex = 0;
		double thez = 0;
		if (!entity.getPersistentData().getBoolean("voreSetup")) {
			entity.getPersistentData().putBoolean("voreSetup", (true));
			thex = (Math.round(Math.random() * 100) - 50) * 48;
			thez = (Math.round(Math.random() * 100) - 50) * 48;
			entity.getPersistentData().putDouble("bellyOriginX", thex);
			entity.getPersistentData().putDouble("bellyOriginZ", thez);
			if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
				VoreModMod.LOGGER.info("[Vore Mod] Your belly origin is X: " + thex + "Z: " + thez);
			}
			if ((entity.getPersistentData().getString("bellyType")).isEmpty()) {
				if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:stomach_noeat")))) {
					entity.getPersistentData().putString("bellyType", "noeat");
					entity.getPersistentData().putBoolean("noEat", (true));
				} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:stomach_animal")))) {
					entity.getPersistentData().putString("bellyType", "animal");
				} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:stomach_anthro")))
						|| entity instanceof Player) {
					entity.getPersistentData().putString("bellyType", "anthro");
				} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:stomach_rotten")))) {
					entity.getPersistentData().putString("bellyType", "rotten");
				} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:stomach_rotten_animal")))) {
					entity.getPersistentData().putString("bellyType", "rotten_animal");
				} else {
					entity.getPersistentData().putString("bellyType", "noeat");
					entity.getPersistentData().putBoolean("noEat", (true));
				}
				if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
					VoreModMod.LOGGER.info(
							entity.getDisplayName().getString() + " got assigned belly name of " + entity.getPersistentData().getString("bellyType"));
				}
				if ((entity.getPersistentData().getString("bellyType")).equals("animal")
						|| (entity.getPersistentData().getString("bellyType")).equals("rotten_animal")) {
					entity.getPersistentData().putDouble("bellyOffsetX", 30);
					entity.getPersistentData().putDouble("bellyOffsetY", 17);
					entity.getPersistentData().putDouble("bellyOffsetZ", 10);
				} else if ((entity.getPersistentData().getString("bellyType")).equals("anthro")
						|| (entity.getPersistentData().getString("bellyType")).equals("rotten")) {
					entity.getPersistentData().putDouble("bellyOffsetX", 9);
					entity.getPersistentData().putDouble("bellyOffsetY", 23);
					entity.getPersistentData().putDouble("bellyOffsetZ", 10);
				}
				entity.getPersistentData().putString("eatText", "[prey] got eaten by [pred]");
				entity.getPersistentData().putString("predExitCMD", "uneat");
			}
		}
	}
}
