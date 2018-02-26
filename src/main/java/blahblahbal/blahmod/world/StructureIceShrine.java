package blahblahbal.blahmod.world;

import java.util.Random;

import com.google.common.collect.Lists;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.items.ModItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockQuartz;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockStoneSlab.EnumType;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureIceShrine extends WorldGenerator
{
	public static final PropertyEnum<BlockStoneSlab.EnumType> VARIANT = PropertyEnum.<BlockStoneSlab.EnumType>create("variant", BlockStoneSlab.EnumType.class);
	private final int[][] middlePillar = new int[][]
	{
		{0, 2, 0}, {0, 3, 0}, {0, 4, 0}
	};
	private final int[][] quartzSlabPos = new int[][]
	{
		{-1, 1, 1}, {-1, 2, -1}, {1, 3, -1}, {1, 4, 1}
	};
	private final int[][] obsBrickStairThingPos = new int[][]
	{
		{-1, 1, 0}, {0, 2, -1}, {1, 3, 0}
	};
	private final int[][] airPos = new int[][]
	{
		{1, 4, 0}, {1, 4, -1}, {0, 4, -1}, {-1, 4, -1}
	};
	private final int[][] doorBottomPos = new int[][]
	{
		{6, 1, 0}, {-6, 1, 0}, {0, 1, 6}, {0, 1, -6}
	};
	private final int[][] doorTopPos = new int[][]
	{
		{6, 2, 0}, {-6, 2, 0}, {0, 2, 6}, {0, 2, -6}
	};
	private final int[] chestPos1 = new int[] {0, 5, 2};
	private final int[] chestPos2 = new int[] {2, 5, 0};
	private final int[] chestPos3 = new int[] {0, 5, -2};
	private final int[] chestPos4 = new int[] {-2, 5, 0};
	private final int[] mobPos = new int[] {0, 1, 0};
	private final WeightedRandomChestContent[] chestContents =
	{
		// parameters: (Item, metadata, min, max, weight)
		new WeightedRandomChestContent(ModItems.gems[1], 0, 1, 3, 4),
		new WeightedRandomChestContent(ModItems.gems[0], 0, 1, 3, 4),
		new WeightedRandomChestContent(Items.emerald, 0, 1, 3, 4),
		new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 4),
		new WeightedRandomChestContent(ModItems.gems[2], 0, 1, 3, 4),
		new WeightedRandomChestContent(ModItems.gems[3], 0, 1, 3, 4),
		new WeightedRandomChestContent(ModItems.gems[4], 0, 1, 3, 4),
		new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 4),
	};
	public static void makeCircle(int x, int y, int z, float r, IBlockState state, World world)
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
					else world.setBlockState(new BlockPos(i, y, j), state, 2);
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
	// use an int[][] to place a lot of one block at once
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
		
		@Override
		public boolean generate(World arg0, Random arg1, BlockPos arg2)
		{
			IBlockState obsBrick = ModBlocks.frostBrick.getDefaultState();
			IBlockState netherIce = ModBlocks.netherIce.getDefaultState();
			IBlockState netherIceBrick = ModBlocks.netherIceBrick.getDefaultState();
			IBlockState quartzSlab = Blocks.stone_slab.getDefaultState().withProperty(VARIANT, EnumType.QUARTZ);
			IBlockState glowstone = Blocks.glowstone.getDefaultState();
			IBlockState boneBlock = ModBlocks.boneBlock.getDefaultState();
			IBlockState doorLower = Blocks.oak_door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER);
			IBlockState doorUpper = Blocks.oak_door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER);
			IBlockState chest = Blocks.chest.getDefaultState();
			
			makeCircle(arg2.getX(), arg2.getY(), arg2.getZ(), 7F, netherIceBrick, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 1, arg2.getZ(), 6F, netherIce, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 1, arg2.getZ(), 5F, null, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 2, arg2.getZ(), 6F, obsBrick, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 2, arg2.getZ(), 5F, null, arg0);

			makeCircle(arg2.getX(), arg2.getY() + 3, arg2.getZ(), 6F, obsBrick, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 3, arg2.getZ(), 5F, null, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 4, arg2.getZ(), 5F, boneBlock, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 5, arg2.getZ(), 3F, netherIceBrick, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 5, arg2.getZ(), 2F, null, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 6, arg2.getZ(), 3F, obsBrick, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 6, arg2.getZ(), 2F, null, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 7, arg2.getZ(), 3F, obsBrick, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 7, arg2.getZ(), 2F, null, arg0);
			makeCircle(arg2.getX(), arg2.getY() + 8, arg2.getZ(), 2F, boneBlock, arg0);

			buildLayer(arg0, arg2, quartzSlabPos, quartzSlab);
			buildLayer(arg0, arg2, obsBrickStairThingPos, obsBrick);
			buildLayer(arg0, arg2, middlePillar, netherIceBrick);
			// place the other features LAST
			buildLayer(arg0, arg2, doorBottomPos, doorLower);
			buildLayer(arg0, arg2, doorTopPos, doorUpper);
			for (int[] coord : airPos)
			{
				arg0.setBlockToAir(new BlockPos(arg2.getX() + coord[0], arg2.getY() + coord[1], arg2.getZ() + coord[2]));
			}
			// I saved the chest for last
			// here's where we use the WeightedRandomChestContent[]
			placeBlock(arg0, arg2, chestPos1, chest); 
			// here we have to do some back-math...
			// we need to know the actual location of the TileEntityChest,
			// not just its offsets from the corner
			BlockPos actualPos = arg2.add(chestPos1[0], chestPos1[1], chestPos1[2]);
			// right, so we get the TileEntityChest here
			TileEntityChest chestTE1 = (TileEntityChest)arg0.getTileEntity(actualPos);
			if (chestTE1 != null)
			{
				// now we add the contents we declared earlier (if the TE is not null)
				WeightedRandomChestContent.generateChestContents(arg0.rand, Lists.newArrayList(chestContents), chestTE1, 6);
			}
			
			
			placeBlock(arg0, arg2, chestPos2, chest); 
			BlockPos actualPos2 = arg2.add(chestPos2[0], chestPos2[1], chestPos2[2]);
			TileEntityChest chestTE2 = (TileEntityChest)arg0.getTileEntity(actualPos2);
			if (chestTE2 != null)
			{
				// now we add the contents we declared earlier (if the TE is not null)
				WeightedRandomChestContent.generateChestContents(arg0.rand, Lists.newArrayList(chestContents), chestTE2, 6);
			}
			placeBlock(arg0, arg2, chestPos3, chest); 
			BlockPos actualPos3 = arg2.add(chestPos3[0], chestPos3[1], chestPos3[2]);
			TileEntityChest chestTE3 = (TileEntityChest)arg0.getTileEntity(actualPos3);
			if (chestTE3 != null)
			{
				// now we add the contents we declared earlier (if the TE is not null)
				WeightedRandomChestContent.generateChestContents(arg0.rand, Lists.newArrayList(chestContents), chestTE3, 6);
			}
			placeBlock(arg0, arg2, chestPos4, chest); 
			BlockPos actualPos4 = arg2.add(chestPos4[0], chestPos4[1], chestPos4[2]);
			TileEntityChest chestTE4 = (TileEntityChest)arg0.getTileEntity(actualPos4);
			if (chestTE4 != null)
			{
				// now we add the contents we declared earlier (if the TE is not null)
				WeightedRandomChestContent.generateChestContents(arg0.rand, Lists.newArrayList(chestContents), chestTE4, 6);
			}
			BlockPos mob = arg2.add(mobPos[0], mobPos[1], mobPos[2]);
			arg0.setBlockState(mob, Blocks.mob_spawner.getDefaultState(), 2);
            TileEntity tileentity = arg0.getTileEntity(mob);
            if (tileentity instanceof TileEntityMobSpawner)
            {
                ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic().setEntityName("Silverfish");
            }
			return true;
		}
}
