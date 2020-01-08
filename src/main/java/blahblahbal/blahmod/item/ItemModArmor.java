package blahblahbal.blahmod.item;

import blahblahbal.blahmod.BlahMod;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor
{
	public ItemModArmor(ArmorMaterial material, EntityEquipmentSlot equipmentSlot, String unlocalizedName, String registryName)
	{
		super(material, 0, equipmentSlot);
		
		setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(BlahMod.TabBlah);
	}
}
