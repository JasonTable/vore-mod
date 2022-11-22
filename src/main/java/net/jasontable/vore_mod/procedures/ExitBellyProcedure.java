package net.jasontable.vore_mod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class ExitBellyProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double orgx = 0;
		double orgz = 0;
		double countmobb = 0;
		String exitCommandThiny = "";
		if (!(entity.getPersistentData().getString("preyExitCMD")).isEmpty()) {
			exitCommandThiny = entity.getPersistentData().getString("preyExitCMD");
			if ((exitCommandThiny).equals("uneat")) {
				exitCommandThiny = "execute in " + entity.getPersistentData().getString("exitDIM") + " run tp @s "
						+ entity.getPersistentData().getDouble("exitX") + " " + entity.getPersistentData().getDouble("exitY") + " "
						+ entity.getPersistentData().getDouble("exitZ");
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof Player)) {
						entityiterator.getPersistentData().putDouble("eatCoolDown", 120);
						{
							Entity _ent = entityiterator;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(),
										_ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), exitCommandThiny);
							}
						}
						if (!entityiterator.level.isClientSide())
							entityiterator.discard();
						countmobb = countmobb + 1;
					}
				}
			}
			if (countmobb > 0) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("#").format(countmobb) + ""
							+ (countmobb == 1 ? " mob followed you" : " mobs followed you"))), (false));
			}
			entity.getPersistentData().putDouble("eatCoolDown", 120);
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands()
							.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
									_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level.getServer(), _ent), exitCommandThiny);
				}
			}
			entity.getPersistentData().putString("preyExitCMD", "");
			entity.getPersistentData().putString("eatenBy", "");
			entity.getPersistentData().putDouble("eatCoolDown", 120);
			countmobb = 0;
		}
	}
}
