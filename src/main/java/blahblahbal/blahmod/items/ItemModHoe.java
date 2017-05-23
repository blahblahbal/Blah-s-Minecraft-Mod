package main.java.blahblahbal.blahmod.items;

import main.java.blahblahbal.blahmod.Main;
import net.minecraft.item.ItemHoe;

public class ItemModHoe extends ItemHoe {

	public ItemModHoe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
	}
}