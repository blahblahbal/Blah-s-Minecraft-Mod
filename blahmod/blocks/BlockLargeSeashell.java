package blahmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLargeSeashell extends Block
{
	public BlockLargeSeashell(String uName, Material material)
	{
		super(material);
		this.setUnlocalizedName(uName);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setHarvestLevel("hand", 0);
		this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.4375F, 0.875F);
	}
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return true;
    }
}
