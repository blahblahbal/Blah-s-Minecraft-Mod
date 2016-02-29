package blahmod.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;

public final class ModItems {

	public static ToolMaterial obsidian = EnumHelper.addToolMaterial("OBSIDIAN", 4, 32, 17F, 4.0F, 25);
	public static ToolMaterial tadaniteM = EnumHelper.addToolMaterial("TADANITE", 4, 3000, 18F, 6.0F, 30);
	public static ArmorMaterial tadaniteA = EnumHelper.addArmorMaterial("TADANITEA", "blahmod:tadanite", 150, new int[] {4, 10, 8, 2}, 32);
	public static Item tadaniteShard;
    public static Item obsidianIngot;
    public static Item acidBucket;
    public static ItemModPickaxe obsidianPickaxe;
    public static ItemModSword obsidianSword;
    public static ItemModAxe obsidianAxe;
    public static ItemModShovel obsidianShovel;
    public static ItemModHoe obsidianHoe;
    public static ItemModArmor tadaniteHelmet;
    public static ItemModArmor tadaniteChestplate;
    public static ItemModArmor tadaniteLeggings;
    public static ItemModArmor tadaniteBoots;
    public static ItemModPickaxe tadanitePickaxe;
    public static ItemModSword tadaniteSword;
    public static ItemModAxe tadaniteAxe;
    public static ItemModShovel tadaniteShovel;
    public static ItemModHoe tadaniteHoe;
	
    public static void createItems()
    {
    	GameRegistry.registerItem(tadaniteShard = new BasicItem("tadaniteShard"), "tadaniteShard");
        GameRegistry.registerItem(obsidianIngot = new BasicItem("obsidianIngot"), "obsidianIngot");
        GameRegistry.registerItem((Item)(obsidianPickaxe = new ItemModPickaxe("obsidianPickaxe", obsidian)), "obsidianPickaxe");
        GameRegistry.registerItem((Item)(obsidianSword = new ItemModSword("obsidianSword", obsidian)), "obsidianSword");
        GameRegistry.registerItem((Item)(obsidianAxe = new ItemModAxe("obsidianAxe", obsidian)), "obsidianAxe");
        GameRegistry.registerItem((Item)(obsidianShovel = new ItemModShovel("obsidianShovel", obsidian)), "obsidianShovel");
        GameRegistry.registerItem((Item)(obsidianHoe = new ItemModHoe("obsidianHoe", obsidian)), "obsidianHoe");
        GameRegistry.registerItem(acidBucket = new BasicItem("acidBucket"), "acidBucket");
        GameRegistry.registerItem((Item)(tadaniteHelmet = new ItemModArmor("tadaniteHelmet", tadaniteA, 1, 0)), "tadaniteHelmet");
        GameRegistry.registerItem((Item)(tadaniteChestplate = new ItemModArmor("tadaniteChestplate", tadaniteA, 1, 1)), "tadaniteChestplate");
        GameRegistry.registerItem((Item)(tadaniteLeggings = new ItemModArmor("tadaniteLeggings", tadaniteA, 2, 2)), "tadaniteLeggings");
        GameRegistry.registerItem((Item)(tadaniteBoots = new ItemModArmor("tadaniteBoots", tadaniteA, 1, 3)), "tadaniteBoots");
        GameRegistry.registerItem((Item)(tadanitePickaxe = new ItemModPickaxe("tadanitePickaxe", tadaniteM)), "tadanitePickaxe");
        GameRegistry.registerItem((Item)(tadaniteSword = new ItemModSword("tadaniteSword", tadaniteM)), "tadaniteSword");
        GameRegistry.registerItem((Item)(tadaniteAxe = new ItemModAxe("tadaniteAxe", tadaniteM)), "tadaniteAxe");
        GameRegistry.registerItem((Item)(tadaniteShovel = new ItemModShovel("tadaniteShovel", tadaniteM)), "tadaniteShovel");
        GameRegistry.registerItem((Item)(tadaniteHoe = new ItemModHoe("tadaniteHoe", tadaniteM)), "tadaniteHoe");
    }
}