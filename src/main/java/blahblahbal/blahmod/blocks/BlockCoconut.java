package main.java.blahblahbal.blahmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCoconut extends Block
{
	public BlockCoconut(String uName, Material material)
	{
		super(material);
		this.setUnlocalizedName(uName);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setHarvestLevel("Pickaxe", 0);
		this.setBlockBounds(0.1875F, 0.25F, 0.1875F, 0.8125F, 1F, 0.8125F);
	}
	public boolean isOpaqueCube()
    {
        return false;
    }
	@Override
    public Item getItemDropped(IBlockState blockstate, Random random, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.groundCoconut);
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
