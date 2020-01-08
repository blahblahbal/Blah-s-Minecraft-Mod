package blahblahbal.blahmod.util;

import blahblahbal.blahmod.init.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event)
	{
		final Block[] blocks = {
				ModBlocks.blazeBrick,
				ModBlocks.hardenedLava,
				ModBlocks.blackSand,
				ModBlocks.compressedObsidian,
				ModBlocks.flintBlock,
				ModBlocks.lumiteBlock,
				ModBlocks.petrifiedWood,
				ModBlocks.sulphurBlock,
				ModBlocks.catalyzer
		};
		event.getRegistry().registerAll(blocks);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event)
	{
		final Item[] items = {
				ModItems.tadaniteShard,
				ModItems.tadaniteDiamond,
				ModItems.tadaniteAxe,
				ModItems.tadaniteHoe,
				ModItems.tadanitePickaxe,
				ModItems.tadaniteShovel,
				ModItems.tadaniteSword,
				ModItems.catalyticInverter,
				ModItems.osborgnenFuel,
				ModItems.sulphur2
				/*new ItemModArmor(ModItems.tadaniteA, EntityEquipmentSlot.HEAD, "tadaniteHelmet", "tadaniteHelmet"),
				new ItemModArmor(ModItems.tadaniteA, EntityEquipmentSlot.CHEST, "tadaniteChestplate", "tadaniteChestplate"),
				new ItemModArmor(ModItems.tadaniteA, EntityEquipmentSlot.LEGS, "tadaniteLeggings", "tadaniteLeggings"),
				new ItemModArmor(ModItems.tadaniteA, EntityEquipmentSlot.FEET, "tadaniteBoots", "tadaniteBoots")*/
		};
		
		final Item[] itemBlocks = {
				new ItemBlock(ModBlocks.blazeBrick).setRegistryName(ModBlocks.blazeBrick.getRegistryName()),
				new ItemBlock(ModBlocks.hardenedLava).setRegistryName(ModBlocks.hardenedLava.getRegistryName()),
				new ItemBlock(ModBlocks.lumiteBlock).setRegistryName(ModBlocks.lumiteBlock.getRegistryName()),
				new ItemBlock(ModBlocks.flintBlock).setRegistryName(ModBlocks.flintBlock.getRegistryName()),
				new ItemBlock(ModBlocks.petrifiedWood).setRegistryName(ModBlocks.petrifiedWood.getRegistryName()),
				new ItemBlock(ModBlocks.blackSand).setRegistryName(ModBlocks.blackSand.getRegistryName()),
				new ItemBlock(ModBlocks.compressedObsidian).setRegistryName(ModBlocks.compressedObsidian.getRegistryName()),
				new ItemBlock(ModBlocks.sulphurBlock).setRegistryName(ModBlocks.sulphurBlock.getRegistryName()),
				new ItemBlock(ModBlocks.catalyzer).setRegistryName(ModBlocks.catalyzer.getRegistryName()),
		};
		
		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
	}
}