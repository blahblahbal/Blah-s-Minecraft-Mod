package blahmod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLog extends ItemBlock
{
	private final static String[] subNames =
	{
		"sequoia"
	};

	public ItemLog(Block id)
	{
		super(id);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata (int damageValue)
	{
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return "tile." + subNames[itemstack.getItemDamage()] + "Log";
	}
}