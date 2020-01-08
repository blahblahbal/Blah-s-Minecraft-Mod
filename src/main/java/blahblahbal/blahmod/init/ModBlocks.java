package blahblahbal.blahmod.init;

import blahblahbal.blahmod.block.BlockBasic;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	public static Block blazeBrick = new BlockBasic(Material.ROCK, SoundType.STONE, "blaze_brick", "blaze_brick").setLightLevel(1f);
	public static Block hardenedLava = new BlockBasic(Material.ROCK, SoundType.STONE, "hardened_lava", "hardened_lava");
	
	
}
