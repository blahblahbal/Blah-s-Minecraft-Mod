package main.java.blahblahbal.blahmod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentStepping extends Enchantment
{
	public EnchantmentStepping(int enchID, ResourceLocation enchName, int enchWeight,
			EnumEnchantmentType enchType)
	{
		super(enchID, enchName, enchWeight, EnumEnchantmentType.ARMOR_FEET);
		this.setName("stepping");
	}
	@Override
	public int getMinEnchantability(int enchantmentLevel)
    {
        return 15;
    }
	@Override
	public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }
	@Override
	public boolean canApplyTogether(Enchantment ench)
    {
        return super.canApplyTogether(ench);
    }
	@Override
	public boolean canApply(ItemStack stack)
    {
        return super.canApply(stack);
    }
	@Override
	public int getMaxLevel()
    {
        return 2;
    }
}
