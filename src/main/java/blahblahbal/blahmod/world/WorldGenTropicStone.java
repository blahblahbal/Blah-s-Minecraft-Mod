package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenTropicStone implements IWorldGenerator
{
    private Block b;
    /** The number of blocks to generate. */
    private int numberOfBlocks;

    public WorldGenTropicStone(int num, Block block)
    {
        this.numberOfBlocks = num;
        this.b = block;
    }

    public boolean generateSurface(World worldIn, Random rand, int chunkX, int chunkZ)
    {
    	BlockPos position = new BlockPos(chunkX + 8, rand.nextInt(70-35) + 35, chunkZ + 8);
    	String s = worldIn.getBiomeGenForCoords(position).biomeName;
    	if (s.contains("Tropics"))
    	{
	        int i = rand.nextInt(this.numberOfBlocks - rand.nextInt(8) + 8) + rand.nextInt(8) + 4;
	        int j = 10;
	
	        for (int k = position.getX() - i; k <= position.getX() + i; ++k)
	        {
	            for (int l = position.getZ() - i; l <= position.getZ() + i; ++l)
	            {
	                int i1 = k - position.getX();
	                int j1 = l - position.getZ();
	
	                if (i1 * i1 + j1 * j1 <= i * i)
	                {
	                    for (int k1 = position.getY() - j; k1 <= position.getY() + j; ++k1)
	                    {
	                        BlockPos blockpos = new BlockPos(k, k1, l);
	                        Block block = worldIn.getBlockState(blockpos).getBlock();
	
	                        if (block == Blocks.stone)
	                        {
	                            worldIn.setBlockState(blockpos, this.b.getDefaultState(), 2);
	                        }
	                    }
	                }
	            }
	        }
	        return true;
	    }
    	return false;
    }

	@Override
	public void generate(Random rand, int arg1, int arg2, World arg3, IChunkProvider arg4, IChunkProvider arg5)
	{
		if (arg3.provider.getDimensionId() == 0)
			this.generateSurface(arg3, rand, arg1 << 4, arg2 << 4);
	}
}