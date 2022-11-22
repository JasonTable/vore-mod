
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.jasontable.vore_mod.fluid.types.CumFluidType;
import net.jasontable.vore_mod.fluid.types.BloodFluidType;
import net.jasontable.vore_mod.fluid.types.AcidFluidType;
import net.jasontable.vore_mod.VoreModMod;

public class VoreModModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, VoreModMod.MODID);
	public static final RegistryObject<FluidType> CUM_TYPE = REGISTRY.register("cum", () -> new CumFluidType());
	public static final RegistryObject<FluidType> BLOOD_TYPE = REGISTRY.register("blood", () -> new BloodFluidType());
	public static final RegistryObject<FluidType> ACID_TYPE = REGISTRY.register("acid", () -> new AcidFluidType());
}
