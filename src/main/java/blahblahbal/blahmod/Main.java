package blahblahbal.blahmod;

import java.io.File;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.enchantments.EnchantmentMoltenTouch;
import blahblahbal.blahmod.enchantments.EnchantmentPulverize;
import blahblahbal.blahmod.enchantments.EnchantmentStepping;
import blahblahbal.blahmod.items.ModItems;
import blahblahbal.blahmod.projectiles.EntityGemBolt;
import blahblahbal.blahmod.world.BiomeGenTropics;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "blahmod";
    public static final String MODNAME = "Blah's Mod";
    public static final String VERSION = "1.0.0";
    
    public static BiomeGenBase tropicsBiome;
    public static Enchantment moltenTouch; // = new EnchantmentMoltenTouch(84, new ResourceLocation("molten_touch"), 1, EnumEnchantmentType.DIGGER);
    public static Enchantment pulverize; // = new EnchantmentPulverize(85, new ResourceLocation("pulverize"), 1);
    public static Enchantment stepping; // = new EnchantmentStepping(86, new ResourceLocation("stepping"), 1, EnumEnchantmentType.ARMOR_FEET);
    public static CreativeTabBlah blahTab;
    public static CreativeTabBlahBlocks blahTabBlock;
    public static File configDirectory;
    
    @Instance
    public static Main instance = new Main();
    @SidedProxy(clientSide="blahblahbal.blahmod.ClientProxy", serverSide="blahblahbal.blahmod.ServerProxy")
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	this.proxy.preInit(e);
    	configDirectory = new File(e.getModConfigurationDirectory(), "blahmod");
    	Config.init(new File(configDirectory, "blah.cfg"));

    	moltenTouch = new EnchantmentMoltenTouch(Config.enchMoltenTouchID, new ResourceLocation("molten_touch"), 1, EnumEnchantmentType.DIGGER);
    	pulverize  = new EnchantmentPulverize(Config.enchPulverizeID, new ResourceLocation("pulverize"), 1);
    	stepping = new EnchantmentStepping(Config.enchSteppingID, new ResourceLocation("stepping"), 1, EnumEnchantmentType.ARMOR_FEET);
    	if (Loader.isModLoaded("BiomesOPlenty"))
        {
 	        ModBOP.addRecipes();
        }
    	tropicsBiome = new BiomeGenTropics(Config.biomeTropicsID).setBiomeName("Tropics").setTemperatureRainfall(0.8F, 0.4F);
    	BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(tropicsBiome, 25));
    	blahTab = new CreativeTabBlah();
    	blahTabBlock = new CreativeTabBlahBlocks();
    	OreDictionary.registerOre("plankWood", ModBlocks.sequoiaPlanks);
    	OreDictionary.registerOre("plankWood", ModBlocks.palmPlanks);
    	OreDictionary.registerOre("oreLumite", ModBlocks.lumiteOre);
    	OreDictionary.registerOre("oreSulphur", ModBlocks.sulphurOre);
    	OreDictionary.registerOre("oreLimestone", ModBlocks.limestoneOre);
    	OreDictionary.registerOre("oreTadanite", ModBlocks.tadaniteOre);
    	OreDictionary.registerOre("cobblestone", ModBlocks.tropicCobblestone);
    	OreDictionary.registerOre("stone", ModBlocks.tropicStone);
    	// increment the index for each entity you register
    	int modEntityIndex = 0;

    	// last 3 parameters are tracking range, tracking frequency, and whether to send tracking updates or not
    	// check the vanilla EntityList (I think) to find a similar entity class and use the same values
    	// in this case, throwable entities all use '64, 10, true' so I recommend you do the same
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Ruby Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Citrine Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Topaz Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Emerald Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Sapphire Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Amethyst Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Diamond Bolt", ++modEntityIndex, this, 64, 10, true);
    }

    public static boolean getMoltenTouchModifier(EntityLivingBase player)
    {
        return EnchantmentHelper.getEnchantmentLevel(moltenTouch.effectId, player.getHeldItem()) > 0;
    }
    public static boolean getLumitePick(EntityLivingBase player)
    {
        if (player instanceof EntityPlayer)
        {
        	EntityPlayer p = (EntityPlayer)player;
        	if (p.inventory.getCurrentItem() != null)
        	{
        		if (p.inventory.getCurrentItem().getItem() == ModItems.lumitePickaxe)
        		{
        			return true;
        		}
        	}
        }
        return false;
    }
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	this.proxy.init(e);
    	AchievementHandler.init();
    	/*if (Loader.isModLoaded("BiomesOPlenty"))
        {
 	        ModBOP.genStuff();
        }*/
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	this.proxy.postInit(e);
    	if (Loader.isModLoaded("Thaumcraft"))
        {
 	        ModTC.addRecipes();
        }
    }
}