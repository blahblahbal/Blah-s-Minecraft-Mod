package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.entity.EntityEskimoZombie;
import blahblahbal.blahmod.entity.EntityIceCube;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenNetherCore extends BiomeGenBase
{
	private static final WorldGenFrostTree tree = new WorldGenFrostTree(false);
    public BiomeGenNetherCore(int p_i1981_1_)
    {
        super(p_i1981_1_);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityGhast.class, 50, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityIceCube.class, 50, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEskimoZombie.class, 100, 4, 4));
    }
    
    public WorldGenAbstractTree genBigTreeChance(Random rand)
    {
        return (WorldGenAbstractTree)tree;
    }
    @Override
	public int getFoliageColorAtPos(BlockPos pos)
	{
		return 0x8FFF00;
	}
}