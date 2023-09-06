
package net.jasontable.vore_mod.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.jasontable.vore_mod.init.VoreModModItems;
import net.jasontable.vore_mod.init.VoreModModFluids;
import net.jasontable.vore_mod.init.VoreModModFluidTypes;
import net.jasontable.vore_mod.init.VoreModModBlocks;

public abstract class BloodFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> VoreModModFluidTypes.BLOOD_TYPE.get(), () -> VoreModModFluids.BLOOD.get(), () -> VoreModModFluids.FLOWING_BLOOD.get()).explosionResistance(100f)
			.bucket(() -> VoreModModItems.BLOOD_BUCKET.get()).block(() -> (LiquidBlock) VoreModModBlocks.BLOOD.get());

	private BloodFluid() {
		super(PROPERTIES);
	}

	public static class Source extends BloodFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends BloodFluid {
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
