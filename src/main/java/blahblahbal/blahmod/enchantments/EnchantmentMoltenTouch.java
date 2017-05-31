package blahblahbal.blahmod.enchantments;

import blahblahbal.blahmod.items.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentMoltenTouch extends Enchantment
{
	public EnchantmentMoltenTouch(int enchID, ResourceLocation enchName, int enchWeight,
			EnumEnchantmentType enchType)
	{
		super(enchID, enchName, enchWeight, EnumEnchantmentType.DIGGER);
		this.setName("moltenTouch");
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
        return super.canApplyTogether(ench) && ench.effectId != fortune.effectId && ench.effectId != silkTouch.effectId;
    }
	@Override
	public boolean canApply(ItemStack stack)
    {
        return super.canApply(stack) && stack.getItem() != ModItems.lumitePickaxe;
    }
	@Override
	public int getMaxLevel()
    {
        return 1;
    }
}
