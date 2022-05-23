
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.jasontable.vore_mod.item.ShrinkGunItem;
import net.jasontable.vore_mod.item.FleshItem;
import net.jasontable.vore_mod.item.CumItem;
import net.jasontable.vore_mod.item.BloodItem;
import net.jasontable.vore_mod.item.AcidItem;
import net.jasontable.vore_mod.VoreModMod;

public class VoreModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, VoreModMod.MODID);
	public static final RegistryObject<Item> FLESHBLOCK = block(VoreModModBlocks.FLESHBLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FLESH_SLAB = block(VoreModModBlocks.FLESH_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ROTTEN_FLESH_BLOCK = block(VoreModModBlocks.ROTTEN_FLESH_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TONGUE = block(VoreModModBlocks.TONGUE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SHIT = block(VoreModModBlocks.SHIT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ADMINFLESH = block(VoreModModBlocks.ADMINFLESH, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ADMINROTFLESH = block(VoreModModBlocks.ADMINROTFLESH, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FOXBLOCK = block(VoreModModBlocks.FOXBLOCK, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> ANUS = block(VoreModModBlocks.ANUS, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SMALL_ANUS = block(VoreModModBlocks.SMALL_ANUS, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> POO = block(VoreModModBlocks.POO, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> CUM_BUCKET = REGISTRY.register("cum_bucket", () -> new CumItem());
	public static final RegistryObject<Item> BLOOD_BUCKET = REGISTRY.register("blood_bucket", () -> new BloodItem());
	public static final RegistryObject<Item> ACID_BUCKET = REGISTRY.register("acid_bucket", () -> new AcidItem());
	public static final RegistryObject<Item> SHRINK_GUN = REGISTRY.register("shrink_gun", () -> new ShrinkGunItem());
	public static final RegistryObject<Item> BELLYORIGIN = block(VoreModModBlocks.BELLYORIGIN, null);
	public static final RegistryObject<Item> BELLY_EXIT_TRIGGER = block(VoreModModBlocks.BELLY_EXIT_TRIGGER, null);
	public static final RegistryObject<Item> UVULA = block(VoreModModBlocks.UVULA, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SCAB = block(VoreModModBlocks.SCAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FLESH = REGISTRY.register("flesh", () -> new FleshItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
