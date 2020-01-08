package blahblahbal.blahmod;

import blahblahbal.blahmod.guicontainer.GuiCatalyzer;
//import blahblahbal.blahmod.client.gui.GuiInventoryFurnace;
import blahblahbal.blahmod.guicontainer.ContainerCatalyzer;
//import blahblahbal.blahmod.guicontainer.ContainerInventoryFurnace;
//import blahblahbal.blahmod.guicontainer.ContainerReinforcedChest;
//import blahblahbal.blahmod.guicontainer.TileInventoryFurnace;
import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.inventory.InventoryLargeChest;
//import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler
{
	public static final int CATALYZER = 0;
	//public static final int SMELTERY = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == CATALYZER)
			return new ContainerCatalyzer(player.inventory, world, new BlockPos(x, y, z));
//		if (ID == SMELTERY)
//		{
//			BlockPos xyz = new BlockPos(x, y, z);
//			TileEntity tileEntity = world.getTileEntity(xyz);
//			if (tileEntity instanceof TileInventoryFurnace)
//			{
//				TileInventoryFurnace tileInventoryFurnace = (TileInventoryFurnace) tileEntity;
//				return new ContainerInventoryFurnace(player.inventory, tileInventoryFurnace);
//			}
//		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == CATALYZER)
			return new GuiCatalyzer(player.inventory, world, new BlockPos(x, y, z));
//		if (ID == SMELTERY)
//		{
//			BlockPos xyz = new BlockPos(x, y, z);
//			TileEntity tileEntity = world.getTileEntity(xyz);
//			if (tileEntity instanceof TileInventoryFurnace)
//			{
//				TileInventoryFurnace tileInventoryFurnace = (TileInventoryFurnace) tileEntity;
//				return new GuiInventoryFurnace(player.inventory, tileInventoryFurnace);
//			}
//		}

		return null;
	}

}