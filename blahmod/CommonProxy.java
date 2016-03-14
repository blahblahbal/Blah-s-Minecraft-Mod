package blahmod;

import blahmod.blocks.ModBlocks;
import blahmod.client.render.blocks.BlockRenderRegister;
import blahmod.crafting.ModCrafting;
import blahmod.enchantments.EnchantmentMoltenTouch;
import blahmod.items.ModItems;
import blahmod.network.ModGuiHandler;
import blahmod.tileentity.ModTileEntities;
import blahmod.world.BlahWorldGen;
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
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
    	ModItems.createItems();
    	
    	ModCrafting.initCrafting();
    	ModTileEntities.init();
    	ModFluids.registerFluids();
    	ModFluids.registerFluidContainers();
    	ModBlocks.createBlocks();
    }
    public void init(FMLInitializationEvent e)
    {
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.tadaniteOre, (Blocks.netherrack), new int[]{-1}, 90, 30, 2, 7), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.limestoneOre, (Blocks.stone), new int[]{0}, 55, 10, 2, 7), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.sulphurOre, (Blocks.stone), new int[]{0}, 35, 10, 1, 4), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.uraniumOre, (Blocks.stone), new int[]{0}, 35, 10, 2, 5), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.uraniumOre, (Blocks.stone), new int[]{0}, 7, 5, 1, 7), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.clayOre, (Blocks.dirt), new int[]{0}, 45, 25, 3, 5), 0);
    	
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.gemOres[0], (Blocks.stone), new int[]{0}, 35, 25, 1, 2), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.gemOres[1], (Blocks.stone), new int[]{0}, 35, 25, 1, 2), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.gemOres[2], (Blocks.stone), new int[]{0}, 35, 25, 1, 2), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.gemOres[3], (Blocks.stone), new int[]{0}, 35, 25, 1, 2), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.gemOres[4], (Blocks.stone), new int[]{0}, 35, 25, 1, 2), 0);
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new ModGuiHandler());
    	MinecraftForge.EVENT_BUS.register(new ModEventHandler());
    	//ModBucketHandler.INSTANCE.buckets.put(ModBlocks.acidL, ModItems.acidBucket);
    	//MinecraftForge.EVENT_BUS.register(ModBucketHandler.INSTANCE);
    	Enchantment.addToBookList(Main.moltenTouch);
    	Enchantment.addToBookList(Main.pulverize);
    }
    public void postInit(FMLPostInitializationEvent e)
    {
    }
}