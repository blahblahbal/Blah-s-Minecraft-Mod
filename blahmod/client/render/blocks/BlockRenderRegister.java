package blahmod.client.render.blocks;

import blahmod.Main;
import blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderRegister {
	public static String modid = Main.MODID;

	public static void registerBlockRenderer() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock((Block)ModBlocks.tadanite), 0, new ModelResourceLocation("blahmod:tadanite", "inventory"));
	    //reg((Block)ModBlocks.tadanite);
	    reg((Block)ModBlocks.leatherBlock);
	    reg((Block)ModBlocks.tadaniteOre);
	}

	public static void reg(Block block) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(4), "inventory"));
	}
}

