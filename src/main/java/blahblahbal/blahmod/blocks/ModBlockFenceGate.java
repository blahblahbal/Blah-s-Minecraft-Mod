package blahblahbal.blahmod.blocks;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;

public class ModBlockFenceGate extends BlockFenceGate
{
	public ModBlockFenceGate(String uname)
	{
		super(BlockPlanks.EnumType.OAK);
		this.setHarvestLevel("axe", 0);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
	    this.setStepSound(soundTypeWood);
	    this.setUnlocalizedName(uname);
	}

}
