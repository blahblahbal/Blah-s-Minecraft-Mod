package blahblahbal.blahmod.items;

import blahblahbal.blahmod.Main;
import blahblahbal.blahmod.projectiles.EntityGemBolt;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemGemStaff extends Item
{
	public int bt;
	public static String name;
    public ItemGemStaff(int ebt, String uname)
    {
        this.maxStackSize = 1;
        this.setMaxDamage(450);
        this.setCreativeTab(Main.blahTab);
        this.setUnlocalizedName(uname);
        name = uname;
        bt = ebt;
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
    {
        //boolean flag = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

        //if (flag || playerIn.inventory.hasItem(Items.arrow))
        //{
            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            //net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(playerIn, stack, i);
            //if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
            //i = event.charge;
            float f = (float)i / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityGemBolt entityarrow = new EntityGemBolt(worldIn, playerIn, bt);

            /*if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }*/

            int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

            if (j > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.5D + 0.5D);
            }

            if (entityarrow.bolt == 1)
            {
            	entityarrow.setKnockbackStrength(2);
            }
            /*int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

            if (k > 0)
            {
                entityarrow.setKnockbackStrength(k);
            }*/

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
            {
                entityarrow.setFire(100);
            }

            stack.damageItem(1, playerIn);
            //worldIn.playSoundAtEntity(playerIn, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            /*if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                playerIn.inventory.consumeInventoryItem(Items.arrow);
            }*/

            //playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

            if (!worldIn.isRemote)
            {
                worldIn.spawnEntityInWorld(entityarrow);
            }
        //}
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        return stack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        //net.minecraftforge.event.entity.player.ArrowNockEvent event = new net.minecraftforge.event.entity.player.ArrowNockEvent(playerIn, itemStackIn);
        //if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return event.result;

        //if (playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(Items.arrow))
        //{
            playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        //}

        return itemStackIn;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}