package blahblahbal.blahmod.item;

import javax.annotation.Nonnull;

import blahblahbal.blahmod.BlahMod;
import net.minecraft.item.Item;

public class ItemBasic extends Item
{
	public ItemBasic(String registryName) //String unlocalizedName, String registryName)
	{
		//setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(BlahMod.TabBlah);
	}
	@Nonnull
	@Override
	public Item setTranslationKey(@Nonnull String message)
	{
		return super.setTranslationKey("blahmod." + message);
	}
}