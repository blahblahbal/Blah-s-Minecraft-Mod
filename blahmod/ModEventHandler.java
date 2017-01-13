package blahmod;

import blahmod.blocks.ModBlocks;
import blahmod.fluids.BlockAcidFluid;
import blahmod.items.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEventHandler
{
	@SubscribeEvent
	public void breakBlockEvent(BreakSpeed event)
	{
		if(event.state.getBlock() == Blocks.bedrock && !(event.entityPlayer.inventory.getCurrentItem().getItem() == ModItems.bedrockPickaxe))
		{
			event.newSpeed = 0F;
		}
	}
	@SubscribeEvent
    public void onRightClickHoldingBucket(FillBucketEvent event)
    {
        // check we're using a bucket, on a block we can modify
        if (event.current.getItem() != Items.bucket) return;
        if (event.target.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) return;
        BlockPos blockpos = event.target.getBlockPos();
        if (!event.world.isBlockModifiable(event.entityPlayer, blockpos)) return;
        if (!event.entityPlayer.canPlayerEdit(blockpos.offset(event.target.sideHit), event.target.sideHit, event.current)) {return;}
        
        // determine if the block is one of our BOP fluids
        IBlockState iblockstate = event.world.getBlockState(blockpos);
        Item filled_bucket = null;
        if (iblockstate.getBlock() == ModBlocks.acid && ((Integer)iblockstate.getValue(BlockAcidFluid.LEVEL)).intValue() == 0)
        {
            filled_bucket = ModItems.acidBucket;
        }
        else
        {
            return;
        }
        
        // remove the fluid and return the appropriate filled bucket
        event.setResult(Result.ALLOW);
        event.result = new ItemStack(filled_bucket);
        event.world.setBlockToAir(blockpos);
        //event.entityPlayer.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(event.current.getItem())]);
    }
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
    			if (event.state.getBlock() == Blocks.stone && Blocks.stone.getMetaFromState(event.state) == 0)
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