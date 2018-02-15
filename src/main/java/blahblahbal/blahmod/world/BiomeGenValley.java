package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenValley extends BiomeGenBase
{
	private static final WorldGenDreadTree tree = new WorldGenDreadTree(false);
	public BiomeGenValley(int id)
	{
		super(id);
		this.waterColorMultiplier = 0x000000;
		this.theBiomeDecorator.treesPerChunk = 4;
        this.theBiomeDecorator.deadBushPerChunk = 10;
        this.spawnableCreatureList.clear();
        this.topBlock = ModBlocks.dreadSand.getDefaultState();
        this.fillerBlock = ModBlocks.dreadRock.getDefaultState();
        this.maxHeight = 0.125F;
		this.minHeight = 0.05F;
	}
	@Override
	public int getFoliageColorAtPos(BlockPos pos)
	{
		return 0xE8CEAB;
	}
	@Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 0xE8CEAB;
    }
	public WorldGenAbstractTree genBigTreeChance(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(3) > 0 ? tree : this.worldGeneratorBigTree);
    }
}
