package blahmod.blocks;

import blahmod.Main;
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
    private static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");
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

    /**
     * Initializes a new instance of the ModBlockSlab class.
     * @param uname the unlocalized name of this ModBlockSlab
     */
    public ModBlockSlab(String uname) {
        super(Material.rock);
        this.useNeighborBrightness = !this.isDouble();
        setHardness(HARDNESS);
        setResistance(RESISTANCE);
        setStepSound(soundTypePiston);
        this.name = uname;
        setUnlocalizedName(uname);
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
    public final Item getItemDropped(
        final IBlockState blockState,
        final java.util.Random random,
        final int unused) {
        String blockId = this.innerGetId(this.isDouble());
        if (blockId.substring(0, 7) == "double_")
        {
        	ItemStack i = new ItemStack(GameRegistry.findItem("blahmod", blockId.substring(7)), 2);
        	return i.getItem();
        }
        return GameRegistry.findItem("blahmod", blockId);
    }

    /**
     * Gets the item dropped when the block is broken.
     * @param world the world
     * @param blockPos the block position.
     * @return the item dropped, the half slab.
     */
    @SideOnly(Side.CLIENT)
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
    }

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
        if (this.getIdFromBlock(this) == ModBlocks.slabs[0].getIdFromBlock(ModBlocks.slabs[0]))
        	ID = "woolSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs[1].getIdFromBlock(ModBlocks.slabs[1]))
        	ID = "ironSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs[2].getIdFromBlock(ModBlocks.slabs[2]))
        	ID = "goldSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs[3].getIdFromBlock(ModBlocks.slabs[3]))
        	ID = "diamondSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs[4].getIdFromBlock(ModBlocks.slabs[4]))
        	ID = "emeraldSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs[5].getIdFromBlock(ModBlocks.slabs[5]))
        	ID = "sulphurSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs[6].getIdFromBlock(ModBlocks.slabs[6]))
        	ID = "limestoneSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs[7].getIdFromBlock(ModBlocks.slabs[7]))
        	ID = "uraniumSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs2[0].getIdFromBlock(ModBlocks.slabs2[0]))
        	ID = "dirtSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs2[1].getIdFromBlock(ModBlocks.slabs2[1]))
        	ID = "grassSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs2[2].getIdFromBlock(ModBlocks.slabs2[2]))
        	ID = "leatherSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs2[3].getIdFromBlock(ModBlocks.slabs2[3]))
        	ID = "lapisSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs2[4].getIdFromBlock(ModBlocks.slabs2[4]))
        	ID = "obsidianSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs2[5].getIdFromBlock(ModBlocks.slabs2[5]))
        	ID = "mossSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs2[6].getIdFromBlock(ModBlocks.slabs2[6]))
        	ID = "endStoneBrickSlab";
        if (this.getIdFromBlock(this) == ModBlocks.slabs2[7].getIdFromBlock(ModBlocks.slabs2[7]))
        	ID = "tadaniteSlab";

        return result + ID;
    }
}
