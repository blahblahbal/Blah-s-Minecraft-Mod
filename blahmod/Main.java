package blahmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

    public static final String MODID = "blahmod";
    public static final String MODNAME = "Blah's Mod";
    public static final String VERSION = "0.2.0";

    @Instance
    public static Main instance = new Main();
    @SidedProxy(clientSide="blahmod.ClientProxy", serverSide="blahmod.ServerProxy")
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	this.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	this.proxy.postInit(e);
    }
}