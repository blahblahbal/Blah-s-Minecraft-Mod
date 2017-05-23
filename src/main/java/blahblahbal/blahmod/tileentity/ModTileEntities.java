package main.java.blahblahbal.blahmod.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(ModTileEntity.class, "catalyzer");
	}

}