package blahblahbal.blahmod.item;

import blahblahbal.blahmod.BlahMod;
import net.minecraft.item.Item;

public class ItemBasic extends Item
{
	public ItemBasic(String unlocalizedName, String registryName)
	{
		setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(BlahMod.MODID + "." + registryName);
		setCreativeTab(BlahMod.TabBlah);
	}
}