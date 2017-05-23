package main.java.blahblahbal.blahmod;

import thaumcraft.api.items.ItemsTC;
import main.java.blahblahbal.blahmod.blocks.ModBlocks;
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
    }
}
