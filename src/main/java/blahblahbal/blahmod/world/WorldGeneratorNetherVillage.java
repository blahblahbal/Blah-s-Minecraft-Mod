package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneratorNetherVillage implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		// these are important!
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		// generate differently based on dimension
		switch (world.provider.getDimensionId())
		{
		case -1: generateNether(world, random, blockX, blockZ);
		break;
		case 0: generateOverworld(world, random, blockX, blockZ);
		break;
		case 1: generateEnd(world, random, blockX, blockZ);
		break;
		case 255: generateCore(world, random, blockX, blockZ);
		break;
		}

	}

	private void generateOverworld(World world, Random rand, int blockX, int blockZ)
	{
		/** CABIN GEN **/
		WorldGenerator genCabin = new StructureIceShrine();
		// 25% of chunks can have a cabin
		final int CABIN_CHANCE = 2;
		if (rand.nextInt(550) < CABIN_CHANCE)
		{
			// get a random position in the chunk
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			// use our custom function to get the ground height
			genCabin.generate(world, rand, new BlockPos(randX, rand.nextInt(15) + 25, randZ));
		}
		/** END CABIN GEN **/		
	}

	private void generateNether(World world, Random rand, int blockX, int blockZ)
	{
		/** CABIN GEN **/
		WorldGenerator genCabin = new StructureNetherVillageHouse1();
		// 25% of chunks can have a cabin
		final int CABIN_CHANCE = 2;
		if (rand.nextInt(300) < CABIN_CHANCE)
		{
			// get a random position in the chunk
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			// use our custom function to get the ground height
			int groundY = getGroundFromAbove(world, randX, randZ, Blocks.netherrack.getDefaultState());
			genCabin.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
		}
		/** END CABIN GEN **/
	}

	private void generateEnd(World world, Random rand, int blockX, int blockZ) 
	{
		// leaving blank for now
	}
	private void generateCore(World world, Random rand, int blockX, int blockZ)
	{
		/** CABIN GEN **/
		WorldGenerator genCabin = new WorldGenFrostTree(false);
		WorldGenerator genIgloo = new StructureNetherCoreIglooDungeon();
		// 25% of chunks can have a cabin
		final int CABIN_CHANCE = 10;
		if (rand.nextInt(30) < CABIN_CHANCE)
		{
			// get a random position in the chunk
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			// use our custom function to get the ground height
			int groundY = getGroundFromAbove(world, randX, randZ, ModBlocks.netherFrost.getDefaultState());
			genCabin.generate(world, rand, new BlockPos(randX, groundY, randZ));
		}
		/** END CABIN GEN **/
		if (rand.nextInt(300) < 5)
		{
			// get a random position in the chunk
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			// use our custom function to get the ground height
			int groundY = rand.nextInt(10) + 35;
			genIgloo.generate(world, rand, new BlockPos(randX, groundY, randZ));
		}
	}

	/** HELPER METHODS **/

	// find a grass or dirt block to place the bush on
	public static int getGroundFromAbove(World world, int x, int z, IBlockState b)
	{
		int y = 100;
		boolean foundGround = false;
		while (!foundGround && y-- >= 0)
		{
			Block blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			Block blockAt2 = world.getBlockState(new BlockPos(x, y, z + 7)).getBlock();
			Block blockAt3 = world.getBlockState(new BlockPos(x + 6, y, z)).getBlock();
			Block blockAt4 = world.getBlockState(new BlockPos(x + 6, y, z + 7)).getBlock();
			Block blockAtIsAir = world.getBlockState(new BlockPos(x, y + 1, z)).getBlock();
			// "ground" for our bush is grass or dirt
			foundGround = blockAt == b.getBlock() &&
					blockAt2 == b.getBlock() &&
					blockAt3 == b.getBlock() &&
					blockAt4 == b.getBlock() &&
					blockAtIsAir == Blocks.air;
		}

		return y;
	}
}