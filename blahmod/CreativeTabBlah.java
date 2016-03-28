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
		super(Main.MODID + "Items");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem()
	{
		return ModItems.limestone;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void displayAllReleventItems(List<ItemStack> items)
	{
		items.add(new ItemStack(ModItems.tadaniteHelmet).copy());
		items.add(new ItemStack(ModItems.tadaniteChestplate).copy());
		items.add(new ItemStack(ModItems.tadaniteLeggings).copy());
		items.add(new ItemStack(ModItems.tadaniteBoots).copy());
		items.add(new ItemStack(ModItems.obsidianHelmet).copy());
		items.add(new ItemStack(ModItems.obsidianChestplate).copy());
		items.add(new ItemStack(ModItems.obsidianLeggings).copy());
		items.add(new ItemStack(ModItems.obsidianBoots).copy());
		items.add(new ItemStack(ModItems.tadaniteSword).copy());
		items.add(new ItemStack(ModItems.tadanitePickaxe).copy());
		items.add(new ItemStack(ModItems.tadaniteAxe).copy());
		items.add(new ItemStack(ModItems.tadaniteShovel).copy());
		items.add(new ItemStack(ModItems.tadaniteHoe).copy());
		items.add(new ItemStack(ModItems.obsidianSword).copy());
		items.add(new ItemStack(ModItems.obsidianPickaxe).copy());
		items.add(new ItemStack(ModItems.obsidianAxe).copy());
		items.add(new ItemStack(ModItems.obsidianShovel).copy());
		items.add(new ItemStack(ModItems.obsidianHoe).copy());
		items.add(new ItemStack(ModItems.bedrockPickaxe).copy());
		items.add(new ItemStack(ModItems.tadaniteShard).copy());
		items.add(new ItemStack(ModItems.obsidianIngot).copy());
		items.add(new ItemStack(ModItems.sulphur2).copy());
		items.add(new ItemStack(ModItems.limestone).copy());
		items.add(new ItemStack(ModItems.uraniumIngot).copy());
		items.add(new ItemStack(ModItems.acidBucket).copy());
		items.add(new ItemStack(ModItems.uraniumRod).copy());
		super.displayAllReleventItems(items);
	}
}