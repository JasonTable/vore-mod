package net.jasontable.vore_mod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.block.BellyoriginBlock;
import net.jasontable.vore_mod.block.BellyExitTriggerBlock;
import net.jasontable.vore_mod.VoreModMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class BellyExitTriggerEntityCollidesInTheBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure BellyExitTriggerEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				VoreModMod.LOGGER.warn("Failed to load dependency x for procedure BellyExitTriggerEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				VoreModMod.LOGGER.warn("Failed to load dependency z for procedure BellyExitTriggerEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VoreModMod.LOGGER.warn("Failed to load dependency world for procedure BellyExitTriggerEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double orgx = 0;
		double orgz = 0;
		double countmobb = 0;
		if (((world.getBlockState(
				new BlockPos((int) Math.floor((entity.getPosX())), (int) Math.floor((entity.getPosY())), (int) Math.floor((entity.getPosZ())))))
						.getBlock() == BellyExitTriggerBlock.block)) {
			orgx = (double) (Math.floor((x / 48)) * 48);
			orgz = (double) (Math.floor((z / 48)) * 48);
			if (((world.getBlockState(new BlockPos((int) orgx, (int) 0, (int) orgz))).getBlock() == BellyoriginBlock.block)) {
				if ((((new Object() {
					public String getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world, new BlockPos((int) orgx, (int) 0, (int) orgz), "exitCMD"))).equals("uneat"))) {
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB((entity.getPosX()) - (5 / 2d), (entity.getPosY()) - (5 / 2d), (entity.getPosZ()) - (5 / 2d),
												(entity.getPosX()) + (5 / 2d), (entity.getPosY()) + (5 / 2d), (entity.getPosZ()) + (5 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if ((!(entityiterator instanceof PlayerEntity))) {
								entityiterator.getPersistentData().putDouble("eatCoolDown", 60);
								{
									Entity _ent = entityiterator;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager().handleCommand(
												_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
												(entity.getPersistentData().getString("exitCMD")));
									}
								}
								if (!entityiterator.world.isRemote())
									entityiterator.remove();
								countmobb = (double) (countmobb + 1);
							}
						}
					}
					if ((countmobb > 0)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(((countmobb) + "" + (" mobs followed you"))), (false));
						}
					}
					entity.getPersistentData().putDouble("eatCoolDown", 60);
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									(entity.getPersistentData().getString("exitCMD")));
						}
					}
					countmobb = (double) 0;
				} else {
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB((entity.getPosX()) - (7 / 2d), (entity.getPosY()) - (7 / 2d), (entity.getPosZ()) - (7 / 2d),
												(entity.getPosX()) + (7 / 2d), (entity.getPosY()) + (7 / 2d), (entity.getPosZ()) + (7 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if ((!(entityiterator instanceof PlayerEntity))) {
								entityiterator.getPersistentData().putDouble("eatCoolDown", 60);
								{
									Entity _ent = entityiterator;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager()
												.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), (new Object() {
													public String getValue(IWorld world, BlockPos pos, String tag) {
														TileEntity tileEntity = world.getTileEntity(pos);
														if (tileEntity != null)
															return tileEntity.getTileData().getString(tag);
														return "";
													}
												}.getValue(world, new BlockPos((int) orgx, (int) 0, (int) orgz), "exitCMD")));
									}
								}
								if (!entityiterator.world.isRemote())
									entityiterator.remove();
								countmobb = (double) (countmobb + 1);
							}
						}
					}
					if ((countmobb > 0)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent(((Math.round(countmobb)) + "" + (" mobs followed you"))), (false));
						}
					}
					entity.getPersistentData().putDouble("eatCoolDown", 60);
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager()
									.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), (new Object() {
										public String getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getString(tag);
											return "";
										}
									}.getValue(world, new BlockPos((int) orgx, (int) 0, (int) orgz), "exitCMD")));
						}
					}
					countmobb = (double) 0;
				}
			}
		}
	}
}
