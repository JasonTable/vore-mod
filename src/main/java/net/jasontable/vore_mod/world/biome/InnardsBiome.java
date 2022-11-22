
package net.jasontable.vore_mod.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;

public class InnardsBiome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-10092544).waterColor(4159204).waterFogColor(329011)
				.skyColor(-10092544).foliageColorOverride(-13312).grassColorOverride(-13210)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("vore_mod:heart_beat")))
				.ambientMoodSound(new AmbientMoodSettings(new SoundEvent(new ResourceLocation("vore_mod:stomach_gurgles")), 200, 8, 2))
				.ambientParticle(new AmbientParticleSettings(ParticleTypes.FALLING_WATER, 0.01f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).temperature(1.5f).downfall(0f).specialEffects(effects)
				.mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
