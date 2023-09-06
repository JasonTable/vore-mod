
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.jasontable.vore_mod.item.ShrinkGunItem;
import net.jasontable.vore_mod.item.FleshItem;
import net.jasontable.vore_mod.item.CumItem;
import net.jasontable.vore_mod.item.BloodItem;
import net.jasontable.vore_mod.item.AcidItem;
import net.jasontable.vore_mod.VoreModMod;

public class VoreModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, VoreModMod.MODID);
	public static final RegistryObject<Item> FLESHBLOCK = block(VoreModModBlocks.FLESHBLOCK);
	public static final RegistryObject<Item> FLESH_SLAB = block(VoreModModBlocks.FLESH_SLAB);
	public static final RegistryObject<Item> ROTTEN_FLESH_BLOCK = block(VoreModModBlocks.ROTTEN_FLESH_BLOCK);
	public static final RegistryObject<Item> ROTTEN_FLESH_SLAB = block(VoreModModBlocks.ROTTEN_FLESH_SLAB);
	public static final RegistryObject<Item> TONGUE = block(VoreModModBlocks.TONGUE);
	public static final RegistryObject<Item> TONGUE_SLAB = block(VoreModModBlocks.TONGUE_SLAB);
	public static final RegistryObject<Item> SHIT = block(VoreModModBlocks.SHIT);
	public static final RegistryObject<Item> SCAB = block(VoreModModBlocks.SCAB);
	public static final RegistryObject<Item> ADMINFLESH = block(VoreModModBlocks.ADMINFLESH);
	public static final RegistryObject<Item> ADMINROTFLESH = block(VoreModModBlocks.ADMINROTFLESH);
	public static final RegistryObject<Item> FOXBLOCK = block(VoreModModBlocks.FOXBLOCK);
	public static final RegistryObject<Item> ANUS = block(VoreModModBlocks.ANUS);
	public static final RegistryObject<Item> SMALL_ANUS = block(VoreModModBlocks.SMALL_ANUS);
	public static final RegistryObject<Item> POO = block(VoreModModBlocks.POO);
	public static final RegistryObject<Item> UVULA = block(VoreModModBlocks.UVULA);
	public static final RegistryObject<Item> ESOPHAGUS = block(VoreModModBlocks.ESOPHAGUS);
	public static final RegistryObject<Item> THIN_TONGUE = block(VoreModModBlocks.THIN_TONGUE);
	public static final RegistryObject<Item> CUM_BUCKET = REGISTRY.register("cum_bucket", () -> new CumItem());
	public static final RegistryObject<Item> BLOOD_BUCKET = REGISTRY.register("blood_bucket", () -> new BloodItem());
	public static final RegistryObject<Item> ACID_BUCKET = REGISTRY.register("acid_bucket", () -> new AcidItem());
	public static final RegistryObject<Item> SHRINK_GUN = REGISTRY.register("shrink_gun", () -> new ShrinkGunItem());
	public static final RegistryObject<Item> FLESH = REGISTRY.register("flesh", () -> new FleshItem());
	public static final RegistryObject<Item> BELLYORIGIN = block(VoreModModBlocks.BELLYORIGIN);
	public static final RegistryObject<Item> BELLY_EXIT_TRIGGER = block(VoreModModBlocks.BELLY_EXIT_TRIGGER);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
