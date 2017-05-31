package blahblahbal.blahmod.world;

import java.util.Random;

import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenCedarGrove extends BiomeGenBase
{
	private static final WorldGenCedarTree tree = new WorldGenCedarTree(false);
	public BiomeGenCedarGrove(int i)
	{
		super(i);
		this.waterColorMultiplier = 0xFFD500;
		this.theBiomeDecorator.treesPerChunk = 4;
        this.theBiomeDecorator.deadBushPerChunk = 2;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getFoliageColorAtPos(BlockPos pos)
	{
		return 0x005900;
	}
	@Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 0x005900; //0xE8CEAB;
    }
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int p_180622_4_, int p_180622_5_, double p_180622_6_)
    {
        this.topBlock = Blocks.grass.getDefaultState();
        this.fillerBlock = Blocks.dirt.getDefaultState();

        if (p_180622_6_ > 1.75D)
        {
            this.topBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        }
        else if (p_180622_6_ > -0.95D)
        {
            this.topBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
        }
        

        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, p_180622_4_, p_180622_5_, p_180622_6_);
    }
	public WorldGenAbstractTree genBigTreeChance(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(3) > 0 ? tree : this.worldGeneratorBigTree);
    }
}
