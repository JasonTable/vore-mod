package net.jasontable.vore_mod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModBlocks;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class DestroyBellyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("vore_mod:belly")));
			if (world != null) {
				{
					final Vec3 _center = new Vec3((x + 24), (y + 24), (z + 24));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream()
							.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(new TextComponent("The creature you were inside of has died."), (false));
						if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == VoreModModBlocks.BELLYORIGIN.get()) {
							if ((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos(x, y, z), "exitCMD")).equals("uneat")) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level.isClientSide() && _ent.getServer() != null)
										_ent.getServer().getCommands().performCommand(
												_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
												("execute in "
														+ (("" + entity.level.dimension()).replace("]", ""))
																.replace("ResourceKey[minecraft:dimension / ", "")
														+ " run tp @s " + entity.getX() + " " + entity.getY() + " " + entity.getZ()));
								}
							} else {
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
												}.getValue(world, new BlockPos(x, y, z), "exitCMD")));
								}
							}
						}
						if (!(entityiterator instanceof Player)) {
							if (!entityiterator.level.isClientSide())
								entityiterator.discard();
						}
					}
				}
			}
			world = _worldorig;
		}
	}
}
