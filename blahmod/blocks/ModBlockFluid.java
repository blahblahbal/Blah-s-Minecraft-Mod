package blahmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockFluid extends BlockFluidClassic
{
	public String name;
	public static Block b;
	
    public ModBlockFluid(Fluid fluid, Material material, String uname)
    {
    	super(fluid, material);
    	setCreativeTab(CreativeTabs.tabMisc);
    	setUnlocalizedName(uname);
    	this.name = uname;
    	//b = b2;
    }
    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos p)
    {
    	if (world.getBlockState(p).getBlock().getMaterial().isLiquid()) return false;
    	return super.canDisplace(world, p);
    }  
    @Override
    public boolean canDrain(World world, BlockPos p)
    {
    	if (world.getBlockState(p).getBlock().getMaterial().isLiquid()) return false;
    	return super.displaceIfPossible(world, p);
    }
    @Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		checkForMixing(worldIn, pos, state);
	}
	public boolean checkForMixing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.blockMaterial == Material.water)
        {
            boolean flag = false;
            boolean flag2 = false;

            for (EnumFacing enumfacing : EnumFacing.values())
            {
                if (enumfacing != EnumFacing.DOWN && worldIn.getBlockState(pos.offset(enumfacing)).getBlock().getMaterial() == Material.lava)
                {
                    flag = true;
                    break;
                }
                else if (enumfacing != EnumFacing.DOWN && worldIn.getBlockState(pos.offset(enumfacing)).getBlock().getMaterial() == Material.water && worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == Blocks.water)
                {
                    flag2 = true;
                    break;
                }
            }

            if (flag)
            {
                Integer integer = (Integer)state.getValue(LEVEL);

                if (integer.intValue() == 0)
                {
                    worldIn.setBlockState(pos, ModBlocks.tadanite.getDefaultState());
                    //this.triggerMixEffects(worldIn, pos);
                    return true;
                }

                /*if (integer.intValue() <= 4)
                {
                    worldIn.setBlockState(pos, Blocks.cobblestone.getDefaultState());
                    this.triggerMixEffects(worldIn, pos);
                    return true;
                }*/
            }
            if (flag2)
            {
                Integer integer = (Integer)state.getValue(LEVEL);

                if (integer.intValue() == 0)
                {
                    worldIn.setBlockState(pos, Blocks.stone.getDefaultState());
                    //this.triggerMixEffects(worldIn, pos);
                    return true;
                }
            }
        }

        return false;
    }
    
}