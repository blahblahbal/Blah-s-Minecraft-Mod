package blahmod;

import blahmod.enchantments.EnchantmentMoltenTouch;
import blahmod.enchantments.EnchantmentPulverize;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "blahmod";
    public static final String MODNAME = "Blah's Mod";
    public static final String VERSION = "0.2.5";
    public static final Enchantment moltenTouch = new EnchantmentMoltenTouch(84, new ResourceLocation("molten_touch"), 1, EnumEnchantmentType.DIGGER);
    public static final Enchantment pulverize = new EnchantmentPulverize(85, new ResourceLocation("pulverize"), 1);
    
    @Instance
    public static Main instance = new Main();
    @SidedProxy(clientSide="blahmod.ClientProxy", serverSide="blahmod.ServerProxy")
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	this.proxy.preInit(e);
    }

    public static boolean getMoltenTouchModifier(EntityLivingBase player)
    {
        return EnchantmentHelper.getEnchantmentLevel(moltenTouch.effectId, player.getHeldItem()) > 0;
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