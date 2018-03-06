package blahblahbal.blahmod.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockSlabDouble extends ModBlockSlab
{
	private final Block singleSlab;
    public ModBlockSlabDouble(String uname, Material m, Block singleSlabReference)
    {
		super(uname, m);
		this.singleSlab = singleSlabReference;
	}

    @Override
	public boolean isDouble()
    {
        return true;
    }
    @Override
    public Item getHalfSlabReference()
    {
        return Item.getItemFromBlock(this.singleSlab);
    }
    @Override
    public boolean doesSideBlockRendering(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return false;
	}
    @Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		//if (this.getHalfSlabReference() == Item.getItemFromBlock(ModBlocks.slabs3[3]))
		if (this.name == "glassSlab")
    		return Blocks.glass.getBlockLayer();
		else return Blocks.stone_slab.getBlockLayer();
	}
}