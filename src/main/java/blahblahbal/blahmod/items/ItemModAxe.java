package blahblahbal.blahmod.items;

import java.util.List;

import blahblahbal.blahmod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModAxe extends ItemAxe
{
	String name;
	public ItemModAxe(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
		this.name = unlocalizedName;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		if (this.name.contains("obsidian"))
		{
			tooltip.add("§7Fragile");
		}
		if (this.name.contains("tadanite"))
		{
			tooltip.add("§eEfficient");
		}
	}
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
		ItemStack mat = new ItemStack(ModItems.lumite);
        if (this.name.contains("tadanite"))
        {
        	mat = new ItemStack(ModItems.tadaniteDiamond);
        }
        if (this.name.contains("obsidian"))
        {
        	mat = new ItemStack(ModItems.obsidianIngot);
        }
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
}
}