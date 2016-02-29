package blahmod.items;

import net.minecraft.item.ItemSpade;

public class ItemModShovel extends ItemSpade {

	public ItemModShovel(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
	}
}