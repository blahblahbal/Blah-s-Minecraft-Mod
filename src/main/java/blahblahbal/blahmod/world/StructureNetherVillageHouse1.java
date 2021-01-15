package blahblahbal.blahmod.world;

import java.util.Random;

import com.google.common.collect.Lists;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.items.ModItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockQuartz;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockStoneSlab.EnumType;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureNetherVillageHouse1 extends WorldGenerator
{
	public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<BlockStoneSlab.EnumType> VARIANT = PropertyEnum.<BlockStoneSlab.EnumType>create("variant", BlockStoneSlab.EnumType.class);
	private final int[][] obsBrickPos = new int[][]
	{
		{0, 0, 0}, {0, 0, 1}, {0, 0, 2}, {0, 0, 3}, {0, 0, 4}, {0, 0, 5}, {0, 0, 6},
		{1, 0, 0}, {2, 0, 0}, {3, 0, 0}, {4, 0, 0}, {5, 0, 0}, {6, 0, 0}, {7, 0, 0},
		{7, 0, 0}, {7, 0, 1}, {7, 0, 2}, {7, 0, 3}, {7, 0, 4}, {7, 0, 5}, {7, 0, 6},
		{1, 0, 6}, {2, 0, 6}, {3, 0, 6}, {4, 0, 6}, {5, 0, 6}, {6, 0, 6}, {7, 0, 6},
		{0, 4, 0}, {0, 4, 6}, {7, 4, 0}, {7, 4, 6},
		{1, 4, 6}, {1, 4, 0}, {6, 4, 6}, {6, 4, 0}
		
	};
	private final int[][] netherBrickPos = new int[][]
	{
		{1, 0, 2}, {1, 0, 3}, {1, 0, 4}, {1, 0, 5},
		{2, 0, 2}, {2, 0, 3}, {2, 0, 4}, {2, 0, 5},
		{3, 0, 2}, {3, 0, 3}, {3, 0, 4}, {3, 0, 5},
		{4, 0, 2}, {4, 0, 3}, {4, 0, 4}, {4, 0, 5},
		{5, 0, 2}, {5, 0, 3}, {5, 0, 4}, {5, 0, 5},
		{6, 0, 2}, {6, 0, 3}, {6, 0, 4}, {6, 0, 5},
		{0, 5, 1}, {0, 5, 5}, {7, 5, 1}, {7, 5, 5},
		{0, 6, 2}, {0, 6, 4}, {7, 6, 2}, {7, 6, 4}
	};
	private final int[][] blazeBrickPos = new int[][]
	{
		{0, 1, 1}, {0, 1, 5}, {7, 1, 1}, {7, 1, 5},
		{1, 1, 0}, {6, 1, 0}, {1, 1, 6}, {6, 1, 6},
		{0, 5, 3}, {0, 6, 3}, {7, 5, 3}, {7, 6, 3}
	};
	private final int[][] quartzPillarPos = new int[][]
	{
		{0, 1, 0}, {0, 2, 0}, {0, 3, 0},
		{0, 1, 6}, {0, 2, 6}, {0, 3, 6},
		{7, 1, 0}, {7, 2, 0}, {7, 3, 0},
		{7, 1, 6}, {7, 2, 6}, {7, 3, 6}
	};
	private final int[][] redNetherBrickPos = new int[][]
	{
		{2, 1, 0}, {3, 1, 0}, {4, 1, 0}, {5, 1, 0},
		{2, 1, 6}, {3, 1, 6}, {4, 1, 6}, {5, 1, 6},
		{1, 2, 0}, {2, 2, 0}, {5, 2, 0}, {6, 2, 0},
		{1, 2, 6}, {2, 2, 6}, {5, 2, 6}, {6, 2, 6},
		{1, 3, 0}, {2, 3, 0}, {5, 3, 0}, {6, 3, 0},
		{1, 3, 6}, {2, 3, 6}, {5, 3, 6}, {6, 3, 6},
		{2, 4, 0}, {3, 4, 0}, {4, 4, 0}, {5, 4, 0},
		{2, 4, 6}, {3, 4, 6}, {4, 4, 6}, {5, 4, 6},
		{0, 1, 2}, {0, 1, 3}, {0, 1, 4},
		{0, 2, 1}, {0, 2, 5},
		{0, 3, 1}, {0, 3, 5},
		{0, 4, 1}, {0, 4, 2}, {0, 4, 3}, {0, 4, 4}, {0, 4, 5},
		{0, 5, 2}, {0, 5, 4},
		{7, 1, 2}, {7, 1, 3}, {7, 1, 4},
		{7, 2, 1}, {7, 2, 5},
		{7, 3, 1}, {7, 3, 5},
		{7, 4, 1}, {7, 4, 2}, {7, 4, 3}, {7, 4, 4}, {7, 4, 5},
		{7, 5, 2}, {7, 5, 4},
		{1, 5, 1}, {1, 5, 2}, {1, 5, 3}, {1, 5, 4}, {1, 5, 5},
		{2, 5, 1}, {2, 5, 2}, {2, 5, 3}, {2, 5, 4}, {2, 5, 5},
		{3, 5, 1}, {3, 5, 2}, {3, 5, 3}, {3, 5, 4}, {3, 5, 5},
		{4, 5, 1}, {4, 5, 2}, {4, 5, 3}, {4, 5, 4}, {4, 5, 5},
		{5, 5, 1}, {5, 5, 2}, {5, 5, 3}, {5, 5, 4}, {5, 5, 5},
		{6, 5, 1}, {6, 5, 2}, {6, 5, 3}, {6, 5, 4}, {6, 5, 5},
		{0, 7, 3}, {1, 7, 3}, {2, 7, 3}, {3, 7, 3}, {4, 7, 3}, {5, 7, 3}, {6, 7, 3}, {7, 7, 3},
		{3, 2, 6}, {4, 2, 6}, {3, 3, 6}, {4, 3, 6}
	};
	private final int[][] glassPos = new int[][]
	{
		{0, 2, 2}, {0, 2, 3}, {0, 2, 4}, {0, 3, 2}, {0, 3, 3}, {0, 3, 4},
		{7, 2, 2}, {7, 2, 3}, {7, 2, 4}, {7, 3, 2}, {7, 3, 3}, {7, 3, 4},
		{3, 2, 0}, {4, 2, 0}, {3, 3, 0}, {4, 3, 0}
	};
	private final int[][] obsSlabPos = new int[][]
	{
		{1, 0, 7}, {3, 0, 7},
		{0, 8, 3}, {1, 8, 3}, {2, 8, 3}, {3, 8, 3}, {4, 8, 3}, {5, 8, 3}, {6, 8, 3}, {7, 8, 3}
	};
	private final int[][] eastStairsPos = new int[][]
	{
		{2, 0, 7},
		{0, 5, 6}, {1, 5, 6}, {2, 5, 6}, {3, 5, 6}, {4, 5, 6}, {5, 5, 6}, {6, 5, 6}, {7, 5, 6},
		{0, 6, 5}, {1, 6, 5}, {2, 6, 5}, {3, 6, 5}, {4, 6, 5}, {5, 6, 5}, {6, 6, 5}, {7, 6, 5},
		{0, 7, 4}, {1, 7, 4}, {2, 7, 4}, {3, 7, 4}, {4, 7, 4}, {5, 7, 4}, {6, 7, 4}, {7, 7, 4}
	};
	private final int[][] westStairsPos = new int[][]
	{
		{0, 5, 0}, {1, 5, 0}, {2, 5, 0}, {3, 5, 0}, {4, 5, 0}, {5, 5, 0}, {6, 5, 0}, {7, 5, 0},
		{0, 6, 1}, {1, 6, 1}, {2, 6, 1}, {3, 6, 1}, {4, 6, 1}, {5, 6, 1}, {6, 6, 1}, {7, 6, 1},
		{0, 7, 2}, {1, 7, 2}, {2, 7, 2}, {3, 7, 2}, {4, 7, 2}, {5, 7, 2}, {6, 7, 2}, {7, 7, 2}
	};
	private final int[][] tadanitePos = new int[][]
	{
		{1, 0, 1}, {2, 0, 1}, {3, 0, 1}, {4, 0, 1}, {5, 0, 1}, {6, 0, 1}
	};
	private final int[][] netherSlabPos = new int[][]
	{
		{1, 1, 1}, {2, 1, 1}, {3, 1, 1}, {4, 1, 1}, {5, 1, 1}, {6, 1, 1},
		{1, 1, 2}, {1, 1, 3}, {1, 1, 4}, {1, 1, 5},
		{6, 1, 2}, {6, 1, 3}, {6, 1, 4}
	};
	private final int[] doorBottomPos = new int[] {2, 1, 6};
	private final int[] doorTopPos = new int[] {2, 2, 6};
	private final int[] chestPos = new int[] {6, 1, 5};
	private final int[][] pressPlatePos = new int[][] { {2, 1, 5} };
	private final int[][] buttonPos = new int[][] { {3, 2, 7} };
	private final WeightedRandomChestContent[] chestContents =
	{
		// parameters: (Item, metadata, min, max, weight)
		new WeightedRandomChestContent(Items.nether_star, 0, 1, 1, 1),
		new WeightedRandomChestContent(ModItems.tadaniteShard, 0, 3, 6, 5),
		new WeightedRandomChestContent(Items.diamond_axe, 0, 1, 1, 5),
		new WeightedRandomChestContent(Items.gold_nugget, 0, 3, 21, 15),
		new WeightedRandomChestContent(Items.diamond_sword, 0, 1, 1, 7),
		new WeightedRandomChestContent(ModItems.tadaniteDiamond, 0, 1, 1, 1),
		new WeightedRandomChestContent(new ItemStack(ModBlocks.netherIce), 3, 5, 17),
	};
	
	// use an int[][] to place a lot of one block at once
		private void buildLayer(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
		{
			// iterate through the entire int[][]
			for(int[] coord : blockPositions)
			{
				placeBlock(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
			}
		}
		private void buildLayerEast(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
		{
			// iterate through the entire int[][]
			for(int[] coord : blockPositions)
			{
				placeBlockEast(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
			}
		}
		private void buildLayerWest(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
		{
			// iterate through the entire int[][]
			for(int[] coord : blockPositions)
			{
				placeBlockWest(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
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
		private void placeBlockWest(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
		{
			placeBlockWest(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
		}

		/** Places a block using corner position and offsets **/
		private void placeBlockWest(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
		{	
			// figure out where that block is relative to the corner
			BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
			world.setBlockState(placePos, toPlace.withProperty(FACING, EnumFacing.SOUTH), 2);
		}
		/** Helper Method **/
		private void placeBlockEast(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
		{
			placeBlockEast(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
		}

		/** Places a block using corner position and offsets **/
		private void placeBlockEast(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
		{	
			// figure out where that block is relative to the corner
			BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
			world.setBlockState(placePos, toPlace.withProperty(FACING, EnumFacing.NORTH), 2);
		}
		
		@Override
		public boolean generate(World arg0, Random arg1, BlockPos arg2)
		{
			IBlockState netherBrick = Blocks.nether_brick.getDefaultState();
			IBlockState netherBrickStairs = Blocks.nether_brick_stairs.getDefaultState();
			IBlockState netherBrickSlab = Blocks.stone_slab.getDefaultState().withProperty(VARIANT, EnumType.NETHERBRICK);
			IBlockState quartzPillar = Blocks.quartz_block.getStateFromMeta(BlockQuartz.EnumType.LINES_Y.getMetadata());
			IBlockState obsBrick = ModBlocks.obsidianBrick.getDefaultState();
			IBlockState blazeBrick = ModBlocks.blazeBrick.getDefaultState();
			IBlockState redNetherBrick = ModBlocks.redNetherBrick.getDefaultState();
			IBlockState netherIce = ModBlocks.netherIce.getDefaultState();
			IBlockState tadanite = Blocks.nether_brick.getDefaultState(); //ModBlocks.tadanite.getDefaultState();
			IBlockState obsSlab = ModBlocks.slabs2[4].getDefaultState();
			IBlockState button = Blocks.stone_button.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
			IBlockState pressPlate = Blocks.stone_pressure_plate.getDefaultState();
			IBlockState redStainedGlassPane = Blocks.stained_glass_pane.getDefaultState().withProperty(COLOR, EnumDyeColor.RED);
			IBlockState doorLower = Blocks.iron_door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER);
			IBlockState doorUpper = Blocks.iron_door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER);
			IBlockState chest = Blocks.chest.getDefaultState();
			
			for (int x = 0; x < 7; x++)
			{
				for (int y = 0; y < 6; y++)
				{
					for (int z = 0; z < 7; z++)
					{
						arg0.setBlockToAir(new BlockPos(arg2.getX() + x, arg2.getY() + y, arg2.getZ() + z));
					}
				}
			}
			buildLayer(arg0, arg2, obsBrickPos, obsBrick);
			buildLayerEast(arg0, arg2, eastStairsPos, netherBrickStairs);
			buildLayerWest(arg0, arg2, westStairsPos, netherBrickStairs);
			buildLayer(arg0, arg2, blazeBrickPos, blazeBrick);
			buildLayer(arg0, arg2, tadanitePos, tadanite);
			buildLayer(arg0, arg2, obsSlabPos, obsSlab);
			buildLayer(arg0, arg2, quartzPillarPos, quartzPillar);
			buildLayer(arg0, arg2, netherSlabPos, netherBrickSlab);
			buildLayer(arg0, arg2, glassPos, redStainedGlassPane);
			buildLayer(arg0, arg2, netherBrickPos, netherBrick);
			buildLayer(arg0, arg2, redNetherBrickPos, redNetherBrick);
			buildLayer(arg0, arg2, buttonPos, button);
			buildLayer(arg0, arg2, pressPlatePos, pressPlate);
			// place the other features LAST
			placeBlock(arg0, arg2, doorBottomPos, doorLower);
			placeBlock(arg0, arg2, doorTopPos, doorUpper);
			
			// I saved the chest for last
			// here's where we use the WeightedRandomChestContent[]
			placeBlock(arg0, arg2, chestPos, chest); 
			// here we have to do some back-math...
			// we need to know the actual location of the TileEntityChest,
			// not just its offsets from the corner
			BlockPos actualPos = arg2.add(chestPos[0], chestPos[1], chestPos[2]);
			// right, so we get the TileEntityChest here
			TileEntityChest chestTE = (TileEntityChest)arg0.getTileEntity(actualPos);
			if(chestTE != null)
			{
				// now we add the contents we declared earlier (if the TE is not null)
				WeightedRandomChestContent.generateChestContents(arg0.rand, Lists.newArrayList(chestContents), chestTE, 6);
			}
			return true;
		}
}
