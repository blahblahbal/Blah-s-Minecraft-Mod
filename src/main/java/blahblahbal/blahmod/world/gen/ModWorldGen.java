package blahblahbal.blahmod.world.gen;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator
{

	public WorldGenerator gen_tadanite_ore;
	Random rand = new Random();
	int[] dimensions;
	Block what;
	Predicate<IBlockState> where;
	int maxY;
	int minY;
	int vpc;
	int opv;
	
	public ModWorldGen(Block block, Block block2, int[] dimensions, int maxY, int minY, int vpc, int opv)
	{
	      this.dimensions = dimensions;
	      this.what = block;
	      this.where = BlockMatcher.forBlock(block2);
	      this.maxY = maxY;
	      this.minY = minY;
	      this.vpc = vpc;
	      this.opv = opv;
	}
	
	public void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight)
	{
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++)
	    {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		for (int i = 0; i < dimensions.length; i++)
		{
	         int dimID = dimensions[0];
	         if (world.provider.getDimension() == dimID)
	         {
	            for (int j = 0; j < this.vpc; j++)
	            {
	               int X = chunkX * 16 + random.nextInt(16);
	               int Y = this.minY + random.nextInt(this.maxY - this.minY + 1);
	               int Z = chunkZ * 16 + random.nextInt(16);
	               (new WorldGenMinable(this.what.getDefaultState(), this.opv, this.where)).generate(world, rand, new BlockPos(X, Y, Z));
	            }
	         }
		}
	}
}