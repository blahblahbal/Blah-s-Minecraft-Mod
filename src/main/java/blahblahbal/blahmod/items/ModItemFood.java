package blahblahbal.blahmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ModItemFood extends ItemFood
{
	private PotionEffect[] effects;
    public ModItemFood(String unlocalizedName, int amount, float saturation, boolean isWolfFood, PotionEffect... effects)
    {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName(unlocalizedName);
        this.effects = effects;
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
    {
        super.onFoodEaten(stack, world, player);
            
        if (effects != null)
        {
        	for (int i = 0; i < effects.length; i ++)
        	{
                if (!world.isRemote && effects[i] != null && effects[i].getPotionID() > 0)
                    player.addPotionEffect(new PotionEffect(this.effects[i]));
            }
        }
        
    }
}
