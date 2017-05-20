package blahmod.blocks;

import blahmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockPotato extends Block
{
	public String Name;
	
    public BlockPotato(Material materialIn, String name)
    {
		super(materialIn);
		this.setCreativeTab(Main.blahTabBlock);
		this.setUnlocalizedName(name);
		this.Name = name;
		this.setHardness(0.5F);
		this.setResistance(20F);
	}

	@Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state)
    {   
        return null;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
    	entity.setInWeb();
    }
}
