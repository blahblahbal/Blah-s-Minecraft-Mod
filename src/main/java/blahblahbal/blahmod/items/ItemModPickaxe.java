package blahblahbal.blahmod.items;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

import blahblahbal.blahmod.AchievementHandler;
import blahblahbal.blahmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemModPickaxe extends ItemPickaxe
{
	String name;
	ToolMaterial material;
	public ItemModPickaxe(String unlocalizedName, ToolMaterial material)
	{
		super(material);
		this.material = material;
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.blahTab);
		this.name = unlocalizedName;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		if (this.name.contains("obsidian"))
		{
			tooltip.add("§7Fragile");
		}
		if (this.name.contains("tadanite"))
		{
			tooltip.add("§eEfficient");
		}
	}
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = (this.name.contains("obsidian") ? new ItemStack(ModItems.obsidianIngot) : new ItemStack(ModItems.tadaniteDiamond));
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
}
}