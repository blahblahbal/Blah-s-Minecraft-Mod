package blahblahbal.blahmod.crafting;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapedUpgradeRecipe extends ShapedOreRecipe
{

	public ShapedUpgradeRecipe(Item result, Object... recipe)
	{
		super(result, recipe);
	}
	public ShapedUpgradeRecipe(ItemStack result, Object... recipe)
	{
		super(result, recipe);
	}
	public ShapedUpgradeRecipe(Block result, Object... recipe)
	{
		super(result, recipe);
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		ItemStack output = super.getCraftingResult(inv); // Get the default output
		Object[] input = super.getInput();

		for (int i = 0; i < inv.getSizeInventory(); i++) { // For each slot in the crafting inventory,
			ItemStack ingredient = inv.getStackInSlot(i); // Get the ingredient in the slot
			ItemStack inItem = (ItemStack)input[i];
			
			if (ingredient != null && Item.getIdFromItem(ingredient.getItem()) == Item.getIdFromItem(inItem.getItem()))
			{
				return output;
			}
		}
		return output; // Return the modified output
	}
}
