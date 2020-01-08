package blahblahbal.blahmod.guicontainer;

import blahblahbal.blahmod.init.ModBlocks;
import blahblahbal.blahmod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotC2 extends Slot
{
	public SlotC2(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		 return (stack.getItem() == Item.getItemFromBlock(ModBlocks.flintBlock) || stack.getItem() == Items.LAVA_BUCKET || stack.getItem() == Item.getItemFromBlock(Blocks.STONE) || stack.getItem() == ModItems.osborgnenFuel || stack.getItem() == Item.getItemFromBlock(ModBlocks.hardenedLava));
	}
}