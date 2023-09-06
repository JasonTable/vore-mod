package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.jasontable.vore_mod.init.VoreModModGameRules;

public class ShrinkGunItemIsCraftedsmeltedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.SHRINKGUNALLOWED)) {
			itemstack.setCount(0);
			for (int index0 = 0; index0 < 6; index0++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.IRON_INGOT));
					entityToSpawn.setPickUpDelay(1);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.NETHER_STAR));
				entityToSpawn.setPickUpDelay(1);
				_level.addFreshEntity(entityToSpawn);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Shrink guns are disabled on this server. Here are the items back."), false);
		}
	}
}
