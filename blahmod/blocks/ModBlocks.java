package blahmod.blocks;

import blahmod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static Block tadanite;
    public static Block leatherBlock;
    public static Block tadaniteOre;
    
    public static void createBlocks()
    {
    	GameRegistry.registerBlock((Block)(tadanite = new BasicBlock("tadanite", Material.rock, 40F, 2000F, "pickaxe", 4, "tadanite")), "tadanite");
    	GameRegistry.registerBlock(tadaniteOre = new ModBlockOre("tadaniteOre", Material.rock, ModItems.tadaniteShard, 40F, 2000F, "pickaxe", 4, 0, 1, 3, "tadaniteOre"), "tadaniteOre");
    	GameRegistry.registerBlock((Block)(leatherBlock = new BasicBlock("leatherBlock", Material.cake, 0.5F, 50F, "axe", 0, "leatherBlock")).setStepSound(Block.soundTypeCloth), "leatherBlock");
    }
}