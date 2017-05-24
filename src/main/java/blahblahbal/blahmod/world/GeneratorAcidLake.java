package blahblahbal.blahmod.world;

import java.util.Random;

import blahblahbal.blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GeneratorAcidLake implements IWorldGenerator
{
    protected IBlockState liquid;
    protected IBlockState lineWith;
    protected float vpc;
	int[] dimensions;

    public GeneratorAcidLake(float amountPerChunk, IBlockState liquid, IBlockState lineWith)
    {
    	this.vpc = amountPerChunk;
        this.liquid = liquid;
        this.lineWith = lineWith;
        this.dimensions = new int[] { 0 };
    }
    
    public BlockPos getScatterY(World world, Random random, int x, int z)
    {
        // always below ground
        return ScatterYMethod.BELOW_GROUND.getBlockPos(world, random, x, z);
    }
    
    public boolean[] getCavityShape(Random rand)
    {
        boolean[] cavityShape = new boolean[2048];
        int numPasses = rand.nextInt(4) + 4;
        int pass;
        
        for (pass = 0; pass < numPasses; ++pass)
        {
            double scaleX = rand.nextDouble() * 6.0D + 3.0D; // between 3 and 9
            double scaleY = rand.nextDouble() * 4.0D + 2.0D; // between 2 and 6
            double scaleZ = rand.nextDouble() * 6.0D + 3.0D; // between 3 and 9
            
            double pointX = rand.nextDouble() * (16.0D - scaleX - 2.0D) + 1.0D + scaleX / 2.0D; // between 2.5 and 13.5
            double pointY = rand.nextDouble() * (8.0D - scaleY - 4.0D) + 2.0D + scaleY / 2.0D; // between 3 and 5
            double pointZ = rand.nextDouble() * (16.0D - scaleZ - 2.0D) + 1.0D + scaleZ / 2.0D; // between 2.5 and 13.5

            for (int x = 1; x < 15; ++x)
            {
                for (int z = 1; z < 15; ++z)
                {
                    for (int y = 1; y < 7; ++y)
                    {
                        double dx = ((double)x - pointX) / (scaleX / 2.0D);
                        double dy = ((double)y - pointY) / (scaleY / 2.0D);
                        double dz = ((double)z - pointZ) / (scaleZ / 2.0D);
                        
                        double r = dx * dx + dy * dy + dz * dz;

                        if (r < 1.0D)
                        {
                            cavityShape[(x * 16 + z) * 8 + y] = true;
                        }
                    }
                }
            }
        }
        
        return cavityShape;
    }
    
    public boolean isCavityEdge(int x, int y, int z, boolean[] cavityShape)
    {
        if (cavityShape[(x * 16 + z) * 8 + y]) {return false;}
        return x < 15 && cavityShape[((x + 1) * 16 + z) * 8 + y] || x > 0 && cavityShape[((x - 1) * 16 + z) * 8 + y] || z < 15 && cavityShape[(x * 16 + z + 1) * 8 + y] || z > 0 && cavityShape[(x * 16 + (z - 1)) * 8 + y] || y < 7 && cavityShape[(x * 16 + z) * 8 + y + 1] || y > 0 && cavityShape[(x * 16 + z) * 8 + (y - 1)];
    }
    
    public boolean isCavityViable(World world, BlockPos startPos, boolean[] cavityShape)
    {        
        for (int x = 0; x < 16; ++x)
        {
            for (int z = 0; z < 16; ++z)
            {
                for (int y = 0; y < 8; ++y)
                {
                    if (this.isCavityEdge(x, y, z, cavityShape)) {

                        Material material = world.getBlockState(startPos.add(x, y, z)).getBlock().getMaterial();

                        // abandon if there's liquid at the edge of the cavity above the water level
                        if (y >= 4 && material.isLiquid())
                        {
                            return false;
                        }

                        // abandon if there's a different liquid at the edge of the cavity below the water level
                        if (y < 4 && !material.isSolid() && world.getBlockState(startPos.add(x, y, z)).getBlock() != this.liquid)
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }   

    // get a random number between 2 values (inclusive of end points)
    public static int nextIntBetween(Random rand, int a, int b)
    {
        if (a == b) {return a;}
        int min = a < b ? a : b;
        int max = a > b ? a : b;
        return min + rand.nextInt(1 + max - min);
    }
    
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        // move to start of square
        pos = pos.add(-8, 0, -8);
        
        // move downwards to the first non-air block
        while (pos.getY() > 5 && world.isAirBlock(pos))
        {
            pos = pos.down();
        }

        // abandon if there isn't 4 blocks beneath pos
        if (pos.getY() <= 4)
        {
            return false;
        }

        // move down 4 blocks (to bottom of lake-to-be)
        pos = pos.down(4);

        // create a random cavity
        boolean[] cavityShape = this.getCavityShape(rand);
        
        // check it's viable
        if (!this.isCavityViable(world, pos, cavityShape))
        {
            return false;
        }
        
        

        int x;
        int y;
        int z;

        // create the lake - bottom 4 layers of turned to water, top 4 turned to air
        for (x = 0; x < 16; ++x)
        {
            for (z = 0; z < 16; ++z)
            {
                for (y = 0; y < 8; ++y)
                {
                    if (cavityShape[(x * 16 + z) * 8 + y])
                    {
                        world.setBlockState(pos.add(x, y, z), y >= 4 ? Blocks.air.getDefaultState() : this.liquid, 2);
                    }
                }
            }
        }
        if (this.lineWith != null)
        {
            // line interior of lakes (used for instance with lava lakes to turn edge to stone)
            for (x = 0; x < 16; ++x)
            {
                for (z = 0; z < 16; ++z)
                {
                    for (y = 0; y < 8; ++y)
                    {
                        if (this.isCavityEdge(x, y, z, cavityShape))
                        {
                            if ((y < 4 || rand.nextInt(2) != 0) && world.getBlockState(pos.add(x, y, z)).getBlock().getMaterial().isSolid())
                            {
                                if (rand.nextInt(4) == 0)
                                {
                                        world.setBlockState(pos.add(x, y, z), ModBlocks.sulphurOre.getDefaultState(), 2);
                                }
                                else world.setBlockState(pos.add(x, y, z), this.lineWith, 2);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public static enum ScatterYMethod
    {
        ANYWHERE, BELOW_SURFACE, BELOW_GROUND, ABOVE_SURFACE, ABOVE_GROUND;
        public BlockPos getBlockPos(World world, Random random, int x, int z)
        {
            int tempY;
            BlockPos pos;
            switch(this)
            {                     
                case BELOW_SURFACE:
                    // random point below surface (but possibly in the sea)
                    tempY = world.getHeight(new BlockPos(x, 0, z)).getY();
                    return new BlockPos(x, nextIntBetween(random, 1, tempY - 1), z);
                case BELOW_GROUND:
                    // random point below ground (and below sea)
                    tempY = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
                    return new BlockPos(x, nextIntBetween(random, 1, tempY - 1), z);
                case ABOVE_SURFACE:
                    // random point above surface (and above the sea)
                    tempY = world.getHeight(new BlockPos(x, 0, z)).getY();
                    return new BlockPos(x, nextIntBetween(random, tempY, 255), z);
                case ABOVE_GROUND:
                    // random point above ground (but possibly in the sea)
                    tempY = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
                    return new BlockPos(x, nextIntBetween(random, tempY, 255), z);
                case ANYWHERE: default:
                    // random y coord
                    return new BlockPos(x, nextIntBetween(random, 1, 255), z);
            }
        }
    }
	@Override
	public void generate(Random arg0, int arg1, int arg2, World arg3, IChunkProvider arg4, IChunkProvider arg5)
	{
		if (arg3.provider.getDimensionId() == 0)
		{
			for (int j = 0; j < this.vpc; j++)
			{
				this.generate(arg3, arg0, getScatterY(arg3, arg0, arg1, arg2));
			}
		}
	}
}