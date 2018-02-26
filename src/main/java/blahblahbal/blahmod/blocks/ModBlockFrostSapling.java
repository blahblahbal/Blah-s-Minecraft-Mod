package blahblahbal.blahmod.blocks;

import java.util.Random;

import blahblahbal.blahmod.Main;
import blahblahbal.blahmod.world.StructureSequoiaTree;
import blahblahbal.blahmod.world.StructureTreeHouse;
import blahblahbal.blahmod.world.WorldGenDifferentPalmTree;
import blahblahbal.blahmod.world.WorldGenFrostTree;
import blahblahbal.blahmod.world.WorldGenLargeFrostTree;
import blahblahbal.blahmod.world.WorldGenPalmTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ModBlockFrostSapling extends BlockSapling
{
	public static String name;
	public static int type;
	public ModBlockFrostSapling(String name, int ty)
	{
		float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setUnlocalizedName(name);
        this.name = name;
        this.type = ty;
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(Main.blahTabBlock);
	}
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, pos, state, rand);
            }
        }
    }

    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state, rand);
    }
    @Override
    public boolean canPlaceBlockOn(Block ground)
    {
    	return ground == ModBlocks.netherFrost || ground == ModBlocks.netherIce;
    }
	@Override
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		WorldGenerator gen = (WorldGenerator)(rand.nextInt(3) == 0 ? new WorldGenLargeFrostTree(worldIn, rand, pos) : new WorldGenFrostTree(worldIn, rand, pos));
		
		/*WorldGenerator gen = (WorldGenerator)new WorldGenFrostTree(worldIn, rand, pos);
		for (int i = 0; i >= -1; --i)
        {
			for (int j = 0; j >= -1; --j)
            {
				if (checkNeighbor(worldIn, pos, i, j, ModBlocks.frostSapling.getDefaultState()))
				{
					gen = (WorldGenerator)new WorldGenLargeFrostTree(worldIn, rand, pos);
				}
            }
        }*/	
	}
	public boolean checkNeighbor(World w, BlockPos bp, int x, int z, IBlockState s)
    {
        return this.isTypeAt(w, bp.add(x, 0, z), s) &&
        		this.isTypeAt(w, bp.add(x + 1, 0, z), s) &&
        		this.isTypeAt(w, bp.add(x, 0, z + 1), s) &&
        		this.isTypeAt(w, bp.add(x + 1, 0, z + 1), s);
    }
	/**
     * Check whether the given BlockPos has a Sapling of the given type
     */
    public boolean isTypeAt(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() == this && iblockstate.getBlock() == state.getBlock();
    }
}
