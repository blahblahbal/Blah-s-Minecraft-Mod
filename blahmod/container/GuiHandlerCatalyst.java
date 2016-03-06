package blahmod.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerCatalyst implements IGuiHandler {
	private static final int GUIID_CATALYST = 31;
	public static int getGuiID() {return GUIID_CATALYST;}

	// Gets the server side element for the given gui id this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		/*TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileInventoryCatalyst) {
			TileInventoryCatalyst tileInventoryFurnace = (TileInventoryCatalyst) tileEntity;
			return new ContainerCatalyst(player.inventory, world, xyz); //, tileInventoryFurnace);
		}
		return null;*/
		return new ContainerCatalyst(player.inventory, world, xyz);
	}

	// Gets the client side element for the given gui id this should return a gui
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		/*TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileInventoryCatalyst) {
			TileInventoryCatalyst tileInventoryFurnace = (TileInventoryCatalyst) tileEntity;
			return new GuiInventoryCatalyst(player.inventory, world, xyz); //, tileInventoryFurnace);
		}*/
		return new GuiInventoryCatalyst(player.inventory, world, xyz);
		//return null;
	}

}