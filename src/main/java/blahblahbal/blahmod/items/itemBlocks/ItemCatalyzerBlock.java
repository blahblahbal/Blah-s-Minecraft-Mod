package main.java.blahblahbal.blahmod.items.itemBlocks;

import main.java.blahblahbal.blahmod.AchievementHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCatalyzerBlock extends ItemBlock
{

	public ItemCatalyzerBlock(Block block)
	{
		super(block);
	}
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		if (world != null)
		{
			player.addStat(AchievementHandler.CATALYZER, 1);
		}
	}
}
