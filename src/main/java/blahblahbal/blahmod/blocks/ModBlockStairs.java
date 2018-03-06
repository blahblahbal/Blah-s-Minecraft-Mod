package blahblahbal.blahmod.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockStairs extends BlockStairs
{
	public ModBlockStairs(IBlockState state, String uname)
	{
		super(state);
		this.setHarvestLevel("pickaxe", 0);
		if (uname == "cedarStairs" || uname == "palmStairs" || uname == "sequoiaStairs")
		{
			this.setHarvestLevel("axe", 0);
		}
		this.setUnlocalizedName(uname);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	@Override
	public boolean isFullCube()
    {
        return false;
    }
	@Override
	public boolean doesSideBlockRendering(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return false;
	}
}
