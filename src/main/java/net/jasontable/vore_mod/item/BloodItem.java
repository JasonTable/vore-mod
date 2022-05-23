
package net.jasontable.vore_mod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import net.jasontable.vore_mod.init.VoreModModFluids;

public class BloodItem extends BucketItem {
	public BloodItem() {
		super(VoreModModFluids.BLOOD,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
	}
}
