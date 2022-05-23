
package net.jasontable.vore_mod.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import net.jasontable.vore_mod.init.VoreModModItems;
import net.jasontable.vore_mod.init.VoreModModFluids;
import net.jasontable.vore_mod.init.VoreModModBlocks;

public abstract class CumFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(VoreModModFluids.CUM, VoreModModFluids.FLOWING_CUM,
			FluidAttributes.builder(new ResourceLocation("vore_mod:blocks/cum1"), new ResourceLocation("vore_mod:blocks/cum1"))

					.viscosity(1700)

	).explosionResistance(100f)

			.bucket(VoreModModItems.CUM_BUCKET).block(() -> (LiquidBlock) VoreModModBlocks.CUM.get());

	private CumFluid() {
		super(PROPERTIES);
	}

	public static class Source extends CumFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CumFluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
