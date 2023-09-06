
package net.jasontable.vore_mod.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import net.jasontable.vore_mod.procedures.VDBSetBellyDestProcedure;
import net.jasontable.vore_mod.procedures.ExitBellyProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;

@Mod.EventBusSubscriber
public class VoredebugCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher()
				.register(Commands.literal("voredebug").requires(s -> s.hasPermission(4)).then(Commands.literal("belly").then(Commands.literal("place").then(Commands.argument("bellyname", StringArgumentType.word()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					VDBSetBellyDestProcedure.execute(world, x, z, arguments, entity);
					return 0;
				}))).then(Commands.literal("exit").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ExitBellyProcedure.execute(world, entity);
					return 0;
				}))));
	}
}
