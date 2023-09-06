
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.jasontable.vore_mod.VoreModMod;

public class VoreModModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, VoreModMod.MODID);
	public static final RegistryObject<SoundEvent> HEART_BEAT = REGISTRY.register("heart_beat", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("vore_mod", "heart_beat")));
	public static final RegistryObject<SoundEvent> STOMACH_GURGLES = REGISTRY.register("stomach_gurgles", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("vore_mod", "stomach_gurgles")));
}
