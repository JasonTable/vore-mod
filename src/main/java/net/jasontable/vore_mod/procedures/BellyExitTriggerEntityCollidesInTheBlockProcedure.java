package net.jasontable.vore_mod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.block.BellyoriginBlock;
import net.jasontable.vore_mod.block.BellyExitTriggerBlock;
import net.jasontable.vore_mod.VoreModModElements;

import java.util.Map;

@VoreModModElements.ModElement.Tag
public class BellyExitTriggerEntityCollidesInTheBlockProcedure extends VoreModModElements.ModElement {
	public BellyExitTriggerEntityCollidesInTheBlockProcedure(VoreModModElements instance) {
		super(instance, 41);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BellyExitTriggerEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BellyExitTriggerEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BellyExitTriggerEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BellyExitTriggerEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double orgx = 0;
		double orgz = 0;
		if (((entity instanceof PlayerEntity) && ((world.getBlockState(
				new BlockPos((int) Math.floor((entity.getPosX())), (int) Math.floor((entity.getPosY())), (int) Math.floor((entity.getPosZ())))))
						.getBlock() == BellyExitTriggerBlock.block.getDefaultState().getBlock()))) {
			orgx = (double) (Math.floor((x / 48)) * 48);
			orgz = (double) (Math.floor((z / 48)) * 48);
			if (((world.getBlockState(new BlockPos((int) (orgx), (int) 0, (int) (orgz)))).getBlock() == BellyoriginBlock.block.getDefaultState()
					.getBlock())) {
				if ((((new Object() {
					public String getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(new BlockPos((int) (orgx), (int) 0, (int) (orgz)), "exitCMD"))).equals("uneat"))) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									(entity.getPersistentData().getString("exitCMD")));
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager()
									.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), (new Object() {
										public String getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getString(tag);
											return "";
										}
									}.getValue(new BlockPos((int) (orgx), (int) 0, (int) (orgz)), "exitCMD")));
						}
					}
				}
			}
		}
	}
}
