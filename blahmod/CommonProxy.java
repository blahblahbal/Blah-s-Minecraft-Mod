package blahmod;

import blahmod.blocks.BlockInventoryFurnace;
import blahmod.blocks.ModBlocks;
import blahmod.client.render.blocks.BlockRenderRegister;
import blahmod.crafting.ModCrafting;
import blahmod.enchantments.EnchantmentMoltenTouch;
import blahmod.guicontainer.TileInventoryFurnace;
import blahmod.items.ModItems;
import blahmod.network.ModGuiHandler;
import blahmod.projectiles.EntityGemBolt;
import blahmod.tileentity.ModTileEntities;
import blahmod.world.BlahWorldGen;
import blahmod.world.BlahWorldGen2;
import blahmod.world.GeneratorAcidLake;
import blahmod.world.WorldGenMud;
import blahmod.world.WorldGeneratorNetherVillage;
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
    	ModItems.createItems();
    	ModBlocks.createBlocks();
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