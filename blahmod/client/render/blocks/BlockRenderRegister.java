package blahmod.client.render.blocks;

import blahmod.Main;
import blahmod.blocks.BasicBlock;
import blahmod.blocks.ModBlockOre;
import blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class BlockRenderRegister {

	public static void registerBlockRenderer() {
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    //.register(Item.getItemFromBlock((Block)ModBlocks.tadanite), 0, new ModelResourceLocation("blahmod:tadanite", "inventory"));
	    reg((BasicBlock)ModBlocks.tadanite);
	    reg((BasicBlock)ModBlocks.leatherBlock);
	    //reg((BasicBlock)ModBlocks.tadaniteOre);
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.tadaniteOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.tadaniteOre)).name, "inventory"));
	}

	public static void reg(BasicBlock block) {
		
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block)block), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + block.name, "inventory"));
	}
}

