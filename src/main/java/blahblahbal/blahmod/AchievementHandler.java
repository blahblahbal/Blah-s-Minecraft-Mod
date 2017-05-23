package main.java.blahblahbal.blahmod;

import com.google.common.collect.ImmutableList;

import main.java.blahblahbal.blahmod.blocks.ModBlocks;
import main.java.blahblahbal.blahmod.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public final class AchievementHandler
{
	public static final Achievement CATALYZER = (Achievement)new Achievement("catalyzer", "catalyzer", 0, 2, ModBlocks.catalyzer, null).initIndependentStat().registerStat();
	//public static final Achievement PREFAB_SAPLING = (Achievement)new Achievement("prefab", "prefab", 2, 2, ModBlocks.prefabSapling, null).initIndependentStat().registerStat();
	public static final Achievement BEDROCK_PICKAXE = (Achievement)new Achievement("bed_pick", "bed_pick", 0, -2, ModItems.bedrockPickaxe, CATALYZER).registerStat();
	public static final Achievement INVERTER = (Achievement)new Achievement("inverter", "inverter", -2, 2, ModItems.catalyticInverter, CATALYZER).registerStat();
	public static final Achievement SMELTERY = (Achievement)new Achievement("smeltery", "smeltery", -4, 2, ModBlocks.tadaniteSmeltery, INVERTER).registerStat().setSpecial();

	public static ImmutableList<Achievement> list = ImmutableList.of(
			CATALYZER, BEDROCK_PICKAXE, INVERTER, SMELTERY
	);
	
	public static void init()
	{
		AchievementPage.registerAchievementPage(new AchievementPage("Blah", list.toArray(new Achievement[list.size()])));
	}
}
