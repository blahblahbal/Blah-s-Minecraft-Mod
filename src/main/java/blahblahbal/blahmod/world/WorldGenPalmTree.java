package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.BlockPalmLeaves;
import blahblahbal.blahmod.blocks.ModBlockLeaves;
import blahblahbal.blahmod.blocks.ModBlockPalmLog;
import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPalmTree extends WorldGenAbstractTree
{
    private static final IBlockState log = ModBlocks.palmLog.getDefaultState().withProperty(ModBlockPalmLog.LOG_AXIS, EnumAxis.Y);
    private static final IBlockState leaves = ModBlocks.palmLeaves.getDefaultState().withProperty(BlockPalmLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockPalmLeaves.DECAYABLE, Boolean.valueOf(true));
    public WorldGenPalmTree(boolean p_i45463_1_)
    {
        super(false);
    }
    public WorldGenPalmTree(World w, Random r, BlockPos bp)
    {
    	super(true);
    	generate(w, r, bp);
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(3) + rand.nextInt(3) + 5;
        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + i + 1 <= 256)
        {
        	this.setBlockToLog(worldIn, position);
            for (int j = position.getY(); j <= position.getY() + 1 + i; ++j)
            {
                int k = 1;

                if (j == position.getY())
                {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
                {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            /*if (!this.isReplaceable(worldIn, blockpos$mutableblockpos.set(l, j, i1)))
                            {
                                flag = false;
                            }*/
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                BlockPos down = position.down();
                Block block = worldIn.getBlockState(down).getBlock();
                boolean isSoil = (block == ModBlocks.blackSand || block == Blocks.sand) && worldIn.getBlockState(position).getBlock().getMaterial() != Material.water;

                if (isSoil && position.getY() < 256 - i - 1)
                {
                    block.onPlantGrow(worldIn, down, position);
                    EnumFacing enumfacing = EnumFacing.Plane.HORIZONTAL.random(rand);
                    int k2 = i - rand.nextInt(4) - 1;
                    int l2 = 3 - rand.nextInt(3);
                    int i3 = position.getX();
                    int j1 = position.getZ();
                    int k1 = 0;

                    for (int l1 = 0; l1 < i; ++l1)
                    {
                        int i2 = position.getY() + l1;

                        if (l1 >= k2 && l2 > 0)
                        {
                            i3 += enumfacing.getFrontOffsetX();
                            j1 += enumfacing.getFrontOffsetZ();
                            --l2;
                        }

                        BlockPos blockpos = new BlockPos(i3, i2, j1);
                        block = worldIn.getBlockState(blockpos).getBlock();

                        if (block.isAir(worldIn, blockpos) || block.isLeaves(worldIn, blockpos))
                        {
                            this.setBlockToLog(worldIn, blockpos);
                            k1 = i2;
                        }
                    }

                    BlockPos blockpos2 = new BlockPos(i3, k1, j1);

                    for (int j3 = -3; j3 <= 3; ++j3)
                    {
                        for (int i4 = -3; i4 <= 3; ++i4)
                        {
                            if (Math.abs(j3) != 3 || Math.abs(i4) != 3)
                            {
                                this.setBlockToLeaves(worldIn, blockpos2.add(j3, 0, i4));
                            }
                        }
                    }

                    blockpos2 = blockpos2.up();

                    for (int k3 = -1; k3 <= 1; ++k3)
                    {
                        for (int j4 = -1; j4 <= 1; ++j4)
                        {
                            this.setBlockToLeaves(worldIn, blockpos2.add(k3, 0, j4));
                        }
                    }

                    this.setBlockToLeaves(worldIn, blockpos2.east(2));
                    this.setBlockToLeaves(worldIn, blockpos2.west(2));
                    this.setBlockToLeaves(worldIn, blockpos2.south(2));
                    this.setBlockToLeaves(worldIn, blockpos2.north(2));
                    i3 = position.getX();
                    j1 = position.getZ();
                    EnumFacing enumfacing1 = EnumFacing.Plane.HORIZONTAL.random(rand);

                    if (enumfacing1 != enumfacing)
                    {
                        int l3 = k2 - rand.nextInt(2) - 1;
                        int k4 = 1 + rand.nextInt(3);
                        k1 = 0;

                        for (int l4 = l3; l4 < i && k4 > 0; --k4)
                        {
                            if (l4 >= 1)
                            {
                                int j2 = position.getY() + l4;
                                i3 += enumfacing1.getFrontOffsetX();
                                j1 += enumfacing1.getFrontOffsetZ();
                                BlockPos blockpos1 = new BlockPos(i3, j2, j1);
                                block = worldIn.getBlockState(blockpos1).getBlock();

                                if (block.isAir(worldIn, blockpos2) || block.isLeaves(worldIn, blockpos2))
                                {
                                    this.setBlockToLog(worldIn, blockpos1);
                                    k1 = j2;
                                }
                            }

                            ++l4;
                        }

                        if (k1 > 0)
                        {
                            BlockPos blockpos3 = new BlockPos(i3, k1, j1);

                            for (int i5 = -2; i5 <= 2; ++i5)
                            {
                                for (int k5 = -2; k5 <= 2; ++k5)
                                {
                                    if (Math.abs(i5) != 2 || Math.abs(k5) != 2)
                                    {
                                        this.setBlockToLeaves(worldIn, blockpos3.add(i5, 0, k5));
                                    }
                                }
                            }

                            blockpos3 = blockpos3.up();

                            for (int j5 = -1; j5 <= 1; ++j5)
                            {
                                for (int l5 = -1; l5 <= 1; ++l5)
                                {
                                    this.setBlockToLeaves(worldIn, blockpos3.add(j5, 0, l5));
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void setBlockToLog(World p_181642_1_, BlockPos p_181642_2_)
    {
        this.setBlockAndNotifyAdequately(p_181642_1_, p_181642_2_, log);
    }

    private void setBlockToLeaves(World worldIn, BlockPos p_175924_2_)
    {
        Block block = worldIn.getBlockState(p_175924_2_).getBlock();

        if (block.isAir(worldIn, p_175924_2_) || block.isLeaves(worldIn, p_175924_2_))
        {
            this.setBlockAndNotifyAdequately(worldIn, p_175924_2_, leaves);
        }
    }
}