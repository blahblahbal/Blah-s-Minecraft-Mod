package blahblahbal.blahmod.guicontainer;

import com.google.common.collect.Lists;

import blahblahbal.blahmod.init.ModBlocks;
import blahblahbal.blahmod.crafting.BlahRecipeSorter;
import blahblahbal.blahmod.crafting.BlahRecipes;
import blahblahbal.blahmod.init.ModItems;
//import blahblahbal.blahmod.tileentity.ModTileEntity;

import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class BlahCraftManager
{
    /** The static instance of this class */
    public static final BlahCraftManager instance = new BlahCraftManager();
    private final List<BlahRecipes> recipes = Lists.<BlahRecipes>newArrayList();
    public static List<Item> catalyst1List = Lists.<Item>newArrayList();
    public static List<Item> catalyst2List = Lists.<Item>newArrayList();
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
        
        this.addRecipe(new ItemStack(Items.DIAMOND, 1), ModItems.sulphur2, Blocks.COAL_BLOCK, Items.LAVA_BUCKET);
        this.addRecipe(new ItemStack(Items.LAVA_BUCKET, 1), ModItems.sulphur2, Items.BUCKET, ModBlocks.hardenedLava);
        this.addRecipe(new ItemStack(Blocks.LOG, 1), ModItems.sulphur2, Items.COAL);
        this.addRecipe(new ItemStack(Blocks.BRICK_BLOCK, 1), ModItems.sulphur2, Blocks.CLAY);
        this.addRecipe(new ItemStack(Blocks.SAND, 1, 1), ModItems.sulphur2, Blocks.SAND);
        this.addRecipe(new ItemStack(ModBlocks.blackSand, 1), ModItems.sulphur2, new ItemStack(Blocks.SAND, 1, 1));
        this.addRecipe(new ItemStack(Blocks.SAND, 1), ModItems.sulphur2, new ItemStack(ModBlocks.blackSand));
        this.addRecipe(new ItemStack(ModBlocks.blackSand), ModItems.sulphur2, new ItemStack(Blocks.SAND, 1, 1), ModItems.tadaniteShard);
        this.addRecipe(new ItemStack(ModBlocks.blackSand), ModItems.sulphur2, Blocks.SAND, ModItems.tadaniteShard);
        this.addRecipe(new ItemStack(Blocks.END_STONE, 1), ModItems.sulphur2, Blocks.COBBLESTONE);
        this.addRecipe(new ItemStack(Blocks.COBBLESTONE, 1), ModItems.sulphur2, Blocks.END_STONE);
        this.addRecipe(new ItemStack(Items.MELON_SEEDS, 1), ModItems.sulphur2, Items.WHEAT_SEEDS);
        this.addRecipe(new ItemStack(Items.PUMPKIN_SEEDS, 1), ModItems.sulphur2, Items.MELON_SEEDS);
        this.addRecipe(new ItemStack(Items.WHEAT_SEEDS, 1), ModItems.sulphur2, Items.PUMPKIN_SEEDS);
        this.addRecipe(new ItemStack(Blocks.BEDROCK, 1), ModItems.sulphur2, ModBlocks.compressedObsidian, ModBlocks.flintBlock);
        this.addRecipe(new ItemStack(Blocks.LOG, 1, 2), ModItems.sulphur2, new ItemStack(Blocks.LOG, 1));
        this.addRecipe(new ItemStack(Blocks.LOG, 1, 1), ModItems.sulphur2, new ItemStack(Blocks.LOG, 1, 2));
        this.addRecipe(new ItemStack(Blocks.LOG, 1, 3), ModItems.sulphur2, new ItemStack(Blocks.LOG, 1, 1));
        this.addRecipe(new ItemStack(Blocks.LOG2, 1), ModItems.sulphur2, new ItemStack(Blocks.LOG, 1, 3));
        this.addRecipe(new ItemStack(Blocks.LOG2, 1, 1), ModItems.sulphur2, new ItemStack(Blocks.LOG2, 1));
        this.addRecipe(new ItemStack(Blocks.LOG, 1), ModItems.sulphur2, new ItemStack(Blocks.LOG2, 1, 1));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.LOG), new ItemStack(Blocks.STONE));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.LOG, 1, 1), new ItemStack(Blocks.STONE));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.LOG, 1, 2), new ItemStack(Blocks.STONE));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.LOG, 1, 3), new ItemStack(Blocks.STONE));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.LOG2), new ItemStack(Blocks.STONE));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.LOG2, 1, 1), new ItemStack(Blocks.STONE));
        this.addRecipe(new ItemStack(Blocks.SAPLING, 1, 2), ModItems.sulphur2, new ItemStack(Blocks.SAPLING, 1));
        this.addRecipe(new ItemStack(Blocks.SAPLING, 1, 1), ModItems.sulphur2, new ItemStack(Blocks.SAPLING, 1, 2));
        this.addRecipe(new ItemStack(Blocks.SAPLING, 1, 3), ModItems.sulphur2, new ItemStack(Blocks.SAPLING, 1, 1));
        this.addRecipe(new ItemStack(Blocks.SAPLING, 1, 4), ModItems.sulphur2, new ItemStack(Blocks.SAPLING, 1, 3));
        this.addRecipe(new ItemStack(Blocks.SAPLING, 1, 5), ModItems.sulphur2, new ItemStack(Blocks.SAPLING, 1, 4));
        this.addRecipe(new ItemStack(Blocks.SAPLING, 1), ModItems.sulphur2, new ItemStack(Blocks.SAPLING, 1, 5));
        
        
        
        
        
        this.addRecipe(new ItemStack(ModItems.catalyticInverter, 1), ModBlocks.sulphurBlock, new ItemStack(ModBlocks.lumiteBlock), new ItemStack(ModItems.osborgnenFuel));
        
        
        
        
        Collections.sort(this.recipes, new BlahRecipeSorter(this));
    }

    /**
     * Adds a shapeless crafting recipe to the the game.
     */
    public void addRecipe(ItemStack stack, Object... recipeComponents)
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

        this.recipes.add(new BlahRecipes(stack, list));
    }

    /**
     * Adds an IRecipe to the list of crafting recipes.
     */
    public void addRecipe(BlahRecipes recipe)
    {
        this.recipes.add(recipe);
    }

    /**
     * Retrieves an ItemStack that has multiple recipes for it.
     */
    
    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
    	for (BlahRecipes var12 : this.recipes)
    	{
    		if (var12.matches(par1InventoryCrafting, par2World))
    		{
    			return var12.getCraftingResult(par1InventoryCrafting);
    		}
    	}
    	return null;
    }

    public NonNullList<ItemStack> getRemainingItems(IInventory craftInv, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches((InventoryCrafting)craftInv, worldIn))
            {
                return irecipe.getRemainingItems((InventoryCrafting)craftInv);
            }
        }
        NonNullList<ItemStack> aitemstack = NonNullList.<ItemStack>withSize(craftInv.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < aitemstack.size(); ++i)
        {
            aitemstack.set(i, craftInv.getStackInSlot(i));
        }

        return aitemstack;
    }
    public List<BlahRecipes> getRecipeList()
    {
        return this.recipes;
    }
}