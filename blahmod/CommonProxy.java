package blahmod;

import blahmod.blocks.ModBlocks;
import blahmod.client.render.blocks.BlockRenderRegister;
import blahmod.crafting.ModCrafting;
import blahmod.items.ModItems;
import blahmod.world.BlahWorldGen;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e)
    {
    	ModBlocks.createBlocks();
    	ModItems.createItems();
    	ModCrafting.initCrafting();
    }

    public void init(FMLInitializationEvent e)
    {
    	GameRegistry.registerWorldGenerator(new BlahWorldGen(), 0);
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}