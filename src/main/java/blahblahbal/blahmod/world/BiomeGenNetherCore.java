package blahblahbal.blahmod.world;

import blahblahbal.blahmod.entity.EntityEskimoZombie;
import blahblahbal.blahmod.entity.EntityIceCube;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenNetherCore extends BiomeGenBase
{
    public BiomeGenNetherCore(int p_i1981_1_)
    {
        super(p_i1981_1_);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityGhast.class, 50, 4, 4));
        //this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityIceCube.class, 50, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
    }
}