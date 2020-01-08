package blahblahbal.blahmod;

import org.apache.logging.log4j.Logger;

import blahblahbal.blahmod.init.ModBlocks;
import blahblahbal.blahmod.proxy.IProxy;
import blahblahbal.blahmod.tabs.BlahTab;
import blahblahbal.blahmod.tileentity.ModTileEntity;
import blahblahbal.blahmod.world.gen.ModWorldGen;

import org.apache.logging.log4j.LogManager;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = BlahMod.MODID, name = BlahMod.NAME, version = BlahMod.VERSION, acceptedMinecraftVersions = BlahMod.MC_VERSION)
public class BlahMod
{
    public static final String MODID = "blahmod";
    public static final String NAME = "Blah's Mod";
    public static final String VERSION = "1.0";
    public static final String MC_VERSION = "[1.12.2]";

    public static final String CLIENT = "blahblahbal.blahmod.proxy.ClientProxy";
	public static final String SERVER = "blahblahbal.blahmod.proxy.ServerProxy";
    
    public static final CreativeTabs TabBlah = new BlahTab("tabBlah");
    
    @Instance
    public static BlahMod instance = new BlahMod();
    
    @SidedProxy(clientSide = BlahMod.CLIENT, serverSide = BlahMod.SERVER)
	public static IProxy proxy;
    
    public static final Logger LOGGER = LogManager.getLogger(BlahMod.MODID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    	//ModItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    	GameRegistry.registerTileEntity(ModTileEntity.class, new ResourceLocation(MODID + ":catalyzer"));
    	GameRegistry.registerWorldGenerator(new ModWorldGen(ModBlocks.hardenedLava, (Blocks.STONE), new int[]{0}, 15, 1, 1, 20), 0);
    	LOGGER.info(BlahMod.NAME + " says hi!");
    }

    @EventHandler
	public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
	}

}
