
package net.jasontable.vore_mod.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.jasontable.vore_mod.block.PooBlock;

@Mod.EventBusSubscriber
public class PooFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == PooBlock.block.asItem())
			event.setBurnTime(300);
	}
}
