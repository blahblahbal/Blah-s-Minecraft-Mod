package main.java.blahblahbal.blahmod.items;

import main.java.blahblahbal.blahmod.AchievementHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BedrockPickaxe extends ItemModPickaxe
{
	public BedrockPickaxe(String unlocalizedName, ToolMaterial material)
	{
		super(unlocalizedName, material);
	}
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		super.onCreated(stack, world, player);
		if (!world.isRemote)
		{
			player.addStat(AchievementHandler.BEDROCK_PICKAXE, 1);
		}
	}
}
