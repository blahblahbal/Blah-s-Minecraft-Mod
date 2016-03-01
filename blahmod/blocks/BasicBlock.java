package blahmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {

	public String name = "";
	
    public BasicBlock(String unlocalizedName, Material material, float hardness, float resistance, String tool, int level, String name) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.name = unlocalizedName;
    }

    public BasicBlock(String unlocalizedName, float hardness, float resistance, String tool, int level, String name)
    {
        this(unlocalizedName, Material.rock, hardness, resistance, tool, level, name);
    }
    
    //public BasicBlock(String unlocalizedName, float hardness, float resistance) {
    //    this(unlocalizedName, Material.rock, hardness, resistance);
    //}

    //public BasicBlock(String unlocalizedName) {
    //    this(unlocalizedName, 2.0f, 10.0f);
    //}
}