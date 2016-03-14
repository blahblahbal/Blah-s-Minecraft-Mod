package blahmod;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public interface MeshDefinitionFix extends ItemMeshDefinition {
	ModelResourceLocation getLocation(ItemStack stack);

	// Helper method to easily create lambda instances of this class
	static ItemMeshDefinition create(MeshDefinitionFix lambda) {
		return lambda;
	}

	default ModelResourceLocation getModelLocation(ItemStack stack) {
		return getLocation(stack);
	}
}
