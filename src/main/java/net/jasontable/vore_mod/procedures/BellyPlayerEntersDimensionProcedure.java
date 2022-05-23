package net.jasontable.vore_mod.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.jasontable.vore_mod.init.VoreModModBlocks;
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
		VoreModMod.LOGGER.info(("[Vore_Mod] Entity " + entity.getDisplayName().getString() + " has been eaten."));
		if (world.isEmptyBlock(new BlockPos(xx, 0, zz))) {
			if ((entity.getPersistentData().getString("bellyDest")).equals("anthro")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hbelly0"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(xx, 0, zz), new BlockPos(xx, 0, zz),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
				randy = Math.round(Math.random() * 6);
				if (randy == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit0"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx + 12, 3, zz + 6), new BlockPos(xx + 12, 3, zz + 6),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit1"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx + 12, 3, zz + 6), new BlockPos(xx + 12, 3, zz + 6),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit2"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx + 12, 3, zz + 6), new BlockPos(xx + 12, 3, zz + 6),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit3"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx + 12, 3, zz + 6), new BlockPos(xx + 12, 3, zz + 6),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit4"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx + 12, 3, zz + 6), new BlockPos(xx + 12, 3, zz + 6),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "hshit5"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx + 12, 3, zz + 6), new BlockPos(xx + 12, 3, zz + 6),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("animal")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "qbelly"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(xx, 0, zz), new BlockPos(xx, 0, zz),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
				randy = Math.floor(Math.random() * 6);
				if (randy == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit0"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx, 13, zz + 8), new BlockPos(xx, 13, zz + 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit1"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx, 13, zz + 8), new BlockPos(xx, 13, zz + 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit2"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx, 13, zz + 8), new BlockPos(xx, 13, zz + 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit3"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx, 13, zz + 8), new BlockPos(xx, 13, zz + 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit4"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx, 13, zz + 8), new BlockPos(xx, 13, zz + 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
				if (randy == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "shit5"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(xx, 13, zz + 8), new BlockPos(xx, 13, zz + 8),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "nobelly"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(xx, 0, zz), new BlockPos(xx, 0, zz),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
				VoreModMod.LOGGER.info("[Vore_Mod] Error: belly NBT blank so belly placeholder is spawned");
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("rotten")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", "rotten"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(xx, 0, zz), new BlockPos(xx, 0, zz),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if ((entity.getPersistentData().getString("bellyDest")).equals("nobelly")) {
				VoreModMod.LOGGER.info("[Vore_Mod] Belly NBT is nobelly so no structure is spawned");
			} else {
				stringe = entity.getPersistentData().getString("bellyDest");
				VoreModMod.LOGGER.info(("[Vore_Mod] Belly id is custom belly \"" + "" + stringe + "\""));
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("vore_mod", stringe));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos((int) xx, (int) 0, (int) zz), new BlockPos((int) xx, (int) 0, (int) zz),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			}
			world.setBlock(new BlockPos(xx, 0, zz), VoreModModBlocks.BELLYORIGIN.get().defaultBlockState(), 3);
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(xx, 0, zz);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putString("bellyname", (entity.getPersistentData().getString("eatenBy") + "'s belly"));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(xx, 0, zz);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putString("exitCMD", "uneat");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			VoreModMod.LOGGER.info(("[Vore_Mod] Placed belly at X" + xx + " Z" + zz));
		} else {
			VoreModMod.LOGGER.info(("[Vore_Mod] Belly already present at X" + xx + " Z" + zz));
		}
	}
}
