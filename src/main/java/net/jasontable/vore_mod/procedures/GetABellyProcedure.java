package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Entity;

import net.jasontable.vore_mod.init.VoreModModGameRules;
import net.jasontable.vore_mod.VoreModMod;

public class GetABellyProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double thex = 0;
		double thez = 0;
		if ((entity.getPersistentData().getString("bellyType")).equals("")) {
			thex = (Math.round(Math.random() * 100) - 50) * 48;
			thez = (Math.round(Math.random() * 100) - 50) * 48;
			if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
				VoreModMod.LOGGER.info("[Vore Mod] Your belly origin is X: " + thex + "Z: " + thez);
			}
			if (entity instanceof Shulker || entity instanceof FlyingMob || entity instanceof SkeletonHorse || entity instanceof AbstractGolem
					|| entity instanceof MagmaCube || entity instanceof Stray || entity instanceof Skeleton || entity instanceof Slime
					|| entity instanceof Bat || entity instanceof Bee || entity instanceof Creeper
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.WATER : false)
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.ARTHROPOD : false)) {
				entity.getPersistentData().putString("bellyType", "noeat");
				entity.getPersistentData().putBoolean("noEat", (true));
			} else if (entity instanceof Player) {
				entity.getPersistentData().putString("bellyType", "anthro");
			} else if (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.UNDEAD : false) {
				entity.getPersistentData().putString("bellyType", "rotten");
			} else if (entity instanceof Animal) {
				entity.getPersistentData().putString("bellyType", "animal");
			} else if (entity instanceof LivingEntity) {
				entity.getPersistentData().putString("bellyType", "anthro");
			} else {
				entity.getPersistentData().putString("bellyType", "noeat");
				entity.getPersistentData().putBoolean("noEat", (true));
			}
			if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
				VoreModMod.LOGGER.info(
						entity.getDisplayName().getString() + " got assigned belly name of " + entity.getPersistentData().getString("bellyType"));
			}
			if ((entity.getPersistentData().getString("bellyType")).equals("animal")) {
				entity.getPersistentData().putDouble("bellyX", (thex + 30));
				entity.getPersistentData().putDouble("bellyY", 17);
				entity.getPersistentData().putDouble("bellyZ", (thez + 10));
			} else if ((entity.getPersistentData().getString("bellyType")).equals("anthro")
					|| (entity.getPersistentData().getString("bellyType")).equals("rotten")) {
				entity.getPersistentData().putDouble("bellyX", (thex + 9));
				entity.getPersistentData().putDouble("bellyY", 23);
				entity.getPersistentData().putDouble("bellyZ", (thez + 10));
			}
			if ((entity.getDisplayName().getString()).equals("AV")) {
				entity.getPersistentData().putString("eatText", "[eatee] got shoved up [eater]'s ass");
			} else {
				entity.getPersistentData().putString("eatText", "[eatee] got eaten by [eater]");
			}
		}
	}
}
