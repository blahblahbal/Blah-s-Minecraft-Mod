package blahblahbal.blahmod.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

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
}