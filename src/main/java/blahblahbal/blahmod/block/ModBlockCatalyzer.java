package blahblahbal.blahmod.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

import blahblahbal.blahmod.tileentity.ModTileEntity;

import blahblahbal.blahmod.BlahMod;
import blahblahbal.blahmod.ModGuiHandler;
import blahblahbal.blahmod.guicontainer.ContainerCatalyzer;
import blahblahbal.blahmod.init.ModBlocks;

public class ModBlockCatalyzer extends BlockContainer
{	
	public ModBlockCatalyzer(String uname)
	{
		super(Material.IRON);
		this.setTranslationKey(uname);
		this.setRegistryName(uname);
		this.setHardness(2.0f);
		this.setResistance(6.0f);
		this.setCreativeTab(BlahMod.TabBlah);
		this.setHarvestLevel("pickaxe", 0);
	}

//	@Override
//	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
//		ModTileEntity te = (ModTileEntity) world.getTileEntity(pos);
//		InventoryHelper.dropInventoryItems(world, pos, te);
//		super.breakBlock(world, pos, blockstate);
//	}
//
//	@Override
//	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
//		if (stack.hasDisplayName()) {
//			((ModTileEntity) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
//		}
//	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			player.displayGui(new InterfaceCatalyzer(world, pos));
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ModTileEntity();
	}
	public static class InterfaceCatalyzer implements IInteractionObject
    {
        private final World world;
        private final BlockPos position;

        public InterfaceCatalyzer(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            this.position = pos;
        }

        public String getName()
        {
            return "catalyzer";
        }
        public boolean hasCustomName()
        {
            return false;
        }
        public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(ModBlocks.catalyzer.getTranslationKey() + ".name", new Object[0]);
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new ContainerCatalyzer(playerInventory, this.world, this.position);
        }

        public String getGuiID()
        {
            return "blahmod:catalyzer";
        }
    }
}