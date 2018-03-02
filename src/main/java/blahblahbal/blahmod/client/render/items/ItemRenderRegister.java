package blahblahbal.blahmod.client.render.items;

import blahblahbal.blahmod.Main;
import blahblahbal.blahmod.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister
{
	public static String modid = Main.MODID;
	
    public static void registerItemRenderer()
    {
    	reg(ModItems.acidBucket);
    	reg(ModItems.iceCream);
    	reg(ModItems.frostRod);
    	reg(ModItems.iceBucket);
    	reg(ModItems.netherCoreKey);
    	reg(ModItems.zircon);
    	reg(ModItems.obsidianIngot);
    	reg(ModItems.tadaniteShard);
    	reg(ModItems.tadaniteDiamond);
    	reg((Item)ModItems.obsidianSword);
    	reg((Item)ModItems.obsidianPickaxe);
    	reg((Item)ModItems.obsidianHoe);
    	reg((Item)ModItems.obsidianShovel);
    	reg((Item)ModItems.obsidianAxe);
    	reg((Item)ModItems.tadaniteSword);
    	reg((Item)ModItems.tadanitePickaxe);
    	reg((Item)ModItems.bedrockPickaxe);
    	reg((Item)ModItems.tadaniteHoe);
    	reg((Item)ModItems.tadaniteShovel);
    	reg((Item)ModItems.tadaniteAxe);
    	reg((Item)ModItems.tadaniteHelmet);
    	reg((Item)ModItems.tadaniteChestplate);
    	reg((Item)ModItems.tadaniteLeggings);
    	reg((Item)ModItems.tadaniteBoots);
    	reg((Item)ModItems.obsidianHelmet);
    	reg((Item)ModItems.obsidianChestplate);
    	reg((Item)ModItems.obsidianLeggings);
    	reg((Item)ModItems.obsidianBoots);
    	reg((Item)ModItems.lumiteHelmet);
    	reg((Item)ModItems.lumiteChestplate);
    	reg((Item)ModItems.lumiteLeggings);
    	reg((Item)ModItems.lumiteBoots);
    	reg((Item)ModItems.lumiteSword);
    	reg((Item)ModItems.lumitePickaxe);
    	reg((Item)ModItems.lumiteHoe);
    	reg((Item)ModItems.lumiteShovel);
    	reg((Item)ModItems.lumiteAxe);
    	reg((Item)ModItems.lumite);
    	reg((Item)ModItems.limestone);
    	reg((Item)ModItems.sulphur2);
    	reg((Item)ModItems.uraniumIngot);
    	reg((Item)ModItems.uraniumRod);
    	reg((Item)ModItems.osborgnenFuel);
    	reg((Item)ModItems.catalyticInverter);
    	reg((Item)ModItems.coconutFood);
    	reg((Item)ModItems.megaBerry);
    	for (int i = 0; i < 5; i++)
    	{
    		reg(ModItems.gems[i]);
    	}
    	for (int i = 0; i < 7; i++)
    	{
    		reg((Item)ModItems.gemStaves[i]);
    	}
    	for (int i = 0; i < 10; i++)
    	{
    		reg((Item)ModItems.dyeNew[i]);
    	}
    }
    
    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}