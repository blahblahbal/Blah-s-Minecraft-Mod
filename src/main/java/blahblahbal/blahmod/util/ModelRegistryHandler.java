package blahblahbal.blahmod.util;

import blahblahbal.blahmod.BlahMod;
import blahblahbal.blahmod.init.ModBlocks;
import blahblahbal.blahmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(Side.CLIENT)
public class ModelRegistryHandler
{
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		registerModel(ModItems.tadaniteShard);
		registerModel(ModItems.tadaniteDiamond);
		registerModel(ModItems.tadaniteAxe);
		registerModel(ModItems.tadanitePickaxe);
		registerModel(ModItems.tadaniteHoe);
		registerModel(ModItems.tadaniteShovel);
		registerModel(ModItems.tadaniteSword);
		/*registerModel(ModItems.tadaniteHelmet);
		registerModel(ModItems.tadaniteChestplate);
		registerModel(ModItems.tadaniteLeggings);
		registerModel(ModItems.tadaniteBoots);*/
		
		registerModel(Item.getItemFromBlock(ModBlocks.blazeBrick));
		registerModel(Item.getItemFromBlock(ModBlocks.hardenedLava));
	}
	private static void registerModel(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}