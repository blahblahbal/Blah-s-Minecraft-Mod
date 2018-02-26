package blahblahbal.blahmod.guicontainer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.crafting.BlahRecipeSorter;
import blahblahbal.blahmod.crafting.BlahRecipes;
import blahblahbal.blahmod.items.ModItems;
import blahblahbal.blahmod.tileentity.ModTileEntity;

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
import net.minecraft.inventory.IInventory;
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
        
        this.addRecipe(new ItemStack(Items.diamond, 1), ModItems.sulphur2, Blocks.coal_block, Items.lava_bucket);
        this.addRecipe(new ItemStack(Items.lava_bucket, 1), ModItems.sulphur2, Items.bucket, ModBlocks.hardenedLava);
        this.addRecipe(new ItemStack(Blocks.log, 1), ModItems.sulphur2, Items.coal);
        this.addRecipe(new ItemStack(Blocks.brick_block, 1), ModItems.sulphur2, Blocks.clay);
        this.addRecipe(new ItemStack(Blocks.sand, 1, 1), ModItems.sulphur2, Blocks.sand);
        this.addRecipe(new ItemStack(ModBlocks.blackSand, 1), ModItems.sulphur2, new ItemStack(Blocks.sand, 1, 1));
        this.addRecipe(new ItemStack(Blocks.sand, 1), ModItems.sulphur2, new ItemStack(ModBlocks.blackSand));
        this.addRecipe(new ItemStack(ModBlocks.blackSand), ModItems.sulphur2, new ItemStack(Blocks.sand, 1, 1), ModItems.tadaniteShard);
        this.addRecipe(new ItemStack(ModBlocks.blackSand), ModItems.sulphur2, Blocks.sand, ModItems.tadaniteShard);
        this.addRecipe(new ItemStack(Blocks.end_stone, 1), ModItems.sulphur2, Blocks.cobblestone);
        this.addRecipe(new ItemStack(Blocks.cobblestone, 1), ModItems.sulphur2, Blocks.end_stone);
        this.addRecipe(new ItemStack(Items.melon_seeds, 1), ModItems.sulphur2, Items.wheat_seeds);
        this.addRecipe(new ItemStack(Items.pumpkin_seeds, 1), ModItems.sulphur2, Items.melon_seeds);
        this.addRecipe(new ItemStack(Items.wheat_seeds, 1), ModItems.sulphur2, Items.pumpkin_seeds);
        this.addRecipe(new ItemStack(Blocks.bedrock, 1), ModItems.sulphur2, ModBlocks.compressedObsidian, ModBlocks.flintBlock);
        this.addRecipe(new ItemStack(ModItems.uraniumRod, 1), ModItems.sulphur2, ModItems.uraniumIngot);
        this.addRecipe(new ItemStack(Blocks.log, 1, 2), ModItems.sulphur2, new ItemStack(Blocks.log, 1));
        this.addRecipe(new ItemStack(Blocks.log, 1, 1), ModItems.sulphur2, new ItemStack(Blocks.log, 1, 2));
        this.addRecipe(new ItemStack(Blocks.log, 1, 3), ModItems.sulphur2, new ItemStack(Blocks.log, 1, 1));
        this.addRecipe(new ItemStack(Blocks.log2, 1), ModItems.sulphur2, new ItemStack(Blocks.log, 1, 3));
        this.addRecipe(new ItemStack(Blocks.log2, 1, 1), ModItems.sulphur2, new ItemStack(Blocks.log2, 1));
        this.addRecipe(new ItemStack(Blocks.log, 1), ModItems.sulphur2, new ItemStack(Blocks.log2, 1, 1));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.log), new ItemStack(Blocks.stone));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.log, 1, 1), new ItemStack(Blocks.stone));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.log, 1, 2), new ItemStack(Blocks.stone));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.log, 1, 3), new ItemStack(Blocks.stone));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.log2), new ItemStack(Blocks.stone));
        this.addRecipe(new ItemStack(ModBlocks.petrifiedWood), ModItems.sulphur2, new ItemStack(Blocks.log2, 1, 1), new ItemStack(Blocks.stone));
        this.addRecipe(new ItemStack(ModItems.gems[0]), ModItems.sulphur2, new ItemStack(ModItems.gems[4]));
        this.addRecipe(new ItemStack(ModItems.gems[1]), ModItems.sulphur2, new ItemStack(ModItems.gems[0]));
        this.addRecipe(new ItemStack(ModItems.gems[2]), ModItems.sulphur2, new ItemStack(ModItems.gems[1]));
        this.addRecipe(new ItemStack(Items.emerald), ModItems.sulphur2, new ItemStack(ModItems.gems[2]));
        this.addRecipe(new ItemStack(ModItems.gems[3]), ModItems.sulphur2, new ItemStack(Items.emerald));
        this.addRecipe(new ItemStack(ModItems.gems[4]), ModItems.sulphur2, new ItemStack(ModItems.gems[3]));
        this.addRecipe(new ItemStack(Blocks.sapling, 1, 2), ModItems.sulphur2, new ItemStack(Blocks.sapling, 1));
        this.addRecipe(new ItemStack(Blocks.sapling, 1, 1), ModItems.sulphur2, new ItemStack(Blocks.sapling, 1, 2));
        this.addRecipe(new ItemStack(Blocks.sapling, 1, 3), ModItems.sulphur2, new ItemStack(Blocks.sapling, 1, 1));
        this.addRecipe(new ItemStack(Blocks.sapling, 1, 4), ModItems.sulphur2, new ItemStack(Blocks.sapling, 1, 3));
        this.addRecipe(new ItemStack(Blocks.sapling, 1, 5), ModItems.sulphur2, new ItemStack(Blocks.sapling, 1, 4));
        this.addRecipe(new ItemStack(Blocks.sapling, 1), ModItems.sulphur2, new ItemStack(Blocks.sapling, 1, 5));
        
        
        
        
        
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

    public ItemStack[] func_180303_b(IInventory craftInv, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches((InventoryCrafting)craftInv, worldIn))
            {
                return irecipe.getRemainingItems((InventoryCrafting)craftInv);
            }
        }

        ItemStack[] aitemstack = new ItemStack[craftInv.getSizeInventory()];

        for (int i = 0; i < aitemstack.length; ++i)
        {
            aitemstack[i] = craftInv.getStackInSlot(i);
        }

        return aitemstack;
    }
    public List<BlahRecipes> getRecipeList()
    {
        return this.recipes;
    }
}