package net.jasontable.vore_mod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModItems;
import net.jasontable.vore_mod.init.VoreModModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DropFleshProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == VoreModModBlocks.ACID.get() && entity instanceof Player) {
			if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("vore_mod:belly"))) && !(entity.getPersistentData().getString("eatenBy")).equals("")) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " got digested by " + entity.getPersistentData().getString("eatenBy"))), false);
			} else {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " got digested")), false);
			}
		} else if (Math.random() < 0.3 && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:stomach_animal")))) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(VoreModModItems.FLESH.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (!(entity.getPersistentData().getString("bellyType")).equals("")) {
			DestroyBellyProcedure.execute(world, (entity.getPersistentData().getDouble("bellyOriginX")), 0, (entity.getPersistentData().getDouble("bellyOriginZ")));
		}
	}
}
