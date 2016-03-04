package blahmod.container;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupClientOnly
{
	public static void preInitClientOnly()
	{
    // This is currently necessary in order to make your block render properly when it is an item (i.e. in the inventory
    //   or in your hand or thrown on the ground).
    // Minecraft knows to look for the item model based on the GameRegistry.registerBlock.  However the registration of
    //  the model for each item is normally done by RenderItem.registerItems(), and this is not currently aware
    //   of any extra items you have created.  Hence you have to do it manually.
    // It must be done on client only, and must be done after the block has been created in Common.preinit().
    Item itemBlockSimple = GameRegistry.findItem("blahmod", "catalyst");
    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("blahmod:catalyst", "inventory");
    ModelLoader.setCustomModelResourceLocation(itemBlockSimple, 0, itemModelResourceLocation);	}

	public static void initClientOnly()
	{

	}

	public static void postInitClientOnly()
	{
	}
}