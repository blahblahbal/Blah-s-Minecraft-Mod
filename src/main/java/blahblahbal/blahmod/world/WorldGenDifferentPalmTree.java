package main.java.blahblahbal.blahmod.world;

import java.util.Random;

import main.java.blahblahbal.blahmod.blocks.BlockPalmLeaves;
import main.java.blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDifferentPalmTree extends WorldGenAbstractTree
{
	private static final IBlockState log = ModBlocks.palmLog.getDefaultState();
    private static final IBlockState leaves = ModBlocks.palmLeaves.getDefaultState().withProperty(BlockPalmLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockPalmLeaves.DECAYABLE, Boolean.valueOf(false));
    private static final IBlockState coco = ModBlocks.coconut.getDefaultState();
    // modify the positions of the logPos array with other arrays
    private int[][] logPosMod1 = new int[][]
    {
    	{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    	{0, 0, -1}, {0, 0, -1}, {0, 0, -2}, {0, 0, -3}
    };
    private int[][] logPosMod2 = new int[][]
    {
    	{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    	{0, 0, 1}, {0, 0, 1}, {0, 0, 2}, {0, 0, 3}
    };
    private int[][] logPosMod3 = new int[][]
    {
    	{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    	{-1, 0, 0}, {-1, 0, 0}, {-2, 0, 0}, {-3, 0, 0}
	};
	private int[][] logPosMod4 = new int[][]
    {
    	{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0},
    	{1, 0, 0}, {1, 0, 0}, {2, 0, 0}, {3, 0, 0}
	};
	// the logs' position array
    private int[][] logPos = new int[][]
    {
    	{0, 0, 0}, {0, 1, 0}, {0, 2, 0}, {0, 3, 0},
    	{0, 4, 0}, {0, 5, 0}, {0, 6, 0}, {0, 7, 0}
    };
    // modify the leaf positions
    private int[][] leafPosMod1 = new int[][]
    {
    	{0, 0, -2}
    };
    private int[][] leafPosMod2 = new int[][]
    {
    	{0, 0, 2}
    };
    private int[][] leafPosMod3 = new int[][]
    {
    	{-2, 0, 0}
    };
    private int[][] leafPosMod4 = new int[][]
    {
    	{2, 0, 0}
    };
    // the leaves' position array
    private int[][] leavesPos = new int[][]
    {
    	{-1, 8, -1}, {0, 8, -1}, {1, 8, -1},
    	{-1, 8, 0}, {0, 8, 0}, {1, 8, 0},
    	{-1, 8, 1}, {0, 8, 1}, {1, 8, 1},
    	{0, 8, -2}, {0, 8, -3},
    	{1, 8, -2}, {1, 8, -3},
    	{-1, 8, -2}, {-1, 8, -3},
    	{2, 8, 0}, {2, 8, -1}, {2, 8, -2},
    	{-2, 8, 0}, {-2, 8, -1}, {-2, 8, -2},
    	{3, 7, 0}, {3, 7, -1}, {3, 7, -2},
    	{-3, 7, 0}, {-3, 7, -1}, {-3, 7, -2},
    	{0, 7, 2}, {1, 7, 2}, {-1, 7, 2},
    	{0, 7, 8}, {1, 7, 8}, {-1, 7, 8},
    	{0, 7, 3},
    	{0, 7, 9},
    	{-4, 7, -1},
    	{4, 7, -1}
    };
    private int[][] cocoPos = new int[][]
    {
    	{0, 7, -2}, {0, 7, 0}, {1, 7, -1}, {-1, 7, -1}
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
		if (arg0.getBlockState(arg2.down()).getBlock() != ModBlocks.blackSand) return false;
		int rn = arg1.nextInt(4);
		if (rn == 0)
		{
			for (int i = 0; i < logPos.length; i++)
			{
				for (int j = 0; j < logPos[i].length; j++)
				{
					logPos[i][j] += logPosMod1[i][j];
				}
			}
			for (int i = 0; i < leavesPos.length; i++)
			{
				for (int j = 0; j < leavesPos[i].length; j++)
				{
					leavesPos[i][j] += leafPosMod1[0][j];
				}
			}
			for (int i = 0; i < cocoPos.length; i++)
			{
				for (int j = 0; j < cocoPos[i].length; j++)
				{
					cocoPos[i][j] += leafPosMod1[0][j];
				}
			}
		}
		else if (rn == 1)
		{
			for (int i = 0; i < logPos.length; i++)
			{
				for (int j = 0; j < logPos[i].length; j++)
				{
					logPos[i][j] += logPosMod2[i][j];
				}
			}
			for (int i = 0; i < leavesPos.length; i++)
			{
				for (int j = 0; j < leavesPos[i].length; j++)
				{
					leavesPos[i][j] += leafPosMod2[0][j];
				}
			}
			for (int i = 0; i < cocoPos.length; i++)
			{
				for (int j = 0; j < cocoPos[i].length; j++)
				{
					cocoPos[i][j] += leafPosMod2[0][j];
				}
			}
		}
		else if (rn == 2)
		{
			for (int i = 0; i < logPos.length; i++)
			{
				for (int j = 0; j < logPos[i].length; j++)
				{
					logPos[i][j] += logPosMod3[i][j];
				}
			}
			for (int i = 0; i < leavesPos.length; i++)
			{
				for (int j = 0; j < leavesPos[i].length; j++)
				{
					leavesPos[i][j] += leafPosMod3[0][j];
				}
			}
			for (int i = 0; i < cocoPos.length; i++)
			{
				for (int j = 0; j < cocoPos[i].length; j++)
				{
					cocoPos[i][j] += leafPosMod3[0][j];
				}
			}
		}
		else if (rn == 3)
		{
			for (int i = 0; i < logPos.length; i++)
			{
				for (int j = 0; j < logPos[i].length; j++)
				{
					logPos[i][j] += logPosMod4[i][j];
				}
			}
			for (int i = 0; i < leavesPos.length; i++)
			{
				for (int j = 0; j < leavesPos[i].length; j++)
				{
					leavesPos[i][j] += leafPosMod4[0][j];
				}
			}
			for (int i = 0; i < cocoPos.length; i++)
			{
				for (int j = 0; j < cocoPos[i].length; j++)
				{
					cocoPos[i][j] += leafPosMod4[0][j];
				}
			}
		}
		buildLayer(arg0, arg2, logPos, log);
		buildLayer(arg0, arg2, leavesPos, leaves);
		buildLayer(arg0, arg2, cocoPos, coco);
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
