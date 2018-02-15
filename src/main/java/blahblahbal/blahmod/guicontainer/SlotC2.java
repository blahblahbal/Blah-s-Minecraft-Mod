package blahblahbal.blahmod.guicontainer;

import blahblahbal.blahmod.items.ModItems;
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
		 return (stack.getItem() == Items.gunpowder || stack.getItem() == Items.lava_bucket || stack.getItem() == Item.getItemFromBlock(Blocks.stone) || stack.getItem() == ModItems.osborgnenFuel);
	}
}