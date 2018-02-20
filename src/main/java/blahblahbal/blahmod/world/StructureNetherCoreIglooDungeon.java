package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.entity.EntityFrostblaze;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureNetherCoreIglooDungeon extends WorldGenerator
{
	public static void makeCircle(int x, int y, int z, float r, IBlockState state, World world)
	{
		int fx = (int)(x - r);
		int fy = (int)(z - r);
		int lx = (int)(x + r);
		int ly = (int)(z + r);
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
	public static void makeHallway(int x, int y, int z, int length, boolean dir, IBlockState state, World w)
	{
		if (dir) // x
		{
			for (int i = x; i < x - length; i += (length < 0 ? -1 : 1))
			{
				for (int j = y; j <= y + 4; j++)
				{
					for (int k = z - 2; k <= z + 2; k++)
					{
						if (j == y || j == y + 4)
						{
							if (k == z - 2 || k == z + 2) w.setBlockState(new BlockPos(i, j, k), state, 2);
							else w.setBlockToAir(new BlockPos(i, j, k));
						}
						else w.setBlockToAir(new BlockPos(i, j, k));
					}
				}
			}
		}
		else // z
		{
			for (int i = x - 2; i <= x + 2; i++)
			{
				for (int j = y; j <= y + 4; j++)
				{
					for (int k = z; k < z - length; k += (length < 0 ? -1 : 1))
					{
						if (j == y || j == y + 4)
						{
							if (i == x - 2 || i == x + 2) w.setBlockState(new BlockPos(i, j, k), state, 2);
							else w.setBlockToAir(new BlockPos(i, j, k));
						}
						else w.setBlockToAir(new BlockPos(i, j, k));
					}
				}
			}
		}
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		IBlockState frostBrick = ModBlocks.frostBrick.getDefaultState();
		makeCircle(position.getX(), position.getY(), position.getZ(), 10F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 1, position.getZ(), 10F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 1, position.getZ(), 9F, null, worldIn);
		makeCircle(position.getX(), position.getY() + 2, position.getZ(), 10F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 2, position.getZ(), 9F, null, worldIn);
		makeCircle(position.getX(), position.getY() + 3, position.getZ(), 10F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 3, position.getZ(), 9F, null, worldIn);
		makeCircle(position.getX(), position.getY() + 4, position.getZ(), 9F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 4, position.getZ(), 8F, null, worldIn);
		makeCircle(position.getX(), position.getY() + 5, position.getZ(), 9F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 5, position.getZ(), 8F, null, worldIn);
		makeCircle(position.getX(), position.getY() + 6, position.getZ(), 8F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 6, position.getZ(), 7F, null, worldIn);
		makeCircle(position.getX(), position.getY() + 7, position.getZ(), 8F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 7, position.getZ(), 6F, null, worldIn);
		makeCircle(position.getX(), position.getY() + 8, position.getZ(), 6F, frostBrick, worldIn);
		makeCircle(position.getX(), position.getY() + 8, position.getZ(), 4F, null, worldIn);
		makeCircle(position.getX(), position.getY() + 9, position.getZ(), 4F, frostBrick, worldIn);

		worldIn.setBlockState(position.up(), Blocks.mob_spawner.getDefaultState(), 2);
        TileEntity tileentity = worldIn.getTileEntity(position.up());

        if (tileentity instanceof TileEntityMobSpawner)
        {
            ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic().setEntityName("blahmod.Frostblaze");
        }
		/*int xpos1 = position.getX() + 9;
		int xpos2 = position.getX() - 9;
		int zpos1 = position.getZ() + 9;
		int zpos2 = position.getZ() - 9;

		if (rand.nextInt(2) == 0)
		{
			makeHallway(xpos1, position.getY(), position.getZ(), rand.nextInt(10) + 10, false, frostBrick, worldIn);
		}
		if (rand.nextInt(2) == 0)
		{
			makeHallway(xpos2, position.getY(), position.getZ(), -(rand.nextInt(10) + 10), false, frostBrick, worldIn);
		}
		if (rand.nextInt(2) == 0)
		{
			makeHallway(position.getX(), position.getY(), zpos1, rand.nextInt(10) + 10, true, frostBrick, worldIn);
		}
		if (rand.nextInt(2) == 0)
		{
			makeHallway(position.getX(), position.getY(), zpos2, -(rand.nextInt(10) + 10), true, frostBrick, worldIn);
		}*/
		return true;
	}
}