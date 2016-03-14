package blahmod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import blahmod.blocks.ModBlockFluid;
import blahmod.blocks.ModBlocks;
import blahmod.items.ModItems;

public class ModFluids
{
	public static Fluid normal;
	public static Block b;

	/**
	 * The fluids registered by this mod. Includes fluids that were already registered by another mod.
	 */
	public static final Set<Fluid> fluids = new HashSet<>();

	/**
	 * The fluid blocks from this mod only. Doesn't include blocks for fluids that were already registered by another mod.
	 */
	public static final Set<IFluidBlock> modFluidBlocks = new HashSet<>();

	public static void registerFluids() {

		normal = createFluid("acid", true,
				fluid -> fluid.setLuminosity(7).setDensity(1000).setViscosity(1000),
				fluid -> new ModBlockFluid(fluid, new MaterialLiquid(MapColor.limeColor), "acid"));
	}

	public static void registerFluidContainers() {
		for (Fluid fluid : fluids) {
			registerBucket(fluid);
		}
	}

	/**
	 * Create a {@link Fluid} and its {@link IFluidBlock}, or use the existing ones if a fluid has already been registered with the same name.
	 *
	 * @param name                 The name of the fluid
	 * @param hasFlowIcon          Does the fluid have a flow icon?
	 * @param fluidPropertyApplier A function that sets the properties of the {@link Fluid}
	 * @param blockFactory         A function that creates the {@link IFluidBlock}
	 * @return The fluid and block
	 */
	private static <T extends Block & IFluidBlock> Fluid createFluid(String name, boolean hasFlowIcon, Consumer<Fluid> fluidPropertyApplier, Function<Fluid, T> blockFactory) {
		final String texturePrefix = "blahmod:blocks/fluid_";

		ResourceLocation still = new ResourceLocation(texturePrefix + name + "_still");
		ResourceLocation flowing = hasFlowIcon ? new ResourceLocation(texturePrefix + name + "_flowing") : still;

		Fluid fluid = new Fluid(name, still, flowing);
		boolean useOwnFluid = FluidRegistry.registerFluid(fluid);

		if (useOwnFluid) {
			fluidPropertyApplier.accept(fluid);
			b = registerFluidBlock(blockFactory.apply(fluid));
		} else {
			fluid = FluidRegistry.getFluid(name);
		}

		fluids.add(fluid);

		return fluid;
	}

	private static <T extends Block & IFluidBlock> T registerFluidBlock(T block) {
		block.setRegistryName("fluid." + block.getFluid().getName());
		block.setUnlocalizedName("blahmod:" + block.getFluid().getUnlocalizedName());
		block.setCreativeTab(CreativeTabs.tabMisc);
		GameRegistry.registerBlock(block);

		modFluidBlocks.add(block);

		return block;
	}

	private static void registerBucket(Fluid fluid)
	{
		FluidRegistry.addBucketForFluid(fluid);
	}
}