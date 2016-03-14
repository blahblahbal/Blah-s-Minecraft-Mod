package blahmod.network;

import blahmod.client.gui.GuiCatalyzer;
import blahmod.guicontainer.ContainerCatalyzer;
import blahmod.guicontainer.ContainerReinforcedChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {

	public static final int MOD_TILE_ENTITY_GUI = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == MOD_TILE_ENTITY_GUI)
			return new ContainerCatalyzer(player.inventory, world, new BlockPos(x, y, z));

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == MOD_TILE_ENTITY_GUI)
			return new GuiCatalyzer(player.inventory, world, new BlockPos(x, y, z));

		return null;
	}

}
