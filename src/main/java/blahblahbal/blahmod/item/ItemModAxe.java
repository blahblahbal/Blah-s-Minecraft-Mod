package blahblahbal.blahmod.item;

import blahblahbal.blahmod.BlahMod;
import net.minecraft.item.ItemAxe;

public class ItemModAxe extends ItemAxe
{	
	public ItemModAxe(ToolMaterial material, float damage, float speed, String unlocalizedName, String registryName)
	{
		super(material, damage, speed);
		
		setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(BlahMod.TabBlah);
	}
	public ItemModAxe(ToolMaterial material, String unlocalizedName, String registryName)
	{
		this(material, 8.0F, -3.1F, unlocalizedName, registryName);
	}
}