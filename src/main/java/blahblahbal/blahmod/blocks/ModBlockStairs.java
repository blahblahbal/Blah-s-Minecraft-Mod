package blahblahbal.blahmod.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class ModBlockStairs extends BlockStairs
{
	public ModBlockStairs(IBlockState state, String uname)
	{
		super(state);
		this.setHarvestLevel("pickaxe", 0);
		if (uname == "cedarStairs" || uname == "palmStairs" || uname == "sequoiaStairs")
		{
			this.setHarvestLevel("axe", 0);
		}
		this.setUnlocalizedName(uname);
	}

}
