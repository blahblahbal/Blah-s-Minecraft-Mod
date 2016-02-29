package blahmod.items;

import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe
{
	public ItemModPickaxe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
	}
}