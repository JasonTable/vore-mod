package net.jasontable.vore_mod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.jasontable.vore_mod.block.BellyoriginBlock;
import net.jasontable.vore_mod.VoreModMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class DestroyBellyProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure DestroyBelly!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				VoreModMod.LOGGER.warn("Failed to load dependency x for procedure DestroyBelly!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				VoreModMod.LOGGER.warn("Failed to load dependency y for procedure DestroyBelly!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				VoreModMod.LOGGER.warn("Failed to load dependency z for procedure DestroyBelly!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VoreModMod.LOGGER.warn("Failed to load dependency world for procedure DestroyBelly!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			IWorld _worldorig = world;
			world = ((ServerWorld) world).getServer()
					.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("vore_mod:belly")));
			if (world != null) {
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) (x + 24), (int) (y + 24), (int) (z + 24)),
							((World) world).getBlockState(new BlockPos((int) (x + 24), (int) (y + 24), (int) (z + 24))).getBlock());
				{
					List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB((x + 24) - (48 / 2d), (y + 24) - (48 / 2d),
							(z + 24) - (48 / 2d), (x + 24) + (48 / 2d), (y + 24) + (48 / 2d), (z + 24) + (48 / 2d)), null).stream()
							.sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((x + 24), (y + 24), (z + 24))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
							((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("The creature you were inside of has died."),
									(false));
						}
						if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BellyoriginBlock.block)) {
							if ((((new Object() {
								public String getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "exitCMD"))).equals("uneat"))) {
								{
									Entity _ent = entityiterator;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager().handleCommand(
												_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
												(("execute in ") + ""
														+ (((("" + ((entity.world.getDimensionKey()))).replace("]", ""))
																.replace("ResourceKey[minecraft:dimension / ", "")))
														+ "" + (" run tp @s ") + "" + ((entity.getPosX())) + "" + (" ") + "" + ((entity.getPosY()))
														+ "" + (" ") + "" + ((entity.getPosZ()))));
									}
								}
							} else {
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
												}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "exitCMD")));
									}
								}
							}
						}
						if ((!(entityiterator instanceof PlayerEntity))) {
							if (!entityiterator.world.isRemote())
								entityiterator.remove();
						}
					}
				}
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			}
			world = _worldorig;
		}
	}
}
