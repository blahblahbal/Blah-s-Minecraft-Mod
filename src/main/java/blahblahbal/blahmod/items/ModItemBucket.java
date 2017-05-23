package main.java.blahblahbal.blahmod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;

public class ModItemBucket extends ItemBucket
{
	public String name;
	public ModItemBucket(Block containedBlock, String uname)
	{
		super(containedBlock);
		setUnlocalizedName(uname);
		name = uname;
	}
}