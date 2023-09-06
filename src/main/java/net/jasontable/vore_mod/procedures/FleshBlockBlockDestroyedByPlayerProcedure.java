package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModBlocks;

public class FleshBlockBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(Enchantments.FIRE_ASPECT) > 0)) {
			world.setBlock(BlockPos.containing(x, y, z), VoreModModBlocks.BLOOD.get().defaultBlockState(), 3);
		}
	}
}
