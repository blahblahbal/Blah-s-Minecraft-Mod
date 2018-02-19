package blahblahbal.blahmod.blocks;

import java.util.Random;

import blahblahbal.blahmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ModBlockSlab extends BlockSlab {
    /**
     * The property used for the variant.
     * Needed for interactions with ItemSlab.
     */
    public static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");
    /**
     * The unlocalized name.
     */
    private static final String NAME = "stainedBricksSlab";

    /**
     * Hardness value for the material.
     */
    private static final float HARDNESS = 2.0f;

    /**
     * Resistance value for the material.
     */
    private static final float RESISTANCE = 10.0f;

    /**
     * The bit in metadata used by the half property.
     */
    private static final int HALF_META_BIT = 8;

    /**
     * Name - needed for creating the model.
     */
    public String name;
    public abstract Item getHalfSlabReference();
    /**
     * Initializes a new instance of the ModBlockSlab class.
     * @param uname the unlocalized name of this ModBlockSlab
     */
    public ModBlockSlab(String uname, Material m) {
        super(m);
        this.useNeighborBrightness = !this.isDouble();
        setHardness(HARDNESS);
        setResistance(RESISTANCE);
        setStepSound(soundTypePiston);
        this.name = uname;
        setUnlocalizedName(uname);
        if (uname == "sequoiaSlab" || uname == "palmSlab" || uname == "cedarSlab" || uname == "dreadSlab" || uname == "frostSlab")
        {
        	this.setStepSound(soundTypeWood);
        	this.setHarvestLevel("axe", 0);
        }
        if (uname == "dirtSlab" || uname == "grassSlab")
        {
        	this.setStepSound(soundTypeGrass);
        	this.setHarvestLevel("shovel", 0);
        }
        if (uname == "leatherSlab" || uname == "woolSlab")
        {
        	this.setStepSound(soundTypeCloth);
        }
        if (!this.isDouble()) {
            setCreativeTab(Main.blahTabBlock);
        }
        IBlockState blockState = this.blockState.getBaseState();
        blockState = blockState.withProperty(VARIANT_PROPERTY, false);
        if (!this.isDouble()) {
            blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
        }

        setDefaultState(blockState);
    }

    /**
     * Gets the ID for the game registry.
     * @return the unique id for the registry.
     */
    public final String getId() {
        return this.innerGetId(this.isDouble());
    }

    /**
     * Gets the unlocalized name based on metadata/damage.
     * @param metadata block metadata.
     * @return the unlocalized name.
     */
    @Override
    public final String getUnlocalizedName(final int metadata) {
        return this.getUnlocalizedName();
    }

    /**
     * Gets the value of the variant property based on the item.
     * @param itemStack item stack.
     * @return the variant value null.
     */
    @Override
    public final Object getVariant(final ItemStack itemStack) {
        return false;
    }

    /**
     * Gets the variant property.
     * @return the variant property null.
     */
    @Override
    public final IProperty getVariantProperty() {
        return VARIANT_PROPERTY;
    }

    /**
     * Gets a block state from metadata.
     * @param meta the metadata or color value.
     * @return a block state with the meta encoded as the variant property.
     */
    @Override
    public final IBlockState getStateFromMeta(final int meta) {
        IBlockState blockState = this.getDefaultState();
        blockState = blockState.withProperty(VARIANT_PROPERTY, false);
        if (!this.isDouble()) {
            EnumBlockHalf value = EnumBlockHalf.BOTTOM;
            if ((meta & HALF_META_BIT) != 0) {
                value = EnumBlockHalf.TOP;
            }

            blockState = blockState.withProperty(HALF, value);
        }

        return blockState;
    }
    @Override
    public int quantityDropped(Random r)
    {
    	return this.isDouble() ? 2 : 1;
    }
    /**
     * Gets the metadata value from a block state.
     * @param state the block state.
     * @return the metadata or color value.
     */
    @Override
    public final int getMetaFromState(final IBlockState state) {
        if (this.isDouble()) {
           return 0;
        }

        if ((EnumBlockHalf) state.getValue(HALF) == EnumBlockHalf.TOP) {
            return HALF_META_BIT;
        } else {
            return 0;
        }
    }

    /**
     * Gets the damage for the block's item when dropped.
     * @param state the block's state.
     * @return the metadata or color value.
     */
    @Override
    public final int damageDropped(final IBlockState state) {
        return 0;
    }

    /**
     * Gets the item dropped when the block is broken.
     * @param blockState the block's state.
     * @param random the random number generator
     * @param unused an integer.
     * @return the half slab item.
     */
    @Override
    public final Item getItemDropped(final IBlockState blockState, final java.util.Random random, final int unused)
    {
        return this.getHalfSlabReference();
    }
    /**
     * Gets the item dropped when the block is broken.
     * @param world the world
     * @param blockPos the block position.
     * @return the item dropped, the half slab.
     */
    /*@SideOnly(Side.CLIENT)
    @Override
    public final net.minecraft.item.Item getItem(
        final net.minecraft.world.World world,
        final net.minecraft.util.BlockPos blockPos) {
        String blockId = this.innerGetId(this.isDouble());
        if (blockId.substring(0, 7) == "double_")
        {
        	ItemStack i = new ItemStack(GameRegistry.findItem("blahmod", blockId.substring(7)), 2);
        	return i.getItem();
        }
        return GameRegistry.findItem("blahmod", blockId);
    }*/

    /**
     * Creates the block state object.
     * @return the block state with properties defined.
     */
    @Override
    protected final BlockState createBlockState() {
        if (this.isDouble()) {
            return new BlockState(this, new IProperty[] {VARIANT_PROPERTY});
        } else {
            return new BlockState(
                this,
                new IProperty[] {VARIANT_PROPERTY, HALF});
        }
    }

    /**
     * Gets the ID of the block.
     * @param isDoubleStacked override the isDouble() method.
     * @return the unique block id.
     */
    private String innerGetId(final boolean isDoubleStacked) {
        String result = "";
        if (isDoubleStacked) {
            result = "double_";
        }
        String ID = "";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs[0]))
        	ID = "woolSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs[1]))
        	ID = "ironSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs[2]))
        	ID = "goldSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs[3]))
        	ID = "diamondSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs[4]))
        	ID = "emeraldSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs[5]))
        	ID = "sulphurSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs[6]))
        	ID = "limestoneSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs[7]))
        	ID = "uraniumSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs2[0]))
        	ID = "dirtSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs2[1]))
        	ID = "grassSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs2[2]))
        	ID = "leatherSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs2[3]))
        	ID = "lapisSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs2[4]))
        	ID = "obsidianSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs2[5]))
        	ID = "mossSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs2[6]))
        	ID = "endStoneBrickSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.slabs2[7]))
        	ID = "tadaniteSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.woodSlabs[0]))
        	ID = "sequoiaSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.woodSlabs[1]))
        	ID = "palmSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.woodSlabs[2]))
        	ID = "cedarSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.woodSlabs[3]))
        	ID = "petrifiedWoodSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.woodSlabs[4]))
        	ID = "dreadSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.woodSlabs[5]))
        	ID = "dreadSandSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.woodSlabs[6]))
        	ID = "blackSandSlab";
        if (Block.getIdFromBlock(this) == Block.getIdFromBlock(ModBlocks.woodSlabs[7]))
        	ID = "frostSlab";

        return result + ID;
    }
}