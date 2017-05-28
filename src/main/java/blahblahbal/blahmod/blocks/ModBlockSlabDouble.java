package blahblahbal.blahmod.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ModBlockSlabDouble extends ModBlockSlab
{
    public ModBlockSlabDouble(String uname, Material m)
    {
		super(uname, m);
	}

    @Override
	public boolean isDouble()
    {
        return true;
    }
}