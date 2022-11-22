
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import net.jasontable.vore_mod.world.biome.InnardsBiome;
import net.jasontable.vore_mod.VoreModMod;

public class VoreModModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, VoreModMod.MODID);
	public static final RegistryObject<Biome> INNARDS = REGISTRY.register("innards", InnardsBiome::createBiome);
}
