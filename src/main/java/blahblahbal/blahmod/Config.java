package blahblahbal.blahmod;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config
{
	public static Configuration config;
	public static int enchMoltenTouchID;
	public static int enchPulverizeID;
	public static int enchSteppingID;
	public static int biomeTropicsID;
	public static int biomeCedarGroveID;
	public static int biomeValleyID;
	public static int netherCoreID;
	public static int biomeNCID;
	public static int portalCD;
	public static void init(File configFile)
    {
        if (config == null)
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }
	private static void loadConfiguration()
	{
		try
		{
			enchMoltenTouchID = config.getInt("Molten Touch Enchantment ID", "BlahMod", 84, 60, 200, "");
			enchPulverizeID = config.getInt("Pulverize Enchantment ID", "BlahMod", 85, 60, 200, "");
			enchSteppingID = config.getInt("Stepping Enchantment ID", "BlahMod", 86, 60, 200, "");
			biomeTropicsID = config.getInt("Tropics Biome ID", "BlahMod", 252, 40, 255, "");
			biomeCedarGroveID = config.getInt("Cedar Grove Biome ID", "BlahMod", 253, 40, 255, "");
			biomeValleyID = config.getInt("Valley of the Damned Biome ID", "BlahMod", 254, 40, 255, "");
			biomeNCID = config.getInt("Nether Core Biome ID", "BlahMod", 255, 40, 255, "");
			netherCoreID = config.getInt("Nether Core Dimension ID", "BlahMod", 255, -2, 255, "");
			portalCD = config.getInt("Portal Cooldown", "BlahMod", 10, 10, 300, "");
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			if (config.hasChanged()) config.save();
		}
	}
}
