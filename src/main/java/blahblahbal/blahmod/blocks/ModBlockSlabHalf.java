package blahblahbal.blahmod.blocks;

import net.minecraft.block.material.Material;

public class ModBlockSlabHalf extends ModBlockSlab
{
    public ModBlockSlabHalf(String uname)
    {
		super(uname);
	}

    @Override
	public boolean isDouble()
    {
        return false;
    }
}