package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.BlockCedarLeaves;
import blahblahbal.blahmod.blocks.BlockPalmLeaves;
import blahblahbal.blahmod.blocks.ModBlockCedarLog;
import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenCedarTree extends WorldGenAbstractTree
{
	private static final IBlockState log = ModBlocks.cedarLog.getDefaultState().withProperty(ModBlockCedarLog.LOG_AXIS, EnumAxis.Y);
	private static final IBlockState leaf = ModBlocks.cedarLeaves.getDefaultState().withProperty(BlockCedarLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockCedarLeaves.DECAYABLE, Boolean.valueOf(true));
	public WorldGenCedarTree(boolean f)
	{
		super(false);
	}
	public WorldGenCedarTree(World w, Random r, BlockPos bp)
	{
		super(true);
		generate(w, r, bp);
	}
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		if (position.getY() < 10 || position.getY() > 240) return false;
		if (worldIn.getBlockState(position.down()).getBlock() != Blocks.dirt && worldIn.getBlockState(position.down()).getBlock() != Blocks.grass) return false;
		int rn = rand.nextInt(5);
		int leafRad = rand.nextInt(2) + 4;
		
		int TOP_POS = position.getY() + rn + 14;
		int distTopBot = (TOP_POS) - (position.getY() + 4);			// distance between the top and the bottom minus 4
		int middleTopBot = (int)(distTopBot / 2);					// the middle
		int TOP_HALF_POS = TOP_POS - middleTopBot;					// the top half position
		int distTopToHalf = TOP_POS - TOP_HALF_POS;					// distance between top and middle
		int middleTopHalf = (int)(distTopToHalf / 2);				// the middle between top and middle
		int TOP_QUARTER_POS = TOP_POS - middleTopHalf;				// the top quarter position
		int distTopToQuarter = TOP_POS - TOP_QUARTER_POS;			// distance between top and quarter
		int middleTopQuarter = (int)(distTopToQuarter / 2);			// the middle between top and quarter
		int TOP_EIGHTH_POS = TOP_POS - middleTopQuarter;			// the top eighth position
		
		for (int x = position.getX(); x <= position.getX() + 1; x++)
		{
			for (int z = position.getZ(); z <= position.getZ() + 1; z++)
			{
				for (int y = position.getY(); y <= position.getY() + rn + 14; y++)
				{
					if (y >= position.getY() + 4 && y < TOP_HALF_POS)
					{
						if (worldIn.getChunkProvider().chunkExists(x >> 4, z >> 4))
							makeCircle(x, y, z, leafRad, leaf, worldIn);
					}
					else if (y >= TOP_HALF_POS && y < TOP_QUARTER_POS)
					{
						if (worldIn.getChunkProvider().chunkExists(x >> 4, z >> 4))
							makeCircle(x, y, z, leafRad - 1, leaf, worldIn);
					}
					else if (y >= TOP_QUARTER_POS && y < TOP_EIGHTH_POS)
					{
						if (worldIn.getChunkProvider().chunkExists(x >> 4, z >> 4))
							makeCircle(x, y, z, leafRad - 2, leaf, worldIn);
					}
					else if (y >= TOP_EIGHTH_POS)
					{
						if (worldIn.getChunkProvider().chunkExists(x >> 4, z >> 4))
							makeCircle(x, y, z, leafRad - 3, leaf, worldIn);
					}
					//if (world.checkChunksExist(j1,posY, l1,j1,posY, l1)) {
					
				}
			}
		}
		for (int x = position.getX(); x <= position.getX() + 1; x++)
		{
			for (int z = position.getZ(); z <= position.getZ() + 1; z++)
			{
				for (int y = position.getY(); y <= position.getY() + rn + 14; y++)
				{
					if (y < position.getY() + rn + 12)
						if (worldIn.getChunkProvider().chunkExists(x >> 4, z >> 4))
							this.setBlockAndNotifyAdequately(worldIn, new BlockPos(x, y, z), log);
				}
			}
		}
		return true;
	}
	public void makeCircle(int x, int y, int z, float r, IBlockState state, World world)
	{
		int fx = (int)(x - r); //first x
		int fy = (int)(z - r); //first y
		int lx = (int)(x + r); //last x
		int ly = (int)(z + r); //last y
		for (int i = fx; i < lx + 1; i++)
		{
			for (int j = fy; j < ly + 1; j++)
			{
				if (distance(i, j, x, z) <= r)
				{
					if (state == null) world.setBlockToAir(new BlockPos(i, y, j));
					else
					{
						if (world.getChunkProvider().chunkExists(i >> 4, j >> 4))
							this.setBlockAndNotifyAdequately(world, new BlockPos(i, y, j), state);
					}
				}
			}
		}
	}
	public static float distance(float x1, float y1, float x2, float y2)
	{
		final float x_d = x2 - x1;
		final float y_d = y2 - y1;
		return (float)Math.sqrt(x_d * x_d + y_d * y_d);
	}
}
