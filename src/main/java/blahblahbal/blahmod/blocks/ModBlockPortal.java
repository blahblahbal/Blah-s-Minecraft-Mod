package blahblahbal.blahmod.blocks;

import java.util.Random;

import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ModBlockPortal extends BlockPortal
{
	public ModBlockPortal()
	{
		super();
	}
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		if (worldIn.provider.getDimensionId() != -1)
		{
			return;
		}
		super.updateTick(worldIn, pos, state, rand);
    }
}
