package blahmod.container;

import blahmod.GuiHandlerRegistry;
import blahmod.Main;
import blahmod.blocks.BasicBlock;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon
{
	public static BlockInventoryCatalyst blockInventoryAdvanced;  // this holds the unique instance of your block

	public static void preInitCommon()
	{
		// each instance of your block should have a name that is unique within your mod.  use lower case.
		blockInventoryAdvanced = new BlockInventoryCatalyst("catalyst");
		GameRegistry.registerBlock(blockInventoryAdvanced, "catalyst");
		// Each of your tile entities needs to be registered with a name that is unique to your mod.
		GameRegistry.registerTileEntity(TileInventoryCatalyst.class, "catalyst");
		// you don't need to register an item corresponding to the block, GameRegistry.registerBlock does this automatically.
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block)blockInventoryAdvanced), 0, new ModelResourceLocation(Main.MODID.toLowerCase() + ":" + blockInventoryAdvanced.name, "inventory"));
		// You need to register a GUIHandler for the container.  However there can be only one handler per mod, so for the purposes
		//   of this project, we create a single GuiHandlerRegistry for all examples.
		// We register this GuiHandlerRegistry with the NetworkRegistry, and then tell the GuiHandlerRegistry about
		//   each example's GuiHandler, in this case GuiHandlerMBE31, so that when it gets a request from NetworkRegistry,
		//   it passes the request on to the correct example's GuiHandler.
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerCatalyst(), GuiHandlerCatalyst.getGuiID());
	}

	public static void initCommon()
	{
	}

	public static void postInitCommon()
	{
	}
}