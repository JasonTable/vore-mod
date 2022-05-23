package net.jasontable.vore_mod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

import net.jasontable.vore_mod.init.VoreModModItems;
import net.jasontable.vore_mod.init.VoreModModGameRules;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.Random;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class EntityTickEatProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		execute(event, event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(),
				event.getEntityLiving());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == VoreModModItems.SHRINK_GUN
						.get()
				&& world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.SHRINKGUNMOBUSE)
				&& !((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("vore_mod:belly"))))) {
			GetABellyProcedure.execute(entity);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!("" + entity).equals("" + entityiterator)
							&& !((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
									.getItem() == VoreModModItems.SHRINK_GUN.get())
							&& entityiterator instanceof LivingEntity && true && entityiterator.getPersistentData().getDouble("eatCoolDown") == 0) {
						entityiterator.getPersistentData().putDouble("eatCoolDown", 60);
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
						entityiterator.getPersistentData().putString("bellyDest", (entity.getPersistentData().getString("bellyType")));
						entityiterator.getPersistentData().putString("eatenBy", (entity.getDisplayName().getString()));
						entityiterator.getPersistentData().putDouble("eatenByID", (entity.getPersistentData().getDouble("voreID")));
						entityiterator.getPersistentData().putDouble("exitX", x);
						entityiterator.getPersistentData().putDouble("exitY", y);
						entityiterator.getPersistentData().putDouble("exitZ", z);
						entityiterator.getPersistentData().putString("exitDIM",
								((("" + (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD)).replace("]", ""))
										.replace("ResourceKey[minecraft:dimension / ", "")));
						if (entity instanceof Fox) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.eat")), SoundSource.NEUTRAL, 2, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.eat")),
											SoundSource.NEUTRAL, 2, 1, false);
								}
							}
						} else {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 2,
											1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")),
											SoundSource.NEUTRAL, 2, 1, false);
								}
							}
						}
						if (true) {
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private LevelAccessor world;

								public void start(LevelAccessor world, int waitTicks) {
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
										if (!_ent.level.isClientSide() && _ent.getServer() != null)
											_ent.getServer().getCommands().performCommand(
													_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
													("execute in vore_mod:belly run tp @s " + entity.getPersistentData().getDouble("bellyX") + " "
															+ entity.getPersistentData().getDouble("bellyY") + " "
															+ entity.getPersistentData().getDouble("bellyZ")));
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, 1);
						}
						if (!(entity.getPersistentData().getString("eatText")).equals("")) {
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList()
											.broadcastMessage(
													new TextComponent((((entity.getPersistentData().getString("eatText")).replace("[eatee]",
															entityiterator.getDisplayName().getString()))
															.replace("[eater]", entity.getDisplayName().getString()))),
													ChatType.SYSTEM, Util.NIL_UUID);
							}
						}
						if (!(entityiterator instanceof Player)) {
							if (!entityiterator.level.isClientSide())
								entityiterator.discard();
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("eatCoolDown") > 0) {
			entity.getPersistentData().putDouble("eatCoolDown", (entity.getPersistentData().getDouble("eatCoolDown") - 1));
		}
		if (entity.getPersistentData().getDouble("voreID") != 0) {
			if (world instanceof ServerLevel _origLevel) {
				LevelAccessor _worldorig = world;
				world = _origLevel.getServer().getLevel(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("vore_mod:belly")));
				if (world != null) {
					{
						List<? extends Player> _players = new ArrayList<>(world.players());
						for (Entity entityiterator : _players) {
							if (entityiterator.getPersistentData().getDouble("eatenByID") == entity.getPersistentData().getDouble("voreID")) {
								entityiterator.getPersistentData().putDouble("exitX", x);
								entityiterator.getPersistentData().putDouble("exitY", y);
								entityiterator.getPersistentData().putDouble("exitZ", z);
								entityiterator.getPersistentData().putString("exitDIM",
										((("" + entity.level.dimension()).replace("]", "")).replace("ResourceKey[minecraft:dimension / ", "")));
							}
						}
					}
				}
				world = _worldorig;
			}
		}
	}
}
