package blahmod;

import blahmod.blocks.ModBlocks;
import blahmod.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
	static final FuelHandler INSTANCE = new FuelHandler();
	final int COAL = 1600;
	final int HARDENED_LAVA = COAL * 3;
	final int OSBORGNEN = HARDENED_LAVA * 12;
	final int CATALYTIC_INVERTER = OSBORGNEN * 2;
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == ModItems.osborgnenFuel)
		{
			return OSBORGNEN;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(ModBlocks.hardenedLava))
		{
			return HARDENED_LAVA;
		}
		else if (fuel.getItem() == ModItems.catalyticInverter)
		{
			return CATALYTIC_INVERTER;
		}
		return 0;
	}
}