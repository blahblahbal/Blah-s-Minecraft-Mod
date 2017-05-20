package blahmod.world;

import java.util.Random;

import blahmod.blocks.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenTropics extends BiomeGenBase
{
	private static final WorldGenPalmTree tree = new WorldGenPalmTree(false);
	public BiomeGenTropics(int i)
	{
		super(i);
		this.spawnableCreatureList.clear();
        this.topBlock = ModBlocks.blackSand.getDefaultState();
        this.fillerBlock = ModBlocks.blackSand.getDefaultState();
        
        this.theBiomeDecorator.treesPerChunk = 3;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 5;
        this.theBiomeDecorator.cactiPerChunk = 0;
	}
	public BiomeGenTropics setMinMaxHeight(int min, int max)
	{
		this.maxHeight = max;
		this.minHeight = min;
		return this;
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int varOne, int varTwo, double varThree)
	{
		generateBiomeTerrain2(worldIn, rand, chunkPrimerIn, varOne, varTwo, varThree);
	}
	public void generateBiomeTerrain2(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int p_180628_4_, int p_180628_5_, double p_180628_6_)
    {
        int i = 63;
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int j = -1;
        int k = (int)(p_180628_6_ / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = p_180628_4_ & 15;
        int i1 = p_180628_5_ & 15;

        for (int ypos = 255; ypos >= 0; --ypos)
        {
            if (ypos <= rand.nextInt(5))
            {
                chunkPrimerIn.setBlockState(i1, ypos, l, Blocks.bedrock.getDefaultState());
            }
            else
            {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, ypos, l);

                if (iblockstate2.getBlock().getMaterial() == Material.air)
                {
                    j = -1;
                }
                else if (iblockstate2.getBlock() == Blocks.stone)
                {
                    if (j == -1)
                    {
                    	if (k <= 0)
                    	{
                    		iblockstate = null;
                    		iblockstate1 = ModBlocks.blackSand.getDefaultState();
                    	}
                    	else if (ypos >= i - 4 && ypos <= i + 1)
                    	{
                    		iblockstate = ModBlocks.blackSand.getDefaultState();
                    		iblockstate1 = ModBlocks.blackSand.getDefaultState();
                    	}
                        j = k;
                        if (ypos >= i - 1)
                        {
                            chunkPrimerIn.setBlockState(i1, ypos, l, ModBlocks.blackSand.getDefaultState());
                        }
                        else if (ypos < i - 7 - k)
                        {
                            iblockstate = null;
                            iblockstate1 = Blocks.stone.getDefaultState();
                            chunkPrimerIn.setBlockState(i1, ypos, l, Blocks.gravel.getDefaultState());
                        }
                        else
                        {
                            chunkPrimerIn.setBlockState(i1, ypos, l, iblockstate1);
                        }
                    }
                    else if (j > 0)
                    {
                        --j;
                        chunkPrimerIn.setBlockState(i1, ypos, l, iblockstate1);

                        if (j == 0 && iblockstate1.getBlock() == ModBlocks.blackSand)
                        {
                            j = rand.nextInt(4) + Math.max(0, ypos - 63);
                            iblockstate1 = ModBlocks.blackSandstone.getDefaultState();
                        }
                    }
                }
            }
        }
    }
	public WorldGenAbstractTree genBigTreeChance(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(5) > 0 ? tree : this.worldGeneratorTrees);
    }
	
}
