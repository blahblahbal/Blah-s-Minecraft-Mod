package main.java.blahblahbal.blahmod.crafting;

import com.google.common.collect.Maps;

import main.java.blahblahbal.blahmod.blocks.ModBlocks;
import main.java.blahblahbal.blahmod.items.ModItems;

import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmelteryRecipes
{
    private static final SmelteryRecipes smeltingBase = new SmelteryRecipes();
    private Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
    private Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static SmelteryRecipes instance()
    {
        return smeltingBase;
    }

    private SmelteryRecipes()
    {
        this.addSmeltingRecipeForBlock(Blocks.iron_ore, new ItemStack(Items.iron_ingot, 2), 0.7F);
        this.addSmeltingRecipeForBlock(Blocks.gold_ore, new ItemStack(Items.gold_ingot, 2), 1.0F);
        this.addSmeltingRecipeForBlock(Blocks.diamond_ore, new ItemStack(Items.diamond, 2), 1.0F);
        this.addSmeltingRecipeForBlock(Blocks.sand, new ItemStack(Blocks.glass, 2), 0.1F);
        this.addSmelting(Items.porkchop, new ItemStack(Items.cooked_porkchop, 2), 0.35F);
        this.addSmelting(Items.beef, new ItemStack(Items.cooked_beef, 2), 0.35F);
        this.addSmelting(Items.chicken, new ItemStack(Items.cooked_chicken, 2), 0.35F);
        this.addSmelting(Items.rabbit, new ItemStack(Items.cooked_rabbit, 2), 0.35F);
        this.addSmelting(Items.mutton, new ItemStack(Items.cooked_mutton, 2), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.cobblestone, new ItemStack(Blocks.stone, 2), 0.1F);
        this.addSmeltingRecipe(new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.DEFAULT_META), new ItemStack(Blocks.stonebrick, 2, BlockStoneBrick.CRACKED_META), 0.1F);
        this.addSmelting(Items.clay_ball, new ItemStack(Items.brick), 0.3F);
        this.addSmeltingRecipeForBlock(Blocks.clay, new ItemStack(Blocks.hardened_clay), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.cactus, new ItemStack(Items.dye, 2, EnumDyeColor.GREEN.getDyeDamage()), 0.2F);
        this.addSmeltingRecipeForBlock(Blocks.log, new ItemStack(Items.coal, 2, 1), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.log2, new ItemStack(Items.coal, 2, 1), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.emerald_ore, new ItemStack(Items.emerald), 1.0F);
        this.addSmelting(Items.potato, new ItemStack(Items.baked_potato, 2), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.netherrack, new ItemStack(Items.netherbrick, 2), 0.1F);
        this.addSmeltingRecipe(new ItemStack(Blocks.sponge, 1, 1), new ItemStack(Blocks.sponge, 2, 0), 0.15F);

        this.addSmeltingRecipeForBlock(ModBlocks.uraniumOre, new ItemStack(ModItems.uraniumIngot), 20F);
        this.addSmeltingRecipeForBlock(ModBlocks.lumiteOre, new ItemStack(ModItems.lumite, 2), 25F);
        this.addSmeltingRecipeForBlock(ModBlocks.limestoneOre, new ItemStack(ModItems.limestone, 2), 2F);
        this.addSmeltingRecipeForBlock(ModBlocks.sulphurOre, new ItemStack(ModItems.sulphur2, 2), 10F);
        this.addSmeltingRecipeForBlock(ModBlocks.tadaniteOre, new ItemStack(ModItems.tadaniteShard, 4), 15F);
        this.addSmeltingRecipeForBlock(ModBlocks.clayOre, new ItemStack(Items.clay_ball, 4), .5F);
        this.addSmeltingRecipeForBlock(Blocks.obsidian, new ItemStack(ModItems.obsidianIngot, 2), 3F);
        this.addSmeltingRecipeForBlock(ModBlocks.blackSand, new ItemStack(ModBlocks.reinforcedGlass, 2), .5F);
        this.addSmeltingRecipeForBlock(ModBlocks.tropicCobblestone, new ItemStack(ModBlocks.tropicStone, 2), .5F);
        this.addSmeltingRecipeForBlock(ModBlocks.coalOre, new ItemStack(Items.coal, 2), .5F);
        this.addSmeltingRecipeForBlock(ModBlocks.ironOre, new ItemStack(Items.iron_ingot, 2), 2F);
        this.addSmeltingRecipeForBlock(ModBlocks.goldOre, new ItemStack(Items.gold_ingot, 2), 2F);
        //this.addSmeltingRecipeForBlock(ModBlocks.caesiumOre, new ItemStack(ModItems.caesiumIngot), .5F);
        
        for (ItemFishFood.FishType itemfishfood$fishtype : ItemFishFood.FishType.values())
        {
            if (itemfishfood$fishtype.canCook())
            {
                this.addSmeltingRecipe(new ItemStack(Items.fish, 2, itemfishfood$fishtype.getMetadata()), new ItemStack(Items.cooked_fish, 1, itemfishfood$fishtype.getMetadata()), 0.35F);
            }
        }

        this.addSmeltingRecipeForBlock(Blocks.coal_ore, new ItemStack(Items.coal, 2), 0.1F);
        this.addSmeltingRecipeForBlock(Blocks.redstone_ore, new ItemStack(Items.redstone, 6), 0.7F);
        this.addSmeltingRecipeForBlock(Blocks.lapis_ore, new ItemStack(Items.dye, 4, EnumDyeColor.BLUE.getDyeDamage()), 0.2F);
        this.addSmeltingRecipeForBlock(Blocks.quartz_ore, new ItemStack(Items.quartz, 2), 0.2F);
    }

    /**
     * Adds a smelting recipe, where the input item is an instance of Block.
     */
    public void addSmeltingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addSmelting(Item.getItemFromBlock(input), stack, experience);
    }

    /**
     * Adds a smelting recipe using an Item as the input item.
     */
    public void addSmelting(Item input, ItemStack stack, float experience)
    {
        this.addSmeltingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    /**
     * Adds a smelting recipe using an ItemStack as the input for the recipe.
     */
    public void addSmeltingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getSmeltingResult(input) != null) { net.minecraftforge.fml.common.FMLLog.info("Ignored smelting recipe with conflicting input: " + input + " = " + stack); return; }
        this.smeltingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return (ItemStack)entry.getValue();
            }
        }

        return null;
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }

        return 0.0F;
    }
}