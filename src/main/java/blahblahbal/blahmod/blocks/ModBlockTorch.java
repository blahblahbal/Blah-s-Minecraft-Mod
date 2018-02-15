package blahblahbal.blahmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ModBlockTorch extends BlockTorch
{
	public String name;
	
	public BlockPos pos;
	
	
	public ModBlockTorch(float light, String uname)
    {
        super();
        setUnlocalizedName(uname);
        this.name = uname;
        setLightLevel(light);
    }
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
    	/*if (worldIn.getBlockState(pos).getBlock().getIdFromBlock(worldIn.getBlockState(pos).getBlock()) == ModBlocks.uraniumTorch.getIdFromBlock(ModBlocks.uraniumTorch))
    	{
    		BlockPos[] bpa = new BlockPos[8];
    		bpa[0] = new BlockPos(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2);
    		bpa[1] = new BlockPos(pos.getX() - 2, pos.getY() + 2, pos.getZ() + 2);
    		bpa[2] = new BlockPos(pos.getX() + 2, pos.getY() - 2, pos.getZ() + 2);
    		bpa[3] = new BlockPos(pos.getX() + 2, pos.getY() + 2, pos.getZ() - 2);
    		bpa[4] = new BlockPos(pos.getX() - 2, pos.getY() - 2, pos.getZ() + 2);
    		bpa[5] = new BlockPos(pos.getX() - 2, pos.getY() + 2, pos.getZ() - 2);
    		bpa[6] = new BlockPos(pos.getX() + 2, pos.getY() - 2, pos.getZ() - 2);
    		bpa[7] = new BlockPos(pos.getX() - 2, pos.getY() - 2, pos.getZ() - 2);
    		for (BlockPos p : bpa)
    		{
    			worldIn.getBlockState(p).getBlock().setLightLevel(3F);
    		}
    	}*/
    }
    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
    	/*if (worldIn.getBlockState(pos).getBlock().getIdFromBlock(worldIn.getBlockState(pos).getBlock()) == ModBlocks.uraniumTorch.getIdFromBlock(ModBlocks.uraniumTorch))
    	{
    		BlockPos[] bpa = new BlockPos[8];
    		bpa[0] = new BlockPos(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2);
    		bpa[1] = new BlockPos(pos.getX() - 2, pos.getY() + 2, pos.getZ() + 2);
    		bpa[2] = new BlockPos(pos.getX() + 2, pos.getY() - 2, pos.getZ() + 2);
    		bpa[3] = new BlockPos(pos.getX() + 2, pos.getY() + 2, pos.getZ() - 2);
    		bpa[4] = new BlockPos(pos.getX() - 2, pos.getY() - 2, pos.getZ() + 2);
    		bpa[5] = new BlockPos(pos.getX() - 2, pos.getY() + 2, pos.getZ() - 2);
    		bpa[6] = new BlockPos(pos.getX() + 2, pos.getY() - 2, pos.getZ() - 2);
    		bpa[7] = new BlockPos(pos.getX() - 2, pos.getY() - 2, pos.getZ() - 2);
    		for (BlockPos p : bpa)
    		{
    			worldIn.getBlockState(p).getBlock().setLightLevel(0F);
    		}
    	}*/
    }
    private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing)
    {
        BlockPos blockpos = pos.offset(facing.getOpposite());
        boolean flag = facing.getAxis().isHorizontal();
        return flag && worldIn.isSideSolid(blockpos, facing, true) || facing.equals(EnumFacing.UP) && this.canPlaceOn(worldIn, blockpos);
    }
    
    private boolean canPlaceOn(World worldIn, BlockPos pos)
    {
        if (World.doesBlockHaveSolidTopSurface(worldIn, pos))
        {
            return true;
        }
        else
        {
            Block block = worldIn.getBlockState(pos).getBlock();
            return block.canPlaceTorchOnTop(worldIn, pos);
        }
    }
}