package blahblahbal.blahmod.blocks;

import java.util.List;
import java.util.Random;

import blahblahbal.blahmod.Main;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockLeaves extends BlockLeaves
{
	public static String name;
	public ModBlockLeaves(String name)
	{
		this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false)));
		setUnlocalizedName(name);
		this.name = name;
		setCreativeTab(Main.blahTabBlock);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if (rand.nextInt(70) == 0)
			return Item.getItemFromBlock(ModBlocks.sequoiaSapling);
		return null;
	}

	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance)
	{
		if (worldIn.rand.nextInt(chance) == 0) {
			spawnAsEntity(worldIn, pos, new ItemStack(Items.apple, 1, 0));
		}
	}

	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}

	public int getMetaFromState(IBlockState state)
	{
		byte b0 = 0;
		int i = b0;

		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue())
		{
			i |= 4;
		}

		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |= 8;
		}

		return i;
	}

	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { CHECK_DECAY, DECAYABLE });
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return Blocks.leaves.getBlockLayer();
	}

	@Override
	public List<ItemStack> onSheared(ItemStack arg0, IBlockAccess arg1, BlockPos arg2, int arg3)
	{
		IBlockState state = arg1.getBlockState(arg2);
		return new java.util.ArrayList(java.util.Arrays.asList(new ItemStack(this, 1, 0)));
	}
	public boolean isOpaqueCube()
    {
        return false;
    }
	@Override
	public EnumType getWoodType(int arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
