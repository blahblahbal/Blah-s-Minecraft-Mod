package main.java.blahblahbal.blahmod.world;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BlahWorldGen2 implements IWorldGenerator
{
	
	Random rand = new Random();
	int[] dimensions;
	Block what;
	Predicate<IBlockState> where;
	int maxY;
	int minY;
	int vpc;
	int opv;
	String biomeName;
	
	public BlahWorldGen2(Block block, Block block2, int[] dimensions, int maxY, int minY, int vpc, int opv, String biome)
	{
	      this.dimensions = dimensions;
	      this.what = block;
	      this.where = BlockHelper.forBlock(block2);
	      this.maxY = maxY;
	      this.minY = minY;
	      this.vpc = vpc;
	      this.opv = opv;
	      this.biomeName = biome;
	}
  public void generate(Random arg0, int arg1, int arg2, World arg3, IChunkProvider arg4, IChunkProvider arg5)
  {
	for (int i = 0; i < dimensions.length; i++)
	{
		int dimID = dimensions[0];

		if (arg3.provider.getDimensionId() == dimID)
			this.generateSurface(arg3, arg0, arg1 << 4, arg2 << 4);
	}
  }

  public void generateSurface(World par1World, Random par2Random, int chunkX, int chunkZ)
  {
    String s = par1World.getBiomeGenForCoords(new BlockPos(chunkX + 8, rand.nextInt(maxY-minY) + minY, chunkZ + 8)).biomeName;
    if (s.contains(biomeName))
    {
      int rarity = 2;
      int veinSize = 4;
      int height = 12;
      for (int i = 0; i < rarity; ++i)
      {
   	 int X = chunkX + par2Random.nextInt(16);
   	 int Y = par2Random.nextInt(height);
   	 int Z = chunkZ + par2Random.nextInt(16);
   	 (new WorldGenMinable(this.what.getDefaultState(), this.opv, this.where)).generate(par1World, par2Random, new BlockPos(X, Y, Z));
      }
    }
  }
}
