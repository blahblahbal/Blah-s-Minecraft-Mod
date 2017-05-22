package blahmod.world;

import java.util.Random;

import blahmod.blocks.BlockPalmLeaves;
import blahmod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDifferentPalmTree extends WorldGenAbstractTree
{
	private static final IBlockState log = ModBlocks.palmLog.getDefaultState();
    private static final IBlockState leaves = ModBlocks.palmLeaves.getDefaultState().withProperty(BlockPalmLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockPalmLeaves.DECAYABLE, Boolean.valueOf(false));
    private int[][] logPos = new int[][]
    {
    	{0, 0, 0}, {0, 1, 0}, {0, 2, 0}, {0, 3, 0},
    	{0, 4, -1}, {0, 5, -1}, {0, 6, -2}, {0, 7, -3}
    };
    private int[][] leavesPos = new int[][]
    {
    	{0, 8, -3}, {0, 8, -2}, {0, 8, -1},
    	{1, 8, -3}, {1, 8, -2}, {1, 8, -1},
    	{-1, 8, -3}, {-1, 8, -2}, {-1, 8, -1},
    	{0, 8, -4}, {0, 8, -5},
    	{1, 8, -4}, {1, 8, -5},
    	{-1, 8, -4}, {-1, 8, -5},
    	{2, 8, -2}, {2, 8, -3}, {2, 8, -4},
    	{-2, 8, -2}, {-2, 8, -3}, {-2, 8, -4},
    	{3, 7, -2}, {3, 7, -3}, {3, 7, -4},
    	{-3, 7, -2}, {-3, 7, -3}, {-3, 7, -4},
    	{0, 7, 0}, {1, 7, 0}, {-1, 7, 0},
    	{0, 7, -6}, {1, 7, -6}, {-1, 7, -6},
    	{0, 7, 1},
    	{0, 7, -7},
    	{-4, 7, -3},
    	{4, 7, -3}
    };
    public WorldGenDifferentPalmTree(boolean f)
    {
    	super(false);
    }
	public WorldGenDifferentPalmTree(World worldIn, Random rand, BlockPos pos)
	{
		super(true);
		generate(worldIn, rand, pos);
	}
	@Override
	public boolean generate(World arg0, Random arg1, BlockPos arg2)
	{
		buildLayer(arg0, arg2, logPos, log);
		buildLayer(arg0, arg2, leavesPos, leaves);
		return true;
	}
	private void buildLayer(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
	{
		// iterate through the entire int[][]
		for(int[] coord : blockPositions)
		{
			placeBlock(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
		}
	}
	/** Helper Method **/
	private void placeBlock(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
	{
		placeBlock(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
	}

	/** Places a block using corner position and offsets **/
	private void placeBlock(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
	{	
		// figure out where that block is relative to the corner
		BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
		world.setBlockState(placePos, toPlace, 2);
	}
}
