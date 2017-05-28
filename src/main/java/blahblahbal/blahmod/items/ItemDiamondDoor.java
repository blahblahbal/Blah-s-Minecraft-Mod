package blahblahbal.blahmod.items;

import blahblahbal.blahmod.blocks.BlockDiamondDoor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemDiamondDoor extends ItemDoor
{
	public ItemDiamondDoor(BlockDiamondDoor block)
	{
		super(block);
		block.setDoorItem(this);
	}
}
