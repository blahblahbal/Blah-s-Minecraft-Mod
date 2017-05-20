package blahmod.blocks;

import org.apache.commons.lang3.tuple.ImmutablePair;

import static blahmod.items.ModItems.acidBucket;

import blahmod.Main;
import blahmod.fluids.AcidFluid;
import blahmod.fluids.BlockAcidFluid;
import blahmod.items.ItemLog;
import blahmod.items.ModItemBlockSlab;
import blahmod.items.ModItemSlab;
import blahmod.items.ModItems;
import blahmod.items.itemBlocks.ItemCatalyzerBlock;
import blahmod.items.itemBlocks.ItemSmelteryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBucket;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;


public final class ModBlocks
{
	public static String[] gemNames = new String[] { "ruby", "citrine", "topaz", "sapphire", "amethyst" };
	public static Block[] gemBlocks = new Block[5];
	public static Block[] gemOres = new Block[5];
	public static Block[] newWool = new Block[10];
	public static String[] woolNames = new String[] { "BrightRed", "BrightYellow", "BrightCyan", "DarkRed", "DarkYellow", "PaleYellow", "Turquoise", "DarkOrange", "LightBrown", "YellowGreen" };
	public static ModBlockPrefabSapling prefabSapling;
	public static ModBlockSequoiaSapling sequoiaSapling;
	public static ModBlockPalmSapling palmSapling;
	public static ModBlockLog sequoiaLog;
	public static ModBlockLeaves sequoiaLeaves;
	public static ModBlockLog palmLog;
	public static BlockPalmLeaves palmLeaves;
	public static ModBlockGlass reinforcedGlass;
	public static Block imperviousBrick;
	public static Block blackSand;
	public static Block blackSandstone;
	public static Fluid acidFluid;
	public static BlockInventoryFurnace tadaniteSmeltery;
	public static Block acid;
	public static Block netherIceBrick;
	public static Block potatoBlock;
	public static Block hardenedLava;
	public static Block saltrock;
	public static Block magnetite;
	public static Block igneousRock;
	public static Block polishedSaltrock;
	public static Block polishedMagnetite;
	public static Block polishedIgneousRock;
	public static Block carrotBlock;
	public static Block quicksilverBlock;
	public static Block sequoiaPlanks;
	public static Block obsidianBrick;
	public static Block netherIce;
	public static Block amethystOre;
	public static Block citrineOre;
	public static Block topazOre;
	public static Block sapphireOre;
	public static Block rubyOre;
	public static Block tadanite;
    public static Block leatherBlock;
    public static Block magmaCreamBlock;
    public static Block enderPearlBlock;
    public static Block tadaniteOre;
    public static Block limestoneOre;
    public static Block limestoneBlock;
    public static Block cement;
    public static Block sulphurOre;
    public static Block lumiteOre;
    public static Block lumiteBlock;
    public static Block uraniumOre;
    public static Block sulphurBlock;
    public static Block catalyzer;
    public static Block uraniumBlock;
    public static Block endStoneBricks;
    public static Block uraniumTorch;
    public static Block clayOre;
    public static Block redNetherBrick;
    public static Block netherWartBlock;
    public static Block boneBlock;
    public static Block fleshBlock;
    public static ModBlockSlab[] slabs = new ModBlockSlab[8];
    public static ModBlockSlab[] doubleSlabs = new ModBlockSlab[8];
    public static ModBlockSlab[] slabs2 = new ModBlockSlab[8];
    public static ModBlockSlab[] doubleSlabs2 = new ModBlockSlab[8];
    public static Block petrifiedWood;
    public static Block blazeBrick;
    
    public static void createBlocks()
    {
    	GameRegistry.registerBlock((Block)(saltrock = new BasicBlock("saltrock", Material.rock, 1.5F, 10F, "pickaxe", 1, "saltrock")), "saltrock");
    	GameRegistry.registerBlock((Block)(polishedSaltrock = new BasicBlock("polishedSaltrock", Material.rock, 1.5F, 10F, "pickaxe", 1, "polishedSaltrock")), "polishedSaltrock");
    	GameRegistry.registerBlock((Block)(magnetite = new BasicBlock("magnetite", Material.rock, 1.5F, 10F, "pickaxe", 1, "magnetite")), "magnetite");
    	GameRegistry.registerBlock((Block)(polishedMagnetite = new BasicBlock("polishedMagnetite", Material.rock, 1.5F, 10F, "pickaxe", 1, "polishedMagnetite")), "polishedMagnetite");
    	GameRegistry.registerBlock((Block)(igneousRock = new BasicBlock("igneousRock", Material.rock, 1.F, 10F, "pickaxe", 1, "igneousRock")), "igneousRock");
    	GameRegistry.registerBlock((Block)(polishedIgneousRock = new BasicBlock("polishedIgneousRock", Material.rock, 1.5F, 10F, "pickaxe", 1, "polishedIgneousRock")), "polishedIgneousRock");
    	GameRegistry.registerBlock((Block)(hardenedLava = new BasicBlock("hardenedLava", Material.rock, 1.5F, 10F, "pickaxe", 1, "hardenedLava")), "hardenedLava");
    	GameRegistry.registerBlock((Block)(tadanite = new BasicBlock("tadanite", Material.rock, 35F, 1000F, "pickaxe", 4, "tadanite")), "tadanite");
    	GameRegistry.registerBlock(tadaniteOre = new ModBlockOre("tadaniteOre", Material.rock, ModItems.tadaniteShard, 40F, 2000F, "pickaxe", 4, 0, 1, 3, "tadaniteOre"), "tadaniteOre");
    	GameRegistry.registerBlock((Block)(leatherBlock = new BasicBlock("leatherBlock", Material.cake, 0.5F, 50F, "axe", 0, "leatherBlock")).setStepSound(Block.soundTypeCloth), "leatherBlock");
    	GameRegistry.registerBlock((Block)(limestoneBlock = new BasicBlock("limestoneBlock", Material.iron, 3F, 100F, "pickaxe", 1, "limestoneBlock")).setStepSound(Block.soundTypeMetal), "limestoneBlock");
    	GameRegistry.registerBlock((Block)(carrotBlock = new BasicBlock("carrotBlock", Material.cake, 0.5F, 30F, "axe", 0, "carrotBlock")).setStepSound(Block.soundTypeWood), "carrotBlock");
    	GameRegistry.registerBlock((Block)(quicksilverBlock = new BasicBlock("quicksilverBlock", Material.iron, 3F, 100F, "pickaxe", 1, "quicksilverBlock")).setStepSound(Block.soundTypeMetal), "quicksilverBlock");
    	GameRegistry.registerBlock((Block)(sulphurBlock = new BasicBlock("sulphurBlock", Material.iron, 3F, 200F, "pickaxe", 1, "sulphurBlock")).setStepSound(Block.soundTypeMetal), "sulphurBlock");
    	GameRegistry.registerBlock((Block)(lumiteBlock = new BasicBlock("lumiteBlock", Material.iron, 5F, 150F, "pickaxe", 1, "lumiteBlock")).setStepSound(Block.soundTypeMetal), "lumiteBlock");
    	GameRegistry.registerBlock((Block)(netherIceBrick = new BasicBlock("netherIceBrick", Material.rock, 8F, 150F, "pickaxe", 1, "netherIceBrick")).setStepSound(Block.soundTypeStone), "netherIceBrick");
    	GameRegistry.registerBlock(limestoneOre = new ModBlockOre("limestoneOre", Material.rock, ModItems.limestone, 3.5F, 100F, "pickaxe", 1, 0, 1, 2, "limestoneOre"), "limestoneOre");
    	GameRegistry.registerBlock(sulphurOre = new ModBlockOre("sulphurOre", Material.rock, ModItems.sulphur2, 3F, 200F, "pickaxe", 2, 0, 1, 2, "sulphurOre"), "sulphurOre");
    	GameRegistry.registerBlock((Block)(lumiteOre = new BasicBlock("lumiteOre", Material.rock, 3F, 200F, "pickaxe", 5, "lumiteOre")), "lumiteOre");
    	GameRegistry.registerBlock((Block)(cement = new BasicBlock("cement", Material.rock, 3F, 150F, "pickaxe", 1, "cement")), "cement");
    	GameRegistry.registerBlock((Block)(uraniumBlock = new BasicBlock("uraniumBlock", Material.iron, 10F, 150F, "pickaxe", 2, "uraniumBlock")).setStepSound(Block.soundTypeMetal).setLightLevel(.3F), "uraniumBlock");
    	GameRegistry.registerBlock((Block)(magmaCreamBlock = new BasicBlock("magmaCreamBlock", Material.cake, 0.5F, 5F, "pickaxe", 0, "magmaCreamBlock")).setStepSound(Block.soundTypeGravel), "magmaCreamBlock");
    	GameRegistry.registerBlock(potatoBlock = new BlockPotato(Material.cloth, "potatoBlock"), "potatoBlock");
    	GameRegistry.registerBlock((Block)(enderPearlBlock = new BasicBlock("enderPearlBlock", Material.cake, 0.5F, 5F, "pickaxe", 0, "enderPearlBlock")).setStepSound(Block.soundTypeStone), "enderPearlBlock");
    	GameRegistry.registerBlock((Block)(endStoneBricks = new BasicBlock("endStoneBricks", Material.rock, 10F, 150F, "pickaxe", 1, "endStoneBricks")).setStepSound(Block.soundTypeStone), "endStoneBricks");
    	GameRegistry.registerBlock(catalyzer = new ModBlockTileEntity("catalyzer"), ItemCatalyzerBlock.class, "catalyzer");
    	GameRegistry.registerBlock((Block)(uraniumOre = new BasicBlock("uraniumOre", Material.rock, 3F, 200F, "pickaxe", 3, "uraniumOre")), "uraniumOre");
    	GameRegistry.registerBlock((Block)(petrifiedWood = new BasicBlock("petrifiedWood", Material.rock, 2F, 100F, "pickaxe", 1, "petrifiedWood")), "petrifiedWood");
    	GameRegistry.registerBlock((Block)(redNetherBrick = new BasicBlock("redNetherBrick", Material.rock, 2F, 100F, "pickaxe", 1, "redNetherBrick")), "redNetherBrick");
    	GameRegistry.registerBlock((Block)(netherWartBlock = new BasicBlock("netherWartBlock", Material.rock, 2F, 100F, "pickaxe", 1, "netherWartBlock")), "netherWartBlock");
    	GameRegistry.registerBlock((Block)(boneBlock = new BasicBlock("boneBlock", Material.rock, 2F, 90F, "pickaxe", 1, "boneBlock")), "boneBlock");
    	GameRegistry.registerBlock((Block)(sequoiaPlanks = new BasicBlock("sequoiaPlanks", Material.wood, 2F, 5F, "hand", 0, "sequoiaPlanks")).setStepSound(Block.soundTypeWood), "sequoiaPlanks");
		GameRegistry.registerBlock((Block)(prefabSapling = new ModBlockPrefabSapling("prefabSapling", 1)), "prefabSapling");
		GameRegistry.registerBlock((Block)(sequoiaSapling = new ModBlockSequoiaSapling("sequoiaSapling", 2)), "sequoiaSapling");
		GameRegistry.registerBlock((Block)(sequoiaLog = new ModBlockLog("sequoiaLog")), "sequoiaLog");
		GameRegistry.registerBlock((Block)(sequoiaLeaves = new ModBlockLeaves("sequoiaLeaves")), "sequoiaLeaves");
		GameRegistry.registerBlock((Block)(palmSapling = new ModBlockPalmSapling("palmSapling", 2)), "palmSapling");
		GameRegistry.registerBlock((Block)(palmLog = new ModBlockLog("palmLog")), "palmLog");
		GameRegistry.registerBlock((Block)(palmLeaves = new BlockPalmLeaves("palmLeaves")), "palmLeaves");
		GameRegistry.registerBlock((Block)(tadaniteSmeltery = new BlockInventoryFurnace()), ItemSmelteryBlock.class, "tadaniteSmeltery");
		GameRegistry.registerBlock((Block)(reinforcedGlass = new ModBlockGlass("reinforcedGlass", Material.glass, 1F, 8F, "pickaxe", 1, "reinforcedGlass")).setStepSound(Block.soundTypeGlass), "reinforcedGlass");
		GameRegistry.registerBlock((Block)(imperviousBrick = new BasicBlock("imperviousBrick", Material.rock, 1F, 8F, "pickaxe", 1, "imperviousBrick")), "imperviousBrick");
		GameRegistry.registerBlock((Block)(blackSand = new BasicBlock("blackSand", Material.sand, 1F, 8F, "shovel", 1, "blackSand")).setStepSound(Block.soundTypeSand), "blackSand");
		GameRegistry.registerBlock((Block)(blackSandstone = new BasicBlock("blackSandstone", Material.rock, 1F, 8F, "pickaxe", 1, "blackSandstone")).setStepSound(Block.soundTypeStone), "blackSandstone");
		
		/*sequoiaLog = new ModBlockLog("sequoiaLog");
	    RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	    GameRegistry.registerBlock(sequoiaLog, ItemLog.class, renderItem, "sequoiaLog");
	    ModelBakery.addVariantName(Item.getItemFromBlock(sequoiaLog), new String[]{Main.MODID + ":" + "sequoiaLog"});*/
    	GameRegistry.registerBlock((Block)(blazeBrick = new BasicBlock("blazeBrick", Material.rock, 2F, 100F, "pickaxe", 1, "blazeBrick")).setLightLevel(12F), "blazeBrick");
    	GameRegistry.registerBlock((Block)(obsidianBrick = new BasicBlock("obsidianBrick", Material.rock, 2F, 50F, "pickaxe", 2, "obsidianBrick")), "obsidianBrick");
    	GameRegistry.registerBlock((Block)(netherIce = new BasicBlock("netherIce", Material.ice, 2F, 7F, "pickaxe", 0, "netherIce")).setStepSound(Block.soundTypeGlass), "netherIce");
    	GameRegistry.registerBlock(uraniumTorch = new ModBlockTorch(3F, "uraniumTorch"), "uraniumTorch");
    	GameRegistry.registerBlock(clayOre = new ModBlockOre("clayOre", Material.grass, Items.clay_ball, 1F, 30F, "shovel", 0, 0, 3, 6, "clayOre").setStepSound(Block.soundTypeGrass), "clayOre");
    	for (int i = 0; i < woolNames.length; i++)
    	{
    		GameRegistry.registerBlock((Block)(newWool[i] = new BasicBlock("wool" + woolNames[i], Material.cloth, 0.5F, 5F, "shears", 0, "wool" + woolNames[i]).setStepSound(Block.soundTypeCloth)), "wool" + woolNames[i]);
    	}
    	Blocks.bedrock.setHarvestLevel("pickaxe", 6);
    	Blocks.bedrock.setHardness(9F);
    	
    	for (int i = 0; i < gemNames.length; i++)
    	{
    		GameRegistry.registerBlock((Block)(gemBlocks[i] = new BasicBlock(gemNames[i] + "Block", Material.iron, 2F, 100F, "pickaxe", 2, gemNames[i] + "Block")), gemNames[i] + "Block");
    		//GameRegistry.registerBlock(gemOres[i] = new ModBlockOre(gemNames[i] + "Ore", Material.rock, ModItems.gems[i], 3.5F, 100F, "pickaxe", 1, 0, 1, 1, gemNames[i] + "Ore"), gemNames[i] + "Ore");
    	}
    	GameRegistry.registerBlock(rubyOre = new ModBlockOre("rubyOre", Material.rock, ModItems.gems[0], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "rubyOre"), "rubyOre");
    	GameRegistry.registerBlock(citrineOre = new ModBlockOre("citrineOre", Material.rock, ModItems.gems[1], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "citrineOre"), "citrineOre");
    	GameRegistry.registerBlock(topazOre = new ModBlockOre("topazOre", Material.rock, ModItems.gems[2], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "topazOre"), "topazOre");
    	GameRegistry.registerBlock(sapphireOre = new ModBlockOre("sapphireOre", Material.rock, ModItems.gems[3], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "sapphireOre"), "sapphireOre");
    	GameRegistry.registerBlock(amethystOre = new ModBlockOre("amethystOre", Material.rock, ModItems.gems[4], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "amethystOre"), "amethystOre");
    	slabs[0] = new ModBlockSlabHalf("woolSlab");
    	slabs[1] = new ModBlockSlabHalf("ironSlab");
    	slabs[2] = new ModBlockSlabHalf("goldSlab");
    	slabs[3] = new ModBlockSlabHalf("diamondSlab");
    	slabs[4] = new ModBlockSlabHalf("emeraldSlab");
    	slabs[5] = new ModBlockSlabHalf("sulphurSlab");
    	slabs[6] = new ModBlockSlabHalf("limestoneSlab");
    	slabs[7] = new ModBlockSlabHalf("uraniumSlab");
    	
    	doubleSlabs[0] = new ModBlockSlabDouble("double_woolSlab");
    	doubleSlabs[1] = new ModBlockSlabDouble("double_ironSlab");
    	doubleSlabs[2] = new ModBlockSlabDouble("double_goldSlab");
    	doubleSlabs[3] = new ModBlockSlabDouble("double_diamondSlab");
    	doubleSlabs[4] = new ModBlockSlabDouble("double_emeraldSlab");
    	doubleSlabs[5] = new ModBlockSlabDouble("double_sulphurSlab");
    	doubleSlabs[6] = new ModBlockSlabDouble("double_limestoneSlab");
    	doubleSlabs[7] = new ModBlockSlabDouble("double_uraniumSlab");
    	
    	slabs2[0] = new ModBlockSlabHalf("dirtSlab");
    	slabs2[1] = new ModBlockSlabHalf("grassSlab");
    	slabs2[2] = new ModBlockSlabHalf("leatherSlab");
    	slabs2[3] = new ModBlockSlabHalf("lapisSlab");
    	slabs2[4] = new ModBlockSlabHalf("obsidianSlab");
    	slabs2[5] = new ModBlockSlabHalf("mossSlab");
    	slabs2[6] = new ModBlockSlabHalf("endStoneBrickSlab");
    	slabs2[7] = new ModBlockSlabHalf("tadaniteSlab");
    	
    	doubleSlabs2[0] = new ModBlockSlabDouble("double_dirtSlab");
    	doubleSlabs2[1] = new ModBlockSlabDouble("double_grassSlab");
    	doubleSlabs2[2] = new ModBlockSlabDouble("double_leatherSlab");
    	doubleSlabs2[3] = new ModBlockSlabDouble("double_lapisSlab");
    	doubleSlabs2[4] = new ModBlockSlabDouble("double_obsidianSlab");
    	doubleSlabs2[5] = new ModBlockSlabDouble("double_mossSlab");
    	doubleSlabs2[6] = new ModBlockSlabDouble("double_endStoneBrickSlab");
    	doubleSlabs2[7] = new ModBlockSlabDouble("double_tadaniteSlab");
    	
    	for (int i = 0; i < 8; i++)
    	{
    		GameRegistry.registerBlock(slabs[i], ModItemBlockSlab.class, slabs[i].name, slabs[i], doubleSlabs[i], false);
    		GameRegistry.registerBlock(doubleSlabs[i], ModItemBlockSlab.class, doubleSlabs[i].name, slabs[i], doubleSlabs[i], false);
    		
    		GameRegistry.registerBlock(slabs2[i], ModItemBlockSlab.class, slabs2[i].name, slabs2[i], doubleSlabs2[i], false);
    		GameRegistry.registerBlock(doubleSlabs2[i], ModItemBlockSlab.class, doubleSlabs2[i].name, slabs2[i], doubleSlabs2[i], false);
    	}
    	acidFluid = AcidFluid.instance;
        FluidRegistry.registerFluid(acidFluid);
        acid = registerFluidBlock(acidFluid, new BlockAcidFluid(acidFluid), "acid");
        acidBucket = ModItems.registerItem((new ItemBucket(acid)).setContainerItem(Items.bucket), "acidBucket");
    }
    public static Block registerFluidBlock(Fluid fluid, BlockFluidBase fluidBlock, String name)
    {
        Block block = GameRegistry.registerBlock(fluidBlock, null, name);
        Main.proxy.registerFluidBlockRendering(block, name);
        fluid.setBlock(fluidBlock);
        return block;
    }
}