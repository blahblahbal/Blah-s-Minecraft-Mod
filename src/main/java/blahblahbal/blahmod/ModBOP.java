package blahblahbal.blahmod;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.item.BOPItems;
import biomesoplenty.common.block.BlockBOPDoor;
import biomesoplenty.common.block.BlockBOPHalfWoodSlab;
import biomesoplenty.common.block.BlockBOPLog;
import biomesoplenty.common.block.BlockBOPPlanks;
import biomesoplenty.common.block.BlockBOPStone;
import biomesoplenty.common.block.BlockBOPStone.StoneType;
import biomesoplenty.common.block.BlockBOPWoodStairs;
import biomesoplenty.common.enums.BOPWoods;
import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.items.ModItems;
import blahblahbal.blahmod.world.BlahWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBOP
{
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", StoneType.class);
	
    public static void addRecipes()
    {
    	
    	for (BOPWoods wood : BOPWoods.values())
    	{
    		if (!wood.hasPlanks()) continue;
    		GameRegistry.addShapedRecipe(BlockBOPLog.paging.getVariantItem(wood), new Object[] {"# #", "   ", "# #", '#', BlockBOPPlanks.paging.getVariantItem(wood)});
    		GameRegistry.addShapelessRecipe(BlockBOPPlanks.paging.getVariantItem(wood, 2), BlockBOPDoor.getBlock(wood).getDoorItem());
    		GameRegistry.addShapedRecipe(BlockBOPPlanks.paging.getVariantItem(wood, 6), new Object[] {"##", "##", '#', BlockBOPWoodStairs.getBlock(wood)});
    		GameRegistry.addShapedRecipe(BlockBOPPlanks.paging.getVariantItem(wood), new Object[] {"###", "###", '#', BlockBOPHalfWoodSlab.paging.getVariantItem(wood)});
    		
    	}
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 0), new ItemStack(BOPBlocks.gem_block, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 1), new ItemStack(BOPBlocks.gem_block, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 2), new ItemStack(BOPBlocks.gem_block, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 3), new ItemStack(BOPBlocks.gem_block, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 4), new ItemStack(BOPBlocks.gem_block, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 5), new ItemStack(BOPBlocks.gem_block, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 6), new ItemStack(BOPBlocks.gem_block, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 7), new ItemStack(BOPBlocks.gem_block, 1, 7));
		GameRegistry.addRecipe(new ItemStack(ModItems.megaBerry), "XXX", "XXX", "XXX", 'X', BOPItems.berries);
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.berries, 9), new ItemStack(ModItems.megaBerry));
	}
	public static void genStuff()
	{
		GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)BOPBlocks.stone.getDefaultState().withProperty(BlockBOPStone.POLISHED, Boolean.valueOf(false)).withProperty(BlockBOPStone.VARIANT, BlockBOPStone.StoneType.SHALE).getBlock(), (Blocks.stone), new int[]{0}, 35, 10, 1, 15), 0);
		GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)BOPBlocks.stone.getDefaultState().withProperty(BlockBOPStone.POLISHED, Boolean.valueOf(false)).withProperty(BlockBOPStone.VARIANT, BlockBOPStone.StoneType.SILTSTONE).getBlock(), (Blocks.stone), new int[]{0}, 45, 24, 1, 10), 0);
		GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)BOPBlocks.stone.getDefaultState().withProperty(BlockBOPStone.POLISHED, Boolean.valueOf(false)).withProperty(BlockBOPStone.VARIANT, BlockBOPStone.StoneType.LIMESTONE).getBlock(), (Blocks.stone), new int[]{0}, 35, 30, 1, 10), 0);
	}
}