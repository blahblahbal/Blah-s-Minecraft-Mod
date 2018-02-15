package blahblahbal.blahmod;

import java.util.List;
import java.util.Random;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.enchantments.EnchantmentStepping;
import blahblahbal.blahmod.fluids.BlockAcidFluid;
import blahblahbal.blahmod.fluids.BlockIceFluid;
import blahblahbal.blahmod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;

public class ModEventHandler
{
	@SubscribeEvent
	public void playerTick(TickEvent.PlayerTickEvent event)
	{
		if (event.phase == TickEvent.Phase.END) // && event.side == Side.SERVER)
		{
			EntityPlayer player = (EntityPlayer)event.player;
			/*GameSettings gs = Minecraft.getMinecraft().gameSettings;
			if (!GameSettings.isKeyDown(gs.keyBindForward) && !GameSettings.isKeyDown(gs.keyBindBack)
				&& !GameSettings.isKeyDown(gs.keyBindRight) && !GameSettings.isKeyDown(gs.keyBindLeft) &&
				player.capabilities.isFlying)
			{
				player.motionX = player.motionZ = 0.0d;
			}*/
			if (player.inventory.armorInventory[0] != null)
			{
				if (EnchantmentHelper.getEnchantments(player.getCurrentArmor(0)).containsKey(Config.enchSteppingID))
				{
					if (EnchantmentHelper.getEnchantmentLevel(Config.enchSteppingID, player.getCurrentArmor(0)) == 2)
					{
						if (player.worldObj.isRemote)
						{
							int x = (int) Math.floor(player.posX);
							int y = (int) (player.posY - player.getYOffset());
							int z = (int) Math.floor(player.posZ);
							BlockPos pos = new BlockPos(x, y, z);

							Block b = player.worldObj.getBlockState(pos.down()).getBlock();

							if ((b == Blocks.lava || b == Blocks.flowing_lava || b == Blocks.water || b == Blocks.flowing_water || b instanceof BlockFluidClassic) && player.worldObj.isAirBlock(pos))
							{
								if (!player.isSneaking())
								{
									player.motionY = 0.0d;
									player.fallDistance = 0.0f;
									player.onGround = true;
								}
							}
						}
			        }
					if ((!player.capabilities.isFlying) && (player.moveForward > 0.0F))
				    {
						if ((player.worldObj.isRemote) && (!player.isSneaking()))
				    	{
							if (!PlayerEvents.INSTANCE.prevStep.containsKey(Integer.valueOf(player.getEntityId())))
							{
								PlayerEvents.INSTANCE.prevStep.put(Integer.valueOf(player.getEntityId()), Float.valueOf(player.stepHeight));
							}
							player.stepHeight = 1.0F;
				    	}
				    }
				}
			}
		}
	}
	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer p = (EntityPlayer)event.entityLiving;
			if(p.getCurrentArmor(0) != null && p.getCurrentArmor(1) != null && p.getCurrentArmor(2) != null && p.getCurrentArmor(3) != null)
			{
				ItemStack boots = p.getCurrentArmor(0);
				ItemStack legs = p.getCurrentArmor(1);
				ItemStack chest = p.getCurrentArmor(2);
				ItemStack helmet = p.getCurrentArmor(3);
				if (boots.getItem() == ModItems.lumiteBoots &&
						legs.getItem() == ModItems.lumiteLeggings &&
						chest.getItem() == ModItems.lumiteChestplate &&
						helmet.getItem() == ModItems.lumiteHelmet)
				{
					AxisAlignedBB aabb = p.getEntityBoundingBox().expand(8, 8, 8);
					List entities = p.worldObj.getEntitiesWithinAABBExcludingEntity(p, aabb);
					for(int j = 0; j < entities.size(); j++)
					{
						Entity entity = (Entity)entities.get(j);
						int eid = entity.getEntityId();
						if (entity instanceof EntityMob)
						{
							entity.attackEntityFrom(DamageSource.causeThornsDamage(p), 4);
						}
					}
				}
			}
		}
	}
	@SubscribeEvent
	public void breakBlockEvent(BreakSpeed event)
	{
		if (event.entityPlayer.inventory.getCurrentItem() != null)
			{
			if(event.state.getBlock() == Blocks.bedrock && !(event.entityPlayer.inventory.getCurrentItem().getItem() == ModItems.bedrockPickaxe))
			{
				event.newSpeed = 0F;
			}
			if (event.state.getBlock() == ModBlocks.lumiteOre && (event.entityPlayer.inventory.getCurrentItem().getItem() != ModItems.lumitePickaxe && event.entityPlayer.inventory.getCurrentItem().getItem() != ModItems.bedrockPickaxe))
			{
				event.newSpeed = 0F;
			}
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
        if (iblockstate.getBlock() == ModBlocks.moltenIce && ((Integer)iblockstate.getValue(BlockIceFluid.LEVEL)).intValue() == 0)
        {
            filled_bucket = ModItems.iceBucket;
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
    		/*if (Main.getLumiteAxe(event.harvester))
    		 * {
    		 * 		if (event.state.getBlock() == ModBlocks.cedarLog ||
    		 * 			event.state.getBlock() == ModBlocks.palmLog ||
    		 * 			event.state.getBlock() == ModBlocks.dreadLog ||
    		 * 			event.state.getBlock() == Blocks.log ||
    		 * 			event.state.getBlock() == Blocks.log2)
    		 * 		{
    		 * 			
    		 * 			//Main.harvestTreeRecursive(event, event.world, event.pos, event.state.getBlock(), 1, 1, 1);
    		 * 		}
    		 * }*/
    		if (Main.getLumitePick(event.harvester))
    		{
    			if (event.state.getBlock() == Blocks.diamond_ore ||
    				event.state.getBlock() == Blocks.emerald_ore ||
    				event.state.getBlock() == Blocks.gold_ore ||
    				event.state.getBlock() == Blocks.iron_ore ||
    				event.state.getBlock() == Blocks.quartz_ore ||
    				event.state.getBlock() == Blocks.coal_ore ||
    				event.state.getBlock() == ModBlocks.coalOre ||
    				event.state.getBlock() == ModBlocks.ironOre ||
    				event.state.getBlock() == ModBlocks.goldOre ||
    				event.state.getBlock() == ModBlocks.limestoneOre ||
    				event.state.getBlock() == ModBlocks.lumiteOre ||
    				event.state.getBlock() == ModBlocks.sulphurOre ||
    				event.state.getBlock() == ModBlocks.rubyOre ||
    				event.state.getBlock() == ModBlocks.citrineOre ||
    				event.state.getBlock() == ModBlocks.topazOre ||
    				event.state.getBlock() == ModBlocks.sapphireOre ||
    				event.state.getBlock() == ModBlocks.amethystOre ||
    				event.state.getBlock() == ModBlocks.tadaniteOre)
    			{
    				if (event.state.getBlock() == Blocks.gold_ore)
    				{
    					event.drops.clear();
        				event.drops.add(new ItemStack(Items.gold_ingot, 3));
    				}
    				else if (event.state.getBlock() == Blocks.iron_ore)
    				{
    					event.drops.clear();
        				event.drops.add(new ItemStack(Items.iron_ingot, 3));
    				}
    				else if (event.state.getBlock() == ModBlocks.ironOre)
    				{
    					event.drops.clear();
        				event.drops.add(new ItemStack(Items.iron_ingot, 3));
    				}
    				else if (event.state.getBlock() == ModBlocks.goldOre)
    				{
    					event.drops.clear();
        				event.drops.add(new ItemStack(Items.gold_ingot, 3));
    				}
    				else if (event.state.getBlock() == ModBlocks.lumiteOre)
    				{
    					event.drops.clear();
        				event.drops.add(new ItemStack(ModItems.lumite, 2));
    				}
    				else
    				{
    					BlockOre bo = (BlockOre)event.state.getBlock();
        				event.drops.add(new ItemStack(bo.getItemDropped(event.state, new Random(), 6)));
    				}
    				
    			}
    		}
    		if (Main.getMoltenTouchModifier(event.harvester))
    		{
    			if (event.state.getBlock() == Blocks.iron_ore)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.iron_ingot));
    			}
    			if (event.state.getBlock() == ModBlocks.ironOre)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.iron_ingot));
    			}
    			if (event.state.getBlock() == Blocks.gold_ore)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.gold_ingot));
    			}
    			if (event.state.getBlock() == ModBlocks.goldOre)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.gold_ingot));
    			}
    			if (event.state.getBlock() == Blocks.netherrack)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.netherbrick));
    			}
    			if (event.state.getBlock() == Blocks.clay)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.brick, 4));
    			}
    			if (event.state.getBlock() == Blocks.sand)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Blocks.glass));
    			}
    			if (event.state.getBlock() == Blocks.stone && Blocks.stone.getMetaFromState(event.state) == 0)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Blocks.stone));
    			}
    			if (event.state.getBlock() == Blocks.cactus)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(Items.dye, 1, 2));
    			}
    			if (event.state.getBlock() == ModBlocks.uraniumOre)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(ModItems.uraniumIngot));
    			}
    			if (event.state.getBlock() == ModBlocks.lumiteOre)
    			{
    				event.drops.clear();
    				event.drops.add(new ItemStack(ModItems.lumite));
    			}
    		}
    	}
    }
}