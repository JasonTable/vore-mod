package net.jasontable.vore_mod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModBlocks;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class BellyExitTriggerEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		double orgx = 0;
		double orgz = 0;
		double countmobb = 0;
		if ((world.getBlockState(new BlockPos(Math.floor(entity.getX()), Math.floor(entity.getY()), Math.floor(entity.getZ()))))
				.getBlock() == VoreModModBlocks.BELLY_EXIT_TRIGGER.get()) {
			orgx = Math.floor(x / 48) * 48;
			orgz = Math.floor(z / 48) * 48;
			if ((world.getBlockState(new BlockPos(orgx, 0, orgz))).getBlock() == VoreModModBlocks.BELLYORIGIN.get()) {
				if ((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world, new BlockPos(orgx, 0, orgz), "exitCMD")).equals("uneat")) {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true)
								.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof Player)) {
								entityiterator.getPersistentData().putDouble("eatCoolDown", 60);
								{
									Entity _ent = entityiterator;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												("execute in " + entity.getPersistentData().getString("exitDIM") + " run tp @s "
														+ entity.getPersistentData().getDouble("exitX") + " "
														+ entity.getPersistentData().getDouble("exitY") + " "
														+ entity.getPersistentData().getDouble("exitZ")));
								}
								if (!entityiterator.level.isClientSide())
									entityiterator.discard();
								countmobb = countmobb + 1;
							}
						}
					}
					if (countmobb > 0) {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(new TextComponent((countmobb + " mobs followed you")), (false));
					}
					entity.getPersistentData().putDouble("eatCoolDown", 60);
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null)
							_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
									("execute in " + entity.getPersistentData().getString("exitDIM") + " run tp @s "
											+ entity.getPersistentData().getDouble("exitX") + " " + entity.getPersistentData().getDouble("exitY")
											+ " " + entity.getPersistentData().getDouble("exitZ")));
					}
					countmobb = 0;
				} else {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true)
								.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof Player)) {
								entityiterator.getPersistentData().putDouble("eatCoolDown", 60);
								{
									Entity _ent = entityiterator;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), (new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getTileData().getString(tag);
														return "";
													}
												}.getValue(world, new BlockPos(orgx, 0, orgz), "exitCMD")));
								}
								if (!entityiterator.level.isClientSide())
									entityiterator.discard();
								countmobb = countmobb + 1;
							}
						}
					}
					if (countmobb > 0) {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(new TextComponent((Math.round(countmobb) + " mobs followed you")), (false));
					}
					entity.getPersistentData().putDouble("eatCoolDown", 60);
					{
						Entity _ent = entity;
						if (!_ent.level.isClientSide() && _ent.getServer() != null)
							_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
									(new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getTileData().getString(tag);
											return "";
										}
									}.getValue(world, new BlockPos(orgx, 0, orgz), "exitCMD")));
					}
					countmobb = 0;
				}
			}
		}
	}
}
