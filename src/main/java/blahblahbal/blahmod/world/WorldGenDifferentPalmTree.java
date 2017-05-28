package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.BlockPalmLeaves;
import blahblahbal.blahmod.blocks.ModBlockPalmLog;
import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDifferentPalmTree extends WorldGenAbstractTree
{
	private static final IBlockState log = ModBlocks.palmLog.getDefaultState().withProperty(ModBlockPalmLog.LOG_AXIS, EnumAxis.Y);
    private static final IBlockState leaves = ModBlocks.palmLeaves.getDefaultState().withProperty(BlockPalmLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockPalmLeaves.DECAYABLE, Boolean.valueOf(false));
    private static final IBlockState coco = ModBlocks.coconut.getDefaultState();
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
    	{0, 7, -4}, {1, 7, -4}, {-1, 7, -4},
    	{0, 7, 1},
    	{0, 7, -5},
    	{-4, 7, -3},
    	{4, 7, -3}
    };
    private int[][] cocoPos = new int[][]
    {
    	{0, 7, -4}, {0, 7, -2}, {1, 7, -3}, {-1, 7, -3}
    };
    
 
	// the logs' position array
    /*private int[][] logPos = new int[][]
    {
    	{0, 0, 0}, {0, 1, 0}, {0, 2, 0}, {0, 3, 0},
    	{0, 4, 0}, {0, 5, 0}, {0, 6, 0}, {0, 7, 0}
    };*/
    // modify the leaf positions
    
    // the leaves' position array
    /*private int[][] leavesPos = new int[][]
    {
    	// middle 9 blocks
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
    };*/
    private int[][] cocoPos1 = new int[][]
    {
    	{0, 7, -3}, {0, 7, -1}, {1, 7, -2}, {-1, 7, -2}
    };
    private int[][] cocoPos2 = new int[][]
    {
    	{0, 7, 1}, {0, 7, 3}, {1, 7, 2}, {-1, 7, 2}
    };
    private int[][] cocoPos3 = new int[][]
    {
    	{-2, 7, -1}, {-2, 7, 1}, {-1, 7, 0}, {-3, 7, 0}
    };
    private int[][] cocoPos4 = new int[][]
    {
    	{2, 7, -1}, {2, 7, 1}, {3, 7, 0}, {1, 7, 0}
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

	public boolean generate(World world, Random random, BlockPos pos)
	{
		if (world.getBlockState(pos.down()).getBlock() != ModBlocks.blackSand && world.getBlockState(pos.down()).getBlock() != Blocks.sand || pos.getY() > 255) return false;
		
		int heightMinusTop = 8 - 1;
		boolean doSlant = true;
        EnumFacing direction = EnumFacing.random(random); //The direction the palm tree curves towards
        if (direction == EnumFacing.DOWN || direction == EnumFacing.UP)
        {
        	doSlant = false;
        }
        double baseSlant = random.nextInt(35) / 100D; 
        double slantMultiplier = 1.3D;
        
        
        double slantOffset = baseSlant;
        
        // Generate trunk of tree (trunk only)
        for(int step = 0; step <= heightMinusTop; step++)
        {
        	BlockPos offsetPos = pos.up(step);
        	
        	if (doSlant)
        	{
        		offsetPos = pos.up(step).offset(direction, (int)Math.floor(slantOffset));
        	}
            
            if (step == heightMinusTop)
            {
                // Generate top of tree
            	createLeafStructure(world, offsetPos);
                break;
            }
            
            world.setBlockState(offsetPos, log, 2);
            
            //As the height increases, slant more drastically
            slantOffset *= slantMultiplier;
        }
		/*int rn = arg1.nextInt(4);
		if (rn == 0)
		{
			buildLayer(arg0, arg2, logPosMod1, log);
			buildLayer(arg0, arg2, leafPosMod1, leaves);
			buildLayer(arg0, arg2, cocoPos1, coco);
		}
		else if (rn == 1)
		{
			buildLayer(arg0, arg2, logPosMod2, log);
			buildLayer(arg0, arg2, leafPosMod2, leaves);
			buildLayer(arg0, arg2, cocoPos2, coco);
		}
		else if (rn == 2)
		{
			buildLayer(arg0, arg2, logPosMod3, log);
			buildLayer(arg0, arg2, leafPosMod3, leaves);
			buildLayer(arg0, arg2, cocoPos3, coco);
		}
		else if (rn == 3)
		{
			buildLayer(arg0, arg2, logPosMod4, log);
			buildLayer(arg0, arg2, leafPosMod4, leaves);
			buildLayer(arg0, arg2, cocoPos4, coco);
		}
		buildLayer(arg0, arg2, logPosMod1, log);
		buildLayer(arg0, arg2, leafPosMod1, leaves);
		buildLayer(arg0, arg2, cocoPos1, coco);*/
		return true;
	}
	public void createLeafStructure(World w, BlockPos bp)
	{
		setLeaf(w, bp.add(-1, 0, -1), false);
		setLeaf(w, bp.add(0, 0, -1), false);
		setLeaf(w, bp.add(1, 0, -1), false);
		setLeaf(w, bp.add(-1, 0, 0), false);
		setLeaf(w, bp.add(0, 0, 0), false);
		setLeaf(w, bp.add(1, 0, 0), false);
		setLeaf(w, bp.add(-1, 0, 1), false);
		setLeaf(w, bp.add(0, 0, 1), false);
		setLeaf(w, bp.add(1, 0, 1), false);
		setLeaf(w, bp.add(0, 0, -2), false);
		setLeaf(w, bp.add(0, 0, -3), false);
		setLeaf(w, bp.add(1, 0, -2), false);
		setLeaf(w, bp.add(1, 0, -3), false);
		setLeaf(w, bp.add(-1, 0, -2), false);
		setLeaf(w, bp.add(-1, 0, -3), false);
		setLeaf(w, bp.add(2, 0, 0), false);
		setLeaf(w, bp.add(2, 0, -1), false);
		setLeaf(w, bp.add(2, 0, -2), false);
		setLeaf(w, bp.add(-2, 0, 0), false);
		setLeaf(w, bp.add(-2, 0, -1), false);
		setLeaf(w, bp.add(-2, 0, -2), false);
		setLeaf(w, bp.add(3, -1, 0), false);
		setLeaf(w, bp.add(3, -1, -1), false);
		setLeaf(w, bp.add(3, -1, -2), false);
		setLeaf(w, bp.add(-3, -1, 0), false);
		setLeaf(w, bp.add(-3, -1, -1), false);
		setLeaf(w, bp.add(-3, -1, -2), false);
		setLeaf(w, bp.add(0, -1, 2), false);
		setLeaf(w, bp.add(1, -1, 2), false);
		setLeaf(w, bp.add(-1, -1, 2), false);
		setLeaf(w, bp.add(0, -1, -4), false);
		setLeaf(w, bp.add(1, -1, -4), false);
		setLeaf(w, bp.add(-1, -1, -4), false);
		setLeaf(w, bp.add(0, -1, 3), false);
		setLeaf(w, bp.add(0, -1, -5), false);
		setLeaf(w, bp.add(-4, -1, -1), false);
		setLeaf(w, bp.add(4, -1, -1), false);
		setLeaf(w, bp.add(0, -1, 0), true);
		setLeaf(w, bp.add(0, -1, -2), true);
		setLeaf(w, bp.add(-1, -1, -1), true);
		setLeaf(w, bp.add(1, -1, -1), true);
	}
	public void setLeaf(World w, BlockPos bp, boolean coco)
	{
		if (!coco) w.setBlockState(bp, leaves, 2);
		else w.setBlockState(bp,  this.coco, 2);
		
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
