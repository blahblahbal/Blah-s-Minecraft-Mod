package blahmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor
{

    public ItemModArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType)
    {
        super(material, renderIndex, armorType);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setUnlocalizedName(unlocalizedName);
    }
}