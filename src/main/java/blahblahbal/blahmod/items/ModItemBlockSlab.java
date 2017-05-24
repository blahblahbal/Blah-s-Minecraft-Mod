package blahblahbal.blahmod.items;

import java.util.ArrayList;
import java.util.List;

import blahblahbal.blahmod.blocks.ModBlockSlabDouble;
import blahblahbal.blahmod.blocks.ModBlockSlabHalf;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ModItemBlockSlab extends ItemSlab
{
	public ModItemBlockSlab(final Block block, final ModBlockSlabHalf slab, final ModBlockSlabDouble doubleSlab, final Boolean stacked) {
		super(block, slab, doubleSlab);
	}
}