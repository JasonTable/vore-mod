package net.jasontable.vore_mod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.jasontable.vore_mod.init.VoreModModItems;
import net.jasontable.vore_mod.init.VoreModModGameRules;
import net.jasontable.vore_mod.VoreModMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityClickProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		String dimid = "";
		String eat_text_coolhuh = "";
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == VoreModModItems.SHRINK_GUN.get()) {
			if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
				VoreModMod.LOGGER.info((entity.getDisplayName().getString() + " was right clicked on with shrink gun by " + sourceentity.getDisplayName().getString()));
			}
			GetABellyProcedure.execute(world, entity);
			if (!entity.getPersistentData().getBoolean("noEat") && !((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("vore_mod:belly"))))) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(sourceentity))) {
					{
						ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				sourceentity.getPersistentData().putString("bellyDest", (entity.getPersistentData().getString("bellyType")));
				sourceentity.getPersistentData().putString("preyExitCMD", (entity.getPersistentData().getString("predExitCMD")));
				sourceentity.getPersistentData().putString("eatenBy", (entity.getDisplayName().getString()));
				sourceentity.getPersistentData().putDouble("eatenByID", (entity.getPersistentData().getDouble("voreID")));
				sourceentity.getPersistentData().putDouble("exitX", x);
				sourceentity.getPersistentData().putDouble("exitY", y);
				sourceentity.getPersistentData().putDouble("exitZ", z);
				sourceentity.getPersistentData().putString("exitDIM", ((("" + (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD)).replace("]", "")).replace("ResourceKey[minecraft:dimension / ", "")));
				if (entity instanceof Fox) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.eat")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fox.eat")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("execute in vore_mod:belly run tp @s " + (entity.getPersistentData().getDouble("bellyOriginX") + entity.getPersistentData().getDouble("bellyOffsetX")) + " " + entity.getPersistentData().getDouble("bellyOffsetY") + " "
										+ (entity.getPersistentData().getDouble("bellyOriginZ") + entity.getPersistentData().getDouble("bellyOffsetZ"))));
					}
				}
				if (!(entity.getPersistentData().getString("eatText")).isEmpty()) {
					eat_text_coolhuh = entity.getPersistentData().getString("eatText");
					eat_text_coolhuh = eat_text_coolhuh.replace("[pred]", entity.getDisplayName().getString());
					eat_text_coolhuh = eat_text_coolhuh.replace("[prey]", sourceentity.getDisplayName().getString());
					eat_text_coolhuh = eat_text_coolhuh.replace("[eater]", entity.getDisplayName().getString());
					eat_text_coolhuh = eat_text_coolhuh.replace("[eatee]", sourceentity.getDisplayName().getString());
					if (!world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.RULE_NO_CHAT)) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(eat_text_coolhuh), false);
					}
				}
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " will not eat you.")), false);
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.NAME_TAG
				&& ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDisplayName().getString()).equals("[AV]")) {
			if (ChangeToAVProcedure.execute(entity)) {
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(sourceentity))) {
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				}
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " will anal vore you now.")), false);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " cannot anal vore you.")), false);
			}
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
