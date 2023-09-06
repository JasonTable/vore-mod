
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoreModModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> SHRINKGUNALLOWED = GameRules.register("shrinkGunAllowed", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> SHRINKGUNMOBUSE = GameRules.register("shrinkGunMobUse", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> VOREBOSE = GameRules.register("vorebose", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> RULE_NO_CHAT = GameRules.register("ruleNoChat", GameRules.Category.CHAT, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> CLOTTING = GameRules.register("clotting", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}
