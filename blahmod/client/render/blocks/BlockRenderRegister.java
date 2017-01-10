package blahmod.client.render.blocks;

import blahmod.Main;
import blahmod.MeshDefinitionFix;
import blahmod.ModFluids;
import blahmod.blocks.BasicBlock;
import blahmod.blocks.ModBlockLeaves;
import blahmod.blocks.ModBlockLog;
import blahmod.blocks.ModBlockSapling;
import blahmod.blocks.ModBlockOre;
import blahmod.blocks.ModBlockTileEntity;
import blahmod.blocks.ModBlockSlab;
import blahmod.blocks.ModBlockTorch;
import blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class BlockRenderRegister
{
	public static final BlockRenderRegister INSTANCE = new BlockRenderRegister();
	
	public void registerFluidModels()
	{
		ModFluids.modFluidBlocks.forEach(this::registerFluidModel);
	}

	private void registerFluidModel(IFluidBlock fluidBlock)
	{
		Item item = Item.getItemFromBlock((Block) fluidBlock);

		ModelBakery.registerItemVariants(item);

		ModelResourceLocation modelResourceLocation = new ModelResourceLocation("blahmod:fluid", fluidBlock.getFluid().getName());

		ModelLoader.setCustomMeshDefinition(item, MeshDefinitionFix.create(stack -> modelResourceLocation));

		ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
				return modelResourceLocation;
			}
		});
	}
	
	public static void registerBlockRenderer()
	{
	    reg((BasicBlock)ModBlocks.tadanite);
	    reg((BasicBlock)ModBlocks.leatherBlock);
	    reg((BasicBlock)ModBlocks.limestoneBlock);
	    reg((BasicBlock)ModBlocks.sulphurBlock);
	    reg((BasicBlock)ModBlocks.uraniumBlock);
	    reg((BasicBlock)ModBlocks.cement);
	    reg((BasicBlock)ModBlocks.uraniumOre);
	    reg((BasicBlock)ModBlocks.endStoneBricks);
	    reg((BasicBlock)ModBlocks.petrifiedWood);
	    reg((BasicBlock)ModBlocks.blazeBrick);
	    reg((BasicBlock)ModBlocks.redNetherBrick);
	    reg((BasicBlock)ModBlocks.netherWartBlock);
	    reg((BasicBlock)ModBlocks.boneBlock);
	    reg((BasicBlock)ModBlocks.netherIce);
	    reg((BasicBlock)ModBlocks.obsidianBrick);
	    reg((BasicBlock)ModBlocks.sequoiaPlanks);
	    for (int i = 0; i < 5; i++)
	    {
	    	reg((BasicBlock)ModBlocks.gemBlocks[i]);
	    	//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.gemOres[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.gemOres[i])).name, "inventory"));
	    }
	    for (int i = 0; i < 10; i++)
	    {
	    	reg((BasicBlock)ModBlocks.newWool[i]);
	    }
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.rubyOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.rubyOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.citrineOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.citrineOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.topazOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.topazOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sapphireOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.sapphireOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.amethystOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.amethystOre)).name, "inventory"));
	    for (int i = 0; i < 8; i++)
	    {
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.doubleSlabs[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.doubleSlabs[i])).name, "inventory"));
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.slabs[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.slabs[i])).name, "inventory"));
	    	
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.doubleSlabs2[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.doubleSlabs2[i])).name, "inventory"));
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.slabs2[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.slabs2[i])).name, "inventory"));
	    }
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.uraniumTorch), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockTorch)(ModBlocks.uraniumTorch)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.tadaniteOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.tadaniteOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.limestoneOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.limestoneOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sulphurOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.sulphurOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.catalyzer), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockTileEntity)(ModBlocks.catalyzer)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.clayOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.clayOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.prefabSapling), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSapling)(ModBlocks.prefabSapling)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaSapling), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSapling)(ModBlocks.sequoiaSapling)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaLog), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockLog)(ModBlocks.sequoiaLog)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaLeaves), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockLeaves)(ModBlocks.sequoiaLeaves)).name, "inventory"));
	}
	public static void reg(BasicBlock block)
	{
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block)block), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + block.name, "inventory"));
	}
}

