package blahblahbal.blahmod.util;

import blahblahbal.blahmod.block.BlockBasic;
import blahblahbal.blahmod.init.*;
import blahblahbal.blahmod.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
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
				new BlockBasic(Material.ROCK, "blaze_brick", "blaze_brick"),
				new BlockBasic(Material.ROCK, "hardened_lava", "hardened_lava"),
		};
		
		event.getRegistry().registerAll(blocks);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event)
	{
		final Item[] items = {
				new ItemBasic("tadanite_shard", "tadanite_shard"),
				new ItemBasic("tadanite_diamond", "tadanite_diamond"),
				new ItemModAxe(ModItems.TADANITE_TM, "tadanite_axe", "tadanite_axe"),
				new ItemModPickaxe(ModItems.TADANITE_TM, "tadanite_pickaxe", "tadanite_pickaxe"),
				new ItemModHoe(ModItems.TADANITE_TM, "tadanite_hoe", "tadanite_hoe"),
				new ItemModShovel(ModItems.TADANITE_TM, "tadanite_shovel", "tadanite_shovel"),
				new ItemModSword(ModItems.TADANITE_TM, "tadanite_sword", "tadanite_sword")
				/*new ItemModArmor(ModItems.tadaniteA, EntityEquipmentSlot.HEAD, "tadaniteHelmet", "tadaniteHelmet"),
				new ItemModArmor(ModItems.tadaniteA, EntityEquipmentSlot.CHEST, "tadaniteChestplate", "tadaniteChestplate"),
				new ItemModArmor(ModItems.tadaniteA, EntityEquipmentSlot.LEGS, "tadaniteLeggings", "tadaniteLeggings"),
				new ItemModArmor(ModItems.tadaniteA, EntityEquipmentSlot.FEET, "tadaniteBoots", "tadaniteBoots")*/
		};
		
		final Item[] itemBlocks = {
				new ItemBlock(ModBlocks.blazeBrick).setRegistryName(ModBlocks.blazeBrick.getRegistryName()),
				new ItemBlock(ModBlocks.hardenedLava).setRegistryName(ModBlocks.hardenedLava.getRegistryName())
		};
		
		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
	}
}