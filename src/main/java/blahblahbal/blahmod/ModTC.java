package blahblahbal.blahmod;

import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.ItemsTC;
import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.crafting.SmelteryRecipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTC
{
	public static void addRecipes()
    {
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsTC.quicksilver, 9), new ItemStack(ModBlocks.quicksilverBlock));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.quicksilverBlock), "###", "###", "###", '#', new ItemStack(ItemsTC.quicksilver));
		SmelteryRecipes.instance().addSmeltingRecipeForBlock(BlocksTC.oreCinnabar, new ItemStack(ItemsTC.quicksilver, 2), 1.0F);
    }
}