package blahmod.crafting;

import blahmod.blocks.ModBlocks;
import blahmod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting
{

	public static void initCrafting()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.acidBucket), new ItemStack(Items.redstone), new ItemStack(Items.slime_ball), new ItemStack(Items.water_bucket));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.leatherBlock), "###","###", "###", '#', Items.leather);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.limestoneBlock), "###","###", "###", '#', ModItems.limestone);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sulphurBlock), "###","###", "###", '#', ModItems.sulphur2);
		GameRegistry.addRecipe(new ItemStack(Blocks.obsidian), "##","##", '#', ModItems.obsidianIngot);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cement, 8), "#x#","xxx", "yzy", '#', Blocks.clay, 'x', ModItems.limestone, 'y', Blocks.gravel, 'z', Items.water_bucket);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tadanite), "xxx", "x x", "xxx", 'x', new ItemStack(ModItems.tadaniteShard));
		GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 8), "xyx", "yxy", "xyx", 'x', new ItemStack(Blocks.cobblestone), 'y', new ItemStack(Items.wheat_seeds));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obsidianIngot, 4), new ItemStack(Blocks.obsidian));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new ItemStack(Items.bucket));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 9), new ItemStack(ModBlocks.leatherBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tadaniteShard, 8), new ItemStack(ModBlocks.tadanite));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.limestone, 9), new ItemStack(ModBlocks.limestoneBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sulphur2, 9), new ItemStack(ModBlocks.sulphurBlock));
		GameRegistry.addRecipe(new ItemStack(Items.saddle), "xxx", "xyx", "z z", 'x', new ItemStack(Items.leather), 'y', new ItemStack(Items.string), 'z', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianPickaxe), "xxx", " y ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianSword), " x ", " x ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianAxe), "xx ", "xy ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianAxe), " xx", " yx", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianShovel), " x ", " y ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianHoe), "xx ", " y ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianHoe), " xx", " y ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadanitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(ModItems.tadaniteShard), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteSword), " x ", " x ", " y ", 'x', new ItemStack(ModItems.tadaniteShard), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteAxe), "xx ", "xy ", " y ", 'x', new ItemStack(ModItems.tadaniteShard), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteAxe), " xx", " yx", " y ", 'x', new ItemStack(ModItems.tadaniteShard), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteShovel), " x ", " y ", " y ", 'x', new ItemStack(ModItems.tadaniteShard), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteHoe), "xx ", " y ", " y ", 'x', new ItemStack(ModItems.tadaniteShard), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteHoe), " xx", " y ", " y ", 'x', new ItemStack(ModItems.tadaniteShard), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteHelmet), "xxx", "x x", 'x', new ItemStack(ModItems.tadaniteShard));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteBoots), "x x", "x x", 'x', new ItemStack(ModItems.tadaniteShard));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteChestplate), "x x", "xxx", "xxx", 'x', new ItemStack(ModItems.tadaniteShard));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteLeggings), "xxx", "x x", "x x", 'x', new ItemStack(ModItems.tadaniteShard));
	}
}



