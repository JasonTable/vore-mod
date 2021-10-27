package net.jasontable.vore_mod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.world.ShrinkGunMobUseGameRule;
import net.jasontable.vore_mod.item.ShrinkGunItem;
import net.jasontable.vore_mod.VoreModMod;

import java.util.Map;
import java.util.HashMap;

public class MobSpawnGiveGunProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntitySpawned(EntityJoinWorldEvent event) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure MobSpawnGiveGun!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VoreModMod.LOGGER.warn("Failed to load dependency world for procedure MobSpawnGiveGun!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((!(world.isRemote())) && (world.getWorldInfo().getGameRulesInstance().getBoolean(ShrinkGunMobUseGameRule.gamerule)))
				&& (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.OVERWORLD))
						&& (((entity.getPersistentData().getString("bellyType"))).equals(""))))
				&& (((entity instanceof FoxEntity) && (Math.random() < 0.1)) || ((entity instanceof ZombieEntity) && (Math.random() < 0.05))))) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(ShrinkGunItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			if ((entity instanceof FoxEntity)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					GetABellyProcedure.executeProcedure($_dependencies);
				}
				if ((Math.random() < 0.5)) {
					entity.setCustomName(new StringTextComponent("Adam the Fox"));
				} else {
					entity.setCustomName(new StringTextComponent("Jason the Fox"));
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						ChangeToAVProcedure.executeProcedure($_dependencies);
					}
				}
			}
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			GetABellyProcedure.executeProcedure($_dependencies);
		}
		if (((entity.getPersistentData().getDouble("voreID")) == 0)) {
			entity.getPersistentData().putDouble("voreID", (Math.random() * 1000000000));
		}
	}
}
