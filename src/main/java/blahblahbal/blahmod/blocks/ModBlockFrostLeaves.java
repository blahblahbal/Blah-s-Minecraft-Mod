package blahblahbal.blahmod.blocks;

import java.util.List;
import java.util.Random;

import blahblahbal.blahmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockFrostLeaves extends BlockLeaves
{
	public static String name;
	int[] surroundings;
	public ModBlockFrostLeaves(String name)
	{
		this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false)));
		setUnlocalizedName(name);
		this.name = name;
		setCreativeTab(Main.blahTabBlock);
	}
	@Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 0xFFFFFF;
    }
	@Override
	@SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return 0xFFFFFF;
    }
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(IBlockState state)
    {
        return 0xFFFFFF;
    }
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.frostSapling);
	}
	@Override
    protected int getSaplingDropChance(IBlockState state)
    {
        return 50;
    }
	@Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta).withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false));
}
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}

	public int getMetaFromState(IBlockState state)
	{
		byte b0 = 0;
		int i = b0;

		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue())
		{
			i |= 4;
		}

		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |= 8;
		}

		return i;
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue() && ((Boolean)state.getValue(DECAYABLE)).booleanValue())
            {
                int radius = 6;
                int j = radius + 1;
                int xPos = pos.getX();
                int yPos = pos.getY();
                int zPos = pos.getZ();
                int j1 = 32;
                int k1 = j1 * j1;
                int l1 = j1 / 2;

                if (this.surroundings == null)
                {
                    this.surroundings = new int[j1 * j1 * j1];
                }

                if (worldIn.isAreaLoaded(new BlockPos(xPos - j, yPos - j, zPos - j), new BlockPos(xPos + j, yPos + j, zPos + j)))
                {
                    BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                    for (int i2 = -radius; i2 <= radius; ++i2)
                    {
                        for (int j2 = -radius; j2 <= radius; ++j2)
                        {
                            for (int k2 = -radius; k2 <= radius; ++k2)
                            {
                                Block block = worldIn.getBlockState(blockpos$mutableblockpos.set(xPos + i2, yPos + j2, zPos + k2)).getBlock();

                                if (!block.canSustainLeaves(worldIn, blockpos$mutableblockpos.set(xPos + i2, yPos + j2, zPos + k2)))
                                {
                                    if (block.isLeaves(worldIn, blockpos$mutableblockpos.set(xPos + i2, yPos + j2, zPos + k2)))
                                    {
                                        this.surroundings[(i2 + l1) * k1 + (j2 + l1) * j1 + k2 + l1] = -2;
                                    }
                                    else
                                    {
                                        this.surroundings[(i2 + l1) * k1 + (j2 + l1) * j1 + k2 + l1] = -1;
                                    }
                                }
                                else
                                {
                                    this.surroundings[(i2 + l1) * k1 + (j2 + l1) * j1 + k2 + l1] = 0;
                                }
                            }
                        }
                    }

                    for (int i3 = 1; i3 <= 4; ++i3)
                    {
                        for (int j3 = -radius; j3 <= radius; ++j3)
                        {
                            for (int k3 = -radius; k3 <= radius; ++k3)
                            {
                                for (int l3 = -radius; l3 <= radius; ++l3)
                                {
                                    if (this.surroundings[(j3 + l1) * k1 + (k3 + l1) * j1 + l3 + l1] == i3 - 1)
                                    {
                                        if (this.surroundings[(j3 + l1 - 1) * k1 + (k3 + l1) * j1 + l3 + l1] == -2)
                                        {
                                            this.surroundings[(j3 + l1 - 1) * k1 + (k3 + l1) * j1 + l3 + l1] = i3;
                                        }

                                        if (this.surroundings[(j3 + l1 + 1) * k1 + (k3 + l1) * j1 + l3 + l1] == -2)
                                        {
                                            this.surroundings[(j3 + l1 + 1) * k1 + (k3 + l1) * j1 + l3 + l1] = i3;
                                        }

                                        if (this.surroundings[(j3 + l1) * k1 + (k3 + l1 - 1) * j1 + l3 + l1] == -2)
                                        {
                                            this.surroundings[(j3 + l1) * k1 + (k3 + l1 - 1) * j1 + l3 + l1] = i3;
                                        }

                                        if (this.surroundings[(j3 + l1) * k1 + (k3 + l1 + 1) * j1 + l3 + l1] == -2)
                                        {
                                            this.surroundings[(j3 + l1) * k1 + (k3 + l1 + 1) * j1 + l3 + l1] = i3;
                                        }

                                        if (this.surroundings[(j3 + l1) * k1 + (k3 + l1) * j1 + (l3 + l1 - 1)] == -2)
                                        {
                                            this.surroundings[(j3 + l1) * k1 + (k3 + l1) * j1 + (l3 + l1 - 1)] = i3;
                                        }

                                        if (this.surroundings[(j3 + l1) * k1 + (k3 + l1) * j1 + l3 + l1 + 1] == -2)
                                        {
                                            this.surroundings[(j3 + l1) * k1 + (k3 + l1) * j1 + l3 + l1 + 1] = i3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                int l2 = this.surroundings[l1 * k1 + l1 * j1 + l1];

                if (l2 >= 0)
                {
                    worldIn.setBlockState(pos, state.withProperty(CHECK_DECAY, Boolean.valueOf(false)), 4);
                }
                else
                {
                    this.destroy(worldIn, pos);
                }
            }
        }
    }
	private void destroy(World worldIn, BlockPos pos)
    {
        this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
        worldIn.setBlockToAir(pos);
    }
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { CHECK_DECAY, DECAYABLE });
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return Blocks.leaves.getBlockLayer();
	}

	@Override
	public List<ItemStack> onSheared(ItemStack arg0, IBlockAccess arg1, BlockPos arg2, int arg3)
	{
		IBlockState state = arg1.getBlockState(arg2);
		return new java.util.ArrayList(java.util.Arrays.asList(new ItemStack(this, 1, 0)));
	}
	public boolean isOpaqueCube()
    {
        return false;
    }
	@Override
	public EnumType getWoodType(int arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
