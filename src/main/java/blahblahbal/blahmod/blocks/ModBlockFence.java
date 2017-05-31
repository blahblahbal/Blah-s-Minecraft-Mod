package blahblahbal.blahmod.blocks;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;

public class ModBlockFence extends BlockFence
{
	public ModBlockFence(Material m, String uname)
	{
		super(m);
		this.setHardness(2F);
		this.setResistance(5F);
		this.setHarvestLevel("axe", 0);
		this.setUnlocalizedName(uname);
	}
}
