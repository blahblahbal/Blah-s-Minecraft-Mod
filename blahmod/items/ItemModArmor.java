package blahmod.items;

import java.util.List;
import java.util.Random;

import blahmod.Main;
import blahmod.PlayerEvents;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModArmor extends ItemArmor
{

    public ItemModArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType)
    {
        super(material, renderIndex, armorType);
        this.setCreativeTab(Main.blahTab);
        this.setUnlocalizedName(unlocalizedName);
    }
    @Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		if(player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null){
			ItemStack boots = player.getCurrentArmor(0);
			ItemStack legs = player.getCurrentArmor(1);
			ItemStack chest = player.getCurrentArmor(2);
			ItemStack helmet = player.getCurrentArmor(3);
			if(boots.getItem() == ModItems.tadaniteBoots &&
				legs.getItem() == ModItems.tadaniteLeggings &&
				chest.getItem() == ModItems.tadaniteChestplate &&
				helmet.getItem() == ModItems.tadaniteHelmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 100, 1));
				if (player.isBurning()) player.extinguish();
				//player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 300, 1));
			}
			if(boots.getItem() == ModItems.obsidianBoots &&
				legs.getItem() == ModItems.obsidianLeggings &&
				chest.getItem() == ModItems.obsidianChestplate &&
				helmet.getItem() == ModItems.obsidianHelmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 100, 1));
				if (player.isBurning()) player.extinguish();
			}
			if (boots.getItem() == ModItems.lumiteBoots &&
					legs.getItem() == ModItems.lumiteLeggings &&
					chest.getItem() == ModItems.lumiteChestplate &&
					helmet.getItem() == ModItems.lumiteHelmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 100, 1));
				//player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 0));
				player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.saturation.getId(), 100, 0));
				if (player.isBurning()) player.extinguish();
				if (world.isRemote)
		        {
		            int x = (int) Math.floor(player.posX);
		            int y = (int) (player.posY - player.getYOffset());
		            int z = (int) Math.floor(player.posZ);
		            BlockPos pos = new BlockPos(x, y, z);

		            Block b = world.getBlockState(pos.down()).getBlock();

		            if ((b == Blocks.lava || b == Blocks.flowing_lava || b == Blocks.water || b == Blocks.flowing_water || b instanceof BlockFluidClassic) && world.isAirBlock(pos))
		            {
		                if (!player.isSneaking())
		                {
		                    player.motionY = 0.0d;
		                    player.fallDistance = 0.0f;
		                    player.onGround = true;
		                }
		            }
		        }
				if ((!player.capabilities.isFlying) && (player.moveForward > 0.0F))
			    {
			      if ((world.isRemote) && (!player.isSneaking()))
			      {
			        if (!PlayerEvents.INSTANCE.prevStep.containsKey(Integer.valueOf(player.getEntityId())))
			        {
			        	PlayerEvents.INSTANCE.prevStep.put(Integer.valueOf(player.getEntityId()), Float.valueOf(player.stepHeight));
			        }
			        player.stepHeight = 1.0F;
			      }
			      
			      if (player.onGround)
			      {
			        float bonus = 0.02F;
			        if (player.isInWater()) bonus /= 4.0F;
			        player.moveFlying(0.0F, 1.0F, bonus);
			      }
			      else
			      {
			    	  player.jumpMovementFactor = 0.05F;
			      }
			    }
			    if (player.fallDistance > 0.0F)
			    {
			    	player.fallDistance -= 0.25F;
			    }	
			}
		}
	}
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Main.MODID + ":textures/armor/" + this.getArmorMaterial() + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }
}