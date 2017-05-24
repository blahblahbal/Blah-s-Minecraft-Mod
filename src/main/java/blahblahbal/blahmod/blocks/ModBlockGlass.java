package blahblahbal.blahmod.blocks;

import blahblahbal.blahmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockGlass extends BlockGlass
{
	public String name = "";
	
    public ModBlockGlass(String unlocalizedName, Material material, float hardness, float resistance, String tool, int level, String name)
    {
        super(material, false);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.blahTabBlock);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.name = unlocalizedName;
    }
    public ModBlockGlass(String unlocalizedName, float hardness, float resistance, String tool, int level, String name)
    {
        this(unlocalizedName, Material.rock, hardness, resistance, tool, level, name);
    }
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return Blocks.glass.getBlockLayer();
    }
}