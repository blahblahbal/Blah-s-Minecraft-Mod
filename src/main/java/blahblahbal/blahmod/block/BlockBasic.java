package blahblahbal.blahmod.block;

import javax.annotation.Nonnull;

import blahblahbal.blahmod.BlahMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBasic extends Block
{
	public BlockBasic(Material material, String unlocalizedName, String registryName)
	{
		this(material, SoundType.STONE, unlocalizedName, registryName);
	}
	public BlockBasic(Material material, SoundType sound, String unlocalizedName, String registryName)
	{
		super(material);
		setTranslationKey(BlahMod.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(BlahMod.TabBlah);
		setSoundType(sound);
	}
}