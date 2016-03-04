package blahmod.blocks;

import blahmod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static Block tadanite;
    public static Block leatherBlock;
    public static Block tadaniteOre;
    public static Block limestoneOre;
    public static Block limestoneBlock;
    public static Block cement;
    public static Block sulphurOre;
    public static Block sulphurBlock;
    
    public static void createBlocks()
    {
    	GameRegistry.registerBlock((Block)(tadanite = new BasicBlock("tadanite", Material.rock, 40F, 2000F, "pickaxe", 4, "tadanite")), "tadanite");
    	GameRegistry.registerBlock(tadaniteOre = new ModBlockOre("tadaniteOre", Material.rock, ModItems.tadaniteShard, 40F, 2000F, "pickaxe", 4, 0, 1, 3, "tadaniteOre"), "tadaniteOre");
    	GameRegistry.registerBlock((Block)(leatherBlock = new BasicBlock("leatherBlock", Material.cake, 0.5F, 50F, "axe", 0, "leatherBlock")).setStepSound(Block.soundTypeCloth), "leatherBlock");
    	GameRegistry.registerBlock((Block)(limestoneBlock = new BasicBlock("limestoneBlock", Material.iron, 7F, 100F, "pickaxe", 1, "limestoneBlock")).setStepSound(Block.soundTypeMetal), "limestoneBlock");
    	GameRegistry.registerBlock((Block)(sulphurBlock = new BasicBlock("sulphurBlock", Material.iron, 8F, 200F, "pickaxe", 1, "sulphurBlock")).setStepSound(Block.soundTypeMetal), "sulphurBlock");
    	GameRegistry.registerBlock(limestoneOre = new ModBlockOre("limestoneOre", Material.rock, ModItems.limestone, 3.5F, 100F, "pickaxe", 1, 0, 1, 2, "limestoneOre"), "limestoneOre");
    	GameRegistry.registerBlock(sulphurOre = new ModBlockOre("sulphurOre", Material.rock, ModItems.sulphur2, 3F, 200F, "pickaxe", 2, 0, 1, 2, "sulphurOre"), "sulphurOre");
    	GameRegistry.registerBlock((Block)(cement = new BasicBlock("cement", Material.rock, 5F, 150F, "pickaxe", 1, "cement")), "cement");
    }
}