package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.ModBlockFrostLeaves;
import blahblahbal.blahmod.blocks.ModBlockFrostLog;
import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFrostTree extends WorldGenAbstractTree
{
    private static final IBlockState log = ModBlocks.frostLog.getDefaultState().withProperty(ModBlockFrostLog.LOG_AXIS, EnumAxis.Y);
    private static final IBlockState logX = ModBlocks.frostLog.getDefaultState().withProperty(ModBlockFrostLog.LOG_AXIS, EnumAxis.X);
    private static final IBlockState logZ = ModBlocks.frostLog.getDefaultState().withProperty(ModBlockFrostLog.LOG_AXIS, EnumAxis.Z);
    private static final IBlockState leaves = ModBlocks.frostLeaves.getDefaultState().withProperty(ModBlockFrostLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(ModBlockFrostLeaves.DECAYABLE, Boolean.valueOf(true));
    private int[][] logYPos = new int[][]
    {
    	{0, 0, 0}, {0, 1, 0}, {0, 2, 0}, {0, 3, 0}, {0, 4, 0}, {0, 5, 0}, {0, 6, 0}
    };
    private int[][] logXPos = new int[][]
    {
        {-1, 2, 0}, {-2, 2, 0}, {1, 2, 0}, {2, 2, 0},
        {-1, 4, 0}, {1, 4, 0}
    };
    private int[][] logZPos = new int[][]
    {
        {0, 2, -1}, {0, 2, -2}, {0, 2, 1}, {0, 2, 2},
        {0, 4, -1}, {0, 4, 1}
    };
    private int[][] leavesPos = new int[][]
    {
    	{1, 2, 1}, {1, 2, -1}, {-1, 2, 1}, {-1, 2, -1},
        {2, 2, 1}, {1, 2, 2}, {-1, 2, 2}, {-2, 2, 1}, {2, 2, -1}, {1, 2, -2}, {-2, 2, -1}, {-1, 2, -2},
        {3, 2, 0}, {0, 2, 3}, {-3, 2, 0}, {0, 2, -3},
        {1, 3, 1}, {1, 3, -1}, {-1, 3, 1}, {-1, 3, -1},
        {-1, 3, 0}, {-2, 3, 0}, {1, 3, 0}, {2, 3, 0},
        {0, 3, -1}, {0, 3, -2}, {0, 3, 1}, {0, 3, 2},
        {1, 4, 1}, {1, 4, -1}, {-1, 4, 1}, {-1, 4, -1},
        {2, 4, 0}, {-2, 4, 0}, {0, 4, 2}, {0, 4, -2},
        {1, 5, 0}, {0, 5, 1}, {-1, 5, 0}, {0, 5, -1},
	    {1, 6, 0}, {0, 6, 1}, {-1, 6, 0}, {0, 6, -1},
        {0, 7, 0}, {0, 8, 0}
    };
    public WorldGenFrostTree(boolean f)
    {
    	super(false);
    }
	public WorldGenFrostTree(World worldIn, Random rand, BlockPos pos)
	{
		super(true);
		generate(worldIn, rand, pos);
	}

	public boolean generate(World world, Random random, BlockPos pos)
	{		
		buildLayer(world, pos, logYPos, log);
		buildLayer(world, pos, logXPos, logX);
		buildLayer(world, pos, logZPos, logZ);
		buildLayer(world, pos, leavesPos, leaves);
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