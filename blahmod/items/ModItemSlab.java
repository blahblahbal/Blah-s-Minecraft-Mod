package blahmod.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;
import org.apache.commons.lang3.tuple.ImmutablePair;

import blahmod.blocks.ModBlockSlabDouble;
import blahmod.blocks.ModBlockSlabHalf;

public class ModItemSlab extends ItemSlab {
	public ModItemSlab(
	        final Block block,
	        final ModBlockSlabHalf slab,
	        final ModBlockSlabDouble doubleSlab,
	        final Boolean stacked) {
	        super(block, slab, doubleSlab);
	    }
}