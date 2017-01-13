package blahmod.items;

import blahmod.Main;
import net.minecraft.item.ItemAxe;

public class ItemModAxe extends ItemAxe {

	public ItemModAxe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
	}
}