package blahblahbal.blahmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

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
	public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.groundCoconut);
    }
    public boolean isFullCube()
    {
        return false;
    }
    public boolean shouldSideBeRendered(IBlockAccess worldIn, int x, int y, int z, int side)
    {
        return true;
    }
}
