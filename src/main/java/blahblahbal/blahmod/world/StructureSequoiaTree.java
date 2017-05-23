package main.java.blahblahbal.blahmod.world;
 
import java.util.List;
import java.util.Random;
 
import org.apache.commons.lang3.ArrayUtils;
 
import com.google.common.collect.Lists;

import main.java.blahblahbal.blahmod.blocks.ModBlockLog;
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
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3i;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureSequoiaTree extends WorldGenerator
{
        /* BLUEPRINTS */
        public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
        public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
        /*private final int[][] logsPos = new int[][]
        {
                {0, 0, 0}, // center
                {0, 0, 1}, {1, 0, 0}, {1, 0, 1}, {0, 0, -1}, {-1, 0, 0}, {-1, 0, -1}, {1, 0, -1}, {-1, 0, 1}, // 1 out from center
                {0, 0, 2}, {1, 0, 2}, {2, 0, 0}, {2, 0, 1}, 
        };*/
        private final int[][] logsPos = new int[][]
        {
        	{3, 53, 0}, {3, 51, 0},
            {-3, 53, 0}, {-3, 51, 0},
            {4, 46, 0}, {4, 44, 0},
            {-4, 46, 0}, {-4, 44, 0},
            {5, 39, 0}, {5, 37, 0},
            {-5, 39, 0}, {-5, 37, 0},
            {0, 53, 3}, {0, 51, 3},
            {0, 53, -3}, {0, 51, -3},
            {0, 46, 4}, {0, 44, 4},
            {0, 46, -4}, {0, 44, -4},
            {0, 39, 5}, {0, 37, 5},
            {0, 39, -5}, {0, 37, -5},
        };
        private final int[][] logsPosEast = new int[][]
        {
                {2, 52, 0}, {-2, 52, 0},
                {2, 45, 0}, {-2, 45, 0},
                {2, 38, 0}, {-2, 38, 0},
                {3, 52, 0}, {-3, 52, 0},
                {3, 45, 0}, {-3, 45, 0},
                {3, 38, 0}, {-3, 38, 0},
                {4, 45, 0}, {-4, 45, 0},
                {4, 38, 0}, {-4, 38, 0},
        };
        private final int[][] logsPosNorth = new int[][]
        {
                {0, 52, 2}, {0, 52, -2},
                {0, 45, 2}, {0, 45, -2},
                {0, 38, 2}, {0, 38, -2},
                {0, 52, 3}, {0, 52, -3},
                {0, 45, 3}, {0, 45, -3},
                {0, 38, 3}, {0, 38, -3},
                {0, 45, 4}, {0, 45, -4},
                {0, 38, 4}, {0, 38, -4},
        };
        
        public StructureSequoiaTree(World worldIn, Random rand, BlockPos pos)
    	{
    		this.generate(worldIn, rand, pos);
    	}
        
        @Override
        public boolean generate(World worldIn, Random rand, BlockPos corner)
        {
                IBlockState sequoiaLog = ModBlocks.sequoiaLog.getDefaultState();
                IBlockState sequoiaLeaves = ModBlocks.sequoiaLeaves.getDefaultState();
                makeSphere(worldIn, new BlockPos(corner.getX(), corner.getY() + 38, corner.getZ() - 7), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX(), corner.getY() + 45, corner.getZ() - 7), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX(), corner.getY() + 38, corner.getZ() + 7), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX(), corner.getY() + 45, corner.getZ() + 7), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX() - 7, corner.getY() + 38, corner.getZ()), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX() - 7, corner.getY() + 45, corner.getZ()), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX() + 7, corner.getY() + 38, corner.getZ()), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX() + 7, corner.getY() + 45, corner.getZ()), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX() - 7, corner.getY() + 52, corner.getZ()), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX(), corner.getY() + 52, corner.getZ() - 7), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX() + 7, corner.getY() + 52, corner.getZ()), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX(), corner.getY() + 52, corner.getZ() + 7), sequoiaLeaves, 4.0, 6.0, 4.0, true);
                makeSphere(worldIn, new BlockPos(corner.getX(), corner.getY() + 48, corner.getZ()), sequoiaLeaves, 10.0, 20.0, 10.0, true);
                
                makeCylinder(worldIn, corner, sequoiaLog, 4.0, 4.0, 4, true);
                makeCylinder(worldIn, corner, sequoiaLog, 3.5, 3.5, 9, true);
                makeCylinder(worldIn, corner, sequoiaLog, 2.5, 2.5, 20, true);
                makeCylinder(worldIn, corner, sequoiaLog, 1.5, 1.5, 55, true);
                makeCylinder(worldIn, corner, sequoiaLog, 0.5, 0.5, 60, true);

                buildLayer(worldIn, corner, logsPosEast, sequoiaLog, 1);
                buildLayer(worldIn, corner, logsPosNorth, sequoiaLog, 3);
                buildLayer(worldIn, corner, logsPos, sequoiaLog, 2);

                return true;
        }



        // direction: 1 = x, 2 = y, 3 = z
        private void buildLayer(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace, int direction)
        {
            // iterate through the entire int[][]
            for(int[] coord : blockPositions)
            {
                if (direction == 1)
                {
                    placeBlockEast(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
                }
                if (direction == 2)
                {
                    placeBlock(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
                }
                if (direction == 3)
                {
                    placeBlockNorth(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
                }
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
    private void placeBlockNorth(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
    {
        placeBlockNorth(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
    }
 
    /** Places a block using corner position and offsets **/
    private void placeBlockNorth(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
    {   
        // figure out where that block is relative to the corner
        BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
        world.setBlockState(placePos, toPlace.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z), 2);
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
        world.setBlockState(placePos, toPlace.withProperty(LOG_AXIS, BlockLog.EnumAxis.X), 2);
    }




    // Places a block
    private void setBlock(World world, BlockPos placePos, IBlockState toPlace)
    {   
        // figure out where that block is relative to the corner
    	if (toPlace == ModBlocks.sequoiaLeaves.getDefaultState())
    		world.setBlockState(placePos, toPlace.withProperty(DECAYABLE, false), 2);
    	else world.setBlockState(placePos, toPlace, 2);
    }
    /*
     * Makes a cylinder.
     * 
     * @param pos Center of the cylinder
     * @param block The block pattern to use
     * @param radiusX The cylinder's largest north/south extent
     * @param radiusZ The cylinder's largest east/west extent
     * @param height The cylinder's up/down extent. If negative, extend downward.
     * @param filled If false, only a shell will be generated.
     * @return number of blocks changed
     * @author Original programmer is sk89q
     */
    public int makeCylinder(World worldIn, BlockPos pos, IBlockState block, double radiusX, double radiusZ, int height, boolean filled)
    {
        int affected = 0;
        radiusX += 0.5;
        radiusZ += 0.5;

        if (height == 0)
        {
            return 0;
        }
        else if (height < 0)
        {
            height = -height;
            pos = pos.subtract(new Vec3i(0, height, 0));
        }

        if (pos.getY() < 0)
        {
            pos = new BlockPos(pos.getX(), 0, pos.getY());
        }
        else if (pos.getY() + height - 1 > worldIn.getHeight())
        {
            height = worldIn.getHeight() - pos.getY() + 1;
        }

        final double invRadiusX = 1 / radiusX;
        final double invRadiusZ = 1 / radiusZ;

        final int ceilRadiusX = (int)Math.ceil(radiusX);
        final int ceilRadiusZ = (int)Math.ceil(radiusZ);

        double nextXn = 0;
        forX: for (int x = 0; x <= ceilRadiusX; ++x)
        {
            final double xn = nextXn;
            nextXn = (x + 1) * invRadiusX;
            double nextZn = 0;
            forZ: for (int z = 0; z <= ceilRadiusZ; ++z)
            {
                final double zn = nextZn;
                nextZn = (z + 1) * invRadiusZ;

                double distanceSq = lengthSq(xn, zn);
                if (distanceSq > 1)
                {
                    if (z == 0)
                    {
                        break forX;
                    }
                    break forZ;
                }

                if (!filled)
                {
                    if (lengthSq(nextXn, zn) <= 1 && lengthSq(xn, nextZn) <= 1)
                    {
                        continue;
                    }
                }

                for (int y = 0; y < height; ++y)
                {
                    setBlock(worldIn, pos.add(x, y, z), block);
                    setBlock(worldIn, pos.add(-x, y, z), block);
                    setBlock(worldIn, pos.add(x, y, -z), block);
                    setBlock(worldIn, pos.add(-x, y, -z), block);
                }
            }
        }

        return affected;
    }
    private static double lengthSq(double x, double y, double z)
    {
        return (x * x) + (y * y) + (z * z);
    }

    private static double lengthSq(double x, double z)
    {
        return (x * x) + (z * z);
    }
    
    /* Makes a sphere
     * @author Original programmer is sk89q
     */
    public int makeSphere(World worldIn, BlockPos pos, IBlockState block, double radiusX, double radiusY, double radiusZ, boolean filled)
    {
        int affected = 0;

        radiusX += 0.5;
        radiusY += 0.5;
        radiusZ += 0.5;

        final double invRadiusX = 1 / radiusX;
        final double invRadiusY = 1 / radiusY;
        final double invRadiusZ = 1 / radiusZ;

        final int ceilRadiusX = (int) Math.ceil(radiusX);
        final int ceilRadiusY = (int) Math.ceil(radiusY);
        final int ceilRadiusZ = (int) Math.ceil(radiusZ);

        double nextXn = 0;
        forX: for (int x = 0; x <= ceilRadiusX; ++x) {
            final double xn = nextXn;
            nextXn = (x + 1) * invRadiusX;
            double nextYn = 0;
            forY: for (int y = 0; y <= ceilRadiusY; ++y) {
                final double yn = nextYn;
                nextYn = (y + 1) * invRadiusY;
                double nextZn = 0;
                forZ: for (int z = 0; z <= ceilRadiusZ; ++z) {
                    final double zn = nextZn;
                    nextZn = (z + 1) * invRadiusZ;

                    double distanceSq = lengthSq(xn, yn, zn);
                    if (distanceSq > 1) {
                        if (z == 0) {
                            if (y == 0) {
                                break forX;
                            }
                            break forY;
                        }
                        break forZ;
                    }

                    if (!filled) {
                        if (lengthSq(nextXn, yn, zn) <= 1 && lengthSq(xn, nextYn, zn) <= 1 && lengthSq(xn, yn, nextZn) <= 1) {
                            continue;
                        }
                    }

                    setBlock(worldIn, pos.add(x, y, z), block);
                    setBlock(worldIn, pos.add(-x, y, z), block);
                    setBlock(worldIn, pos.add(x, -y, z), block);
                    setBlock(worldIn, pos.add(x, y, -z), block);
                    setBlock(worldIn, pos.add(-x, -y, z), block);
                    setBlock(worldIn, pos.add(x, -y, -z), block);
                    setBlock(worldIn, pos.add(-x, y, -z), block);
                    setBlock(worldIn, pos.add(-x, -y, -z), block);
                }
            }
        }

        return affected;
}
}









