package blahblahbal.blahmod.blocks;

import java.util.List;
import java.util.Random;

import blahblahbal.blahmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockSideSlab extends Block
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    private static final float HARDNESS = 2.0f;
    private static final float RESISTANCE = 10.0f;
    
    public ModBlockSideSlab(Material m)
    {
        super(m);
        this.useNeighborBrightness = true;
        setHardness(HARDNESS);
        setResistance(RESISTANCE);
        setStepSound(soundTypePiston);
        setUnlocalizedName("sideSlab");
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public final String getUnlocalizedName(final int metadata) {
        return this.getUnlocalizedName();
    }
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
    	IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() == this)
        {
            if (iblockstate.getValue(FACING) == EnumFacing.NORTH)
            {
                this.setBlockBounds(0F, 0F, 0.5F, 1F, 1F, 1F);
            }
            else if (iblockstate.getValue(FACING) == EnumFacing.EAST)
            {
                this.setBlockBounds(0.5F, 0F, 0F, 1F, 1F, 1F);
            }
            else if (iblockstate.getValue(FACING) == EnumFacing.WEST)
            {
                this.setBlockBounds(0F, 0F, 0F, 0.5F, 1F, 1F); 
            }
            else if (iblockstate.getValue(FACING) == EnumFacing.SOUTH)
            {
                this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 0.5F);
            }
        }
    }
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.5F, 0F, 0F, 1F, 1F, 1F);
    }
    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(pos.north()).getBlock();
            Block block1 = worldIn.getBlockState(pos.south()).getBlock();
            Block block2 = worldIn.getBlockState(pos.west()).getBlock();
            Block block3 = worldIn.getBlockState(pos.east()).getBlock();
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
    	boolean flag1 = hitX + hitZ > 1.0F;
        boolean flag2 = hitX > hitZ;
        
        EnumFacing blockFacing = EnumFacing.NORTH;
        if (flag1)
        {
          if (flag2)
          {
            blockFacing = EnumFacing.WEST;
          }
          else {
            blockFacing = EnumFacing.NORTH;
          }
          
        }
        else if (flag2)
        {
          blockFacing = EnumFacing.SOUTH;
        }
        else {
          blockFacing = EnumFacing.EAST;
        }
        return getDefaultState().withProperty(FACING, blockFacing);
    }
    public final IBlockState getStateFromMeta(final int meta)
    {
    	EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
    public int quantityDropped(Random r)
    {
    	return 1;
    }
    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
        this.setBlockBoundsBasedOnState(worldIn, pos);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean isFullCube()
    {
        return false;
    }
    public final int getMetaFromState(final IBlockState state)
    {
    	return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
    public final int damageDropped(final IBlockState state) {
        return 0;
    }
    public final Item getItemDropped(final IBlockState blockState, final java.util.Random random, final int unused)
    {
        return Item.getItemFromBlock(this);
    }
    protected final BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }
}