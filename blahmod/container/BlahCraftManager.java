package blahmod.container;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import blahmod.items.ModItems;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockStoneSlabNew;
import net.minecraft.block.BlockWall;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class BlahCraftManager
{
    /** The static instance of this class */
    private static final BlahCraftManager instance = new BlahCraftManager();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();

    /**
     * Returns the static instance of this class
     */
    public static BlahCraftManager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    public BlahCraftManager()
    {
        
        this.addRecipe(new ItemStack(Items.diamond, 1), "s", "l", "c", 's', ModItems.sulphur2, 'c', Blocks.coal_block, 'l', Items.lava_bucket);
        this.addRecipe(new ItemStack(Blocks.log, 1), "s", "c", 's', ModItems.sulphur2, 'c', Items.coal);
        this.addRecipe(new ItemStack(Blocks.brick_block, 1), "s", "c", 's', ModItems.sulphur2, 'c', Blocks.clay);
        this.addRecipe(new ItemStack(Blocks.sand, 1, 1), "s", "c", 's', ModItems.sulphur2, 'c', Blocks.sand);
        this.addRecipe(new ItemStack(Blocks.sand, 1), "s", "c", 's', ModItems.sulphur2, 'c', new ItemStack(Blocks.sand, 1, 1));
        this.addRecipe(new ItemStack(Blocks.end_stone, 1), "s", "c", 's', ModItems.sulphur2, 'c', Blocks.cobblestone);
        
        
        Collections.sort(this.recipes, new Comparator<IRecipe>()
        {
            public int compare(IRecipe p_compare_1_, IRecipe p_compare_2_)
            {
                return p_compare_1_ instanceof ShapelessRecipes && p_compare_2_ instanceof ShapedRecipes ? 1 : (p_compare_2_ instanceof ShapelessRecipes && p_compare_1_ instanceof ShapedRecipes ? -1 : (p_compare_2_.getRecipeSize() < p_compare_1_.getRecipeSize() ? -1 : (p_compare_2_.getRecipeSize() > p_compare_1_.getRecipeSize() ? 1 : 0)));
            }
        });
    }

    /**
     * Adds a shaped recipe to the games recipe list.
     */
    public ShapedRecipes addRecipe(ItemStack stack, Object... recipeComponents)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (recipeComponents[i] instanceof String[])
        {
            String[] astring = (String[])((String[])recipeComponents[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s2 = astring[l];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }
        else
        {
            while (recipeComponents[i] instanceof String)
            {
                String s1 = (String)recipeComponents[i++];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }

        Map<Character, ItemStack> map;

        for (map = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2)
        {
            Character character = (Character)recipeComponents[i];
            ItemStack itemstack = null;

            if (recipeComponents[i + 1] instanceof Item)
            {
                itemstack = new ItemStack((Item)recipeComponents[i + 1]);
            }
            else if (recipeComponents[i + 1] instanceof Block)
            {
                itemstack = new ItemStack((Block)recipeComponents[i + 1], 1, 32767);
            }
            else if (recipeComponents[i + 1] instanceof ItemStack)
            {
                itemstack = (ItemStack)recipeComponents[i + 1];
            }

            map.put(character, itemstack);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (map.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)map.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    /**
     * Adds a shapeless crafting recipe to the the game.
     */
    public void addShapelessRecipe(ItemStack stack, Object... recipeComponents)
    {
        List<ItemStack> list = Lists.<ItemStack>newArrayList();

        for (Object object : recipeComponents)
        {
            if (object instanceof ItemStack)
            {
                list.add(((ItemStack)object).copy());
            }
            else if (object instanceof Item)
            {
                list.add(new ItemStack((Item)object));
            }
            else
            {
                if (!(object instanceof Block))
                {
                    throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
                }

                list.add(new ItemStack((Block)object));
            }
        }

        this.recipes.add(new ShapelessRecipes(stack, list));
    }

    /**
     * Adds an IRecipe to the list of crafting recipes.
     */
    public void addRecipe(IRecipe recipe)
    {
        this.recipes.add(recipe);
    }

    /**
     * Retrieves an ItemStack that has multiple recipes for it.
     */
    public ItemStack findMatchingRecipe(InventoryCrafting craftingMatrix, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(craftingMatrix, worldIn))
            {
                return getResultForItem(craftingMatrix.getStackInSlot(0), craftingMatrix.getStackInSlot(1), craftingMatrix.getStackInSlot(2));
            }
        }

        return null;
    }

    public ItemStack[] func_180303_b(InventoryCrafting p_180303_1_, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(p_180303_1_, worldIn))
            {
                return irecipe.getRemainingItems(p_180303_1_);
            }
        }

        ItemStack[] aitemstack = new ItemStack[p_180303_1_.getSizeInventory()];

        for (int i = 0; i < aitemstack.length; ++i)
        {
            aitemstack[i] = p_180303_1_.getStackInSlot(i);
        }

        return aitemstack;
    }

    public static ItemStack getResultForItem(ItemStack stack, ItemStack c1, ItemStack c2)
	{
		
		if (stack == new ItemStack(Blocks.coal_block) && c1 == new ItemStack(ModItems.sulphur2) && c2 == new ItemStack(Items.lava_bucket)) return new ItemStack(Items.diamond, 1);
		if (stack == new ItemStack(Blocks.clay) && c1 == new ItemStack(ModItems.sulphur2)) return new ItemStack(Blocks.brick_block);
		if (stack == new ItemStack(Blocks.sand) && c1 == new ItemStack(ModItems.sulphur2)) return new ItemStack(Blocks.sand, 1, 1);
		if (stack == new ItemStack(Blocks.sand, 1, 1) && c1 == new ItemStack(ModItems.sulphur2)) return new ItemStack(Blocks.sand);
		if (stack == new ItemStack(Blocks.cobblestone, 1, 1) && c1 == new ItemStack(ModItems.sulphur2)) return new ItemStack(Blocks.end_stone);
		if (stack == new ItemStack(Items.coal) && c1 == new ItemStack(ModItems.sulphur2)) return new ItemStack(Blocks.log);
		return null;
	}
    
    /*public static ItemStack getResultForItem(ItemStack stack, ItemStack c1, ItemStack c2)
	{
    	for (int i = 1; i < 65; i++)
    	{
    		if (stack == new ItemStack(Blocks.coal_block, i) && c1 == new ItemStack(ModItems.sulphur2, i) && c2 == new ItemStack(Items.lava_bucket, i)) return new ItemStack(Items.diamond, i);
			if (stack == new ItemStack(Blocks.clay, i) && c1 == new ItemStack(ModItems.sulphur2, i)) return new ItemStack(Blocks.brick_block, i);
			if (stack == new ItemStack(Blocks.sand, i) && c1 == new ItemStack(ModItems.sulphur2, i)) return new ItemStack(Blocks.sand, i, 1);
			if (stack == new ItemStack(Blocks.sand, i, 1) && c1 == new ItemStack(ModItems.sulphur2, i)) return new ItemStack(Blocks.sand, i);
			if (stack == new ItemStack(Blocks.cobblestone, i, 1) && c1 == new ItemStack(ModItems.sulphur2, i)) return new ItemStack(Blocks.end_stone);
			if (stack == new ItemStack(Items.coal, i) && c1 == new ItemStack(ModItems.sulphur2, i)) return new ItemStack(Blocks.log, i);
    	}
		return null;
	}*/
    
    public List<IRecipe> getRecipeList()
    {
        return this.recipes;
    }
}