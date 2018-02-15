package blahblahbal.blahmod.blocks;

import blahblahbal.blahmod.Main;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockCedarLog extends BlockRotatedPillar
{
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	public static String name;
	
	public ModBlockCedarLog(String name)
	{
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
		this.name = name;
		this.setUnlocalizedName(name);
        this.setCreativeTab(Main.blahTabBlock);
        this.setHarvestLevel("axe", 0);
        this.setHardness(2F);
        this.setResistance(5F);
        this.setStepSound(soundTypeWood);
	}
	@Override
	public boolean canSustainLeaves(IBlockAccess world, BlockPos pos)
	{
		return true;
	}
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = 4;
        int j = i + 1;

        if (worldIn.isAreaLoaded(pos.add(-j, -j, -j), pos.add(j, j, j)))
        {
            for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-i, -i, -i), pos.add(i, i, i)))
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if (iblockstate.getBlock().isLeaves(worldIn, blockpos))
                {
                    iblockstate.getBlock().beginLeavesDecay(worldIn, blockpos);
                }
            }
        }
    }
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
    }
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockLog.EnumAxis)state.getValue(LOG_AXIS)).ordinal() * 4;
	}
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.values()[meta >> 2]);
	}
	@Override
	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[]{LOG_AXIS});
    }
}