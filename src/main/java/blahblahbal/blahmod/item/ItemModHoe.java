package blahblahbal.blahmod.item;

import blahblahbal.blahmod.BlahMod;
import net.minecraft.item.ItemHoe;

public class ItemModHoe extends ItemHoe
{	
	public ItemModHoe(ToolMaterial material, String unlocalizedName, String registryName)
	{
		super(material);
		
		setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(BlahMod.TabBlah);
	}
}