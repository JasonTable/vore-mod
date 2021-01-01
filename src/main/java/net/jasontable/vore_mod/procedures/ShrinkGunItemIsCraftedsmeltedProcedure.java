package net.jasontable.vore_mod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.VoreModModVariables;
import net.jasontable.vore_mod.VoreModModElements;

import java.util.Map;

@VoreModModElements.ModElement.Tag
public class ShrinkGunItemIsCraftedsmeltedProcedure extends VoreModModElements.ModElement {
	public ShrinkGunItemIsCraftedsmeltedProcedure(VoreModModElements instance) {
		super(instance, 60);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ShrinkGunItemIsCraftedsmelted!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure ShrinkGunItemIsCraftedsmelted!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ShrinkGunItemIsCraftedsmelted!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ShrinkGunItemIsCraftedsmelted!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ShrinkGunItemIsCraftedsmelted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ShrinkGunItemIsCraftedsmelted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((VoreModModVariables.MapVariables.get(world).shrinkgunoff)) {
			((itemstack)).setCount((int) 0);
			for (int index0 = 0; index0 < (int) (6); index0++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Items.IRON_INGOT, (int) (1)));
					entityToSpawn.setPickupDelay((int) 1);
					world.addEntity(entityToSpawn);
				}
			}
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Items.DIAMOND, (int) (1)));
				entityToSpawn.setPickupDelay((int) 1);
				world.addEntity(entityToSpawn);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity)
						.sendStatusMessage(new StringTextComponent("Shrink guns are disabled on this server. Here are the items back."), (false));
			}
		}
	}
}
