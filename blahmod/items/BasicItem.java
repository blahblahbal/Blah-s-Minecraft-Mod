package blahmod.items;

import blahmod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item {

	public BasicItem(String unlocalizedName) {
		super();

		this.setUnlocalizedName(unlocalizedName);
		
		this.setCreativeTab(Main.blahTab);
	}

}