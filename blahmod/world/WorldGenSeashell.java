package blahmod.world;

import java.util.Random;

import blahmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSeashell extends WorldGenerator
{
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        Block block;

        do
        {
            block = worldIn.getBlockState(position).getBlock();
            if (!block.isLeaves(worldIn, position) && !block.isLeaves(worldIn, position)) break;
            position = position.down();
        } while (position.getY() > 0);

        for (int i = 0; i < 4; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos))
            {
                worldIn.setBlockState(blockpos, ModBlocks.seashell.getDefaultState(), 2);
            }
        }

        return true;
    }
}