package blahblahbal.blahmod.blocks;

import java.util.Random;

import blahblahbal.blahmod.Main;
import blahblahbal.blahmod.world.StructureSequoiaTree;
import blahblahbal.blahmod.world.StructureTreeHouse;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ModBlockPrefabSapling extends BlockSapling
{
	public static String name;
	public static int type;
	public ModBlockPrefabSapling(String name, int ty)
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
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		WorldGenerator gen = (WorldGenerator)(new StructureTreeHouse(worldIn, rand, pos));
	}
}
