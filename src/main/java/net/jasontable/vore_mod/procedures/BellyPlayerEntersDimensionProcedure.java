package net.jasontable.vore_mod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.jasontable.vore_mod.init.VoreModModGameRules;
import net.jasontable.vore_mod.VoreModMod;

public class BellyPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		double xx = 0;
		double zz = 0;
		double randy = 0;
		String stringe = "";
		xx = Math.floor(x / 48) * 48;
		zz = Math.floor(z / 48) * 48;
		if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
			VoreModMod.LOGGER.info(("[Vore_Mod] Entity " + entity.getDisplayName().getString() + " has been eaten."));
		}
		if (world.isEmptyBlock(BlockPos.containing(xx, 0, zz))) {
			if ((entity.getPersistentData().getString("bellyDest")).equals("anthro")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hbelly0"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(xx, 0, zz), BlockPos.containing(xx, 0, zz), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
				randy = Mth.nextInt(RandomSource.create(), 0, 5);
				if (randy == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit0"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx + 12, 3, zz + 6), BlockPos.containing(xx + 12, 3, zz + 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx + 12, 3, zz + 6), BlockPos.containing(xx + 12, 3, zz + 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx + 12, 3, zz + 6), BlockPos.containing(xx + 12, 3, zz + 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx + 12, 3, zz + 6), BlockPos.containing(xx + 12, 3, zz + 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit4"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx + 12, 3, zz + 6), BlockPos.containing(xx + 12, 3, zz + 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit5"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx + 12, 3, zz + 6), BlockPos.containing(xx + 12, 3, zz + 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
					VoreModMod.LOGGER.debug(("[Vore_Mod] Random shit number " + randy));
				}
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("animal")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "qbelly"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(xx, 0, zz), BlockPos.containing(xx, 0, zz), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
				randy = Mth.nextInt(RandomSource.create(), 0, 6);
				if (randy == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit0"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx, 13, zz + 8), BlockPos.containing(xx, 13, zz + 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx, 13, zz + 8), BlockPos.containing(xx, 13, zz + 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx, 13, zz + 8), BlockPos.containing(xx, 13, zz + 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx, 13, zz + 8), BlockPos.containing(xx, 13, zz + 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit4"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx, 13, zz + 8), BlockPos.containing(xx, 13, zz + 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit5"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx, 13, zz + 8), BlockPos.containing(xx, 13, zz + 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 6) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit6"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(xx, 13, zz + 8), BlockPos.containing(xx, 13, zz + 8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
					VoreModMod.LOGGER.debug(("[Vore_Mod] Random shit number " + randy));
				}
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "nobelly"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(xx, 0, zz), BlockPos.containing(xx, 0, zz), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
				VoreModMod.LOGGER.warn("[Vore_Mod] Error: belly NBT blank so belly placeholder is spawned");
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("rotten")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "rotten"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(xx, 0, zz), BlockPos.containing(xx, 0, zz), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("rotten_animal")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "rotten_animal"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(xx, 0, zz), BlockPos.containing(xx, 0, zz), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("nobelly")) {
				if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
					VoreModMod.LOGGER.debug("[Vore_Mod] Belly NBT is nobelly so no structure is spawned");
				}
			} else {
				stringe = entity.getPersistentData().getString("bellyDest");
				if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
					VoreModMod.LOGGER.info(("[Vore_Mod] Belly id is custom belly \"" + "" + stringe + "\""));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(xx, 0, zz), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("place template vore_mod:" + stringe));
			}
			if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
				VoreModMod.LOGGER.debug(("[Vore_Mod] Placed belly at X" + xx + " Z" + zz));
			}
		} else {
			if (world.getLevelData().getGameRules().getBoolean(VoreModModGameRules.VOREBOSE)) {
				VoreModMod.LOGGER.debug(("[Vore_Mod] Belly already present at X" + xx + " Z" + zz));
			}
		}
	}
}
