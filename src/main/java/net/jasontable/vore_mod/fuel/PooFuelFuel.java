
package net.jasontable.vore_mod.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.jasontable.vore_mod.block.PooBlock;
import net.jasontable.vore_mod.VoreModModElements;

@VoreModModElements.ModElement.Tag
public class PooFuelFuel extends VoreModModElements.ModElement {
	public PooFuelFuel(VoreModModElements instance) {
		super(instance, 45);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(PooBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
