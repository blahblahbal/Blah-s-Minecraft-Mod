package blahmod;

import blahmod.blocks.ModBlocks;
import blahmod.client.render.blocks.BlockRenderRegister;
import blahmod.crafting.ModCrafting;
import blahmod.items.ModItems;
import blahmod.world.BlahWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e)
    {
    	ModItems.createItems();
    	ModBlocks.createBlocks();
    	ModCrafting.initCrafting();
    	blahmod.container.StartupCommon.preInitCommon();
    }

    public void init(FMLInitializationEvent e)
    {
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.tadaniteOre, (Blocks.netherrack), new int[]{-1}, 90, 30, 3, 7), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.limestoneOre, (Blocks.stone), new int[]{0}, 55, 10, 3, 7), 0);
    	GameRegistry.registerWorldGenerator(new BlahWorldGen((Block)ModBlocks.sulphurOre, (Blocks.stone), new int[]{0}, 35, 10, 1, 4), 0);
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}