package main.java.blahblahbal.blahmod.world;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;

import main.java.blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureTreeHouse extends WorldGenerator
{
	/** BLUEPRINTS **/
	// Format: int[][] { {distanceRight, distanceUp, distanceBack} } 
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
	private final int[][] birchLogsPos = new int[][]
	{ 
		{0, 0, 0}, {0, 0, 1}, {1, 0, 0}, {1, 0, 1},
		{0, 4, 0}, {0, 4, 1}, {1, 4, 0}, {1, 4, 1}
	};
	private final int[][] jungleLogsPos = new int[][]
	{
		{0, 1, 0}, {0, 1, 1}, {1, 1, 0}, {1, 1, 1}
	};
	private final int[][] jungleLogsPosX = new int[][]
	{
		{-1, 5, 0}, {-1, 5, 1}, {-2, 5, 0}, {-2, 5, 1}, // left
		{2, 5, 0}, {2, 5, 1}, {3, 5, 0}, {3, 5, 1}, // right
		{-3, 6, 0}, {-3, 6, 1},
		{0, 6, 4}, {1, 6, 4}
	};
	private final int[][] jungleLogsPosZ = new int[][]
	{
		{0, 5, 2}, {1, 5, 2}, {0, 5, 3}, {1, 5, 3}, // back
		{0, 5, -1}, {1, 5, -1}, {0, 5, -2}, {1, 5, -2}, // front
		{4, 6, 0}, {4, 6, 1},
		{0, 6, -3}, {1, 6, -3}
	};
	private final int[][] spruceLogsPos = new int[][]
	{
		{0, 2, 0}, {0, 2, 1}, {1, 2, 0}, {1, 2, 1}, // trunk
		{-5, 8, 0}, {-5, 8, 1}, {-5, 9, 0}, {-5, 9, 1}, {-5, 10, 0}, {-5, 10, 1},
		{6, 8, 0}, {6, 8, 1}, {6, 9, 0}, {6, 9, 1}, {6, 10, 0}, {6, 10, 1},
		{0, 8, -5}, {1, 8, -5}, {0, 9, -5}, {1, 9, -5}, {0, 10, -5}, {1, 10, -5},
		{0, 8, 6}, {1, 8, 6}, {0, 9, 6}, {1, 9, 6}, {0, 10, 6}, {1, 10, 6}
	};
	private final int[][] glowstonePos = new int[][]
	{
		{0, 13, 0}, {0, 13, 1}, {1, 13, 0}, {1, 13, 1}
	};
	private final int[][] acaciaLogsPos = new int[][]
	{
		{0, 3, 0}, {0, 3, 1}, {1, 3, 0}, {1, 3, 1}
	};
	private final int[][] jungleLeavesPos = new int[][]
	{
		{-1, 5, -1}, {2, 5, 2}, {-1, 5, 2}, {2, 5, -1}, // corners
		{-1, 6, -1}, {2, 6, 2}, {-1, 6, 2}, {2, 6, -1},
		{-1, 7, -1}, {2, 7, 2}, {-1, 7, 2}, {2, 7, -1},
		{-1, 7, 0}, {-1, 7, 1},
		{1, 7, 2}, {2, 7, 2},
		{2, 7, 0}, {2, 7, 1},
		{0, 7, -1}, {1, 7, -1},
		{0, 7, 2},
		{-4, 9, -4}, {-3, 9, -4}, {-2, 9, -4}, {-1, 9, -4}, {0, 9, -4}, {1, 9, -4}, {2, 9, -4}, {3, 9, -4}, {4, 9, -4}, {5, 9, -4},
		{-4, 9, -3}, {-3, 9, -3}, {-2, 9, -3}, {-1, 9, -3}, {0, 9, -3}, {1, 9, -3}, {2, 9, -3}, {3, 9, -3}, {4, 9, -3}, {5, 9, -3},
		{-4, 9, -2}, {-3, 9, -2}, {-4, 9, -1}, {-3, 9, -1},
		{-4, 9, 0}, {-3, 9, 0}, {-4, 9, 1}, {-3, 9, 1},
		{-4, 9, 2}, {-3, 9, 2}, {-4, 9, 3}, {-3, 9, 3},
		{4, 9, -2}, {5, 9, -2}, {4, 9, -1}, {5, 9, -1},
		{4, 9, 0}, {5, 9, 0}, {4, 9, 1}, {5, 9, 1},
		{4, 9, 2}, {5, 9, 2}, {4, 9, 3}, {5, 9, 3},
		{-4, 9, 4}, {-3, 9, 4}, {-2, 9, 4}, {-1, 9, 4}, {0, 9, 4}, {1, 9, 4}, {2, 9, 4}, {3, 9, 4}, {4, 9, 4}, {5, 9, 4},
		{-4, 9, 5}, {-3, 9, 5}, {-2, 9, 5}, {-1, 9, 5}, {0, 9, 5}, {1, 9, 5}, {2, 9, 5}, {3, 9, 5}, {4, 9, 5}, {5, 9, 5},
		{-4, 10, -2}, {-4, 10, -1},
		{-4, 10, 0}, {-4, 10, 1},
		{-4, 10, 2}, {-4, 10, 3},
		{5, 10, -2}, {5, 10, -1},
		{5, 10, 0}, {5, 10, 1},
		{5, 10, 2}, {5, 10, 3},
		{-4, 10, -3}, {-4, 10, 4}, {5, 10, -3}, {5, 10, 4},
		{-4, 11, -3}, {-4, 11, 4}, {5, 11, -3}, {5, 11, 4},
		{-4, 12, -3}, {-4, 12, 4}, {5, 12, -3}, {5, 12, 4},
		{-4, 10, -4}, {-3, 10, -4}, {-2, 10, -4}, {-1, 10, -4}, {0, 10, -4}, {1, 10, -4}, {2, 10, -4}, {3, 10, -4}, {4, 10, -4}, {5, 10, -4},
		{-4, 10, 5}, {-3, 10, 5}, {-2, 10, 5}, {-1, 10, 5}, {0, 10, 5}, {1, 10, 5}, {2, 10, 5}, {3, 10, 5}, {4, 10, 5}, {5, 10, 5},
		{-4, 12, -2}, {-4, 12, -1},
		{-4, 12, 2}, {-4, 12, 3},
		{5, 12, -2}, {5, 12, -1},
		{5, 12, 2}, {5, 12, 3},
		{-4, 12, -4}, {-3, 12, -4}, {-2, 12, -4}, {-1, 12, -4}, {2, 12, -4}, {3, 12, -4}, {4, 12, -4}, {5, 12, -4},
		{-4, 12, 5}, {-3, 12, 5}, {-2, 12, 5}, {-1, 12, 5}, {2, 12, 5}, {3, 12, 5}, {4, 12, 5}, {5, 12, 5},
		{-2, 13, -3}, {-1, 13, -3}, {0, 13, -3}, {1, 13, -3}, {2, 13, -3}, {3, 13, -3},
		{-2, 13, 4}, {-1, 13, 4}, {0, 13, 4}, {1, 13, 4}, {2, 13, 4}, {3, 13, 4},
		{-3, 13, -2}, {-3, 13, -1}, {-3, 13, 0}, {-3, 13, 1}, {-3, 13, 2}, {-3, 13, 3},
		{4, 13, -2}, {4, 13, -1}, {4, 13, 0}, {4, 13, 1}, {4, 13, 2}, {4, 13, 3},
		{-3, 13, -3}, {4, 13, 4}, {-3, 13, 4}, {4, 13, -3},
		{-2, 14, -2}, {-2, 14, -1}, {-2, 14, 0}, {-2, 14, 1}, {-2, 14, 2}, {-2, 14, 3},
		{-1, 14, -2}, {-1, 14, -1}, {-1, 14, 0}, {-1, 14, 1}, {-1, 14, 2}, {-1, 14, 3},
		{0, 14, -2}, {0, 14, -1}, {0, 14, 0}, {0, 14, 1}, {0, 14, 2}, {0, 14, 3},
		{1, 14, -2}, {1, 14, -1}, {1, 14, 0}, {1, 14, 1}, {1, 14, 2}, {1, 14, 3},
		{2, 14, -2}, {2, 14, -1}, {2, 14, 0}, {2, 14, 1}, {2, 14, 2}, {2, 14, 3},
		{3, 14, -2}, {3, 14, -1}, {3, 14, 0}, {3, 14, 1}, {3, 14, 2}, {3, 14, 3}
	};
	private final int[][] spruceLeavesPos = new int[][]
	{
		{-2, 8, -2}, {-2, 8, -1}, {-2, 8, 0}, {-2, 8, 1}, {-2, 8, 2}, {-2, 8, 3},
		{-1, 8, -2}, {-1, 8, -1}, {-1, 8, 0}, {-1, 8, 1}, {-1, 8, 2}, {-1, 8, 3},
		{0, 8, -2}, {0, 8, -1}, {0, 8, 0}, {0, 8, 1}, {0, 8, 2}, {0, 8, 3},
		{1, 8, -2}, {1, 8, -1}, {1, 8, 0}, {1, 8, 1}, {1, 8, 2}, {1, 8, 3},
		{2, 8, -2}, {2, 8, -1}, {2, 8, 0}, {2, 8, 1}, {2, 8, 2}, {2, 8, 3},
		{3, 8, -2}, {3, 8, -1}, {3, 8, 0}, {3, 8, 1}, {3, 8, 2}, {3, 8, 3},
		{-4, 11, -2}, {-4, 11, -1},
		{-4, 11, 0}, {-4, 11, 1},
		{-4, 11, 2}, {-4, 11, 3},
		{5, 11, -2}, {5, 11, -1},
		{5, 11, 0}, {5, 11, 1},
		{5, 11, 2}, {5, 11, 3},
		{-4, 11, -4}, {-3, 11, -4}, {-2, 11, -4}, {-1, 11, -4}, {0, 11, -4}, {1, 11, -4}, {2, 11, -4}, {3, 11, -4}, {4, 11, -4}, {5, 11, -4},
		{-4, 11, 5}, {-3, 11, 5}, {-2, 11, 5}, {-1, 11, 5}, {0, 11, 5}, {1, 11, 5}, {2, 11, 5}, {3, 11, 5}, {4, 11, 5}, {5, 11, 5},
		{-4, 12, 0}, {-4, 12, 1},
		{5, 12, 0}, {5, 12, 1},
		{0, 12, -4}, {1, 12, -4},
		{0, 12, 5}, {1, 12, 5},
		{-4, 13, 0}, {-4, 13, 1},
		{5, 13, 0}, {5, 13, 1},
		{0, 13, -4}, {1, 13, -4},
		{0, 13, 5}, {1, 13, 5},
		{0, 15, 0}, {0, 15, 1}, {1, 15, 0}, {1, 15, 1}
	};
	private final int[][] spruceLogsPosZ = new int[][]
	{
		{5, 7, 0}, {5, 7, 1},
		{0, 7, -4}, {1, 7, -4}
	};
	private final int[][] spruceLogsPosX = new int[][]
	{
		{-4, 7, 0}, {-4, 7, 1},
		{0, 7, 5}, {1, 7, 5}
	};
	private final int[][] oakLogsPos = new int[][]
	{
		{-3, 10, -3}, {4, 10, 4},
		{-3, 11, -3}, {4, 11, 4},
		{-3, 12, -3}, {4, 12, 4},
		{-3, 10, 4}, {4, 10, -3},
		{-3, 11, 4}, {4, 11, -3},
		{-3, 12, 4}, {4, 12, -3}
	};
	private final int[][] mossStonePos = new int[][]
	{
		{-2, 13, -2}, {-2, 13, -1}, {-2, 13, 0}, {-2, 13, 1}, {-2, 13, 2}, {-2, 13, 3},
		{-1, 13, -2}, {-1, 13, -1}, {-1, 13, 0}, {-1, 13, 1}, {-1, 13, 2}, {-1, 13, 3},
		{0, 13, -2}, {0, 13, -1}, {0, 13, 2}, {0, 13, 3},
		{1, 13, -2}, {1, 13, -1}, {1, 13, 2}, {1, 13, 3},
		{2, 13, -2}, {2, 13, -1}, {2, 13, 0}, {2, 13, 1}, {2, 13, 2}, {2, 13, 3},
		{3, 13, -2}, {3, 13, -1}, {3, 13, 0}, {3, 13, 1}, {3, 13, 2}, {3, 13, 3}
	};
	private final int[][] petrifWoodPos = new int[][]
	{
		{-2, 9, -2}, {-2, 9, -1}, {-2, 9, 0}, {-2, 9, 1}, {-2, 9, 2}, {-2, 9, 3},
		{-1, 9, -2}, {-1, 9, -1}, {-1, 9, 0}, {-1, 9, 1}, {-1, 9, 2}, {-1, 9, 3},
		{0, 9, -2}, {0, 9, -1}, {0, 9, 0}, {0, 9, 1}, {0, 9, 2}, {0, 9, 3},
		{1, 9, -2}, {1, 9, -1}, {1, 9, 0}, {1, 9, 1}, {1, 9, 2}, {1, 9, 3},
		{2, 9, -2}, {2, 9, -1}, {2, 9, 0}, {2, 9, 1}, {2, 9, 2}, {2, 9, 3},
		{3, 9, -2}, {3, 9, -1}, {3, 9, 0}, {3, 9, 1}, {3, 9, 2}, {3, 9, 3}
	};
	private final int[][] acaciaLogsPosZ = new int[][]
	{
		{-2, 10, -3}, {-1, 10, -3}, {0, 10, -3}, {1, 10, -3}, {2, 10, -3}, {3, 10, -3},
		{-2, 10, 4}, {-1, 10, 4}, {0, 10, 4}, {1, 10, 4}, {2, 10, 4}, {3, 10, 4}
	};
	private final int[][] acaciaLogsPosX = new int[][]
	{
		{-3, 10, -2}, {-3, 10, -1}, {-3, 10, 0}, {-3, 10, 1}, {-3, 10, 2}, {-3, 10, 3},
		{4, 10, -2}, {4, 10, -1}, {4, 10, 0}, {4, 10, 1}, {4, 10, 2}, {4, 10, 3}
	};
	private final int[][] birchPlanksPos = new int[][]
	{
		{-2, 11, -3}, {-1, 11, -3}, {0, 11, -3}, {1, 11, -3}, {2, 11, -3}, {3, 11, -3},
		{-2, 11, 4}, {-1, 11, 4}, {0, 11, 4}, {1, 11, 4}, {2, 11, 4}, {3, 11, 4},
		{-3, 11, -2}, {-3, 11, -1}, {-3, 11, 0}, {-3, 11, 1}, {-3, 11, 2}, {-3, 11, 3},
		{4, 11, -2}, {4, 11, -1}, {4, 11, 0}, {4, 11, 1}, {4, 11, 2}, {4, 11, 3},
		{-2, 12, -3}, {-1, 12, -3}, {0, 12, -3}, {1, 12, -3}, {2, 12, -3}, {3, 12, -3},
		{-2, 12, 4}, {-1, 12, 4}, {0, 12, 4}, {1, 12, 4}, {2, 12, 4}, {3, 12, 4},
		{-3, 12, -2}, {-3, 12, -1}, {-3, 12, 0}, {-3, 12, 1}, {-3, 12, 2}, {-3, 12, 3},
		{4, 12, -2}, {4, 12, -1}, {4, 12, 0}, {4, 12, 1}, {4, 12, 2}, {4, 12, 3}
	};
	public StructureTreeHouse(World worldIn, Random rand, BlockPos pos)
	{
		this.generate(worldIn, rand, pos);
	}
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos corner)
	{
			// figure out each IBlockState we will use
			IBlockState spruceLogs = Blocks.log.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata());
			IBlockState oakLogs = Blocks.log.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata());
			IBlockState birchPlank = Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.BIRCH.getMetadata());
			IBlockState birchLogs = Blocks.log.getStateFromMeta(BlockPlanks.EnumType.BIRCH.getMetadata());
			IBlockState acaciaLogs = Blocks.log2.getStateFromMeta(BlockPlanks.EnumType.ACACIA.getMetadata());
			IBlockState jungleLogs = Blocks.log.getStateFromMeta(BlockPlanks.EnumType.JUNGLE.getMetadata());
			IBlockState spruceLeaves = Blocks.leaves.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata());
			IBlockState jungleLeaves = Blocks.leaves.getStateFromMeta(BlockPlanks.EnumType.JUNGLE.getMetadata());
			IBlockState petrifWood = ModBlocks.petrifiedWood.getDefaultState();
			IBlockState mossStone = Blocks.mossy_cobblestone.getDefaultState();
			IBlockState glowstone = Blocks.glowstone.getDefaultState();
			// build the layers using the arrays
			buildLayer(worldIn, corner, spruceLogsPos, spruceLogs);
			buildLayerX(worldIn, corner, spruceLogsPosX, spruceLogs);
			buildLayerZ(worldIn, corner, spruceLogsPosZ, spruceLogs);
			buildLayer(worldIn, corner, oakLogsPos, oakLogs);
			buildLayer(worldIn, corner, birchLogsPos, birchLogs);
			buildLayerX(worldIn, corner, jungleLogsPosX, jungleLogs);
			buildLayerZ(worldIn, corner, jungleLogsPosZ, jungleLogs);
			buildLayer(worldIn, corner, jungleLogsPos, jungleLogs);
			buildLayer(worldIn, corner, acaciaLogsPos, acaciaLogs);
			buildLayerX(worldIn, corner, acaciaLogsPosX, acaciaLogs);
			buildLayerZ(worldIn, corner, acaciaLogsPosZ, acaciaLogs);
			buildLayerLeaves(worldIn, corner, spruceLeavesPos, spruceLeaves);
			buildLayerLeaves(worldIn, corner, jungleLeavesPos, jungleLeaves);
			buildLayer(worldIn, corner, petrifWoodPos, petrifWood);
			buildLayer(worldIn, corner, birchPlanksPos, birchPlank);
			buildLayer(worldIn, corner, mossStonePos, mossStone);
			buildLayer(worldIn, corner, glowstonePos, glowstone);
			return true;
	}

	// use an int[][] to place a lot of one block at once
	private void buildLayer(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
	{
		// iterate through the entire int[][]
		for(int[] coord : blockPositions)
		{
			placeBlock(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
		}
	}
	// use an int[][] to place a lot of one block at once
		private void buildLayerLeaves(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
		{
			// iterate through the entire int[][]
			for(int[] coord : blockPositions)
			{
				placeBlockLeaves(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
			}
		}
	private void buildLayerX(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
	{
		// iterate through the entire int[][]
		for(int[] coord : blockPositions)
		{
			placeBlockX(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
		}
	}
	private void buildLayerZ(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
	{
		// iterate through the entire int[][]
		for(int[] coord : blockPositions)
		{
			placeBlockZ(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
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
	/** Helper Method **/
	private void placeBlockLeaves(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
	{
		placeBlock(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
	}

	/** Places a block using corner position and offsets **/
	private void placeBlockLeaves(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
	{	
		// figure out where that block is relative to the corner
		BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
		world.setBlockState(placePos, toPlace.withProperty(DECAYABLE, false), 2);
	}
	/** Helper Method **/
	private void placeBlockX(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
	{
		placeBlockX(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
	}

	/** Places a block using corner position and offsets **/
	private void placeBlockX(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
	{	
		// figure out where that block is relative to the corner
		BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
		world.setBlockState(placePos, toPlace.withProperty(LOG_AXIS, EnumAxis.X), 2);
	}
	/** Helper Method **/
	private void placeBlockZ(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
	{
		placeBlockZ(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
	}

	/** Places a block using corner position and offsets **/
	private void placeBlockZ(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
	{	
		// figure out where that block is relative to the corner
		BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
		world.setBlockState(placePos, toPlace.withProperty(LOG_AXIS, EnumAxis.Z), 2);
	}

	private boolean canSpawnHere(World world, BlockPos posAboveGround)
	{
		// check all the corners to see which ones are replaceable
		boolean corner1Air = canReplace(world, posAboveGround);
		boolean corner2Air = canReplace(world, posAboveGround.add(4, 0, 0));
		boolean corner4Air = canReplace(world, posAboveGround.add(0, 0, 4));
		boolean corner3Air = canReplace(world, posAboveGround.add(4, 0, 4));
		
		// if Y > 20 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 20 && corner1Air && corner2Air && corner3Air && corner4Air;
	}
	
	private boolean canReplace(World world, BlockPos pos)
	{
		Block at = world.getBlockState(pos).getBlock();
		Material material = at.getMaterial();
		// we think it's replaceable if it's air / liquid / snow, plants, or leaves 
		return material.isReplaceable() || material == Material.plants || material == Material.leaves;
	}
}