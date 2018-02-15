package blahblahbal.blahmod.items;

import blahblahbal.blahmod.Main;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword
{
	String name;
	public ItemModSword(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		this.name = unlocalizedName;
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
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