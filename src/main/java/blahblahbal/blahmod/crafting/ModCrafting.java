package blahblahbal.blahmod.crafting;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public final class ModCrafting
{
	public static void initCrafting()
	{
		for (int i = 0; i < 10; i++)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.newWool[i]), new ItemStack(ModItems.dyeNew[i]), new ItemStack(Blocks.wool, 1, 0));
			GameRegistry.addRecipe(new ShapedOreRecipe(Items.bed, "xxx", "yyy", 'x', ModBlocks.newWool[i], 'y', "plankWood"));
		}
		/*ItemStack is = new ItemStack(Items.potionitem);
		if (is.hasTagCompound() && is.getTagCompound().hasKey("CustomPotionEffects", 9))
		{
			NBTTagList nbttaglist = is.getTagCompound().getTagList("CustomPotionEffects", 10);
			
		}*/
		//BrewingRecipeRegistry.addRecipe(new ItemStack(Items.potionitem, 1, 16), new ItemStack(Blocks.gold_block), new ItemStack(Items.potionitem).setTagCompound();
		
		// -- NEW DYES --
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[0]), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[1]), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[2]), new ItemStack(Items.dye, 1, 6), new ItemStack(Items.dye, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[3]), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[4]), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[5]), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[6]), new ItemStack(Items.dye, 1, 10), new ItemStack(Items.dye, 1, 12));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[7]), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[8]), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dyeNew[9]), new ItemStack(Items.dye, 1, 10), new ItemStack(Items.dye, 1, 11));
		// -- END NEW DYES --
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.acidBucket), new ItemStack(Items.redstone), new ItemStack(Items.slime_ball), new ItemStack(Items.water_bucket));
		// -- WOOD STUFF --
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.sequoiaPlanks, 4), new ItemStack(ModBlocks.sequoiaLog));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.frostPlanks, 4), new ItemStack(ModBlocks.frostLog));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.palmPlanks, 4), new ItemStack(ModBlocks.palmLog));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.cedarPlanks, 4), new ItemStack(ModBlocks.cedarLog));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaLog), "# #", "   ", "# #", '#', new ItemStack(ModBlocks.sequoiaPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.iceCreamBlock), "XX", "XX", 'X', ModItems.iceCream);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadRockBricks), "XX", "XX", 'X', ModBlocks.dreadRock);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.iceCream, 4), new ItemStack(ModBlocks.iceCreamBlock));
		GameRegistry.addRecipe(new ItemStack(ModItems.frostRod, 2), "IBI", "BTB", "IBI", 'I', ModBlocks.iceCreamBlock, 'B', Items.blaze_rod, 'T', new ItemStack(ModBlocks.tadanite));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.ironSideSlab, 6), "x", "x", "x", 'x', Blocks.iron_block);
		GameRegistry.addRecipe(new ItemStack(Blocks.iron_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.ironSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.goldSideSlab, 6), "x", "x", "x", 'x', Blocks.gold_block);
		GameRegistry.addRecipe(new ItemStack(Blocks.gold_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.goldSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.diamondSideSlab, 6), "x", "x", "x", 'x', Blocks.diamond_block);
		GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.diamondSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.emeraldSideSlab, 6), "x", "x", "x", 'x', Blocks.emerald_block);
		GameRegistry.addRecipe(new ItemStack(Blocks.emerald_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.emeraldSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sulphurSideSlab, 6), "x", "x", "x", 'x', ModBlocks.sulphurBlock);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sulphurBlock, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.sulphurSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.limestoneSideSlab, 6), "x", "x", "x", 'x', ModBlocks.limestoneBlock);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.limestoneBlock, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.limestoneSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.oakSideSlab, 6), "x", "x", "x", 'x', new ItemStack(Blocks.planks, 1, 0));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.oakSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.acaciaSideSlab, 6), "x", "x", "x", 'x', new ItemStack(Blocks.planks, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 4), "xxx", "xxx", 'x', new ItemStack(ModBlocks.acaciaSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.darkOakSideSlab, 6), "x", "x", "x", 'x', new ItemStack(Blocks.planks, 1, 5));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 5), "xxx", "xxx", 'x', new ItemStack(ModBlocks.darkOakSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.spruceSideSlab, 6), "x", "x", "x", 'x', new ItemStack(Blocks.planks, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 1), "xxx", "xxx", 'x', new ItemStack(ModBlocks.spruceSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.jungleSideSlab, 6), "x", "x", "x", 'x', new ItemStack(Blocks.planks, 1, 3));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.jungleSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.birchSideSlab, 6), "x", "x", "x", 'x', new ItemStack(Blocks.planks, 1, 2));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 2), "xxx", "xxx", 'x', new ItemStack(ModBlocks.birchSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaSideSlab, 6), "x", "x", "x", 'x', ModBlocks.sequoiaPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.sequoiaSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarSideSlab, 6), "x", "x", "x", 'x', ModBlocks.cedarPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.cedarSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tropicsSideSlab, 6), "x", "x", "x", 'x', ModBlocks.palmPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.palmPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.tropicsSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadSideSlab, 6), "x", "x", "x", 'x', ModBlocks.deadPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.deadPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.dreadSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostSideSlab, 6), "x", "x", "x", 'x', ModBlocks.frostPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostPlanks, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.frostSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blazeSideSlab, 6), "x", "x", "x", 'x', ModBlocks.blazeBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blazeBrick, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.blazeSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.lapisSideSlab, 6), "x", "x", "x", 'x', Blocks.lapis_block);
		GameRegistry.addRecipe(new ItemStack(Blocks.lapis_block, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.lapisSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.obsidianSideSlab, 6), "x", "x", "x", 'x', Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(Blocks.obsidian, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.obsidianSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tadaniteSideSlab, 6), "x", "x", "x", 'x', ModBlocks.tadanite);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tadanite, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.tadaniteSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.mossSideSlab, 6), "x", "x", "x", 'x', Blocks.mossy_cobblestone);
		GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.mossSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dirtSideSlab, 6), "x", "x", "x", 'x', Blocks.dirt);
		GameRegistry.addRecipe(new ItemStack(Blocks.dirt, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.dirtSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.petrifiedWoodSideSlab, 6), "x", "x", "x", 'x', ModBlocks.petrifiedWood);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.petrifiedWood, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.petrifiedWoodSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.netherBrickSideSlab, 6), "x", "x", "x", 'x', Blocks.nether_brick);
		GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.netherBrickSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.netherFrostBrickSideSlab, 6), "x", "x", "x", 'x', ModBlocks.frostBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostBrick, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.netherFrostBrickSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.quartzSideSlab, 6), "x", "x", "x", 'x', Blocks.quartz_block);
		GameRegistry.addRecipe(new ItemStack(Blocks.quartz_block, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.quartzSideSlab));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cobblestoneSideSlab, 6), "x", "x", "x", 'x', Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 3), "xxx", "xxx", 'x', new ItemStack(ModBlocks.cobblestoneSideSlab));
		
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.frostSapling, 8), "XXX", "XYX", "XXX", 'X', new ItemStack(ModBlocks.netherIce), 'Y', new ItemStack(ModBlocks.frostBrick));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostLog), "# #", "   ", "# #", '#', new ItemStack(ModBlocks.frostPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadLog), "# #", "   ", "# #", '#', new ItemStack(ModBlocks.deadPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.palmLog), "# #", "   ", "# #", '#', new ItemStack(ModBlocks.palmPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarLog), "# #", "   ", "# #", '#', new ItemStack(ModBlocks.cedarPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.cedarPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.glassStairs, 4), "x  ", "xx ", "xxx", 'x', Blocks.glass);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.reinGlassStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.reinforcedGlass);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blazeStairs, 8), "x  ", "xx ", "xxx", 'x', ModBlocks.blazeBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostBrickStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.frostBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blazeStairs, 8), "  x", " xx", "xxx", 'x', ModBlocks.blazeBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostBrickStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.frostBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.palmStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.palmPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.sequoiaPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cementStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.cement);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.deadPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.frostPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tropicStoneBrickStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.tropicStoneBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.netherIceBrickStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.netherIceBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.petrifiedWoodStairs, 4), "x  ", "xx ", "xxx", 'x', ModBlocks.petrifiedWood);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.cedarPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.palmStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.palmPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.sequoiaPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cementStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.cement);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.deadPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.frostPlanks);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.netherIceBrickStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.netherIceBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tropicStoneBrickStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.tropicStoneBrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.petrifiedWoodStairs, 4), "  x", " xx", "xxx", 'x', ModBlocks.petrifiedWood);
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.deadPlanks, 4), new ItemStack(ModBlocks.dreadLog));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarFence, 3), "xyx", "xyx", 'x', ModBlocks.cedarPlanks, 'y', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostFence, 3), "xyx", "xyx", 'x', ModBlocks.frostPlanks, 'y', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.palmFence, 3), "xyx", "xyx", 'x', ModBlocks.palmPlanks, 'y', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaFence, 3), "xyx", "xyx", 'x', ModBlocks.sequoiaPlanks, 'y', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadFence, 3), "xyx", "xyx", 'x', ModBlocks.deadPlanks, 'y', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarFenceGate, 3), "xyx", "xyx", 'y', ModBlocks.cedarPlanks, 'x', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostFenceGate, 3), "xyx", "xyx", 'y', ModBlocks.frostPlanks, 'x', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.palmFenceGate, 3), "xyx", "xyx", 'y', ModBlocks.palmPlanks, 'x', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaFenceGate, 3), "xyx", "xyx", 'y', ModBlocks.sequoiaPlanks, 'x', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadFenceGate, 3), "xyx", "xyx", 'y', ModBlocks.deadPlanks, 'x', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.petrifiedWoodWall, 6), "xxx", "xxx", 'x', ModBlocks.petrifiedWood);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.lantern, 3), " x ", "zyz", " x ", 'x', Blocks.stone_slab, 'y', Blocks.torch, 'z', Blocks.glass_pane);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.lanternFloor, 3), " x ", "zyz", "xxx", 'x', Blocks.stone_slab, 'y', Blocks.torch, 'z', Blocks.glass_pane);
		// -- END WOOD STUFF --
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.coconutFood, 2), new ItemStack(ModBlocks.groundCoconut));
		// -- CUSTOM DOOR REVERSE CRAFTING --
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 2), new ItemStack(ModItems.goldDoorItem));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 2), new ItemStack(ModItems.diamondDoorItem));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.lumite, 2), new ItemStack(ModItems.lumiteDoorItem));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 2), new ItemStack(ModItems.cobbleDoorItem));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.palmPlanks, 2), new ItemStack(ModItems.palmDoorItem));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.sequoiaPlanks, 2), new ItemStack(ModItems.sequoiaDoorItem));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.cedarPlanks, 2), new ItemStack(ModItems.cedarDoorItem));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.deadPlanks, 2), new ItemStack(ModItems.dreadDoorItem));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.frostPlanks, 2), new ItemStack(ModItems.frostDoorItem));
		// -- END CUSTOM DOOR REVERSE CRAFTING --
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.chiseledDreadSandstone), "x", "x", 'x', ModBlocks.woodSlabs[5]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.chiseledBlackSandstone), "x", "x", 'x', ModBlocks.woodSlabs[6]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.chiseledFrostSandstone), "x", "x", 'x', ModBlocks.slabs3[2]);
		GameRegistry.addRecipe(new ItemStack(ModItems.osborgnenFuel, 2), "xyx","yzy", "xyx", 'x', Blocks.obsidian, 'z', Items.coal, 'y', ModItems.tadaniteDiamond);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.imperviousBrick, 8), "#x#","x#x", "#x#", '#', new ItemStack(ModBlocks.blackSand), 'x', new ItemStack(Blocks.obsidian));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.leatherBlock), "###","###", "###", '#', Items.leather);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.netherIce, 2), "xyx","zzz", "yzy", 'x', Items.nether_wart, 'z', Blocks.netherrack, 'y', Items.ghast_tear);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.limestoneBlock), "###","###", "###", '#', ModItems.limestone);
		GameRegistry.addRecipe(new ItemStack(ModItems.netherCoreKey), "###","#x#", "###", 'x', Blocks.dragon_egg, '#', ModBlocks.netherIce);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.carrotBlock), "###","###", "###", '#', Items.carrot);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedObsidian), "###","###", "###", '#', Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.potatoBlock), "###","###", "###", '#', Items.potato);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sulphurBlock), "###","###", "###", '#', ModItems.sulphur2);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.uraniumBlock), "###","###", "###", '#', ModItems.uraniumIngot);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[0]), "###","###", "###", '#', ModItems.gems[0]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[1]), "###","###", "###", '#', ModItems.gems[1]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[2]), "###","###", "###", '#', ModItems.gems[2]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[3]), "###","###", "###", '#', ModItems.gems[3]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlocks[4]), "###","###", "###", '#', ModItems.gems[4]);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.zirconBlock), "###","###", "###", '#', ModItems.zircon);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.netherWartBlock), "###","###", "###", '#', Items.nether_wart);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.flintBlock), "###","###", "###", '#', Items.flint);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.magmaCreamBlock), "###","###", "###", '#', Items.magma_cream);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.enderPearlBlock), "###","###", "###", '#', Items.ender_pearl);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.lumiteBlock), "###","###", "###", '#', ModItems.lumite);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.boneBlock), "###","###", "###", '#', new ItemStack(Items.dye, 1, 15));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.redNetherBrick), "#x","x#", '#', Items.nether_wart, 'x', Items.netherbrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.redNetherBrick), "x#","#x", '#', Items.nether_wart, 'x', Items.netherbrick);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.obsidianBrick), "##","##", '#', ModItems.obsidianIngot);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostBrick), "##","##", '#', ModBlocks.netherFrost);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blackSandstone), "##","##", '#', ModBlocks.blackSand);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.endStoneBricks), "##","##", '#', Blocks.end_stone);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cement, 8), "#x#","xxx", "yzy", '#', Blocks.clay, 'x', ModItems.limestone, 'y', Blocks.gravel, 'z', Items.water_bucket);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tadanite), "xxx", "x x", "xxx", 'x', new ItemStack(ModItems.tadaniteShard));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.polishedSaltrock, 4), "##","##", '#', new ItemStack(ModBlocks.saltrock));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.polishedMagnetite, 4), "##","##", '#', new ItemStack(ModBlocks.magnetite));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.polishedIgneousRock, 4), "##","##", '#', new ItemStack(ModBlocks.igneousRock));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tropicStoneBrick, 4), "##","##", '#', new ItemStack(ModBlocks.tropicStone));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadSandstone), "##","##", '#', new ItemStack(ModBlocks.dreadSand));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostSandstone), "##","##", '#', new ItemStack(ModBlocks.frostSand));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian, 9), new ItemStack(ModBlocks.compressedObsidian));
		// new vanilla item recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.ice, 4), new ItemStack(Blocks.packed_ice));
		GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 8), "xyx", "yxy", "xyx", 'x', new ItemStack(Blocks.cobblestone), 'y', new ItemStack(Items.wheat_seeds));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.prefabSapling, 2), "xyz", "wui", "plx", 'x', new ItemStack(Items.diamond), 'y', new ItemStack(Blocks.sapling, 1, 4), 'z', new ItemStack(Blocks.sapling, 1, 2), 'w', new ItemStack(Blocks.sapling, 1, 5), 'u', new ItemStack(Blocks.crafting_table), 'i', new ItemStack(Blocks.sapling, 1, 3), 'p', new ItemStack(Blocks.sapling, 1), 'l', new ItemStack(Blocks.sapling, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.packed_ice), "##","##", '#', Blocks.ice);
		GameRegistry.addRecipe(new ItemStack(Items.saddle), "xxx", "xyx", "z z", 'x', new ItemStack(Items.leather), 'y', new ItemStack(Items.string), 'z', new ItemStack(Items.stick));
		// vanilla reverse crafting start
		// random stuff
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(Items.wooden_pickaxe));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(Items.wooden_axe));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(Items.wooden_sword));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(Items.wooden_hoe));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(Items.wooden_shovel));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new ItemStack(Items.bucket));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new ItemStack(Items.iron_door));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 5), new ItemStack(Items.minecart));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 7), new ItemStack(Items.cauldron));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.brick, 3), new ItemStack(Items.flower_pot));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 2), "##","##", '#', Items.stick);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4), new ItemStack(Blocks.wool));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 3), new ItemStack(Blocks.trapdoor));
		GameRegistry.addRecipe(new ItemStack(Blocks.log), "# #", "   ", "# #", '#', new ItemStack(Blocks.planks));
		GameRegistry.addRecipe(new ItemStack(Blocks.log, 1, 1), "# #", "   ", "# #", '#', new ItemStack(Blocks.planks, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.log, 1, 2), "# #", "   ", "# #", '#', new ItemStack(Blocks.planks, 1, 2));
		GameRegistry.addRecipe(new ItemStack(Blocks.log, 1, 3), "# #", "   ", "# #", '#', new ItemStack(Blocks.planks, 1, 3));
		GameRegistry.addRecipe(new ItemStack(Blocks.log2, 1), "# #", "   ", "# #", '#', new ItemStack(Blocks.planks, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Blocks.log2, 1, 1), "# #", "   ", "# #", '#', new ItemStack(Blocks.planks, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2, 0), new ItemStack(Items.oak_door));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2, 1), new ItemStack(Items.spruce_door));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2, 2), new ItemStack(Items.birch_door));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2, 3), new ItemStack(Items.jungle_door));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2, 4), new ItemStack(Items.acacia_door));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 2, 5), new ItemStack(Items.dark_oak_door));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obsidianIngot, 1), new ItemStack(ModBlocks.obsidianBrick));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 4), new ItemStack(Blocks.quartz_block));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3), "##", "##", '#', new ItemStack(Items.bowl));
		GameRegistry.addRecipe(new ItemStack(Blocks.glass, 3), "xxx", "x x", "xxx", 'x', new ItemStack(Blocks.glass_pane));
		// end random stuff
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadSapling, 2), " x", "x ", 'x', new ItemStack(ModBlocks.dreadLog));
		// slabs start
		GameRegistry.addRecipe(new ItemStack(Blocks.red_sandstone, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.stone_slab2));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.wooden_slab));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 1), "xxx", "xxx", 'x', new ItemStack(Blocks.wooden_slab, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 2), "xxx", "xxx", 'x', new ItemStack(Blocks.wooden_slab, 1, 2));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 3), "xxx", "xxx", 'x', new ItemStack(Blocks.wooden_slab, 1, 3));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 4), "xxx", "xxx", 'x', new ItemStack(Blocks.wooden_slab, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 3, 5), "xxx", "xxx", 'x', new ItemStack(Blocks.wooden_slab, 1, 5));
		GameRegistry.addRecipe(new ItemStack(Blocks.stone, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.stone_slab));
		GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.stone_slab, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.stone_slab, 1, 3));
		GameRegistry.addRecipe(new ItemStack(Blocks.brick_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.stone_slab, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.stone_slab, 1, 5));
		GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.stone_slab, 1, 6));
		GameRegistry.addRecipe(new ItemStack(Blocks.quartz_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(Blocks.stone_slab, 1, 7));
		GameRegistry.addRecipe(new ItemStack(Blocks.glass, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs3[3]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs3[3], 6), "xxx", 'x', new ItemStack(Blocks.glass));
		// slabs end
		GameRegistry.addRecipe(new ItemStack(ModBlocks.netherIceBrick), "##", "##", '#', ModBlocks.netherIce);
		// stairs start
		GameRegistry.addRecipe(new ItemStack(ModBlocks.netherIceBrick, 6), "##","##", '#', ModBlocks.netherIceBrickStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tropicStoneBrick, 6), "##","##", '#', ModBlocks.tropicStoneBrickStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cement, 6), "##","##", '#', ModBlocks.cementStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostPlanks, 6), "##","##", '#', ModBlocks.frostStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarPlanks, 6), "##","##", '#', ModBlocks.cedarStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.palmPlanks, 6), "##","##", '#', ModBlocks.palmStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaPlanks, 6), "##","##", '#', ModBlocks.sequoiaStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.petrifiedWood, 6), "##","##", '#', ModBlocks.petrifiedWoodStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.deadPlanks, 6), "##","##", '#', ModBlocks.dreadStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blazeBrick, 3), "##","##", '#', ModBlocks.blazeStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostBrick, 6), "##","##", '#', ModBlocks.frostBrickStairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.glass, 6), "##","##", '#', ModBlocks.glassStairs);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.reinforcedGlass, 6), "##","##", '#', ModBlocks.reinGlassStairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 6), "##","##", '#', Blocks.stone_brick_stairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick, 6), "##","##", '#', Blocks.nether_brick_stairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.brick_block, 6), "##","##", '#', Blocks.brick_stairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.red_sandstone, 6), "##","##", '#', Blocks.red_sandstone_stairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 6), "##","##", '#', Blocks.sandstone_stairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 6), "##","##", '#', Blocks.stone_stairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 6), "##","##", '#', Blocks.stone_brick_stairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 0), "xx", "xx", 'x', new ItemStack(Blocks.oak_stairs));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 1), "xx", "xx", 'x', new ItemStack(Blocks.spruce_stairs));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 2), "xx", "xx", 'x', new ItemStack(Blocks.birch_stairs));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 3), "xx", "xx", 'x', new ItemStack(Blocks.jungle_stairs));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 4), "xx", "xx", 'x', new ItemStack(Blocks.acacia_stairs));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 6, 5), "xx", "xx", 'x', new ItemStack(Blocks.dark_oak_stairs));
		GameRegistry.addRecipe(new ItemStack(Blocks.quartz_block, 6), "##","##", '#', Blocks.quartz_stairs);
		// stairs end
		// reverse crafting end
		
		//GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obsidianIngot, 4), new ItemStack(Blocks.obsidian));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 9), new ItemStack(ModBlocks.leatherBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.zircon, 9), new ItemStack(ModBlocks.zirconBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.magma_cream, 9), new ItemStack(ModBlocks.magmaCreamBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 9), new ItemStack(ModBlocks.enderPearlBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_wart, 9), new ItemStack(ModBlocks.netherWartBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone, 3), new ItemStack(ModBlocks.boneBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[0], 9), new ItemStack(ModBlocks.gemBlocks[0]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[1], 9), new ItemStack(ModBlocks.gemBlocks[1]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[2], 9), new ItemStack(ModBlocks.gemBlocks[2]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[3], 9), new ItemStack(ModBlocks.gemBlocks[3]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gems[4], 9), new ItemStack(ModBlocks.gemBlocks[4]));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tadaniteShard, 8), new ItemStack(ModBlocks.tadanite));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.limestone, 9), new ItemStack(ModBlocks.limestoneBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.carrot, 9), new ItemStack(ModBlocks.carrotBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.potato, 9), new ItemStack(ModBlocks.potatoBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sulphur2, 9), new ItemStack(ModBlocks.sulphurBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.lumite, 9), new ItemStack(ModBlocks.lumiteBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.flint, 9), new ItemStack(ModBlocks.flintBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.uraniumIngot, 9), new ItemStack(ModBlocks.uraniumBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_rod, 5), new ItemStack(ModBlocks.blazeBrick));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteDiamond), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.tadaniteShard), 'y', new ItemStack(Items.diamond));
		// -- TOOLS --
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianPickaxe), "xxx", " y ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianSword), " x ", " x ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianAxe), "xx ", "xy ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianAxe), " xx", " yx", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianShovel), " x ", " y ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianHoe), "xx ", " y ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianHoe), " xx", " y ", " y ", 'x', new ItemStack(ModItems.obsidianIngot), 'y', new ItemStack(Items.stick));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumitePickaxe), "lll", " t ", " z ", 'l', new ItemStack(ModItems.lumite), 'z', new ItemStack(ModItems.zircon), 't', new ItemStack(ModItems.tadanitePickaxe, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteSword), "lzl", "lzl", " t ", 'l', new ItemStack(ModItems.lumite), 't', new ItemStack(ModItems.tadaniteSword), 'z', new ItemStack(ModItems.zircon));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteAxe), "ll ", "lt ", " z ", 'l', new ItemStack(ModItems.lumite), 'z', new ItemStack(ModItems.zircon), 't', new ItemStack(ModItems.tadaniteAxe, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteAxe), " ll", " tl", " z ", 'l', new ItemStack(ModItems.lumite), 'z', new ItemStack(ModItems.zircon), 't', new ItemStack(ModItems.tadaniteAxe, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteShovel), " l ", " t ", " z ", 'l', new ItemStack(ModItems.lumite), 'z', new ItemStack(ModItems.zircon), 't', new ItemStack(ModItems.tadaniteShovel, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteHoe), "ll ", " t ", " z ", 'l', new ItemStack(ModItems.lumite), 'z', new ItemStack(ModItems.zircon), 't', new ItemStack(ModItems.tadaniteHoe, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteHoe), " ll", " t ", " z ", 'l', new ItemStack(ModItems.lumite), 'z', new ItemStack(ModItems.zircon), 't', new ItemStack(ModItems.tadaniteHoe, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadanitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(ModItems.tadaniteDiamond), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteSword), " x ", " x ", " y ", 'x', new ItemStack(ModItems.tadaniteDiamond), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteAxe), "xx ", "xy ", " y ", 'x', new ItemStack(ModItems.tadaniteDiamond), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteAxe), " xx", " yx", " y ", 'x', new ItemStack(ModItems.tadaniteDiamond), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteShovel), " x ", " y ", " y ", 'x', new ItemStack(ModItems.tadaniteDiamond), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteHoe), "xx ", " y ", " y ", 'x', new ItemStack(ModItems.tadaniteDiamond), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteHoe), " xx", " y ", " y ", 'x', new ItemStack(ModItems.tadaniteDiamond), 'y', new ItemStack(Items.blaze_rod));
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockPickaxe), "xxx", " y ", " y ", 'x', new ItemStack(Blocks.bedrock), 'y', new ItemStack(ModItems.frostRod));
		// -- END TOOLS --
		// -- ARMOR --
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteHelmet), "lzl", "ctc", 'l', new ItemStack(ModItems.lumite), 't', new ItemStack(ModItems.tadaniteHelmet, 1, OreDictionary.WILDCARD_VALUE), 'c', new ItemStack(ModItems.catalyticInverter), 'z', new ItemStack(ModItems.zircon));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteBoots), "ltl", "czc", 'l', new ItemStack(ModItems.lumite), 't', new ItemStack(ModItems.tadaniteBoots, 1, OreDictionary.WILDCARD_VALUE), 'c', new ItemStack(ModItems.catalyticInverter), 'z', new ItemStack(ModItems.zircon));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteChestplate), "ctc", "lzl", "zlz", 'l', new ItemStack(ModItems.lumite), 't', new ItemStack(ModItems.tadaniteChestplate, 1, OreDictionary.WILDCARD_VALUE), 'c', new ItemStack(ModItems.catalyticInverter), 'z', new ItemStack(ModItems.zircon));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteLeggings), "zlz", "ltl", "c c", 'l', new ItemStack(ModItems.lumite), 't', new ItemStack(ModItems.tadaniteLeggings, 1, OreDictionary.WILDCARD_VALUE), 'c', new ItemStack(ModItems.catalyticInverter), 'z', new ItemStack(ModItems.zircon));
		
		
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteHelmet), "xxx", "x x", 'x', new ItemStack(ModItems.tadaniteDiamond));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteBoots), "x x", "x x", 'x', new ItemStack(ModItems.tadaniteDiamond));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteChestplate), "x x", "xxx", "xxx", 'x', new ItemStack(ModItems.tadaniteDiamond));
		GameRegistry.addRecipe(new ItemStack(ModItems.tadaniteLeggings), "xxx", "x x", "x x", 'x', new ItemStack(ModItems.tadaniteDiamond));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianHelmet), "xxx", "x x", 'x', new ItemStack(ModItems.obsidianIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianBoots), "x x", "x x", 'x', new ItemStack(ModItems.obsidianIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianChestplate), "x x", "xxx", "xxx", 'x', new ItemStack(ModItems.obsidianIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianLeggings), "xxx", "x x", "x x", 'x', new ItemStack(ModItems.obsidianIngot));
		// -- END ARMOR --
		
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.uraniumTorch, 4), "x", "y", 'x', new ItemStack(ModItems.uraniumRod), 'y', new ItemStack(Items.stick));
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blazeBrick), "xxx", "xyx", "xxx", 'x', new ItemStack(Items.blaze_powder), 'y', new ItemStack(Items.blaze_rod));
		// -- CRAFTING STATIONS --
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.catalyzer), "xxx", "uuu", "yzy", 'x', "plankWood", 'y', new ItemStack(ModBlocks.sulphurBlock), 'z', new ItemStack(Blocks.crafting_table), 'u', new ItemStack(Items.iron_ingot)));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tadaniteSmeltery), "xyx","yzy", "zwz", 'x', ModBlocks.lumiteBlock, 'y', ModBlocks.tadanite, 'w', ModItems.catalyticInverter, 'z', Blocks.diamond_block);
		// -- END CRAFTING STATIONS --
		// -- CUSTOM DOORS --
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(Items.diamond));
		GameRegistry.addRecipe(new ItemStack(ModItems.cobbleDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(Blocks.cobblestone));
		GameRegistry.addRecipe(new ItemStack(ModItems.goldDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(Items.gold_ingot));
		GameRegistry.addRecipe(new ItemStack(ModItems.lumiteDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(ModItems.lumite));
		GameRegistry.addRecipe(new ItemStack(ModItems.palmDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(ModBlocks.palmPlanks));
		GameRegistry.addRecipe(new ItemStack(ModItems.sequoiaDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(ModBlocks.sequoiaPlanks));
		GameRegistry.addRecipe(new ItemStack(ModItems.cedarDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(ModBlocks.cedarPlanks));
		GameRegistry.addRecipe(new ItemStack(ModItems.dreadDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(ModBlocks.deadPlanks));
		GameRegistry.addRecipe(new ItemStack(ModItems.frostDoorItem, 3), "xx", "xx", "xx", 'x', new ItemStack(ModBlocks.frostPlanks));
		// -- END CUSTOM DOORS --
		// custom slab crafting
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
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodSlabs[0], 6), "xxx", 'x', new ItemStack(ModBlocks.sequoiaPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodSlabs[1], 6), "xxx", 'x', new ItemStack(ModBlocks.palmPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodSlabs[2], 6), "xxx", 'x', new ItemStack(ModBlocks.cedarPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodSlabs[3], 6), "xxx", 'x', new ItemStack(ModBlocks.petrifiedWood));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodSlabs[4], 6), "xxx", 'x', new ItemStack(ModBlocks.deadPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodSlabs[5], 6), "xxx", 'x', new ItemStack(ModBlocks.dreadSandstone));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodSlabs[6], 6), "xxx", 'x', new ItemStack(ModBlocks.blackSandstone));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodSlabs[7], 6), "xxx", 'x', new ItemStack(ModBlocks.frostPlanks));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs3[0], 6), "xxx", 'x', new ItemStack(ModBlocks.blazeBrick));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs3[1], 6), "xxx", 'x', new ItemStack(ModBlocks.frostBrick));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slabs3[2], 6), "xxx", 'x', new ItemStack(ModBlocks.frostSandstone));
		// custom slab decrafting
		GameRegistry.addRecipe(new ItemStack(Blocks.dirt, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs2[0]));
		GameRegistry.addRecipe(new ItemStack(Blocks.grass, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs2[1]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.leatherBlock, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs2[2]));
		GameRegistry.addRecipe(new ItemStack(Blocks.lapis_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs2[3]));
		GameRegistry.addRecipe(new ItemStack(Blocks.obsidian, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs2[4]));
		GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs2[5]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.endStoneBricks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs2[6]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tadanite, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs2[7]));
		GameRegistry.addRecipe(new ItemStack(Blocks.wool, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs[0]));
		GameRegistry.addRecipe(new ItemStack(Blocks.iron_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs[1]));
		GameRegistry.addRecipe(new ItemStack(Blocks.gold_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs[2]));
		GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs[3]));
		GameRegistry.addRecipe(new ItemStack(Blocks.emerald_block, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs[4]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sulphurBlock, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs[5]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.limestoneBlock, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs[6]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.uraniumBlock, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs[7]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sequoiaPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.woodSlabs[0]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.palmPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.woodSlabs[1]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.cedarPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.woodSlabs[2]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.petrifiedWood, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.woodSlabs[3]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.deadPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.woodSlabs[4]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dreadSandstone, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.woodSlabs[5]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blackSandstone, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.woodSlabs[6]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostPlanks, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.woodSlabs[7]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blazeBrick, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs3[0]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostBrick, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs3[1]));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.frostSandstone, 3, 0), "xxx", "xxx", 'x', new ItemStack(ModBlocks.slabs3[2]));
		// end custom slab crafting/decrafting		
		// gem staves
		GameRegistry.addRecipe(new ItemStack(ModItems.gemStaves[0]), "y", "y", "z", 'y', new ItemStack(ModBlocks.gemBlocks[0]), 'z', new ItemStack(ModBlocks.petrifiedWood));
		GameRegistry.addRecipe(new ItemStack(ModItems.gemStaves[1]), "y", "y", "z", 'y', new ItemStack(ModBlocks.gemBlocks[1]), 'z', new ItemStack(ModBlocks.petrifiedWood));
		GameRegistry.addRecipe(new ItemStack(ModItems.gemStaves[2]), "y", "y", "z", 'y', new ItemStack(ModBlocks.gemBlocks[2]), 'z', new ItemStack(ModBlocks.petrifiedWood));
		GameRegistry.addRecipe(new ItemStack(ModItems.gemStaves[3]), "y", "y", "z", 'y', new ItemStack(Blocks.emerald_block), 'z', new ItemStack(ModBlocks.petrifiedWood));
		GameRegistry.addRecipe(new ItemStack(ModItems.gemStaves[4]), "y", "y", "z", 'y', new ItemStack(ModBlocks.gemBlocks[3]), 'z', new ItemStack(ModBlocks.petrifiedWood));
		GameRegistry.addRecipe(new ItemStack(ModItems.gemStaves[5]), "y", "y", "z", 'y', new ItemStack(ModBlocks.gemBlocks[4]), 'z', new ItemStack(ModBlocks.petrifiedWood));
		GameRegistry.addRecipe(new ItemStack(ModItems.gemStaves[6]), "y", "y", "z", 'y', new ItemStack(Blocks.diamond_block), 'z', new ItemStack(ModBlocks.petrifiedWood));
		// end gem staves
		// smelting recipes
		GameRegistry.addSmelting(ModBlocks.uraniumOre, new ItemStack(ModItems.uraniumIngot), 20F);
		GameRegistry.addSmelting(ModBlocks.lumiteOre, new ItemStack(ModItems.lumite), 25F);
		GameRegistry.addSmelting(ModBlocks.limestoneOre, new ItemStack(ModItems.limestone), 2F);
		GameRegistry.addSmelting(ModBlocks.sulphurOre, new ItemStack(ModItems.sulphur2), 10F);
		GameRegistry.addSmelting(ModBlocks.tadaniteOre, new ItemStack(ModItems.tadaniteShard, 2), 15F);
		GameRegistry.addSmelting(ModBlocks.clayOre, new ItemStack(Items.clay_ball, 2), .5F);
		GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(ModItems.obsidianIngot), 3F);
		GameRegistry.addSmelting(ModBlocks.blackSand, new ItemStack(ModBlocks.reinforcedGlass), .5F);
		GameRegistry.addSmelting(ModBlocks.tropicCobblestone, new ItemStack(ModBlocks.tropicStone), .5F);
		GameRegistry.addSmelting(ModBlocks.ironOre, new ItemStack(Items.iron_ingot), 2F);
		GameRegistry.addSmelting(ModBlocks.goldOre, new ItemStack(Items.gold_ingot), 2F);
		GameRegistry.addSmelting(ModBlocks.coalOre, new ItemStack(Items.coal), 2F);
		GameRegistry.addSmelting(ModBlocks.palmLog, new ItemStack(Items.coal, 1, 1), 2F);
		GameRegistry.addSmelting(ModBlocks.sequoiaLog, new ItemStack(Items.coal, 1, 1), 2F);
		GameRegistry.addSmelting(ModBlocks.cedarLog, new ItemStack(Items.coal, 1, 1), 2F);
	}
}