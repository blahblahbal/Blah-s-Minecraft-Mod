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
		GameRegistry.addRecipe(new ItemStack(ModBlocks.uraniumBlock), "###","###", "###", '#', ModItems.uraniumIngot);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[0]), "###","###", "###", '#', ModItems.gems[0]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[1]), "###","###", "###", '#', ModItems.gems[1]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[2]), "###","###", "###", '#', ModItems.gems[2]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[3]), "###","###", "###", '#', ModItems.gems[3]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[4]), "###","###", "###", '#', ModItems.gems[4]);
		GameRegistry.addRecipe(new ItemStack(Blocks.obsidian), "##","##", '#', ModItems.obsidianIngot);
		GameRegistry.addRecipe(new ItemStack(Blocks.packed_ice), "##","##", '#', Blocks.ice);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.endStoneBricks), "##","##", '#', Blocks.end_stone);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cement, 8), "#x#","xxx", "yzy", '#', Blocks.clay, 'x', ModItems.limestone, 'y', Blocks.gravel, 'z', Items.water_bucket);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tadanite), "xxx", "x x", "xxx", 'x', new ItemStack(ModItems.tadaniteShard));
		GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 8), "xyx", "yxy", "xyx", 'x', new ItemStack(Blocks.cobblestone), 'y', new ItemStack(Items.wheat_seeds));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obsidianIngot, 4), new ItemStack(Blocks.obsidian));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new ItemStack(Items.bucket));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new ItemStack(Items.iron_door));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 9), new ItemStack(ModBlocks.leatherBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[0], 9), new ItemStack(ModBlocks.gemBlocks[0]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[1], 9), new ItemStack(ModBlocks.gemBlocks[1]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[2], 9), new ItemStack(ModBlocks.gemBlocks[2]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[3], 9), new ItemStack(ModBlocks.gemBlocks[3]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[4], 9), new ItemStack(ModBlocks.gemBlocks[4]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tadaniteShard, 8), new ItemStack(ModBlocks.tadanite));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.limestone, 9), new ItemStack(ModBlocks.limestoneBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sulphur2, 9), new ItemStack(ModBlocks.sulphurBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.uraniumIngot, 9), new ItemStack(ModBlocks.uraniumBlock));
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
		GameRegistry.addRecipe(new ItemStack(ModBlocks.uraniumTorch, 4), "x", "y", 'x', new ItemStack(ModItems.uraniumRod), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockPickaxe), "xxx", " y ", " y ", 'x', new ItemStack(Blocks.bedrock), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blazeBrick), "xxx", "xyx", "xxx", 'x', new ItemStack(Items.blaze_powder), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianHelmet), "xxx", "x x", 'x', new ItemStack(ModItems.obsidianIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianBoots), "x x", "x x", 'x', new ItemStack(ModItems.obsidianIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianChestplate), "x x", "xxx", "xxx", 'x', new ItemStack(ModItems.obsidianIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianLeggings), "xxx", "x x", "x x", 'x', new ItemStack(ModItems.obsidianIngot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.catalyzer), "xxx", "uuu", "yzy", 'x', new ItemStack(Blocks.planks), 'y', new ItemStack(ModBlocks.sulphurBlock), 'z', new ItemStack(Blocks.crafting_table), 'u', new ItemStack(Items.iron_ingot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.catalyzer), "xxx", "uuu", "yzy", 'x', new ItemStack(Blocks.planks, 1, 1), 'y', new ItemStack(ModBlocks.sulphurBlock), 'z', new ItemStack(Blocks.crafting_table), 'u', new ItemStack(Items.iron_ingot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.catalyzer), "xxx", "uuu", "yzy", 'x', new ItemStack(Blocks.planks, 1, 2), 'y', new ItemStack(ModBlocks.sulphurBlock), 'z', new ItemStack(Blocks.crafting_table), 'u', new ItemStack(Items.iron_ingot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.catalyzer), "xxx", "uuu", "yzy", 'x', new ItemStack(Blocks.planks, 1, 3), 'y', new ItemStack(ModBlocks.sulphurBlock), 'z', new ItemStack(Blocks.crafting_table), 'u', new ItemStack(Items.iron_ingot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.catalyzer), "xxx", "uuu", "yzy", 'x', new ItemStack(Blocks.planks, 1, 4), 'y', new ItemStack(ModBlocks.sulphurBlock), 'z', new ItemStack(Blocks.crafting_table), 'u', new ItemStack(Items.iron_ingot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.catalyzer), "xxx", "uuu", "yzy", 'x', new ItemStack(Blocks.planks, 1, 5), 'y', new ItemStack(ModBlocks.sulphurBlock), 'z', new ItemStack(Blocks.crafting_table), 'u', new ItemStack(Items.iron_ingot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs[0], 6), "xxx", 'x', new ItemStack(Blocks.wool, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs[1], 6), "xxx", 'x', new ItemStack(Blocks.iron_block));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs[2], 6), "xxx", 'x', new ItemStack(Blocks.gold_block));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs[3], 6), "xxx", 'x', new ItemStack(Blocks.diamond_block));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs[4], 6), "xxx", 'x', new ItemStack(Blocks.emerald_block));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs[5], 6), "xxx", 'x', new ItemStack(ModBlocks.sulphurBlock));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs[6], 6), "xxx", 'x', new ItemStack(ModBlocks.limestoneBlock));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs[7], 6), "xxx", 'x', new ItemStack(ModBlocks.uraniumBlock));
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs2[0], 6), "xxx", 'x', new ItemStack(Blocks.dirt, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs2[1], 6), "xxx", 'x', new ItemStack(Blocks.grass));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs2[2], 6), "xxx", 'x', new ItemStack(ModBlocks.leatherBlock));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs2[3], 6), "xxx", 'x', new ItemStack(Blocks.lapis_block));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs2[4], 6), "xxx", 'x', new ItemStack(Blocks.obsidian));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs2[5], 6), "xxx", 'x', new ItemStack(Blocks.mossy_cobblestone));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs2[6], 6), "xxx", 'x', new ItemStack(ModBlocks.endStoneBricks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs2[7], 6), "xxx", 'x', new ItemStack(ModBlocks.tadanite));
		
		GameRegistry.addSmelting(ModBlocks.uraniumOre, new ItemStack(ModItems.uraniumIngot), 5F);
		GameRegistry.addSmelting(ModBlocks.limestoneOre, new ItemStack(ModItems.limestone), 4F);
		GameRegistry.addSmelting(ModBlocks.sulphurOre, new ItemStack(ModItems.sulphur2), 2F);
		GameRegistry.addSmelting(ModBlocks.tadaniteOre, new ItemStack(ModItems.tadaniteShard), 6F);
		GameRegistry.addSmelting(ModBlocks.clayOre, new ItemStack(Items.clay_ball), .5F);
	}
}



