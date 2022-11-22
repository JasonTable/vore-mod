package net.jasontable.vore_mod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.jasontable.vore_mod.init.VoreModModItems;
import net.jasontable.vore_mod.init.VoreModModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MobSpawnGiveGunProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		GetABellyProcedure.execute(world, entity);
		if (!world.isClientSide() && world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.SHRINKGUNMOBUSE)
				&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (Level.OVERWORLD)
				&& (entity.getPersistentData().getString("bellyType")).equals("")
				&& (entity instanceof Fox && Math.random() < 0.1 || entity instanceof Zombie && Math.random() < 0.05)) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(VoreModModItems.SHRINK_GUN.get());
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (entity instanceof Fox) {
				if (Math.random() < 0.5) {
					entity.setCustomName(Component.literal("Adam the Fox"));
				} else {
					entity.setCustomName(Component.literal("Jason the Fox"));
					ChangeToAVProcedure.execute(entity);
				}
			}
		}
		if (entity.getPersistentData().getDouble("voreID") == 0) {
			entity.getPersistentData().putDouble("voreID", (Math.random() * 1000000000));
		}
	}
}
