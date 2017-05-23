package main.java.blahblahbal.blahmod.items;

import main.java.blahblahbal.blahmod.Main;
import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {

	public ItemModSword(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
	}
}