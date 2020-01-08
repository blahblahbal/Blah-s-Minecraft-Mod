package blahblahbal.blahmod.init;

import blahblahbal.blahmod.BlahMod;
import blahblahbal.blahmod.item.ItemBasic;
import blahblahbal.blahmod.item.ItemModAxe;
import blahblahbal.blahmod.item.ItemModHoe;
import blahblahbal.blahmod.item.ItemModPickaxe;
import blahblahbal.blahmod.item.ItemModShovel;
import blahblahbal.blahmod.item.ItemModSword;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModItems
{
	public static ToolMaterial TADANITE_TM = EnumHelper.addToolMaterial("TADANITE", 4, 3000, 18F, 8.0F, 30);
	public static ToolMaterial OBSIDIAN_TM = EnumHelper.addToolMaterial("OBSIDIAN", 4, 56, 20F, 4.0F, 25);
	public static ToolMaterial LUMITE_TM = EnumHelper.addToolMaterial("LUMITE", 5, 5000, 30F, 11.0F, 45);
	public static ToolMaterial BEDROCK_TM = EnumHelper.addToolMaterial("BEDROCKM", 6, 5000, 20F, 4.0F, 10);
	
	public static ArmorMaterial tadaniteA = EnumHelper.addArmorMaterial("TADANITEA", "blahmod:tadanite", 150, new int[] {4, 9, 8, 3}, 32, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2f);
	public static ArmorMaterial obsidianA = EnumHelper.addArmorMaterial("OBSIDIANA", "blahmod:obsidian", 50, new int[] {2, 6, 6, 2}, 32, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0f);
	public static ArmorMaterial lumiteA = EnumHelper.addArmorMaterial("LUMITEA", "blahmod:lumite", 250, new int[] {4, 9, 8, 3}, 32, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5f);
	
	public static final Item tadaniteShard = new ItemBasic("tadanite_shard").setTranslationKey("tadanite_shard");
	public static final Item tadaniteDiamond = new ItemBasic("tadanite_diamond").setTranslationKey("tadanite_diamond");
	public static final Item sulphur2 = new ItemBasic("sulphur2").setTranslationKey("sulphur2");
	public static final Item osborgnenFuel = new ItemBasic("osborgnen_coal").setTranslationKey("osborgnen_coal");
	public static final Item catalyticInverter = new ItemBasic("catalytic_inverter").setTranslationKey("catalytic_inverter");
	public static final ItemModAxe tadaniteAxe = new ItemModAxe(TADANITE_TM, "tadanite_axe", "tadanite_axe");
	public static final ItemModHoe tadaniteHoe = new ItemModHoe(TADANITE_TM, "tadanite_hoe", "tadanite_hoe");
	public static final ItemModPickaxe tadanitePickaxe = new ItemModPickaxe(TADANITE_TM, "tadanite_pickaxe", "tadanite_pickaxe");
	public static final ItemModShovel tadaniteShovel = new ItemModShovel(TADANITE_TM, "tadanite_shovel", "tadanite_shovel");
	public static final ItemModSword tadaniteSword = new ItemModSword(TADANITE_TM, "tadanite_sword", "tadanite_sword");
	
//	public static void registerItems()
//	{
//		registerItem(tadaniteShard, "tadanite_shard");
//		registerItem(tadaniteDiamond, "tadanite_diamond");
//		registerItem(tadaniteAxe, "tadanite_axe");
//		registerItem(tadaniteHoe, "tadanite_hoe");
//		registerItem(tadanitePickaxe, "tadanite_pickaxe");
//		registerItem(tadaniteShovel, "tadanite_shovel");
//		registerItem(tadaniteSword, "tadanite_sword");
//	}
//	
//    public static Item registerItem(Item item, String name)
//    {    
//        item.setTranslationKey(name);
//        item.setCreativeTab(BlahMod.TabBlah);
//
//        item.setRegistryName(new ResourceLocation(BlahMod.MODID, name));
//        ForgeRegistries.ITEMS.register(item);
//        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(BlahMod.MODID + ":" + item.delegate.name().getPath(), "inventory"));
//        return item;   
//    }
}
