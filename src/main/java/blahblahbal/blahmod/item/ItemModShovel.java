package blahblahbal.blahmod.item;

import blahblahbal.blahmod.BlahMod;
import net.minecraft.item.ItemSpade;

public class ItemModShovel extends ItemSpade
{	
	public ItemModShovel(ToolMaterial material, String unlocalizedName, String registryName)
	{
		super(material);
		setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(BlahMod.TabBlah);
	}
}