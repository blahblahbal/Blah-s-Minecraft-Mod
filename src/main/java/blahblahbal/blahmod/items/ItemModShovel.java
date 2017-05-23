package main.java.blahblahbal.blahmod.items;

import main.java.blahblahbal.blahmod.Main;
import net.minecraft.item.ItemSpade;

public class ItemModShovel extends ItemSpade {

	public ItemModShovel(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
	}
}