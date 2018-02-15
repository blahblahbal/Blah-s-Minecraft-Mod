package blahblahbal.blahmod.items;

import java.util.List;

import blahblahbal.blahmod.AchievementHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BedrockPickaxe extends ItemModPickaxe
{
	public BedrockPickaxe(String unlocalizedName, ToolMaterial material)
	{
		super(unlocalizedName, material);
	}
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		super.onCreated(stack, world, player);
		if (!world.isRemote)
		{
			player.addStat(AchievementHandler.BEDROCK_PICKAXE, 1);
		}
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		tooltip.add("§cOmniharvest");
	}
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = new ItemStack(Blocks.bedrock);
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }
}
