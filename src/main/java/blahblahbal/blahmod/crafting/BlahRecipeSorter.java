package blahblahbal.blahmod.crafting;

import java.util.Comparator;

import blahblahbal.blahmod.guicontainer.BlahCraftManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

public class BlahRecipeSorter implements Comparator
{
	public final BlahCraftManager CraftingManager;

	public BlahRecipeSorter(BlahCraftManager cM)
	{
		CraftingManager = cM;
	}

	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
	{
		if ((par1IRecipe instanceof BlahRecipes) && (par2IRecipe instanceof ShapedRecipes))
		{
			return 1;
		}

		if ((par2IRecipe instanceof BlahRecipes) && (par1IRecipe instanceof ShapedRecipes))
		{
			return -1;
		}

		if (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize())
		{
			return -1;
		}

		return par2IRecipe.getRecipeSize() <= par1IRecipe.getRecipeSize() ? 0 : 1;
	}

	public int compare(Object par1Obj, Object par2Obj)
	{
		return compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
	}

}