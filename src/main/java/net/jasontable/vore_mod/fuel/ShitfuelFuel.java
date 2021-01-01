
package net.jasontable.vore_mod.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.jasontable.vore_mod.block.ShitBlock;
import net.jasontable.vore_mod.VoreModModElements;

@VoreModModElements.ModElement.Tag
public class ShitfuelFuel extends VoreModModElements.ModElement {
	public ShitfuelFuel(VoreModModElements instance) {
		super(instance, 23);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(ShitBlock.block, (int) (1)).getItem())
			event.setBurnTime(3200);
	}
}
