
package net.jasontable.vore_mod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

import net.jasontable.vore_mod.init.VoreModModFluids;

public class CumBlock extends LiquidBlock {
	public CumBlock() {
		super(() -> VoreModModFluids.CUM.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f).noCollission().noLootTable());
	}
}
