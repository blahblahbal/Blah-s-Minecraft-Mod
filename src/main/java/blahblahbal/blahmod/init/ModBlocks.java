package blahblahbal.blahmod.init;

import blahblahbal.blahmod.block.BlockBasic;
import blahblahbal.blahmod.block.ModBlockCatalyzer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	public static final Block blazeBrick = new BlockBasic(Material.ROCK, SoundType.STONE, "blaze_brick", "blaze_brick").setLightLevel(1f);
	public static final Block hardenedLava = new BlockBasic(Material.ROCK, SoundType.STONE, "hardened_lava", "hardened_lava");
	public static final Block sulphurBlock = new BlockBasic(Material.ROCK, SoundType.STONE, "sulphur_block", "sulphur_block");
	public static final Block flintBlock = new BlockBasic(Material.IRON, SoundType.METAL, "flint_block", "flint_block");
	public static final Block blackSand = new BlockBasic(Material.SAND, SoundType.SAND, "black_sand", "black_sand");
	public static final Block petrifiedWood = new BlockBasic(Material.SAND, SoundType.SAND, "petrified_wood", "petrified_wood");
	public static final Block compressedObsidian = new BlockBasic(Material.ROCK, SoundType.STONE, "compressed_obsidian", "compressed_obsidian");
	public static final Block lumiteBlock = new BlockBasic(Material.IRON, SoundType.METAL, "lumite_block", "lumite_block");
	public static final Block catalyzer = new ModBlockCatalyzer("catalyzer");
}
