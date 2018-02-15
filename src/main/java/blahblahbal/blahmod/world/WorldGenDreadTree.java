package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.ModBlockDreadLog;
import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenDreadTree extends WorldGenAbstractTree
{
	private static final IBlockState log = ModBlocks.dreadLog.getDefaultState().withProperty(ModBlockDreadLog.LOG_AXIS, EnumAxis.Y);
	public WorldGenDreadTree(boolean p_i45448_1_) {
		super(false);
	}
	public WorldGenDreadTree(World w, Random r, BlockPos bp)
	{
		super(true);
		generate(w, r, bp);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		if (position.getY() < 10 || position.getY() > 240) return false;
		if (worldIn.getBlockState(position.down()).getBlock() != ModBlocks.dreadSand) return false;
		for (int y = position.getY(); y < position.getY() + 7; y++)
		{
			if (worldIn.getChunkProvider().chunkExists(position.getX() >> 4, position.getZ() >> 4))
				this.setBlockAndNotifyAdequately(worldIn, new BlockPos(position.getX(), y, position.getZ()), log);
		}
		return true;
	}

}
