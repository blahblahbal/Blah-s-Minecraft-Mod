package blahblahbal.blahmod;

import blahblahbal.blahmod.blocks.BlockInventoryFurnace;
import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.client.render.blocks.BlockRenderRegister;
import blahblahbal.blahmod.crafting.ModCrafting;
import blahblahbal.blahmod.enchantments.EnchantmentMoltenTouch;
import blahblahbal.blahmod.guicontainer.TileInventoryFurnace;
import blahblahbal.blahmod.items.ModItems;
import blahblahbal.blahmod.network.ModGuiHandler;
import blahblahbal.blahmod.projectiles.EntityGemBolt;
import blahblahbal.blahmod.tileentity.ModTileEntities;
import blahblahbal.blahmod.world.BlahWorldGen;
import blahblahbal.blahmod.world.BlahWorldGen2;
import blahblahbal.blahmod.world.GeneratorAcidLake;
import blahblahbal.blahmod.world.WorldGenMud;
import blahblahbal.blahmod.world.WorldGeneratorNetherVillage;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
	
    public void preInit(FMLPreInitializationEvent e)
    {
	    ModBlocks.createBlocks();
	    ModItems.createItems();
    	GameRegistry.registerTileEntity(TileInventoryFurnace.class, "tadaniteSmeltery");
    	ModCrafting.initCrafting();
    	GameRegistry.registerFuelHandler(new FuelHandler());
    	ModTileEntities.init();
    	//ModFluids.registerFluids();
    	//ModFluids.registerFluidContainers();
    }
    public void init(FMLInitializationEvent e)
    {
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.tadaniteOre, (Blocks.netherrack), new int[]{-1}, 90, 30, 2, 7), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.limestoneOre, (Blocks.stone), new int[]{0}, 55, 10, 2, 7), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen2((Block)ModBlocks.boneBlock, (Blocks.stone), new int[]{0}, 55, 10, 10, 12, "Swampland"), 0);
    	
    	//GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.uraniumOre, (Blocks.stone), new int[]{0}, 35, 10, 2, 5), 0);
    	//GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.uraniumOre, (Blocks.stone), new int[]{0}, 7, 5, 1, 7), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.clayOre, (Blocks.dirt), new int[]{0}, 45, 25, 3, 5), 0);
    	
    	
    	/*for (int i = 0; i < 5; i++)
    	{
    		GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.gemOres[i], (Blocks.stone), new int[]{0}, 40, 20, 1, 3), 0);
    	}*/
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.rubyOre, (Blocks.stone), new int[]{0}, 45, 25, 1, 3), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.citrineOre, (Blocks.stone), new int[]{0}, 50, 15, 2, 3), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen2((Block)ModBlocks.topazOre, (Blocks.stone), new int[]{0}, 43, 27, 3, 3, "Desert"), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen2((Block)ModBlocks.sapphireOre, (Blocks.stone), new int[]{0}, 40, 20, 4, 3, "Ocean"), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.amethystOre, (Blocks.stone), new int[]{0}, 35, 22, 2, 3), 0);
    	GameRegistry.registerWorldGenerator(new WorldGeneratorNetherVillage(), 10);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen(ModBlocks.coalOre, (ModBlocks.tropicStone), new int[]{0}, 55, 35, 7, 15), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen(ModBlocks.ironOre, (ModBlocks.tropicStone), new int[]{0}, 55, 35, 3, 10), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen(ModBlocks.goldOre, (ModBlocks.tropicStone), new int[]{0}, 42, 35, 3, 9), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen(ModBlocks.rubyOreTrop, (ModBlocks.tropicStone), new int[]{0}, 42, 35, 1, 1), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.igneousRock, (Blocks.stone), new int[]{0}, 35, 15, 1, 25), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.sulphurOre, (ModBlocks.igneousRock), new int[]{0}, 35, 15, 2, 5), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.magnetite, (Blocks.stone), new int[]{0}, 55, 20, 1, 25), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.hardenedLava, (Blocks.stone), new int[]{0}, 15, 1, 1, 20), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.lumiteOre, (ModBlocks.hardenedLava), new int[]{0}, 15, 1, 3, 4), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.saltrock, (Blocks.stone), new int[]{0}, 60, 15, 1, 25), 0);
    	GameRegistry.registerWorldGenerator(new GeneratorAcidLake(0.2F, ModBlocks.acid.getDefaultState(), Blocks.stone.getDefaultState()), 0);
    	GameRegistry.registerWorldGenerator(new WorldGenMud(10, ModBlocks.tropicMud), 0);
    	NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new ModGuiHandler());
    	MinecraftForge.EVENT_BUS.register(new ModEventHandler());
    	Enchantment.addToBookList(Main.moltenTouch);
    	Enchantment.addToBookList(Main.pulverize);
    	Enchantment.addToBookList(Main.stepping);
    }
    public void postInit(FMLPostInitializationEvent e)
    {
    }
	public void registerFluidBlockRendering(Block block, String name) {	}
}