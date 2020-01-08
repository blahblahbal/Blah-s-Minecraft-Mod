package blahblahbal.blahmod.guicontainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SlotCatalyst extends Slot
{
	/** The craft matrix inventory linked to this result slot. */
	private final IInventory craftMatrix;
	
	/** The player that is using the GUI where this slot resides. */
	private EntityPlayer thePlayer;
	
	/**
		 * The number of items that have been crafted so far. Gets passed to ItemStack.onCrafting before being reset.
		 */
	private int amountCrafted;
	
	public SlotCatalyst(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3IInventory, int par4, int par5, int par6)
	{
		 super(par3IInventory, par4, par5, par6);
		 this.thePlayer = par1EntityPlayer;
		 this.craftMatrix = par2IInventory;
	}
	
	/**
		 * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
		 */
	public boolean isItemValid(ItemStack par1ItemStack)
	{
		 return false;
	}
	
	/**
		 * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
		 * stack.
		 */
	public ItemStack decrStackSize(int par1)
	{
		 if (this.getHasStack())
		 {
			 this.amountCrafted += Math.min(par1, this.getStack().getCount());
		 }
	
		 return super.decrStackSize(par1);
	}
	
	/**
		 * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
		 * internal count then calls onCrafting(item).
		 */
	protected void onCrafting(ItemStack par1ItemStack, int par2)
	{
		 this.amountCrafted += par2;
		 this.onCrafting(par1ItemStack);
	}
	
	/**
		 * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
		 */
	protected void onCrafting(ItemStack par1ItemStack)
	{
		 par1ItemStack.onCrafting(this.thePlayer.world, this.thePlayer, this.amountCrafted);
		 this.amountCrafted = 0;
	}
	
	public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack)
	{
	    net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerCraftingEvent(playerIn, stack, craftMatrix);
	    this.onCrafting(stack);
	    net.minecraftforge.common.ForgeHooks.setCraftingPlayer(playerIn);
	    NonNullList<ItemStack> aitemstack = BlahCraftManager.getInstance().getRemainingItems(this.craftMatrix, playerIn.world);
	    net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);
	
	    for (int i = 0; i < aitemstack.size(); ++i)
	    {
	        ItemStack itemstack = this.craftMatrix.getStackInSlot(i);
	        ItemStack itemstack1 = aitemstack.get(i);
	
	        if (itemstack != null)
	        {
	            this.craftMatrix.decrStackSize(i, 1);
	        }
	
	        if (itemstack1 != null)
	        {
	            if (this.craftMatrix.getStackInSlot(i) == null)
	            {
	                this.craftMatrix.setInventorySlotContents(i, itemstack1);
	            }
	            else if (!this.thePlayer.inventory.addItemStackToInventory(itemstack1))
	            {
	                this.thePlayer.dropItem(itemstack1, false);
	            }
	        }
	    }
	}
}