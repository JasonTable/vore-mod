package net.jasontable.vore_mod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Util;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.jasontable.vore_mod.world.ShrinkGunMobUseGameRule;
import net.jasontable.vore_mod.item.ShrinkGunItem;
import net.jasontable.vore_mod.VoreModMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;
import java.util.ArrayList;

public class EntityTickEatProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
			Entity entity = event.getEntityLiving();
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure EntityTickEat!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				VoreModMod.LOGGER.warn("Failed to load dependency x for procedure EntityTickEat!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				VoreModMod.LOGGER.warn("Failed to load dependency y for procedure EntityTickEat!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				VoreModMod.LOGGER.warn("Failed to load dependency z for procedure EntityTickEat!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VoreModMod.LOGGER.warn("Failed to load dependency world for procedure EntityTickEat!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((!(entity instanceof PlayerEntity))
				&& ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == ShrinkGunItem.block)
						&& (world.getWorldInfo().getGameRulesInstance().getBoolean(ShrinkGunMobUseGameRule.gamerule))))
				&& (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("vore_mod:belly"))))))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				GetABellyProcedure.executeProcedure($_dependencies);
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (2 / 2d), y - (2 / 2d), z - (2 / 2d), x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((((!((("" + (entity))).equals(("" + (entityiterator))))) && (((!(((entityiterator instanceof LivingEntity)
							? ((LivingEntity) entityiterator).getHeldItemMainhand()
							: ItemStack.EMPTY).getItem() == ShrinkGunItem.block)) && (entityiterator instanceof LivingEntity)) && (true)))
							&& ((entityiterator.getPersistentData().getDouble("eatCoolDown")) == 0))) {
						entityiterator.getPersistentData().putDouble("eatCoolDown", 60);
						{
							ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
							if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
						entityiterator.getPersistentData().putString("bellyDest", (entity.getPersistentData().getString("bellyType")));
						entityiterator.getPersistentData().putString("eatenBy", (entity.getDisplayName().getString()));
						entityiterator.getPersistentData().putDouble("eatenByID", (entity.getPersistentData().getDouble("voreID")));
						entityiterator.getPersistentData().putDouble("exitX", x);
						entityiterator.getPersistentData().putDouble("exitY", y);
						entityiterator.getPersistentData().putDouble("exitZ", z);
						entityiterator.getPersistentData().putString("exitDIM",
								((("" + ((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD))).replace("]", ""))
										.replace("ResourceKey[minecraft:dimension / ", "")));
						if ((entity instanceof FoxEntity)) {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.eat")),
										SoundCategory.NEUTRAL, (float) 2, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.eat")),
										SoundCategory.NEUTRAL, (float) 2, (float) 1, false);
							}
						} else {
							if (world instanceof World && !world.isRemote()) {
								((World) world)
										.playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.generic.eat")),
												SoundCategory.NEUTRAL, (float) 2, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.generic.eat")),
										SoundCategory.NEUTRAL, (float) 2, (float) 1, false);
							}
						}
						if ((true)) {
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;
								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									{
										Entity _ent = entityiterator;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													(("execute in vore_mod:belly run tp @s ") + ""
															+ ((entity.getPersistentData().getDouble("bellyX"))) + "" + (" ") + ""
															+ ((entity.getPersistentData().getDouble("bellyY"))) + "" + (" ") + ""
															+ ((entity.getPersistentData().getDouble("bellyZ")))));
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 1);
						}
						if ((!(((entity.getPersistentData().getString("eatText"))).equals("")))) {
							if (!world.isRemote()) {
								MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
								if (mcserv != null)
									mcserv.getPlayerList()
											.func_232641_a_(new StringTextComponent((((entity.getPersistentData().getString("eatText"))
													.replace("[eatee]", (entityiterator.getDisplayName().getString()))).replace("[eater]",
															(entity.getDisplayName().getString())))),
													ChatType.SYSTEM, Util.DUMMY_UUID);
							}
						}
						if ((!(entityiterator instanceof PlayerEntity))) {
							if (!entityiterator.world.isRemote())
								entityiterator.remove();
						}
					}
				}
			}
		}
		if (((entity.getPersistentData().getDouble("eatCoolDown")) > 0)) {
			entity.getPersistentData().putDouble("eatCoolDown", ((entity.getPersistentData().getDouble("eatCoolDown")) - 1));
		}
		if (((entity.getPersistentData().getDouble("voreID")) != 0)) {
			if (world instanceof ServerWorld) {
				IWorld _worldorig = world;
				world = ((ServerWorld) world).getServer()
						.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("vore_mod:belly")));
				if (world != null) {
					{
						List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
						for (Entity entityiterator : _players) {
							if (((entityiterator.getPersistentData().getDouble("eatenByID")) == (entity.getPersistentData().getDouble("voreID")))) {
								entityiterator.getPersistentData().putDouble("exitX", x);
								entityiterator.getPersistentData().putDouble("exitY", y);
								entityiterator.getPersistentData().putDouble("exitZ", z);
								entityiterator.getPersistentData().putString("exitDIM", ((("" + ((entity.world.getDimensionKey()))).replace("]", ""))
										.replace("ResourceKey[minecraft:dimension / ", "")));
							}
						}
					}
				}
				world = _worldorig;
			}
		}
	}
}
