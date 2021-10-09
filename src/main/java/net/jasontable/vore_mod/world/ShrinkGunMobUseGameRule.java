package net.jasontable.vore_mod.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.jasontable.vore_mod.VoreModModElements;

import java.lang.reflect.Method;

@VoreModModElements.ModElement.Tag
public class ShrinkGunMobUseGameRule extends VoreModModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("shrinkGunMobUse", GameRules.Category.MOBS,
			create(true));
	public ShrinkGunMobUseGameRule(VoreModModElements instance) {
		super(instance, 63);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
