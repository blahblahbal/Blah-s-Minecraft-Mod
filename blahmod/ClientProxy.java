package blahmod;

import blahmod.client.render.blocks.BlockRenderRegister;
import blahmod.client.render.items.ItemRenderRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        
        
        BlockRenderRegister.registerBlockRenderer();
        blahmod.container.StartupClientOnly.preInitClientOnly();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        
        
        ItemRenderRegister.registerItemRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}