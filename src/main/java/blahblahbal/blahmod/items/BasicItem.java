package main.java.blahblahbal.blahmod.items;

import main.java.blahblahbal.blahmod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item {

	public BasicItem(String unlocalizedName)
	{
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
	}
}