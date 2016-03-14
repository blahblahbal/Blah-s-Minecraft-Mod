package blahmod.guicontainer;

import blahmod.items.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotC1 extends Slot
{
	public SlotC1(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		 return (stack.getItem() == ModItems.sulphur2);
	}
}