package net.jasontable.vore_mod.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import net.jasontable.vore_mod.VoreModMod;

import java.util.Map;

public class GetABellyProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure GetABelly!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double thex = 0;
		double thez = 0;
		if ((((entity.getPersistentData().getString("bellyType"))).equals(""))) {
			thex = (double) ((Math.round((Math.random() * 100)) - 50) * 48);
			thez = (double) ((Math.round((Math.random() * 100)) - 50) * 48);
			System.out.println((("[Vore Mod] Your belly origin is X: ") + "" + (thex) + "" + ("Z: ") + "" + (thez)));
			if ((((((entity instanceof ShulkerEntity) || (entity instanceof FlyingEntity))
					|| ((entity instanceof SkeletonHorseEntity) || (entity instanceof GolemEntity)))
					|| (((entity instanceof MagmaCubeEntity) || (entity instanceof StrayEntity))
							|| ((entity instanceof SkeletonEntity) || (entity instanceof SlimeEntity))))
					|| ((((entity instanceof BatEntity) || (entity instanceof BeeEntity)) || (entity instanceof CreeperEntity))
							|| ((entity instanceof LivingEntity ? (((LivingEntity) entity).getCreatureAttribute() == CreatureAttribute.WATER) : false)
									|| (entity instanceof LivingEntity
											? (((LivingEntity) entity).getCreatureAttribute() == CreatureAttribute.ARTHROPOD)
											: false))))) {
				entity.getPersistentData().putString("bellyType", "noeat");
				entity.getPersistentData().putBoolean("noEat", (true));
			} else if ((entity instanceof PlayerEntity)) {
				entity.getPersistentData().putString("bellyType", "anthro");
			} else if ((entity instanceof LivingEntity ? (((LivingEntity) entity).getCreatureAttribute() == CreatureAttribute.UNDEAD) : false)) {
				entity.getPersistentData().putString("bellyType", "rotten");
			} else if ((entity instanceof AnimalEntity)) {
				entity.getPersistentData().putString("bellyType", "animal");
			} else if ((entity instanceof LivingEntity)) {
				entity.getPersistentData().putString("bellyType", "anthro");
			} else {
				entity.getPersistentData().putString("bellyType", "noeat");
				entity.getPersistentData().putBoolean("noEat", (true));
			}
			System.out.println((((entity.getDisplayName().getString())) + "" + (" got assigned belly name of ") + ""
					+ ((entity.getPersistentData().getString("bellyType")))));
			if ((((entity.getPersistentData().getString("bellyType"))).equals("animal"))) {
				entity.getPersistentData().putDouble("bellyX", (thex + 30));
				entity.getPersistentData().putDouble("bellyY", 17);
				entity.getPersistentData().putDouble("bellyZ", (thez + 10));
			} else if (((((entity.getPersistentData().getString("bellyType"))).equals("anthro"))
					|| (((entity.getPersistentData().getString("bellyType"))).equals("rotten")))) {
				entity.getPersistentData().putDouble("bellyX", (thex + 9));
				entity.getPersistentData().putDouble("bellyY", 23);
				entity.getPersistentData().putDouble("bellyZ", (thez + 10));
			}
			if ((((entity.getDisplayName().getString())).equals("AV"))) {
				entity.getPersistentData().putString("eatText", "[eatee] got shoved up [eater]'s ass");
			} else {
				entity.getPersistentData().putString("eatText", "[eatee] got eaten by [eater]");
			}
		}
	}
}
