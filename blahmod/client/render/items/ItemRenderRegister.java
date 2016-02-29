package blahmod.client.render.items;

import blahmod.Main;
import blahmod.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {

	public static String modid = Main.MODID;
	
    public static void registerItemRenderer()
    {
    	reg(ModItems.acidBucket);
    	reg(ModItems.obsidianIngot);
    	reg(ModItems.tadaniteShard);
    	reg((Item)ModItems.obsidianSword);
    	reg((Item)ModItems.obsidianPickaxe);
    	reg((Item)ModItems.obsidianHoe);
    	reg((Item)ModItems.obsidianShovel);
    	reg((Item)ModItems.obsidianAxe);
    	reg((Item)ModItems.tadaniteSword);
    	reg((Item)ModItems.tadanitePickaxe);
    	reg((Item)ModItems.tadaniteHoe);
    	reg((Item)ModItems.tadaniteShovel);
    	reg((Item)ModItems.tadaniteAxe);
    	reg((Item)ModItems.tadaniteHelmet);
    	reg((Item)ModItems.tadaniteChestplate);
    	reg((Item)ModItems.tadaniteLeggings);
    	reg((Item)ModItems.tadaniteBoots);
    }
    
    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}