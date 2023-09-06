
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.jasontable.vore_mod.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.jasontable.vore_mod.VoreModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoreModModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VoreModMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(VoreModModBlocks.FLESHBLOCK.get().asItem());
			tabData.accept(VoreModModBlocks.FLESH_SLAB.get().asItem());
			tabData.accept(VoreModModBlocks.ROTTEN_FLESH_BLOCK.get().asItem());
			tabData.accept(VoreModModBlocks.ROTTEN_FLESH_SLAB.get().asItem());
			tabData.accept(VoreModModBlocks.TONGUE.get().asItem());
			tabData.accept(VoreModModBlocks.TONGUE_SLAB.get().asItem());
			tabData.accept(VoreModModBlocks.SHIT.get().asItem());
			tabData.accept(VoreModModBlocks.SCAB.get().asItem());
			tabData.accept(VoreModModBlocks.ADMINFLESH.get().asItem());
			tabData.accept(VoreModModBlocks.ADMINROTFLESH.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(VoreModModBlocks.FOXBLOCK.get().asItem());
			tabData.accept(VoreModModBlocks.ANUS.get().asItem());
			tabData.accept(VoreModModBlocks.SMALL_ANUS.get().asItem());
			tabData.accept(VoreModModBlocks.POO.get().asItem());
			tabData.accept(VoreModModBlocks.UVULA.get().asItem());
			tabData.accept(VoreModModBlocks.ESOPHAGUS.get().asItem());
			tabData.accept(VoreModModBlocks.THIN_TONGUE.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(VoreModModItems.CUM_BUCKET.get());
			tabData.accept(VoreModModItems.BLOOD_BUCKET.get());
			tabData.accept(VoreModModItems.ACID_BUCKET.get());
			tabData.accept(VoreModModItems.SHRINK_GUN.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(VoreModModItems.FLESH.get());
		}
	}
}
