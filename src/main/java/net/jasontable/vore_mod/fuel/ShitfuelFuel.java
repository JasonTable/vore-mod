
package net.jasontable.vore_mod.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.jasontable.vore_mod.block.ShitBlock;

@Mod.EventBusSubscriber
public class ShitfuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == ShitBlock.block.asItem())
			event.setBurnTime(3200);
	}
}
