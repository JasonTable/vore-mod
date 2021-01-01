package net.jasontable.vore_mod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.jasontable.vore_mod.block.BellyoriginBlock;
import net.jasontable.vore_mod.VoreModModElements;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

@VoreModModElements.ModElement.Tag
public class DestroyBellyProcedure extends VoreModModElements.ModElement {
	public DestroyBellyProcedure(VoreModModElements instance) {
		super(instance, 57);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure DestroyBelly!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure DestroyBelly!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure DestroyBelly!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure DestroyBelly!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB((x + 24) - (48 / 2d), (y + 24) - (48 / 2d),
					(z + 24) - (48 / 2d), (x + 24) + (48 / 2d), (y + 24) + (48 / 2d), (z + 24) + (48 / 2d)), null).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((x + 24), (y + 24), (z + 24))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if ((!(entityiterator instanceof PlayerEntity))) {
					if (!entityiterator.world.isRemote)
						entityiterator.remove();
				} else {
					if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote) {
						((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("The creature you were inside of has died."),
								(false));
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BellyoriginBlock.block.getDefaultState()
							.getBlock())) {
						if ((((new Object() {
							public String getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getString(tag);
								return "";
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "exitCMD"))).equals("uneat"))) {
							{
								Entity _ent = entityiterator;
								if (!_ent.world.isRemote && _ent.world.getServer() != null) {
									_ent.world.getServer().getCommandManager().handleCommand(
											_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
											(entityiterator.getPersistentData().getString("exitCMD")));
								}
							}
						} else {
							{
								Entity _ent = entityiterator;
								if (!_ent.world.isRemote && _ent.world.getServer() != null) {
									_ent.world.getServer().getCommandManager()
											.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), (new Object() {
												public String getValue(BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getString(tag);
													return "";
												}
											}.getValue(new BlockPos((int) x, (int) y, (int) z), "exitCMD")));
								}
							}
						}
					}
				}
			}
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
	}
}
