package net.jasontable.vore_mod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.jasontable.vore_mod.block.BellyoriginBlock;
import net.jasontable.vore_mod.VoreModMod;

import java.util.Map;

public class BellyPlayerEntersDimensionProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				VoreModMod.LOGGER.warn("Failed to load dependency entity for procedure BellyPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				VoreModMod.LOGGER.warn("Failed to load dependency x for procedure BellyPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				VoreModMod.LOGGER.warn("Failed to load dependency z for procedure BellyPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				VoreModMod.LOGGER.warn("Failed to load dependency world for procedure BellyPlayerEntersDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double xx = 0;
		double zz = 0;
		double randy = 0;
		String stringe = "";
		xx = (double) (Math.floor((x / 48)) * 48);
		zz = (double) (Math.floor((z / 48)) * 48);
		VoreModMod.LOGGER.info((("[Vore_Mod] Entity ") + "" + ((entity.getDisplayName().getString())) + "" + (" has been eaten.")));
		if ((world.isAirBlock(new BlockPos((int) xx, (int) 0, (int) zz)))) {
			if ((((entity.getPersistentData().getString("bellyDest"))).equals("anthro"))) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("vore_mod", "hbelly0"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 0, (int) zz),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				randy = (double) Math.round((Math.random() * 6));
				if ((randy == 0)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "hshit0"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (xx + 12), (int) 3, (int) (zz + 6)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 1)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "hshit1"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (xx + 12), (int) 3, (int) (zz + 6)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 2)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "hshit2"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (xx + 12), (int) 3, (int) (zz + 6)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 3)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "hshit3"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (xx + 12), (int) 3, (int) (zz + 6)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 4)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "hshit4"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (xx + 12), (int) 3, (int) (zz + 6)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 5)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "hshit5"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (xx + 12), (int) 3, (int) (zz + 6)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
			} else if ((((entity.getPersistentData().getString("bellyDest"))).equals("animal"))) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("vore_mod", "qbelly"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 0, (int) zz),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				randy = (double) Math.floor((Math.random() * 6));
				if ((randy == 0)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "shit0"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 13, (int) (zz + 8)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 1)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "shit1"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 13, (int) (zz + 8)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 2)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "shit2"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 13, (int) (zz + 8)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 3)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "shit3"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 13, (int) (zz + 8)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 4)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "shit4"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 13, (int) (zz + 8)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((randy == 5)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("vore_mod", "shit5"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 13, (int) (zz + 8)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
			} else if ((((entity.getPersistentData().getString("bellyDest"))).equals(""))) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("vore_mod", "nobelly"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 0, (int) zz),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				VoreModMod.LOGGER.info("[Vore_Mod] Error: belly NBT blank so belly placeholder is spawned");
			} else if ((((entity.getPersistentData().getString("bellyDest"))).equals("rotten"))) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("vore_mod", "rotten"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) xx, (int) 0, (int) zz),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			} else if ((((entity.getPersistentData().getString("bellyDest"))).equals("nobelly"))) {
				VoreModMod.LOGGER.info("[Vore_Mod] Belly NBT is nobelly so no structure is spawned");
			} else {
				stringe = (String) (entity.getPersistentData().getString("bellyDest"));
				VoreModMod.LOGGER.info((("[Vore_Mod] Belly id is custom belly \"") + "" + (stringe) + "" + ("\"")));
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("vore_mod", stringe));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) (xx), (int) 13, (int) ((zz) + 8)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
			world.setBlockState(new BlockPos((int) xx, (int) 0, (int) zz), BellyoriginBlock.block.getDefaultState(), 3);
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) xx, (int) 0, (int) zz);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putString("bellyname", (((entity.getPersistentData().getString("eatenBy"))) + "" + ("'s belly")));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) xx, (int) 0, (int) zz);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putString("exitCMD", "uneat");
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			VoreModMod.LOGGER.info((("[Vore_Mod] Placed belly at X") + "" + (xx) + "" + (" Z") + "" + (zz)));
		} else {
			VoreModMod.LOGGER.info((("[Vore_Mod] Belly already present at X") + "" + (xx) + "" + (" Z") + "" + (zz)));
		}
	}
}
