package blahblahbal.blahmod.item;

import blahblahbal.blahmod.BlahMod;
import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword
{	
	public ItemModSword(ToolMaterial material, String unlocalizedName, String registryName)
	{
		super(material);
		setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(BlahMod.TabBlah);
	}
}