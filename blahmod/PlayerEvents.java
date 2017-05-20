package blahmod;

import java.util.HashMap;

import blahmod.items.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEvents
{
	public static final PlayerEvents INSTANCE = new PlayerEvents();
	
	@SubscribeEvent
	  public void livingTick(LivingEvent.LivingUpdateEvent event)
	  {
	    if ((event.entity instanceof EntityPlayer))
	    {
	      EntityPlayer player = (EntityPlayer)event.entity;
	      handleSpeedMods(player);
	    }
	  }
	
	private void handleSpeedMods(EntityPlayer player)
	{
		if ((player.worldObj.isRemote) && ((player.isSneaking()) || (player.inventory.armorItemInSlot(0) == null) || (player.inventory.armorItemInSlot(0).getItem() != ModItems.lumiteBoots)) && (prevStep.containsKey(Integer.valueOf(player.getEntityId()))))
	    {


	      player.stepHeight = ((Float)prevStep.get(Integer.valueOf(player.getEntityId()))).floatValue();
	      prevStep.remove(Integer.valueOf(player.getEntityId()));
	    }
	  }
	  
	  public HashMap<Integer, Float> prevStep = new HashMap();
	  
	  @SubscribeEvent
	  public void playerJumps(LivingEvent.LivingJumpEvent event)
	  {
	    if (event.entity instanceof EntityPlayer)
	    {
	    	EntityPlayer p = (EntityPlayer)event.entity;
	    	if (p.inventory.armorItemInSlot(0) != null && p.inventory.armorItemInSlot(0).getItem() == ModItems.lumiteBoots)
	    	{
	    		event.entityLiving.motionY += 0.2750000059604645D;
	    	}
	    }
	  }

}
