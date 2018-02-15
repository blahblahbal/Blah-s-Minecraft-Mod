package blahblahbal.blahmod.items;

import java.util.List;

import blahblahbal.blahmod.Config;
import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ItemNetherCoreKey extends Item
{
	public ItemNetherCoreKey(String unlocalizedName)
	{
		super();
		maxStackSize = 1;
		setUnlocalizedName(unlocalizedName);
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack)
	{
		return EnumChatFormatting.DARK_RED + super.getItemStackDisplayName(par1ItemStack);
	}

	/*@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer entityplayer, List<String> list, boolean is){
		list.add(StatCollector.translateToLocal("tooltip.portalplacer.1"));
		list.add(StatCollector.translateToLocal("tooltip.portalplacer.2"));
		if(key > 0)
			list.add(StatCollector.translateToLocal("tooltip.portalplacer.3"));
		if(!isCorrectDim(Minecraft.getMinecraft().theWorld.provider.getDimensionId()))
			list.add(EnumChatFormatting.DARK_RED+""+EnumChatFormatting.ITALIC+StatCollector.translateToLocal("tooltip.portalplacer.4"));
	}*/

	private boolean isCorrectDim(int dim)
	{
		return (dim == -1 || dim == Config.netherCoreID);
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!world.isRemote)
		{
			if(isCorrectDim(player.dimension))
			{
				int direction = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
				
					return buildPortal(world, pos, direction, ModBlocks.netherIce.getDefaultState(), ModBlocks.iceFire.getDefaultState());
			}
		}
		else if(!isCorrectDim(player.dimension))
		{
			FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("You are not in the correct dimension."));
			return false;
		}
		return false;
	}

	private boolean buildPortal(World world, BlockPos pos, int direction, IBlockState frame, IBlockState fire){
		if(direction == 1 || direction == 3)
		{
			for(int y = 1; y < 5; y++)
				for (int z = -1; z < 2; z++)
					if(!world.isAirBlock(pos.add(0, y, z)))
						return false;

			world.setBlockState(pos.add(0, 1, 0), frame);
			world.setBlockState(pos.add(0, 1, 1), frame);
			world.setBlockState(pos.add(0, 1, 2), frame);
			world.setBlockState(pos.add(0, 1, -1), frame);

			world.setBlockState(pos.add(0, 2, -1), frame);
			world.setBlockState(pos.add(0, 3, -1), frame);
			world.setBlockState(pos.add(0, 4, -1), frame);
			world.setBlockState(pos.add(0, 5, -1), frame);

			world.setBlockState(pos.add(0, 2, 2), frame);
			world.setBlockState(pos.add(0, 3, 2), frame);
			world.setBlockState(pos.add(0, 4, 2), frame);
			world.setBlockState(pos.add(0, 5, 2), frame);

			world.setBlockState(pos.add(0, 5, 0), frame);
			world.setBlockState(pos.add(0, 5, 1), frame);

			world.setBlockState(pos.add(0, 2, 1), fire);

			return true;
		}
		else
		{
			for(int y = 1; y < 5; y++)
				for (int x = -1; x < 2; x++)
					if(!world.isAirBlock(pos.add(x, y, 0)))
						return false;

			world.setBlockState(pos.add(0, 1, 0), frame);
			world.setBlockState(pos.add(1, 1, 0), frame);
			world.setBlockState(pos.add(2, 1, 0), frame);
			world.setBlockState(pos.add(-1, 1, 0), frame);

			world.setBlockState(pos.add(-1, 2, 0), frame);
			world.setBlockState(pos.add(-1, 3, 0), frame);
			world.setBlockState(pos.add(-1, 4, 0), frame);
			world.setBlockState(pos.add(-1, 5, 0), frame);

			world.setBlockState(pos.add(2, 2, 0), frame);
			world.setBlockState(pos.add(2, 3, 0), frame);
			world.setBlockState(pos.add(2, 4, 0), frame);
			world.setBlockState(pos.add(2, 5, 0), frame);

			world.setBlockState(pos.add(0, 5, 0), frame);
			world.setBlockState(pos.add(1, 5, 0), frame);

			world.setBlockState(pos.add(1, 2, 0), fire);

			return true;
		}
	}
}
