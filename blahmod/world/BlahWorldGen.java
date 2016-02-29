package blahmod.world;

import java.util.Random;

import blahmod.blocks.ModBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BlahWorldGen implements IWorldGenerator {

	private WorldGenerator gen_tadanite_ore;

	public BlahWorldGen() {
	    this.gen_tadanite_ore = new WorldGenMinable(ModBlocks.tadaniteOre.getDefaultState(), 12);
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
	
	@Override
	public void generate(Random arg0, int arg1, int arg2, World arg3, IChunkProvider arg4, IChunkProvider arg5) {
		switch (arg3.provider.getDimensionId()) {
	    case 0: 
	        break;
	    case -1: //Nether
	    	this.runGenerator(this.gen_tadanite_ore, arg3, arg0, arg1, arg2, 25, 35, 80);
	        break;
	    case 1: //End

	        break;
	    }
		
	}
}