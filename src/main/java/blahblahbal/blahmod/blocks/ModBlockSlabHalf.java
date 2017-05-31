package blahblahbal.blahmod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModBlockSlabHalf extends ModBlockSlab
{
    public ModBlockSlabHalf(String uname, Material m)
    {
		super(uname, m);
	}

    @Override
	public boolean isDouble()
    {
        return false;
    }

	@Override
	public Item getHalfSlabReference()
	{	
		return Item.getItemFromBlock(this);
	}
}