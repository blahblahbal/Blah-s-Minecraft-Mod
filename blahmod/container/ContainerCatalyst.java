package blahmod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerCatalyst extends Container
{
    /** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 1);
    public IInventory craftResult = new InventoryCraftResult();
    public TileInventoryCatalyst tic;
    private World worldObj;
    /** Position of the workbench */
    private BlockPos pos;
    
    private final int HOTBAR_SLOT_COUNT = 9;
	private final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
	/*private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
	private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
	
	public final int INPUT_SLOTS_COUNT = 3;
	public final int OUTPUT_SLOTS_COUNT = 1;
	public final int CATALYZER_SLOTS_COUNT = INPUT_SLOTS_COUNT + OUTPUT_SLOTS_COUNT;
	
	private final int FIRST_CATALYST_SLOT_INDEX = VANILLA_SLOT_COUNT;
	private final int FIRST_INPUT_SLOT_INDEX = FIRST_CATALYST_SLOT_INDEX;
	private final int FIRST_OUTPUT_SLOT_INDEX = FIRST_INPUT_SLOT_INDEX + INPUT_SLOTS_COUNT;*/

    public ContainerCatalyst(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) //, TileInventoryCatalyst tick)
    {
        this.worldObj = worldIn;
        this.pos = posIn;
        //this.craftResult = new InventoryCatalystResult(posIn);
        //this.tic = tick;
        final int SLOT_X_SPACING = 18;
		final int SLOT_Y_SPACING = 18;		
		
		//output
		this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 0, 107, 29));
		
		for (int i = 0; i < 3; ++i)
		{
			if (i == 2) addSlotToContainer(new Slot(this.craftMatrix, 2, 26, 16)); // input
			if (i == 0) addSlotToContainer(new Slot(this.craftMatrix, 0, 26, 42)); // c1
			if (i == 1) addSlotToContainer(new Slot(this.craftMatrix, 1, 52, 16)); // c2
		}
		
		// Add the player's hotbar to the gui - the [xpos, ypos] location of each item
		for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 129));
        }
		// Add the rest of the player's inventory to the gui
		for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 71 + k * 18));
            }
        }
		
		

		this.onCraftMatrixChanged(this.craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        this.craftResult.setInventorySlotContents(0, BlahCraftManager.getInstance().findMatchingRecipe((InventoryCrafting)inventoryIn, this.worldObj));
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 3; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    playerIn.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return craftResult.isUseableByPlayer(playerIn);
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {    	
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 40, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 10 && index < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 40, false))
                {
                    return null;
                }
            }
            else if (index >= 37 && index < 40)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 40, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    public boolean canMergeSlot(ItemStack stack, Slot p_94530_2_)
    {
        return p_94530_2_.inventory != this.craftResult && super.canMergeSlot(stack, p_94530_2_);
    }
}