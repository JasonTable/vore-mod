
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.jasontable.vore_mod.block.UvulaBlock;
import net.jasontable.vore_mod.block.TongueSlabBlock;
import net.jasontable.vore_mod.block.TongueBlock;
import net.jasontable.vore_mod.block.ThinTongueBlock;
import net.jasontable.vore_mod.block.SmallAnusBlock;
import net.jasontable.vore_mod.block.ShitBlock;
import net.jasontable.vore_mod.block.ScabBlock;
import net.jasontable.vore_mod.block.RottenFleshSlabBlock;
import net.jasontable.vore_mod.block.RottenFleshBlockBlock;
import net.jasontable.vore_mod.block.PooBlock;
import net.jasontable.vore_mod.block.FoxblocklolBlock;
import net.jasontable.vore_mod.block.FleshSlabBlock;
import net.jasontable.vore_mod.block.FleshBlockBlock;
import net.jasontable.vore_mod.block.EsophagusBlock;
import net.jasontable.vore_mod.block.CumBlock;
import net.jasontable.vore_mod.block.BloodBlock;
import net.jasontable.vore_mod.block.BellyoriginBlock;
import net.jasontable.vore_mod.block.BellyExitTriggerBlock;
import net.jasontable.vore_mod.block.AnusBlock;
import net.jasontable.vore_mod.block.AdminrotfleshBlock;
import net.jasontable.vore_mod.block.AdminfleshBlock;
import net.jasontable.vore_mod.block.AcidBlock;
import net.jasontable.vore_mod.VoreModMod;

public class VoreModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, VoreModMod.MODID);
	public static final RegistryObject<Block> FLESHBLOCK = REGISTRY.register("fleshblock", () -> new FleshBlockBlock());
	public static final RegistryObject<Block> FLESH_SLAB = REGISTRY.register("flesh_slab", () -> new FleshSlabBlock());
	public static final RegistryObject<Block> ROTTEN_FLESH_BLOCK = REGISTRY.register("rotten_flesh_block", () -> new RottenFleshBlockBlock());
	public static final RegistryObject<Block> ROTTEN_FLESH_SLAB = REGISTRY.register("rotten_flesh_slab", () -> new RottenFleshSlabBlock());
	public static final RegistryObject<Block> TONGUE = REGISTRY.register("tongue", () -> new TongueBlock());
	public static final RegistryObject<Block> TONGUE_SLAB = REGISTRY.register("tongue_slab", () -> new TongueSlabBlock());
	public static final RegistryObject<Block> SHIT = REGISTRY.register("shit", () -> new ShitBlock());
	public static final RegistryObject<Block> SCAB = REGISTRY.register("scab", () -> new ScabBlock());
	public static final RegistryObject<Block> ADMINFLESH = REGISTRY.register("adminflesh", () -> new AdminfleshBlock());
	public static final RegistryObject<Block> ADMINROTFLESH = REGISTRY.register("adminrotflesh", () -> new AdminrotfleshBlock());
	public static final RegistryObject<Block> FOXBLOCK = REGISTRY.register("foxblock", () -> new FoxblocklolBlock());
	public static final RegistryObject<Block> ANUS = REGISTRY.register("anus", () -> new AnusBlock());
	public static final RegistryObject<Block> SMALL_ANUS = REGISTRY.register("small_anus", () -> new SmallAnusBlock());
	public static final RegistryObject<Block> POO = REGISTRY.register("poo", () -> new PooBlock());
	public static final RegistryObject<Block> UVULA = REGISTRY.register("uvula", () -> new UvulaBlock());
	public static final RegistryObject<Block> ESOPHAGUS = REGISTRY.register("esophagus", () -> new EsophagusBlock());
	public static final RegistryObject<Block> THIN_TONGUE = REGISTRY.register("thin_tongue", () -> new ThinTongueBlock());
	public static final RegistryObject<Block> CUM = REGISTRY.register("cum", () -> new CumBlock());
	public static final RegistryObject<Block> BLOOD = REGISTRY.register("blood", () -> new BloodBlock());
	public static final RegistryObject<Block> ACID = REGISTRY.register("acid", () -> new AcidBlock());
	public static final RegistryObject<Block> BELLYORIGIN = REGISTRY.register("bellyorigin", () -> new BellyoriginBlock());
	public static final RegistryObject<Block> BELLY_EXIT_TRIGGER = REGISTRY.register("belly_exit_trigger", () -> new BellyExitTriggerBlock());
}
