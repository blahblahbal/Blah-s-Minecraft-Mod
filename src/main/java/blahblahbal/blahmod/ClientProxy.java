package blahblahbal.blahmod;

import blahblahbal.blahmod.client.render.blocks.BlockRenderRegister;
import blahblahbal.blahmod.client.render.entity.RenderEskimoZombie;
import blahblahbal.blahmod.client.render.entity.RenderGemBolt;
import blahblahbal.blahmod.client.render.entity.RenderIceCube;
import blahblahbal.blahmod.client.render.items.ItemRenderRegister;
import blahblahbal.blahmod.entity.EntityEskimoZombie;
import blahblahbal.blahmod.entity.EntityIceCube;
import blahblahbal.blahmod.projectiles.EntityGemBolt;
import blahblahbal.blahmod.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        BlockRenderRegister.registerBlockRenderer();
        Item itemBlockSimple = GameRegistry.findItem("blahmod", "tadaniteSmeltery");
        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("blahmod:tadaniteSmeltery", "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(itemBlockSimple, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
        //BlockRenderRegister.INSTANCE.registerFluidModels();
        RenderingRegistry.registerEntityRenderingHandler(EntityEskimoZombie.class, manager -> new RenderEskimoZombie(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceCube.class, manager -> new RenderIceCube(manager));
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        
        ItemRenderRegister.registerItemRenderer();
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderingRegistry.registerEntityRenderingHandler(EntityGemBolt.class, new RenderGemBolt(renderManager, 1F));
    }

    @Override
    public void postInit(FMLPostInitializationEvent e)
    {
        super.postInit(e);
    }
    @Override
    public void registerFluidBlockRendering(Block block, String name) 
    {
        final ModelResourceLocation fluidLocation = new ModelResourceLocation("blahmod:fluids", name);

        // use a custom state mapper which will ignore the LEVEL property
        ModelLoader.setCustomStateMapper(block, new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return fluidLocation;
            }
        });
}
}