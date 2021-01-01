package net.jasontable.vore_mod.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.world.dimension.BellyDimension;
import net.jasontable.vore_mod.item.FleshItem;
import net.jasontable.vore_mod.block.AcidBlock;
import net.jasontable.vore_mod.VoreModModElements;

import java.util.Map;
import java.util.HashMap;

@VoreModModElements.ModElement.Tag
public class DropFleshProcedure extends VoreModModElements.ModElement {
	public DropFleshProcedure(VoreModModElements instance) {
		super(instance, 26);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DropFlesh!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure DropFlesh!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure DropFlesh!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure DropFlesh!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure DropFlesh!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AcidBlock.block.getDefaultState().getBlock())) {
			if ((entity instanceof PlayerEntity)) {
				if ((((entity.dimension.getId()) == (BellyDimension.type.getId()))
						&& (!(((entity.getPersistentData().getString("eatenBy"))).equals(""))))) {
					{
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList().sendMessage(new StringTextComponent((((entity.getDisplayName().getString())) + ""
									+ (" got digested by ") + "" + ((entity.getPersistentData().getString("eatenBy"))))));
					}
				} else {
					{
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList()
									.sendMessage(new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" got digested"))));
					}
				}
			}
		} else {
			if (((Math.random() < 0.3) && (entity instanceof AnimalEntity))) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(FleshItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
		if ((!(((entity.getPersistentData().getString("bellyType"))).equals("")))) {
			if (world instanceof ServerWorld) {
				IWorld _worldorig = world;
				world = ((ServerWorld) world).getServer().getWorld(BellyDimension.type);
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", (Math.floor(((entity.getPersistentData().getDouble("bellyX")) / 48)) * 48));
					$_dependencies.put("y", 0);
					$_dependencies.put("z", (Math.floor(((entity.getPersistentData().getDouble("bellyZ")) / 48)) * 48));
					DestroyBellyProcedure.executeProcedure($_dependencies);
				}
				world = _worldorig;
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
