package blahblahbal.blahmod;

import com.google.common.collect.ImmutableList;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public final class AchievementHandler
{
	public static final Achievement GHOST = (Achievement)new Achievement("ghost", "ghost", 0, 2, Blocks.obsidian, null).initIndependentStat().registerStat();
	
	public static final Achievement CATALYZER = (Achievement)new Achievement("catalyzer", "catalyzer", 0, 2, ModBlocks.catalyzer, null).initIndependentStat().registerStat();
	//public static final Achievement PREFAB_SAPLING = (Achievement)new Achievement("prefab", "prefab", 2, 2, ModBlocks.prefabSapling, null).initIndependentStat().registerStat();
	public static final Achievement BEDROCK_PICKAXE = (Achievement)new Achievement("bed_pick", "bed_pick", 0, -2, ModItems.bedrockPickaxe, CATALYZER).registerStat();
	public static final Achievement INVERTER = (Achievement)new Achievement("inverter", "inverter", -2, 2, ModItems.catalyticInverter, CATALYZER).registerStat();
	public static final Achievement SMELTERY = (Achievement)new Achievement("smeltery", "smeltery", -4, 2, ModBlocks.tadaniteSmeltery, INVERTER).registerStat().setSpecial();
	
	public static final Achievement NETHERCORE = (Achievement)new Achievement("nethercore", "nethercore", 2, 2, ModItems.netherCoreKey, null).initIndependentStat().registerStat();
	public static final Achievement TAD_ARMOR = (Achievement)new Achievement("tadaniteArmor", "tadaniteArmor", 2, 4, ModItems.tadaniteHelmet, NETHERCORE).registerStat();
	public static final Achievement LUM_ARMOR = (Achievement)new Achievement("lumiteArmor", "lumiteArmor", 2, 6, ModItems.lumiteHelmet, TAD_ARMOR).registerStat().setSpecial();
	
	
	public static ImmutableList<Achievement> list = ImmutableList.of(
			CATALYZER, BEDROCK_PICKAXE, INVERTER, SMELTERY, NETHERCORE, TAD_ARMOR, LUM_ARMOR
	);
	
	public static void init()
	{
		AchievementPage.registerAchievementPage(new AchievementPage("Blah", list.toArray(new Achievement[list.size()])));
	}
}
