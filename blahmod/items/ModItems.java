package blahmod.items;

import blahmod.blocks.ModBlocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;

public final class ModItems {

	public static ToolMaterial obsidian = EnumHelper.addToolMaterial("OBSIDIAN", 4, 56, 20F, 4.0F, 25);
	public static ToolMaterial tadaniteM = EnumHelper.addToolMaterial("TADANITE", 4, 3000, 18F, 8.0F, 30);
	public static ToolMaterial bedrockM = EnumHelper.addToolMaterial("BEDROCKM", 6, 5000, 20F, 4.0F, 10);
	public static ArmorMaterial tadaniteA = EnumHelper.addArmorMaterial("TADANITEA", "blahmod:tadanite", 150, new int[] {4, 9, 8, 3}, 32);
	public static ArmorMaterial obsidianA = EnumHelper.addArmorMaterial("OBSIDIANA", "blahmod:obsidian", 50, new int[] {2, 6, 6, 2}, 32);
	public static Item[] gems = new Item[5];
	
	public static Item[] gemStaves = new Item[7];
	public static Item[] dyeNew = new Item[10];
	public static Item tadaniteShard;
	public static Item tadaniteDiamond;
    public static Item obsidianIngot;
    public static Item acidBucket;
    public static Item limestone;
    public static Item sulphur2;
    public static Item uraniumRod;
    public static Item uraniumIngot;
    public static ItemModPickaxe obsidianPickaxe;
    public static ItemModSword obsidianSword;
    public static ItemModAxe obsidianAxe;
    public static ItemModShovel obsidianShovel;
    public static ItemModHoe obsidianHoe;
    public static ItemModArmor tadaniteHelmet;
    public static ItemModArmor tadaniteChestplate;
    public static ItemModArmor tadaniteLeggings;
    public static ItemModArmor tadaniteBoots;
    
    public static ItemModArmor obsidianHelmet;
    public static ItemModArmor obsidianChestplate;
    public static ItemModArmor obsidianLeggings;
    public static ItemModArmor obsidianBoots;
    
    public static ItemModPickaxe tadanitePickaxe;
    public static ItemModPickaxe bedrockPickaxe;
    public static ItemModSword tadaniteSword;
    public static ItemModAxe tadaniteAxe;
    public static ItemModShovel tadaniteShovel;
    public static ItemModHoe tadaniteHoe;
	
    public static void createItems()
    {
    	GameRegistry.registerItem(tadaniteShard = new BasicItem("tadaniteShard"), "tadaniteShard");
    	GameRegistry.registerItem(tadaniteDiamond = new BasicItem("tadaniteDiamond"), "tadaniteDiamond");
        GameRegistry.registerItem(obsidianIngot = new BasicItem("obsidianIngot"), "obsidianIngot");
        GameRegistry.registerItem((Item)(obsidianPickaxe = new ItemModPickaxe("obsidianPickaxe", obsidian)), "obsidianPickaxe");
        GameRegistry.registerItem((Item)(obsidianSword = new ItemModSword("obsidianSword", obsidian)), "obsidianSword");
        GameRegistry.registerItem((Item)(obsidianAxe = new ItemModAxe("obsidianAxe", obsidian)), "obsidianAxe");
        GameRegistry.registerItem((Item)(obsidianShovel = new ItemModShovel("obsidianShovel", obsidian)), "obsidianShovel");
        GameRegistry.registerItem((Item)(obsidianHoe = new ItemModHoe("obsidianHoe", obsidian)), "obsidianHoe");
        //GameRegistry.registerItem((Item)(acidBucket = new BasicItem("acidBucket")), "acidBucket");
        GameRegistry.registerItem((Item)(tadaniteHelmet = new ItemModArmor("tadaniteHelmet", tadaniteA, 1, 0)), "tadaniteHelmet");
        GameRegistry.registerItem((Item)(tadaniteChestplate = new ItemModArmor("tadaniteChestplate", tadaniteA, 1, 1)), "tadaniteChestplate");
        GameRegistry.registerItem((Item)(tadaniteLeggings = new ItemModArmor("tadaniteLeggings", tadaniteA, 2, 2)), "tadaniteLeggings");
        GameRegistry.registerItem((Item)(tadaniteBoots = new ItemModArmor("tadaniteBoots", tadaniteA, 1, 3)), "tadaniteBoots");
        GameRegistry.registerItem((Item)(obsidianHelmet = new ItemModArmor("obsidianHelmet", obsidianA, 1, 0)), "obsidianHelmet");
        GameRegistry.registerItem((Item)(obsidianChestplate = new ItemModArmor("obsidianChestplate", obsidianA, 1, 1)), "obsidianChestplate");
        GameRegistry.registerItem((Item)(obsidianLeggings = new ItemModArmor("obsidianLeggings", obsidianA, 2, 2)), "obsidianLeggings");
        GameRegistry.registerItem((Item)(obsidianBoots = new ItemModArmor("obsidianBoots", obsidianA, 1, 3)), "obsidianBoots");
        GameRegistry.registerItem((Item)(tadanitePickaxe = new ItemModPickaxe("tadanitePickaxe", tadaniteM)), "tadanitePickaxe");
        GameRegistry.registerItem((Item)(tadaniteSword = new ItemModSword("tadaniteSword", tadaniteM)), "tadaniteSword");
        GameRegistry.registerItem((Item)(tadaniteAxe = new ItemModAxe("tadaniteAxe", tadaniteM)), "tadaniteAxe");
        GameRegistry.registerItem((Item)(tadaniteShovel = new ItemModShovel("tadaniteShovel", tadaniteM)), "tadaniteShovel");
        GameRegistry.registerItem((Item)(tadaniteHoe = new ItemModHoe("tadaniteHoe", tadaniteM)), "tadaniteHoe");
        GameRegistry.registerItem((Item)(bedrockPickaxe = new ItemModPickaxe("bedrockPickaxe", bedrockM)), "bedrockPickaxe");
        GameRegistry.registerItem(limestone = new BasicItem("limestone"), "limestone");
        GameRegistry.registerItem(sulphur2 = new BasicItem("sulphur2"), "sulphur2");
        GameRegistry.registerItem(uraniumIngot = new BasicItem("uraniumIngot"), "uraniumIngot");
        GameRegistry.registerItem(uraniumRod = new BasicItem("uraniumRod"), "uraniumRod");
        Items.egg.setMaxStackSize(64);
        Items.ender_pearl.setMaxStackSize(64);
        Items.snowball.setMaxStackSize(64);
        Items.cake.setMaxStackSize(64);
        GameRegistry.registerItem((Item)(gemStaves[0] = new ItemGemStaff(0, ModBlocks.gemNames[0] + "Staff")), ModBlocks.gemNames[0] + "Staff");
        GameRegistry.registerItem((Item)(gemStaves[1] = new ItemGemStaff(1, ModBlocks.gemNames[1] + "Staff")), ModBlocks.gemNames[1] + "Staff");
        GameRegistry.registerItem((Item)(gemStaves[2] = new ItemGemStaff(2, ModBlocks.gemNames[2] + "Staff")), ModBlocks.gemNames[2] + "Staff");
        GameRegistry.registerItem((Item)(gemStaves[3] = new ItemGemStaff(3, "emeraldStaff")), "emeraldStaff");
        GameRegistry.registerItem((Item)(gemStaves[4] = new ItemGemStaff(4, ModBlocks.gemNames[3] + "Staff")), ModBlocks.gemNames[3] + "Staff");
        GameRegistry.registerItem((Item)(gemStaves[5] = new ItemGemStaff(5, ModBlocks.gemNames[4] + "Staff")), ModBlocks.gemNames[4] + "Staff");
        GameRegistry.registerItem((Item)(gemStaves[6] = new ItemGemStaff(6, "diamondStaff")), "diamondStaff");
        
        for (int i = 0; i < 5; i++)
        {
        	GameRegistry.registerItem(gems[i] = new BasicItem(ModBlocks.gemNames[i]), ModBlocks.gemNames[i]);
        }
        for (int i = 0; i < 10; i++)
        {
        	GameRegistry.registerItem(dyeNew[i] = new BasicItem("dye" + ModBlocks.woolNames[i]), "dye" + ModBlocks.woolNames[i]);
        }
    }
    public static Item registerItem(Item item, String name)
    {
    	item.setUnlocalizedName(name);
    	GameRegistry.registerItem(item,name);
    	return item;
    }
}