package blahmod.items;

import blahmod.Main;
import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe
{
	public ItemModPickaxe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
	}
}