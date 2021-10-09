package net.jasontable.vore_mod.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.jasontable.vore_mod.VoreModModElements;

import java.lang.reflect.Method;

@VoreModModElements.ModElement.Tag
public class ShrinkGunAllowedGameRule extends VoreModModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("shrinkGunAllowed", GameRules.Category.PLAYER,
			create(true));
	public ShrinkGunAllowedGameRule(VoreModModElements instance) {
		super(instance, 62);
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
