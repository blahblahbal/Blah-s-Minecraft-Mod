package blahblahbal.blahmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import blahblahbal.blahmod.blocks.ModBlocks;
import blahblahbal.blahmod.items.ModItems;

public class CreativeTabBlahBlocks extends CreativeTabs
{
	public CreativeTabBlahBlocks()
	{
		super(Main.MODID + "Blocks");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(ModBlocks.blazeBrick);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void displayAllReleventItems(List<ItemStack> items)
	{
		items.add(new ItemStack(ModBlocks.coalOre).copy());
		items.add(new ItemStack(ModBlocks.ironOre).copy());
		items.add(new ItemStack(ModBlocks.goldOre).copy());
		items.add(new ItemStack(ModBlocks.rubyOreTrop).copy());
		items.add(new ItemStack(ModBlocks.clayOre).copy());
		items.add(new ItemStack(ModBlocks.limestoneOre).copy());
		items.add(new ItemStack(ModBlocks.sulphurOre).copy());
		items.add(new ItemStack(ModBlocks.tadaniteOre).copy());
		items.add(new ItemStack(ModBlocks.uraniumOre).copy());
		items.add(new ItemStack(ModBlocks.rubyOre).copy());
		items.add(new ItemStack(ModBlocks.citrineOre).copy());
		items.add(new ItemStack(ModBlocks.topazOre).copy());
		items.add(new ItemStack(ModBlocks.sapphireOre).copy());
		items.add(new ItemStack(ModBlocks.amethystOre).copy());
		items.add(new ItemStack(ModBlocks.zirconOre).copy());
		items.add(new ItemStack(ModBlocks.lumiteOre).copy());
		items.add(new ItemStack(ModBlocks.limestoneBlock).copy());
		items.add(new ItemStack(ModBlocks.sulphurBlock).copy());
		items.add(new ItemStack(ModBlocks.tadanite).copy());
		items.add(new ItemStack(ModBlocks.uraniumBlock).copy());
		items.add(new ItemStack(ModBlocks.gemBlocks[0]).copy());
		items.add(new ItemStack(ModBlocks.gemBlocks[1]).copy());
		items.add(new ItemStack(ModBlocks.gemBlocks[2]).copy());
		items.add(new ItemStack(ModBlocks.gemBlocks[3]).copy());
		items.add(new ItemStack(ModBlocks.gemBlocks[4]).copy());
		items.add(new ItemStack(ModBlocks.zirconBlock).copy());
		items.add(new ItemStack(ModBlocks.lumiteBlock).copy());
		items.add(new ItemStack(ModBlocks.magnetite).copy());
		items.add(new ItemStack(ModBlocks.polishedMagnetite).copy());
		items.add(new ItemStack(ModBlocks.igneousRock).copy());
		items.add(new ItemStack(ModBlocks.polishedIgneousRock).copy());
		items.add(new ItemStack(ModBlocks.saltrock).copy());
		items.add(new ItemStack(ModBlocks.polishedSaltrock).copy());
		items.add(new ItemStack(ModBlocks.hardenedLava).copy());
		items.add(new ItemStack(ModBlocks.blazeBrick).copy());
		items.add(new ItemStack(ModBlocks.cement).copy());
		items.add(new ItemStack(ModBlocks.magmaCreamBlock).copy());
		items.add(new ItemStack(ModBlocks.enderPearlBlock).copy());
		items.add(new ItemStack(ModBlocks.quicksilverBlock).copy());
		items.add(new ItemStack(ModBlocks.endStoneBricks).copy());
		items.add(new ItemStack(ModBlocks.leatherBlock).copy());
		items.add(new ItemStack(ModBlocks.petrifiedWood).copy());
		items.add(new ItemStack(ModBlocks.redNetherBrick).copy());
		items.add(new ItemStack(ModBlocks.netherWartBlock).copy());
		items.add(new ItemStack(ModBlocks.boneBlock).copy());
		items.add(new ItemStack(ModBlocks.reinforcedGlass).copy());
		items.add(new ItemStack(ModBlocks.imperviousBrick).copy());
		items.add(new ItemStack(ModBlocks.netherIce).copy());
		items.add(new ItemStack(ModBlocks.netherIceBrick).copy());
		items.add(new ItemStack(ModBlocks.potatoBlock).copy());
		items.add(new ItemStack(ModBlocks.carrotBlock).copy());
		items.add(new ItemStack(ModBlocks.obsidianBrick).copy());
		items.add(new ItemStack(ModBlocks.sequoiaLog).copy());
		items.add(new ItemStack(ModBlocks.sequoiaPlanks).copy());
		items.add(new ItemStack(ModBlocks.sequoiaLeaves).copy());
		items.add(new ItemStack(ModBlocks.newWool[0]).copy());
		items.add(new ItemStack(ModBlocks.newWool[3]).copy());
		items.add(new ItemStack(ModBlocks.newWool[8]).copy());
		items.add(new ItemStack(ModBlocks.newWool[7]).copy());
		items.add(new ItemStack(ModBlocks.newWool[5]).copy());
		items.add(new ItemStack(ModBlocks.newWool[1]).copy());
		items.add(new ItemStack(ModBlocks.newWool[4]).copy());
		items.add(new ItemStack(ModBlocks.newWool[9]).copy());
		items.add(new ItemStack(ModBlocks.newWool[2]).copy());
		items.add(new ItemStack(ModBlocks.newWool[6]).copy());
		items.add(new ItemStack(ModBlocks.catalyzer).copy());
		items.add(new ItemStack(ModBlocks.tadaniteSmeltery).copy());
		items.add(new ItemStack(ModBlocks.sequoiaSapling).copy());
		items.add(new ItemStack(ModBlocks.prefabSapling).copy());
		items.add(new ItemStack(ModBlocks.cedarSapling).copy());
		items.add(new ItemStack(ModBlocks.palmSapling).copy());
		items.add(new ItemStack(ModBlocks.dreadSapling).copy());
		items.add(new ItemStack(ModBlocks.frostSapling).copy());
		items.add(new ItemStack(ModBlocks.blackSand).copy());
		items.add(new ItemStack(ModBlocks.blackSandstone).copy());
		items.add(new ItemStack(ModBlocks.chiseledBlackSandstone).copy());
		items.add(new ItemStack(ModBlocks.palmLog).copy());
		items.add(new ItemStack(ModBlocks.palmLeaves).copy());
		items.add(new ItemStack(ModBlocks.palmPlanks).copy());
		items.add(new ItemStack(ModBlocks.frostLog).copy());
		items.add(new ItemStack(ModBlocks.frostLeaves).copy());
		items.add(new ItemStack(ModBlocks.frostPlanks).copy());
		items.add(new ItemStack(ModBlocks.tropicStone).copy());
		items.add(new ItemStack(ModBlocks.tropicStoneBrick).copy());
		items.add(new ItemStack(ModBlocks.tropicCobblestone).copy());
		items.add(new ItemStack(ModBlocks.tropicMud).copy());
		items.add(new ItemStack(ModBlocks.seashell).copy());
		items.add(new ItemStack(ModBlocks.largeSeashell).copy());
		items.add(new ItemStack(ModBlocks.groundCoconut).copy());
		items.add(new ItemStack(ModBlocks.cedarLeaves).copy());
		items.add(new ItemStack(ModBlocks.cedarLog).copy());
		items.add(new ItemStack(ModBlocks.cedarPlanks).copy());
		items.add(new ItemStack(ModBlocks.dreadLog).copy());
		items.add(new ItemStack(ModBlocks.deadPlanks).copy());
		items.add(new ItemStack(ModBlocks.dreadSand).copy());
		items.add(new ItemStack(ModBlocks.dreadRock).copy());
		items.add(new ItemStack(ModBlocks.dreadSandstone).copy());
		items.add(new ItemStack(ModBlocks.chiseledDreadSandstone).copy());
		items.add(new ItemStack(ModItems.cedarDoorItem).copy());
		items.add(new ItemStack(ModItems.cobbleDoorItem).copy());
		items.add(new ItemStack(ModItems.diamondDoorItem).copy());
		items.add(new ItemStack(ModItems.goldDoorItem).copy());
		items.add(new ItemStack(ModItems.lumiteDoorItem).copy());
		items.add(new ItemStack(ModItems.palmDoorItem).copy());
		items.add(new ItemStack(ModItems.sequoiaDoorItem).copy());
		items.add(new ItemStack(ModItems.dreadDoorItem).copy());
		items.add(new ItemStack(ModItems.frostDoorItem).copy());
		items.add(new ItemStack(ModBlocks.frostBlazeBrick).copy());
		items.add(new ItemStack(ModBlocks.magmaRockBricks).copy());
		items.add(new ItemStack(ModBlocks.slabs[0]).copy());
		items.add(new ItemStack(ModBlocks.slabs[1]).copy());
		items.add(new ItemStack(ModBlocks.slabs[2]).copy());
		items.add(new ItemStack(ModBlocks.slabs[3]).copy());
		items.add(new ItemStack(ModBlocks.slabs[4]).copy());
		items.add(new ItemStack(ModBlocks.slabs[5]).copy());
		items.add(new ItemStack(ModBlocks.slabs[6]).copy());
		items.add(new ItemStack(ModBlocks.slabs[7]).copy());
		items.add(new ItemStack(ModBlocks.slabs2[0]).copy());
		items.add(new ItemStack(ModBlocks.slabs2[1]).copy());
		items.add(new ItemStack(ModBlocks.slabs2[2]).copy());
		items.add(new ItemStack(ModBlocks.slabs2[3]).copy());
		items.add(new ItemStack(ModBlocks.slabs2[4]).copy());
		items.add(new ItemStack(ModBlocks.slabs2[5]).copy());
		items.add(new ItemStack(ModBlocks.slabs2[6]).copy());
		items.add(new ItemStack(ModBlocks.slabs2[7]).copy());
		items.add(new ItemStack(ModBlocks.woodSlabs[0]).copy());
		items.add(new ItemStack(ModBlocks.woodSlabs[1]).copy());
		items.add(new ItemStack(ModBlocks.woodSlabs[2]).copy());
		items.add(new ItemStack(ModBlocks.woodSlabs[3]).copy());
		items.add(new ItemStack(ModBlocks.woodSlabs[4]).copy());
		items.add(new ItemStack(ModBlocks.woodSlabs[5]).copy());
		items.add(new ItemStack(ModBlocks.woodSlabs[6]).copy());
		items.add(new ItemStack(ModBlocks.woodSlabs[7]).copy());
		items.add(new ItemStack(ModBlocks.slabs3[0]).copy());
		items.add(new ItemStack(ModBlocks.slabs3[1]).copy());
		items.add(new ItemStack(ModBlocks.slabs3[2]).copy());
		items.add(new ItemStack(ModBlocks.slabs3[3]).copy());
		items.add(new ItemStack(ModBlocks.slabs3[4]).copy());
		items.add(new ItemStack(ModBlocks.acaciaSideSlab).copy());
		items.add(new ItemStack(ModBlocks.oakSideSlab).copy());
		items.add(new ItemStack(ModBlocks.darkOakSideSlab).copy());
		items.add(new ItemStack(ModBlocks.frostSideSlab).copy());
		items.add(new ItemStack(ModBlocks.netherFrostBrickSideSlab).copy());
		items.add(new ItemStack(ModBlocks.spruceSideSlab).copy());
		items.add(new ItemStack(ModBlocks.jungleSideSlab).copy());
		items.add(new ItemStack(ModBlocks.obsidianSideSlab).copy());
		items.add(new ItemStack(ModBlocks.tadaniteSideSlab).copy());
		items.add(new ItemStack(ModBlocks.sulphurSideSlab).copy());
		items.add(new ItemStack(ModBlocks.lapisSideSlab).copy());
		items.add(new ItemStack(ModBlocks.cedarSideSlab).copy());
		items.add(new ItemStack(ModBlocks.sequoiaSideSlab).copy());
		items.add(new ItemStack(ModBlocks.ironSideSlab).copy());
		items.add(new ItemStack(ModBlocks.goldSideSlab).copy());
		items.add(new ItemStack(ModBlocks.emeraldSideSlab).copy());
		items.add(new ItemStack(ModBlocks.diamondSideSlab).copy());
		items.add(new ItemStack(ModBlocks.limestoneSideSlab).copy());
		items.add(new ItemStack(ModBlocks.birchSideSlab).copy());
		items.add(new ItemStack(ModBlocks.tropicsSideSlab).copy());
		items.add(new ItemStack(ModBlocks.dreadSideSlab).copy());
		items.add(new ItemStack(ModBlocks.dirtSideSlab).copy());
		items.add(new ItemStack(ModBlocks.mossSideSlab).copy());
		items.add(new ItemStack(ModBlocks.petrifiedWoodSideSlab).copy());
		items.add(new ItemStack(ModBlocks.netherBrickSideSlab).copy());
		items.add(new ItemStack(ModBlocks.cobblestoneSideSlab).copy());
		items.add(new ItemStack(ModBlocks.quartzSideSlab).copy());
		items.add(new ItemStack(ModBlocks.blazeSideSlab).copy());
		items.add(new ItemStack(ModBlocks.palmFence).copy());
		items.add(new ItemStack(ModBlocks.cedarFence).copy());
		items.add(new ItemStack(ModBlocks.sequoiaFence).copy());
		items.add(new ItemStack(ModBlocks.dreadFence).copy());
		items.add(new ItemStack(ModBlocks.frostFence).copy());
		items.add(new ItemStack(ModBlocks.petrifiedWoodWall).copy());
		items.add(new ItemStack(ModBlocks.palmFenceGate).copy());
		items.add(new ItemStack(ModBlocks.cedarFenceGate).copy());
		items.add(new ItemStack(ModBlocks.sequoiaFenceGate).copy());
		items.add(new ItemStack(ModBlocks.dreadFenceGate).copy());
		items.add(new ItemStack(ModBlocks.frostFenceGate).copy());
		items.add(new ItemStack(ModBlocks.palmStairs).copy());
		items.add(new ItemStack(ModBlocks.cedarStairs).copy());
		items.add(new ItemStack(ModBlocks.sequoiaStairs).copy());
		items.add(new ItemStack(ModBlocks.cementStairs).copy());
		items.add(new ItemStack(ModBlocks.petrifiedWoodStairs).copy());
		items.add(new ItemStack(ModBlocks.dreadStairs).copy());
		items.add(new ItemStack(ModBlocks.frostStairs).copy());
		items.add(new ItemStack(ModBlocks.glassStairs).copy());
		items.add(new ItemStack(ModBlocks.reinGlassStairs).copy());
		items.add(new ItemStack(ModBlocks.tropicStoneBrickStairs).copy());
		items.add(new ItemStack(ModBlocks.netherIceBrickStairs).copy());
		items.add(new ItemStack(ModBlocks.lantern).copy());
		items.add(new ItemStack(ModBlocks.lanternFloor).copy());
		items.add(new ItemStack(ModBlocks.netherFrost).copy());
		items.add(new ItemStack(ModBlocks.netherSnow).copy());
		items.add(new ItemStack(ModBlocks.frostBrick).copy());
		items.add(new ItemStack(ModBlocks.frostSand).copy());
		items.add(new ItemStack(ModBlocks.frostSandstone).copy());
		items.add(new ItemStack(ModBlocks.chiseledFrostSandstone).copy());
		items.add(new ItemStack(ModBlocks.iceCreamBlock).copy());
		super.displayAllReleventItems(items);
	}
}