package blahblahbal.blahmod.client.render.blocks;

import blahblahbal.blahmod.Main;
import blahblahbal.blahmod.MeshDefinitionFix;
import blahblahbal.blahmod.blocks.BasicBlock;
import blahblahbal.blahmod.blocks.*;
import blahblahbal.blahmod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.IFluidBlock;

public final class BlockRenderRegister
{
	public static final BlockRenderRegister INSTANCE = new BlockRenderRegister();
	
	/*public void registerFluidModels()
	{
		ModFluids.modFluidBlocks.forEach(this::registerFluidModel);
	}*/

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
	    reg((BasicBlock)ModBlocks.frostBrick);
	    reg((BasicBlock)ModBlocks.netherSnow);
	    reg((BasicBlock)ModBlocks.netherFrost);
	    reg((BasicBlock)ModBlocks.leatherBlock);
	    reg((BasicBlock)ModBlocks.limestoneBlock);
	    reg((BasicBlock)ModBlocks.sulphurBlock);
	    reg((BasicBlock)ModBlocks.uraniumBlock);
	    reg((BasicBlock)ModBlocks.zirconBlock);
	    reg((BasicBlock)ModBlocks.cement);
	    reg((BasicBlock)ModBlocks.uraniumOre);
	    reg((BasicBlock)ModBlocks.endStoneBricks);
	    reg((BasicBlock)ModBlocks.petrifiedWood);
	    reg((BasicBlock)ModBlocks.blazeBrick);
	    reg((BasicBlock)ModBlocks.redNetherBrick);
	    reg((BasicBlock)ModBlocks.netherWartBlock);
	    reg((BasicBlock)ModBlocks.lumiteBlock);
	    reg((BasicBlock)ModBlocks.boneBlock);
	    reg((BasicBlock)ModBlocks.netherIce);
	    reg((BasicBlock)ModBlocks.obsidianBrick);
	    reg((BasicBlock)ModBlocks.sequoiaPlanks);
	    reg((BasicBlock)ModBlocks.cedarPlanks);
	    reg((BasicBlock)ModBlocks.hardenedLava);
	    reg((BasicBlock)ModBlocks.igneousRock);
	    reg((BasicBlock)ModBlocks.lumiteOre);
	    reg((BasicBlock)ModBlocks.magnetite);
	    reg((BasicBlock)ModBlocks.saltrock);
	    reg((BasicBlock)ModBlocks.polishedSaltrock);
	    reg((BasicBlock)ModBlocks.polishedIgneousRock);
	    reg((BasicBlock)ModBlocks.polishedMagnetite);
	    reg((BasicBlock)ModBlocks.imperviousBrick);
	    reg((BasicBlock)ModBlocks.blackSand);
	    reg((BasicBlock)ModBlocks.netherIceBrick);
	    reg((BasicBlock)ModBlocks.magmaCreamBlock);
	    reg((BasicBlock)ModBlocks.enderPearlBlock);
	    reg((BasicBlock)ModBlocks.carrotBlock);
	    reg((BasicBlock)ModBlocks.quicksilverBlock);
	    reg((BasicBlock)ModBlocks.blackSandstone);
	    reg((BasicBlock)ModBlocks.palmPlanks);
	    reg((BasicBlock)ModBlocks.tropicCobblestone);
	    reg((BasicBlock)ModBlocks.tropicMud);
	    reg((BasicBlock)ModBlocks.ironOre);
	    reg((BasicBlock)ModBlocks.goldOre);
	    reg((BasicBlock)ModBlocks.deadPlanks);
	    reg((BasicBlock)ModBlocks.dreadRock);
	    reg((BasicBlock)ModBlocks.dreadSand);
	    reg((BasicBlock)ModBlocks.flintBlock);
	    reg((BasicBlock)ModBlocks.dreadSandstone);
	    reg((BasicBlock)ModBlocks.tropicStoneBrick);
	    reg((BasicBlock)ModBlocks.magma);
	    reg((BasicBlock)ModBlocks.chiseledDreadSandstone);
	    //reg((BasicBlock)ModBlocks.lantern);
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
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.zirconOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.zirconOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.citrineOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.citrineOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.topazOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.topazOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sapphireOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.sapphireOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.amethystOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.amethystOre)).name, "inventory"));
	    for (int i = 0; i < 8; i++)
	    {
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.doubleSlabs[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.doubleSlabs[i])).name, "inventory"));
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.slabs[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.slabs[i])).name, "inventory"));
	    	ModelLoader.setCustomStateMapper(ModBlocks.doubleSlabs[i], new StateMap.Builder().ignore(ModBlockSlab.VARIANT_PROPERTY).build());
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.doubleSlabs2[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.doubleSlabs2[i])).name, "inventory"));
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.slabs2[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.slabs2[i])).name, "inventory"));
	    	ModelLoader.setCustomStateMapper(ModBlocks.doubleSlabs2[i], new StateMap.Builder().ignore(ModBlockSlab.VARIANT_PROPERTY).build());
	    }
	    for (int i = 0; i < 7; i++)
	    {
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.doubleWoodSlabs[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.doubleWoodSlabs[i])).name, "inventory"));
	    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.woodSlabs[i]), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSlab)(ModBlocks.woodSlabs[i])).name, "inventory"));
	    	ModelLoader.setCustomStateMapper(ModBlocks.doubleWoodSlabs[i], new StateMap.Builder().ignore(ModBlockSlab.VARIANT_PROPERTY).build());
	    }
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.uraniumTorch), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockTorch)(ModBlocks.uraniumTorch)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.tadaniteOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.tadaniteOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sulphurOre2), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.sulphurOre2)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.netherCorePortal), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((BlockNetherCorePortal)(ModBlocks.netherCorePortal)).name, "inventory"));	    
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.lantern), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((BlockLantern)(ModBlocks.lantern)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.lanternFloor), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((BlockLantern)(ModBlocks.lanternFloor)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.potatoBlock), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((BlockPotato)(ModBlocks.potatoBlock)).Name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.limestoneOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.limestoneOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sulphurOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.sulphurOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.catalyzer), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockTileEntity)(ModBlocks.catalyzer)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.clayOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.clayOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.prefabSapling), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockPrefabSapling)(ModBlocks.prefabSapling)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaSapling), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockSequoiaSapling)(ModBlocks.sequoiaSapling)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaLog), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockLog)(ModBlocks.sequoiaLog)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaLeaves), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockLeaves)(ModBlocks.sequoiaLeaves)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.palmLog), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockPalmLog)(ModBlocks.palmLog)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.palmSapling), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockPalmSapling)(ModBlocks.palmSapling)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.cedarSapling), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockCedarSapling)(ModBlocks.cedarSapling)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.dreadSapling), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockDreadSapling)(ModBlocks.dreadSapling)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.palmLeaves), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((BlockPalmLeaves)(ModBlocks.palmLeaves)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.reinforcedGlass), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockGlass)(ModBlocks.reinforcedGlass)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.cedarLog), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockCedarLog)(ModBlocks.cedarLog)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.dreadLog), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockDreadLog)(ModBlocks.dreadLog)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.cedarLeaves), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((BlockCedarLeaves)(ModBlocks.cedarLeaves)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.seashell), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":seashell", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.largeSeashell), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":largeSeashell", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.coconut), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":coconut", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.groundCoconut), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":coconutGround", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.tadaniteSmeltery), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":tadaniteSmeltery", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.tropicStone), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.tropicStone)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.coalOre), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.coalOre)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.rubyOreTrop), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + ((ModBlockOre)(ModBlocks.rubyOreTrop)).name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.cedarFence), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":cedarFence", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaFence), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":sequoiaFence", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.palmFence), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":palmFence", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.dreadFence), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":dreadFence", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.cedarFenceGate), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":cedarFenceGate", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaFenceGate), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":sequoiaFenceGate", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.palmFenceGate), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":palmFenceGate", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.dreadFenceGate), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":dreadFenceGate", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.petrifiedWoodWall), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":petrifiedWoodWall", "inventory"));
	    ModelLoader.setCustomStateMapper(ModBlocks.petrifiedWoodWall, new StateMap.Builder().ignore(ModBlockWall.VARIANT).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.cedarFenceGate, new StateMap.Builder().ignore(ModBlockFenceGate.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.palmFenceGate, new StateMap.Builder().ignore(ModBlockFenceGate.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.sequoiaFenceGate, new StateMap.Builder().ignore(ModBlockFenceGate.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.dreadFenceGate, new StateMap.Builder().ignore(ModBlockFenceGate.POWERED).build());
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.petrifiedWoodStairs), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":petrifiedWoodStairs", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.cementStairs), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":cementStairs", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.cedarStairs), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":cedarStairs", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.palmStairs), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":palmStairs", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.sequoiaStairs), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":sequoiaStairs", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.dreadStairs), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":dreadStairs", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.netherIceBrickStairs), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":netherIceBrickStairs", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(ModItems.diamondDoorItem, 0, new ModelResourceLocation(Main.MODID + ":diamondDoor", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(ModItems.cobbleDoorItem, 0, new ModelResourceLocation(Main.MODID + ":cobbleDoor", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(ModItems.goldDoorItem, 0, new ModelResourceLocation(Main.MODID + ":goldDoor", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(ModItems.lumiteDoorItem, 0, new ModelResourceLocation(Main.MODID + ":lumiteDoor", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(ModItems.palmDoorItem, 0, new ModelResourceLocation(Main.MODID + ":palmDoor", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(ModItems.sequoiaDoorItem, 0, new ModelResourceLocation(Main.MODID + ":sequoiaDoor", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(ModItems.cedarDoorItem, 0, new ModelResourceLocation(Main.MODID + ":cedarDoor", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(ModItems.dreadDoorItem, 0, new ModelResourceLocation(Main.MODID + ":dreadDoor", "inventory"));
	    
	    
	    ModelLoader.setCustomStateMapper(ModBlocks.diamondDoor, new StateMap.Builder().ignore(BlockDiamondDoor.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.cobbleDoor, new StateMap.Builder().ignore(BlockDiamondDoor.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.goldDoor, new StateMap.Builder().ignore(BlockDiamondDoor.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.lumiteDoor, new StateMap.Builder().ignore(BlockDiamondDoor.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.palmDoor, new StateMap.Builder().ignore(BlockDiamondDoor.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.sequoiaDoor, new StateMap.Builder().ignore(BlockDiamondDoor.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.cedarDoor, new StateMap.Builder().ignore(BlockDiamondDoor.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.dreadDoor, new StateMap.Builder().ignore(BlockDiamondDoor.POWERED).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.sequoiaSapling, new StateMap.Builder().ignore(ModBlockSequoiaSapling.STAGE).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.palmSapling, new StateMap.Builder().ignore(ModBlockPalmSapling.STAGE).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.prefabSapling, new StateMap.Builder().ignore(ModBlockPrefabSapling.STAGE).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.cedarSapling, new StateMap.Builder().ignore(ModBlockCedarSapling.STAGE).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.sequoiaSapling, new StateMap.Builder().ignore(ModBlockSequoiaSapling.TYPE).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.palmSapling, new StateMap.Builder().ignore(ModBlockPalmSapling.TYPE).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.prefabSapling, new StateMap.Builder().ignore(ModBlockPrefabSapling.TYPE).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.cedarSapling, new StateMap.Builder().ignore(ModBlockCedarSapling.TYPE).build());
	    ModelLoader.setCustomStateMapper(ModBlocks.dreadSapling, new StateMap.Builder().ignore(ModBlockDreadSapling.TYPE).build());
	}
	public static void reg(BasicBlock block)
	{
	    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block)block), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + block.name, "inventory"));
	}
}

