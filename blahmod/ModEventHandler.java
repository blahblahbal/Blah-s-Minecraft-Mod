package blahmod;

import blahmod.blocks.ModBlocks;
import blahmod.items.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEventHandler
{
	@SubscribeEvent
    public void playerHarvestEvent(HarvestDropsEvent event)
    {
    	if (event.harvester != null)
    	{
    		if (Main.getMoltenTouchModifier(event.harvester))
    		{
    			if (event.state.getBlock() == Blocks.iron_ore)
    			{
    				//event.drops.remove(new ItemStack(Blocks.iron_ore));
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.iron_ingot));
    			}
    			if (event.state.getBlock() == Blocks.gold_ore)
    			{
    				//event.drops.remove(new ItemStack(Blocks.gold_ore));
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.gold_ingot));
    			}
    			if (event.state.getBlock() == Blocks.netherrack)
    			{
    				//event.drops.remove(new ItemStack(Blocks.netherrack));
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.netherbrick));
    			}
    			if (event.state.getBlock() == Blocks.clay)
    			{
    				//event.drops.remove(new ItemStack(Items.clay_ball));
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.brick, 4));
    			}
    			if (event.state.getBlock() == Blocks.sand)
    			{
    				//event.drops.remove(new ItemStack(Blocks.sand));
    				event.drops.clear();
    				event.drops.add(new ItemStack(Blocks.glass));
    			}
    			if (event.state.getBlock() == Blocks.stone)
    			{
    				//event.drops.remove(new ItemStack(Blocks.cobblestone));
    				event.drops.clear();
    				event.drops.add(new ItemStack(Blocks.stone));
    			}
    			if (event.state.getBlock() == Blocks.cactus)
    			{
    				//event.drops.remove(new ItemStack(Blocks.cobblestone));
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.dye, 1, 2));
    			}
    			if (event.state.getBlock() == ModBlocks.uraniumOre)
    			{
    				//event.drops.remove(new ItemStack(Blocks.cobblestone));
    				event.drops.clear();
    				event.drops.add(new ItemStack(ModItems.uraniumIngot));
    			}
    		}
    	}
    }
}