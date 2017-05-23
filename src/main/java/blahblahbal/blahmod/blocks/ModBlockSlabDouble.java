package main.java.blahblahbal.blahmod.blocks;

import net.minecraft.block.material.Material;

public class ModBlockSlabDouble extends ModBlockSlab
{
    public ModBlockSlabDouble(String uname)
    {
		super(uname);
	}

    @Override
	public boolean isDouble()
    {
        return true;
    }
}