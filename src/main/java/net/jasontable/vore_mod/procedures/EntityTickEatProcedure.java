package net.jasontable.vore_mod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.jasontable.vore_mod.init.VoreModModItems;
import net.jasontable.vore_mod.init.VoreModModGameRules;
import net.jasontable.vore_mod.VoreModMod;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class EntityTickEatProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean whatthefuckwhywontthissave = false;
		String anothershitworkaroundbullshit = "";
		whatthefuckwhywontthissave = false;
		if (!(entity instanceof Player)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == VoreModModItems.SHRINK_GUN
						.get()
				&& world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.SHRINKGUNMOBUSE)
				&& !((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("vore_mod:belly"))))) {
			GetABellyProcedure.execute(world, entity);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)
							&& !((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
									.getItem() == VoreModModItems.SHRINK_GUN.get())
							&& entityiterator instanceof LivingEntity && entityiterator.getPersistentData().getDouble("eatCoolDown") == 0) {
						entityiterator.getPersistentData().putDouble("eatCoolDown", 60);
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
						entityiterator.getPersistentData().putString("bellyDest", (entity.getPersistentData().getString("bellyType")));
						entityiterator.getPersistentData().putString("preyExitCMD", (entity.getPersistentData().getString("predExitCMD")));
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
							VoreModMod.queueServerWork(1, () -> {
								{
									Entity _ent = entityiterator;
									if (!_ent.level.isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
														_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent),
												("execute in vore_mod:belly run tp @s "
														+ (entity.getPersistentData().getDouble("bellyOriginX")
																+ entity.getPersistentData().getDouble("bellyOffsetX"))
														+ " " + entity.getPersistentData().getDouble("bellyOffsetY") + " "
														+ (entity.getPersistentData().getDouble("bellyOriginZ")
																+ entity.getPersistentData().getDouble("bellyOffsetZ"))));
									}
								}
							});
						}
						if (!(entity.getPersistentData().getString("eatText")).equals("")) {
							anothershitworkaroundbullshit = entity.getPersistentData().getString("eatText");
							anothershitworkaroundbullshit = anothershitworkaroundbullshit.replace("[pred]", entity.getDisplayName().getString());
							anothershitworkaroundbullshit = anothershitworkaroundbullshit.replace("[prey]",
									entityiterator.getDisplayName().getString());
							anothershitworkaroundbullshit = anothershitworkaroundbullshit.replace("[eater]", entity.getDisplayName().getString());
							anothershitworkaroundbullshit = anothershitworkaroundbullshit.replace("[eatee]",
									entityiterator.getDisplayName().getString());
							if (entityiterator instanceof Player || entity instanceof Player) {
								if (!world.isClientSide()) {
									MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
									if (_mcserv != null)
										_mcserv.getPlayerList().broadcastSystemMessage(Component.literal(anothershitworkaroundbullshit), false);
								}
							} else {
								whatthefuckwhywontthissave = true;
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
		if (whatthefuckwhywontthissave) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal(anothershitworkaroundbullshit), (false));
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
							if (entityiterator.getPersistentData().getDouble("eatenByID") == entity.getPersistentData().getDouble("voreID")
									&& !((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
											new ResourceLocation("vore_mod:belly"))))) {
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
