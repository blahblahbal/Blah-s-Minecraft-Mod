package blahblahbal.blahmod.tabs;

import blahblahbal.blahmod.BlahMod;
import blahblahbal.blahmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlahTab extends CreativeTabs
{
	public BlahTab(String name) {
		super(BlahMod.MODID + "." + name);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.tadaniteShard);
	}

}