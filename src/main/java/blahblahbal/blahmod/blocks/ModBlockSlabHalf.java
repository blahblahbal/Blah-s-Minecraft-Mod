package blahblahbal.blahmod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockSlabHalf extends ModBlockSlab
{
    public ModBlockSlabHalf(String uname, Material m)
    {
		super(uname, m);
	}

    @Override
	public boolean isDouble()
    {
        return false;
    }
    @Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		//if (this.getHalfSlabReference() == Item.getItemFromBlock(ModBlocks.slabs3[3]))
		//if (this.name == "glassSlab")
    		return EnumWorldBlockLayer.CUTOUT;
		//else return Blocks.stone_slab.getBlockLayer();
	}
    public boolean isFullCube()
    {
        return false;
    }
    @Override
    public boolean doesSideBlockRendering(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return false;
	}
	@Override
	public Item getHalfSlabReference()
	{	
		return Item.getItemFromBlock(this);
	}
}