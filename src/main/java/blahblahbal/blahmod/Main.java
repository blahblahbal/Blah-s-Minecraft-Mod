package blahblahbal.blahmod;

import java.io.File;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.enchantments.EnchantmentMoltenTouch;
import blahblahbal.blahmod.enchantments.EnchantmentPulverize;
import blahblahbal.blahmod.enchantments.EnchantmentStepping;
import blahblahbal.blahmod.entity.EntityEskimoZombie;
import blahblahbal.blahmod.entity.EntityIceCube;
import blahblahbal.blahmod.items.ModItems;
import blahblahbal.blahmod.projectiles.EntityGemBolt;
import blahblahbal.blahmod.world.BiomeGenCedarGrove;
import blahblahbal.blahmod.world.BiomeGenNetherCore;
import blahblahbal.blahmod.world.BiomeGenTropics;
import blahblahbal.blahmod.world.BiomeGenValley;
import blahblahbal.blahmod.world.WorldProviderNetherCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.DimensionManager;
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
    public static BiomeGenBase cedarBiome;
    public static BiomeGenBase valleyBiome;
    public static BiomeGenBase netherCoreBiome;
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
    	cedarBiome = new BiomeGenCedarGrove(Config.biomeCedarGroveID).setBiomeName("Cedar Grove").setTemperatureRainfall(0.8F, 0.4F);
    	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(cedarBiome, 38));
    	valleyBiome = new BiomeGenValley(Config.biomeValleyID).setBiomeName("Valley of the Damned").setDisableRain();
    	BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(valleyBiome, 56));
    	
    	netherCoreBiome = new BiomeGenNetherCore(Config.biomeNCID).setBiomeName("Nether Core").setDisableRain();
    	BiomeDictionary.registerBiomeType(netherCoreBiome, Type.COLD);
    	registerDimension(Config.biomeNCID, WorldProviderNetherCore.class, true);
    	blahTab = new CreativeTabBlah();
    	blahTabBlock = new CreativeTabBlahBlocks();
    	OreDictionary.registerOre("plankWood", ModBlocks.sequoiaPlanks);
    	OreDictionary.registerOre("plankWood", ModBlocks.palmPlanks);
    	OreDictionary.registerOre("plankWood", ModBlocks.cedarPlanks);
    	OreDictionary.registerOre("plankWood", ModBlocks.deadPlanks);
    	OreDictionary.registerOre("plankWood", ModBlocks.frostPlanks);
    	OreDictionary.registerOre("oreLumite", ModBlocks.lumiteOre);
    	OreDictionary.registerOre("oreSulphur", ModBlocks.sulphurOre);
    	OreDictionary.registerOre("oreLimestone", ModBlocks.limestoneOre);
    	OreDictionary.registerOre("oreTadanite", ModBlocks.tadaniteOre);
    	OreDictionary.registerOre("cobblestone", ModBlocks.tropicCobblestone);
    	OreDictionary.registerOre("stone", ModBlocks.tropicStone);
    	OreDictionary.registerOre("logWood", ModBlocks.sequoiaLog);
    	OreDictionary.registerOre("logWood", ModBlocks.palmLog);
    	OreDictionary.registerOre("logWood", ModBlocks.cedarLog);
    	OreDictionary.registerOre("logWood", ModBlocks.dreadLog);
    	OreDictionary.registerOre("logWood", ModBlocks.frostLog);
    	OreDictionary.registerOre("treeSapling", ModBlocks.sequoiaSapling);
    	OreDictionary.registerOre("treeSapling", ModBlocks.palmSapling);
    	OreDictionary.registerOre("treeSapling", ModBlocks.cedarSapling);
    	OreDictionary.registerOre("treeSapling", ModBlocks.dreadSapling);
    	OreDictionary.registerOre("treeSapling", ModBlocks.frostSapling);
    	// increment the index for each entity you register
    	int modEntityIndex = 0;

    	// last 3 parameters are tracking range, tracking frequency, and whether to send tracking updates or not
    	// check the vanilla EntityList (I think) to find a similar entity class and use the same values
    	// in this case, throwable entities all use '64, 10, true' so I recommend you do the same
    	/*EntityRegistry.registerModEntity(EntityGemBolt.class, "Ruby Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Citrine Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Topaz Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Emerald Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Sapphire Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Amethyst Bolt", ++modEntityIndex, this, 64, 10, true);
    	EntityRegistry.registerModEntity(EntityGemBolt.class, "Diamond Bolt", ++modEntityIndex, this, 64, 10, true);*/
    	EntityRegistry.addSpawn(EntityEskimoZombie.class, 10, 1, 3, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
    	EntityRegistry.registerModEntity(EntityEskimoZombie.class, "Eskimo Zombie", 50, this, 80, 3, true);
    	EntityRegistry.registerModEntity(EntityIceCube.class, "Ice Cube", 51, this, 80, 3, true);
    }
    /*public static void harvestTreeRecursive(HarvestDropsEvent e, World w, BlockPos bp, Block b, int i, int j, int k)
    {
    	if (w.getBlockState(new BlockPos(bp.getX() + i, bp.getY() + j, bp.getZ() + k)).getBlock() == b)
    	{
    		e.drops.add(new ItemStack(b, 1));
    	}
    	else if (w.getBlockState(new BlockPos(bp.getX() + i, bp.getY() + j, bp.getZ() + k)).getBlock().getMaterial() == Material.leaves ||
    			 w.getBlockState(new BlockPos(bp.getX() + i, bp.getY() + j, bp.getZ() + k)).getBlock().getMaterial() == Material.air)
    	{
    		harvestTreeRecursive(e, w, bp, b, i + 1, j + 1, k + 1);
    	}
    }*/
    
    private static void registerDimension(int id, Class<? extends WorldProvider> provider, boolean keepLoaded){
		DimensionManager.registerProviderType(id, provider, keepLoaded);
		DimensionManager.registerDimension(id, id);
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