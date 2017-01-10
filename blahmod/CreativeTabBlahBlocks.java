package blahmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import blahmod.blocks.ModBlocks;
import blahmod.items.ModItems;

public class CreativeTabBlahBlocks extends CreativeTabs
{
	public CreativeTabBlahBlocks()
	{
		super(Main.MODID + "Blocks");
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
		items.add(new ItemStack(ModBlocks.clayOre).copy());
		items.add(new ItemStack(ModBlocks.limestoneOre).copy());
		items.add(new ItemStack(ModBlocks.sulphurOre).copy());
		items.add(new ItemStack(ModBlocks.tadaniteOre).copy());
		items.add(new ItemStack(ModBlocks.uraniumOre).copy());
		items.add(new ItemStack(ModBlocks.limestoneBlock).copy());
		items.add(new ItemStack(ModBlocks.sulphurBlock).copy());
		items.add(new ItemStack(ModBlocks.tadanite).copy());
		items.add(new ItemStack(ModBlocks.uraniumBlock).copy());
		items.add(new ItemStack(ModBlocks.blazeBrick).copy());
		items.add(new ItemStack(ModBlocks.cement).copy());
		items.add(new ItemStack(ModBlocks.endStoneBricks).copy());
		items.add(new ItemStack(ModBlocks.leatherBlock).copy());
		items.add(new ItemStack(ModBlocks.petrifiedWood).copy());
		items.add(new ItemStack(ModBlocks.redNetherBrick).copy());
		items.add(new ItemStack(ModBlocks.netherWartBlock).copy());
		items.add(new ItemStack(ModBlocks.boneBlock).copy());
		super.displayAllReleventItems(items);
	}
}