package blahmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import blahmod.blocks.ModBlocks;
import blahmod.items.ModItems;

public class CreativeTabBlah extends CreativeTabs
{
	public CreativeTabBlah()
	{
		super(Main.MODID);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(ModBlocks.blazeBrick);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void displayAllReleventItems(List<ItemStack> items)
	{
		items.add(new ItemStack(ModItems.limestone).copy());
		items.add(new ItemStack(ModItems.sulphur2).copy());
		items.add(new ItemStack(ModItems.tadaniteShard).copy());
		items.add(new ItemStack(ModItems.uraniumRod).copy());
		items.add(new ItemStack(ModItems.obsidianIngot).copy());
		items.add(new ItemStack(ModItems.uraniumIngot).copy());
		items.add(new ItemStack(ModItems.acidBucket).copy());
		super.displayAllReleventItems(items);
	}
}