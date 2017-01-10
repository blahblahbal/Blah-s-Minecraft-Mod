package blahmod;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.item.BOPItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBOP
{
        public static void addRecipes()
        {
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_0, 1, 4), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_0, 1, 5), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 1));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_0, 1, 6), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 2));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_0, 1, 7), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 3));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_1, 1, 4), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 4));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_1, 1, 5), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 5));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_1, 1, 6), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 6));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_1, 1, 7), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 7));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_2, 1, 4), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 8));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_2, 1, 5), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 9));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_2, 1, 6), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 10));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_2, 1, 7), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 11));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_3, 1, 4), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 12));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_3, 1, 5), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 13));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_3, 1, 6), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 14));
                GameRegistry.addRecipe(new ItemStack(BOPBlocks.log_3, 1, 7), "# #", "   ", "# #", '#', new ItemStack(BOPBlocks.planks_0, 1, 15));

        GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 0), new ItemStack(BOPItems.sacred_oak_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 1), new ItemStack(BOPItems.cherry_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 2), new ItemStack(BOPItems.umbran_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 3), new ItemStack(BOPItems.fir_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 4), new ItemStack(BOPItems.ethereal_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 5), new ItemStack(BOPItems.magic_door));
        GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 6), new ItemStack(BOPItems.mangrove_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 7), new ItemStack(BOPItems.palm_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 8), new ItemStack(BOPItems.redwood_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 9), new ItemStack(BOPItems.willow_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 11), new ItemStack(BOPItems.pine_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 12), new ItemStack(BOPItems.hellbark_door));
        GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 13), new ItemStack(BOPItems.jacaranda_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 14), new ItemStack(BOPItems.mahogany_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 15), new ItemStack(BOPItems.ebony_door));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPBlocks.planks_0, 2, 16), new ItemStack(BOPItems.eucalyptus_door));

        GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 0), "xx", "xx", 'x', new ItemStack(BOPBlocks.sacred_oak_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 1), "xx", "xx", 'x', new ItemStack(BOPBlocks.cherry_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 2), "xx", "xx", 'x', new ItemStack(BOPBlocks.umbran_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 3), "xx", "xx", 'x', new ItemStack(BOPBlocks.fir_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 4), "xx", "xx", 'x', new ItemStack(BOPBlocks.ethereal_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 5), "xx", "xx", 'x', new ItemStack(BOPBlocks.magic_stairs));
        GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 6), "xx", "xx", 'x', new ItemStack(BOPBlocks.mangrove_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 7), "xx", "xx", 'x', new ItemStack(BOPBlocks.palm_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 8), "xx", "xx", 'x', new ItemStack(BOPBlocks.redwood_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 9), "xx", "xx", 'x', new ItemStack(BOPBlocks.willow_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 10), "xx", "xx", 'x', new ItemStack(BOPBlocks.pine_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 11), "xx", "xx", 'x', new ItemStack(BOPBlocks.hellbark_stairs));
        GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 12), "xx", "xx", 'x', new ItemStack(BOPBlocks.jacaranda_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 13), "xx", "xx", 'x', new ItemStack(BOPBlocks.mahogany_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 14), "xx", "xx", 'x', new ItemStack(BOPBlocks.ebony_stairs));
		GameRegistry.addRecipe(new ItemStack(BOPBlocks.planks_0, 6, 15), "xx", "xx", 'x', new ItemStack(BOPBlocks.eucalyptus_stairs));

		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 0), new ItemStack(BOPBlocks.gem_block, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 1), new ItemStack(BOPBlocks.gem_block, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 2), new ItemStack(BOPBlocks.gem_block, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 3), new ItemStack(BOPBlocks.gem_block, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 4), new ItemStack(BOPBlocks.gem_block, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 5), new ItemStack(BOPBlocks.gem_block, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 6), new ItemStack(BOPBlocks.gem_block, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(BOPItems.gem, 9, 7), new ItemStack(BOPBlocks.gem_block, 1, 7));
        }
}