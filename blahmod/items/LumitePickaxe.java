package blahmod.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class LumitePickaxe extends ItemModPickaxe
{
	public LumitePickaxe(String unlocalizedName, ToolMaterial material)
	{
		super(unlocalizedName, material);
	}
}
