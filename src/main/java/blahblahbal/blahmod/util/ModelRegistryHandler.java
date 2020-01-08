package blahblahbal.blahmod.util;

import blahblahbal.blahmod.init.ModBlocks;
import blahblahbal.blahmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(Side.CLIENT)
public class ModelRegistryHandler
{
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		registerItemModel(ModItems.tadaniteShard);
		registerItemModel(ModItems.tadaniteDiamond);
		registerItemModel(ModItems.tadaniteAxe);
		registerItemModel(ModItems.tadanitePickaxe);
		registerItemModel(ModItems.tadaniteHoe);
		registerItemModel(ModItems.tadaniteShovel);
		registerItemModel(ModItems.tadaniteSword);
		registerItemModel(ModItems.sulphur2);
		registerItemModel(ModItems.catalyticInverter);
		registerItemModel(ModItems.osborgnenFuel);
		/*registerItemModel(ModItems.tadaniteHelmet);
		registerItemModel(ModItems.tadaniteChestplate);
		registerItemModel(ModItems.tadaniteLeggings);
		registerItemModel(ModItems.tadaniteBoots);*/
		
		registerBlockModel(ModBlocks.blazeBrick);
		registerBlockModel(ModBlocks.hardenedLava);
		registerBlockModel(ModBlocks.blackSand);
		registerBlockModel(ModBlocks.compressedObsidian);
		registerBlockModel(ModBlocks.sulphurBlock);
		registerBlockModel(ModBlocks.flintBlock);
		registerBlockModel(ModBlocks.lumiteBlock);
		registerBlockModel(ModBlocks.petrifiedWood);
		registerBlockModel(ModBlocks.catalyzer);
	}
	
	private static void registerBlockModel(Block b)
	{
		String name = ForgeRegistries.BLOCKS.getKey(b).toString();
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation(name, "inventory"));
	}
	
	private static void registerItemModel(Item i)
	{
		String name = ForgeRegistries.ITEMS.getKey(i).toString();
		ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(name, "inventory"));
	}
}