package blahmod.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockOre extends BlockOre {

	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	public String name;
	
    public ModBlockOre(String unlocalizedName, Material mat, Item drop, float hard, float res, String tool, int level, int meta, int least_quantity, int most_quantity, String name)
    {
        super(mat.getMaterialMapColor());
        this.drop = drop;
        this.meta = meta;
        this.least_quantity = least_quantity;
        this.most_quantity = most_quantity;
        this.setHarvestLevel(tool, level);
        this.setHardness(hard);
        this.setResistance(res);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.name = unlocalizedName;
    }
    
    @Override
    public Item getItemDropped(IBlockState blockstate, Random random, int fortune)
    {
        return this.drop;
    }

    @Override
    public int damageDropped(IBlockState blockstate)
    {
        return this.meta;
    }

    @Override
    public int quantityDropped(IBlockState blockstate, int fortune, Random random)
    {
        if (this.least_quantity >= this.most_quantity)
            return this.least_quantity;
        return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
    }
    
    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
    	IBlockState state = world.getBlockState(pos);
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        
        if (this == ModBlocks.tadaniteOre)
        {
        	return MathHelper.getRandomIntegerInRange(rand, 10, 15);
        }
        if (this == ModBlocks.limestoneOre)
        {
        	return MathHelper.getRandomIntegerInRange(rand, 1, 5);
        }
        if (this == ModBlocks.sulphurOre)
        {
        	return MathHelper.getRandomIntegerInRange(rand, 15, 17);
        }
        if (this == ModBlocks.rubyOre ||
        	this == ModBlocks.citrineOre ||
        	this == ModBlocks.topazOre ||
        	this == ModBlocks.sapphireOre ||
        	this == ModBlocks.amethystOre)
        {
        	return MathHelper.getRandomIntegerInRange(rand, 3, 7);
        }
        return 0;
    }
}