
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.jasontable.vore_mod.fluid.CumFluid;
import net.jasontable.vore_mod.fluid.BloodFluid;
import net.jasontable.vore_mod.fluid.AcidFluid;
import net.jasontable.vore_mod.VoreModMod;

public class VoreModModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, VoreModMod.MODID);
	public static final RegistryObject<Fluid> CUM = REGISTRY.register("cum", () -> new CumFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_CUM = REGISTRY.register("flowing_cum", () -> new CumFluid.Flowing());
	public static final RegistryObject<Fluid> BLOOD = REGISTRY.register("blood", () -> new BloodFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_BLOOD = REGISTRY.register("flowing_blood", () -> new BloodFluid.Flowing());
	public static final RegistryObject<Fluid> ACID = REGISTRY.register("acid", () -> new AcidFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_ACID = REGISTRY.register("flowing_acid", () -> new AcidFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(CUM.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CUM.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BLOOD.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BLOOD.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ACID.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ACID.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
