package blahmod.items;

import blahmod.AchievementHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemInverter extends BasicItem
{
	public ItemInverter(String unlocalizedName)
	{
		super(unlocalizedName);
	}
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) 
	{
		super.onCreated(stack, world, player);
		if (!world.isRemote)
		{
			player.addStat(AchievementHandler.INVERTER, 1);
		}
	}
}
