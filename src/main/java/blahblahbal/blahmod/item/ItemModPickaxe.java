package blahblahbal.blahmod.item;

import blahblahbal.blahmod.BlahMod;

import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe
{	
	public ItemModPickaxe(ToolMaterial material, String unlocalizedName, String registryName)
	{
		super(material);
		setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(BlahMod.TabBlah);
	}
}