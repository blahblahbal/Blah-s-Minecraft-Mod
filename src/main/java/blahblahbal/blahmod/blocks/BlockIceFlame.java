package blahblahbal.blahmod.blocks;

import java.util.Random;

import blahblahbal.blahmod.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockIceFlame extends Block {

	public BlockIceFlame()
	{
		super(Material.fire);
		setTickRandomly(true);
	}

	@Override
	public boolean isBurning(IBlockAccess world, BlockPos pos)
	{
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		return null;
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		if(!World.doesBlockHaveSolidTopSurface(worldIn, pos.down()))
			worldIn.setBlockToAir(pos);
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random random)
	{
		return 0;
	}

	@Override
	public int tickRate(World worldIn)
	{
		return 30;
	}

	@Override
	public boolean requiresUpdates()
	{
		return false;
	}

	@Override
	public boolean isCollidable()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, BlockPos pos, Entity par5Entity) {
		super.onEntityCollidedWithBlock(par1World, pos, par5Entity);

	}

	@Override
	public void onBlockAdded(World par1World, BlockPos pos, IBlockState state)
	{

		if ((par1World.provider.getDimensionId() == -1 || par1World.provider.getDimensionId() == Config.netherCoreID) &&
				!BlockNetherCorePortal.tryToCreatePortal(par1World, pos))
			if (!World.doesBlockHaveSolidTopSurface(par1World, pos.down()))
				par1World.setBlockToAir(pos);
			else
				par1World.scheduleUpdate(pos, this, tickRate(par1World) + par1World.rand.nextInt(10));
	}
}