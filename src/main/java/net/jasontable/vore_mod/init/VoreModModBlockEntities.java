
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.jasontable.vore_mod.block.entity.SmallAnusBlockEntity;
import net.jasontable.vore_mod.block.entity.FoxblocklolBlockEntity;
import net.jasontable.vore_mod.VoreModMod;

public class VoreModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, VoreModMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> FOXBLOCK = register("foxblock", VoreModModBlocks.FOXBLOCK, FoxblocklolBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SMALL_ANUS = register("small_anus", VoreModModBlocks.SMALL_ANUS, SmallAnusBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
