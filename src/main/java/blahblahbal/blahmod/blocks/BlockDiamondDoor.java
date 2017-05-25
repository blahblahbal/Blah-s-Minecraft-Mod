package blahblahbal.blahmod.blocks;

import java.util.Random;

import blahblahbal.blahmod.items.ModItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDiamondDoor extends BlockDoor
{
	private Item doorItem;
    public BlockDiamondDoor(Material material)
    {
		super(material);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 0);
		this.setUnlocalizedName("diamondDoor");
	}
    public void setDoorItem(Item doorItem)
    {
        this.doorItem = doorItem;
    }

    public Item getDoorItem()
    {
        return doorItem;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return this.getDoorItem();
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : this.getDoorItem();
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
        IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

        if (iblockstate.getBlock() != this)
        {
            return false;
        }
        else
        {
            state = iblockstate.cycleProperty(OPEN);
            worldIn.setBlockState(blockpos, state, 2);
            worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
            worldIn.playAuxSFXAtEntity(playerIn, ((Boolean)state.getValue(OPEN)).booleanValue() ? 1003 : 1006, pos, 0);
            return true;
        }
    }
}
