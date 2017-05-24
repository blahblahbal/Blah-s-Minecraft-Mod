package blahblahbal.blahmod.guicontainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerCatalyzer extends Container
{
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 1);
    public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
    private BlockPos pos;
    public ContainerCatalyzer(InventoryPlayer playerInv, World worldIn, BlockPos posIn)
    {
    	this.worldObj = worldIn;
    	this.pos = posIn;
        addSlotToContainer(new SlotCatalyst(playerInv.player, this.craftMatrix, this.craftResult, 0, 107, 29));
		for (int i = 0; i < 3; ++i)
		{
			if (i == 0) addSlotToContainer(new Slot(this.craftMatrix, 0, 26, 16)); // input
			if (i == 1) addSlotToContainer(new SlotC1(this.craftMatrix, 1, 26, 42)); // c1
			if (i == 2) addSlotToContainer(new SlotC2(this.craftMatrix, 2, 52, 16)); // c2
		}
        for (int y = 0; y < 3; ++y)
        {
            for (int x = 0; x < 9; ++x)
            {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18)); // Player Inventory, Slot 9-35, Slot IDs 4-30
            }
        }
        for (int x = 0; x < 9; ++x)
        {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142)); // Player Inventory, Slot 0-8, Slot IDs 31-39
        }
    }

    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        this.craftResult.setInventorySlotContents(0, BlahCraftManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot)
    {
        ItemStack previous = null;
        Slot slot = (Slot)this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();
            if (fromSlot < 4)
            {
                if (!this.mergeItemStack(current, 4, 40, true)) // From TE Inventory to Player Inventory
                    return null;
            }
            else
            {
                if (!this.mergeItemStack(current, 0, 4, false)) // From Player Inventory to TE Inventory
                    return null;
            }
            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();
            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }
        return previous;
    }
    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 4; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlot(i);

                if (itemstack != null)
                {
                    playerIn.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.craftMatrix.isUseableByPlayer(playerIn);
    }
}