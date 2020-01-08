package blahblahbal.blahmod.crafting;

import com.google.common.collect.Lists;

//import blahblahbal.blahmod.tileentity.ModTileEntity;

import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BlahRecipes implements IRecipe
{
    private final ItemStack recipeOutput;
    public final List<ItemStack> recipeItems;
    public BlahRecipes(ItemStack output, List<ItemStack> inputList)
    {
        this.recipeOutput = output;
        this.recipeItems = inputList;
    }
    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv)
    {
    	NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);
        for (int i = 0; i < nonnulllist.size(); ++i)
        {
            ItemStack itemstack = inv.getStackInSlot(i);
            nonnulllist.set(i, net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack));
        }
        return nonnulllist;
    }
    public boolean matches(InventoryCrafting inv, World worldIn)
    {
        List<ItemStack> list = Lists.newArrayList(this.recipeItems);

        for (int i = 0; i < inv.getHeight(); ++i)
        {
            for (int j = 0; j < inv.getWidth(); ++j)
            {
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);

                if (itemstack != null)
                {
                    boolean flag = false;

                    for (ItemStack itemstack1 : list)
                    {
                        if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getMetadata() == 32767 || itemstack.getMetadata() == itemstack1.getMetadata()))
                        {
                            flag = true;
                            list.remove(itemstack1);
                            break;
                        }
                    }

                    if (!flag)
                    {
                        return false;
                    }
                }
            }
        }

        return list.isEmpty();
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting inv)
    {
        return this.recipeOutput.copy();
    }
    
    public ItemStack getCraftingResult()
    {
        return this.recipeOutput.copy();
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }
	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResourceLocation getRegistryName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Class<IRecipe> getRegistryType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean canFit(int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}