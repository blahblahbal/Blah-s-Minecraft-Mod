package blahblahbal.blahmod.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;

public class ModPotion extends Potion
{
	
	public static final Potion frostFire = (new ModPotion("blahmod:frostFire", true, 5149489)).setEffectiveness(1D);
	private double effectiveness;
	private String name;
	protected ModPotion(String loc, boolean badEffect, int potionColor)
	{
		super(new ResourceLocation(loc), badEffect, 3035801);
		int color = 3035801;
		setPotionName("potion." + loc.substring(8));
	}
	@Override
	protected Potion setEffectiveness(double effectivenessIn)
    {
        this.effectiveness = effectivenessIn;
        return this;
    }
	public Potion setPotionName(String nameIn)
    {
        this.name = nameIn;
        return this;
    }
    /**
     * returns the name of the potion
     */
    public String getName()
    {
        return this.name;
    }
	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_)
	{
		if (this.id == frostFire.id)
		{
			if (entityLivingBaseIn.getHealth() > 0)
			{
				
				entityLivingBaseIn.attackEntityFrom(DamageSource.wither, 3F);
			}
		}
	}
}
