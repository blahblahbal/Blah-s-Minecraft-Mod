package blahmod.world;

import java.util.Random;

import com.google.common.base.Predicate;

import blahmod.blocks.ModBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BlahWorldGen implements IWorldGenerator
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
	
	public BlahWorldGen(Block block, Block block2, int[] dimensions, int maxY, int minY, int vpc, int opv)
	{
	      this.dimensions = dimensions;
	      this.what = block;
	      this.where = BlockHelper.forBlock(block2);
	      this.maxY = maxY;
	      this.minY = minY;
	      this.vpc = vpc;
	      this.opv = opv;
	}
	
	/*public BlahWorldGen()
	{
	    this.gen_tadanite_ore = new WorldGenMinable(ModBlocks.tadaniteOre.getDefaultState(), 12, (Predicate<IBlockState>)Blocks.netherrack);
	}*/
	
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
	public void generate(Random arg0, int arg1, int arg2, World arg3, IChunkProvider arg4, IChunkProvider arg5)
	{
		for (int i = 0; i < dimensions.length; i++)
		{
	         int dimID = dimensions[0];
	         if (arg3.provider.getDimensionId() == dimID)
	         {
	            for (int j = 0; j < this.vpc; j++)
	            {
	               int X = arg1 * 16 + arg0.nextInt(16);
	               int Y = this.minY + arg0.nextInt(this.maxY - this.minY + 1);
	               int Z = arg2 * 16 + arg0.nextInt(16);
	               (new WorldGenMinable(this.what.getDefaultState(), this.opv, this.where)).generate(arg3, rand, new BlockPos(X, Y, Z));
	            }
	         }
		}
		
	}
}