package blahblahbal.blahmod.blocks;

import org.apache.commons.lang3.tuple.ImmutablePair;

import static blahblahbal.blahmod.items.ModItems.acidBucket;
import static blahblahbal.blahmod.items.ModItems.iceBucket;

import blahblahbal.blahmod.Main;
import blahblahbal.blahmod.fluids.AcidFluid;
import blahblahbal.blahmod.fluids.BlockAcidFluid;
import blahblahbal.blahmod.fluids.BlockIceFluid;
import blahblahbal.blahmod.fluids.IceFluid;
import blahblahbal.blahmod.items.ItemDiamondDoor;
import blahblahbal.blahmod.items.ItemLog;
import blahblahbal.blahmod.items.ModItemBlockSlab;
import blahblahbal.blahmod.items.ModItemSlab;
import blahblahbal.blahmod.items.ModItems;
import blahblahbal.blahmod.items.itemBlocks.ItemCatalyzerBlock;
import blahblahbal.blahmod.items.itemBlocks.ItemSmelteryBlock;
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
import net.minecraft.item.ItemDoor;
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
	public static Block iceFire;
	public static Block netherCorePortal;
	public static Block netherFrost;
	public static Block netherSnow;
	public static Block frostBrick;
	public static Block chiseledBlackSandstone;
	public static ModBlockPalmSapling palmSapling;
	public static ModBlockLog sequoiaLog;
	public static ModBlockLeaves sequoiaLeaves;
	public static ModBlockPalmLog palmLog;
	public static ModBlockCedarLog cedarLog;
	public static BlockCedarLeaves cedarLeaves;
	public static ModBlockCedarSapling cedarSapling;
	public static ModBlockDreadSapling dreadSapling;
	public static BlockPalmLeaves palmLeaves;
	public static ModBlockGlass reinforcedGlass;
	public static Block lantern;
	public static Block lanternFloor;
	public static Block zirconOre;
	public static Block zirconBlock;
	public static Block imperviousBrick;
	public static Block blackSand;
	public static Block blackSandstone;
	public static Fluid acidFluid;
	public static Fluid iceFluid;
	public static BlockInventoryFurnace tadaniteSmeltery;
	public static BlockCoconut groundCoconut;
	public static BlockCoconut coconut;
	public static Block acid;
	public static Block moltenIce;
	//public static ModBlockPortal corePortal;
	public static Block magma;
	public static Block netherIceBrick;
	public static Block dreadSandstone;
	public static Block tropicStone;
	public static Block tropicCobblestone;
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
	public static Block palmPlanks;
	public static Block cedarPlanks;
	public static Block obsidianBrick;
	public static Block netherIce;
	public static Block amethystOre;
	public static Block citrineOre;
	public static Block topazOre;
	public static Block sapphireOre;
	public static Block rubyOre;
	public static Block tadanite;
	public static Block tropicMud;
	public static Block deadPlanks;
	public static BlockDiamondDoor diamondDoor;
	public static BlockDiamondDoor cobbleDoor;
	public static BlockDiamondDoor goldDoor;
	public static BlockDiamondDoor lumiteDoor;
	public static BlockDiamondDoor palmDoor;
	public static BlockDiamondDoor sequoiaDoor;
	public static BlockDiamondDoor cedarDoor;
	public static BlockDiamondDoor dreadDoor;
	public static Block ironOre;
	public static Block coalOre;
	public static Block goldOre;
	public static Block rubyOreTrop;
	public static BlockSeashell seashell;
	public static BlockLargeSeashell largeSeashell;
	public static Block dreadRock;
	public static Block dreadSand;
	public static ModBlockDreadLog dreadLog;
    public static Block leatherBlock;
    public static Block magmaCreamBlock;
    public static Block enderPearlBlock;
    public static Block tadaniteOre;
    public static Block limestoneOre;
    public static Block limestoneBlock;
    public static Block cement;
    public static Block sulphurOre;
    public static Block sulphurOre2;
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
    public static Block flintBlock;
    public static Block chiseledDreadSandstone;
    public static ModBlockFence palmFence;
    public static ModBlockFence sequoiaFence;
    public static ModBlockFence cedarFence;
    public static ModBlockFence dreadFence;
    
    public static ModBlockFenceGate palmFenceGate;
    public static ModBlockFenceGate sequoiaFenceGate;
    public static ModBlockFenceGate cedarFenceGate;
    public static ModBlockFenceGate dreadFenceGate;
    
    public static ModBlockWall petrifiedWoodWall;
    public static ModBlockStairs palmStairs;
    public static ModBlockStairs cedarStairs;
    public static ModBlockStairs sequoiaStairs;
    public static ModBlockStairs dreadStairs;
    public static ModBlockStairs petrifiedWoodStairs;
    public static ModBlockStairs netherIceBrickStairs;
    public static ModBlockStairs cementStairs;
    public static ModBlockStairs tropicStoneBrickStairs;
    public static ModBlockSlab[] slabs = new ModBlockSlab[8];
    public static ModBlockSlab[] doubleSlabs = new ModBlockSlab[8];
    public static ModBlockSlab[] slabs2 = new ModBlockSlab[8];
    public static ModBlockSlab[] doubleSlabs2 = new ModBlockSlab[8];
    public static ModBlockSlab[] woodSlabs = new ModBlockSlab[7];
    public static ModBlockSlab[] doubleWoodSlabs = new ModBlockSlab[7];
    public static Block petrifiedWood;
    public static Block blazeBrick;
    public static Block tropicStoneBrick;
    
    public static void createBlocks()
    {
    	GameRegistry.registerBlock((Block)(saltrock = new BasicBlock("saltrock", Material.rock, 1.5F, 10F, "pickaxe", 0, "saltrock")), "saltrock");
    	GameRegistry.registerBlock((Block)(chiseledBlackSandstone = new BasicBlock("chiseledBlackSandstone", Material.rock, 1.5F, 10F, "pickaxe", 0, "chiseledBlackSandstone")), "chiseledBlackSandstone");
    	GameRegistry.registerBlock((Block)(frostBrick = new BasicBlock("frostBrick", Material.rock, 1.5F, 10F, "pickaxe", 0, "frostBrick")), "frostBrick");
    	GameRegistry.registerBlock((Block)(netherFrost = new BasicBlock("netherFrost", Material.rock, 1.5F, 10F, "pickaxe", 0, "netherFrost")), "netherFrost");
    	GameRegistry.registerBlock((Block)(netherSnow = new BasicBlock("netherSnow", Material.sand, 1.5F, 10F, "shovel", 0, "netherSnow")), "netherSnow");
    	GameRegistry.registerBlock((BlockNetherCorePortal)(netherCorePortal = new BlockNetherCorePortal("ncportal").setUnlocalizedName("ncportal")), "ncportal");
    	GameRegistry.registerBlock((BlockIceFlame)(iceFire = new BlockIceFlame().setUnlocalizedName("iceFire")), "iceFire");
    	GameRegistry.registerBlock((Block)(magma = new BasicBlock("magma", Material.rock, 1.5F, 10F, "pickaxe", 1, "magma")), "magma");
    	GameRegistry.registerBlock((Block)(dreadSand = new BasicBlock("dreadSand", Material.sand, 1.5F, 10F, "shovel", 0, "dreadSand")).setStepSound(Block.soundTypeSand), "dreadSand");
    	GameRegistry.registerBlock((Block)(dreadRock = new BasicBlock("dreadRock", Material.rock, 1.5F, 10F, "pickaxe", 0, "dreadRock")), "dreadRock");
    	GameRegistry.registerBlock((Block)(dreadSandstone = new BasicBlock("dreadSandstone", Material.rock, 1.5F, 10F, "pickaxe", 1, "dreadSandstone")), "dreadSandstone");
    	GameRegistry.registerBlock((Block)(tropicStoneBrick = new BasicBlock("tropicStoneBrick", Material.rock, 1.5F, 10F, "pickaxe", 1, "tropicStoneBrick")), "tropicStoneBrick");
    	GameRegistry.registerBlock((Block)(flintBlock = new BasicBlock("flintBlock", Material.iron, 1.5F, 10F, "pickaxe", 0, "flintBlock")), "flintBlock");
    	GameRegistry.registerBlock((Block)(polishedSaltrock = new BasicBlock("polishedSaltrock", Material.rock, 1.5F, 10F, "pickaxe", 1, "polishedSaltrock")), "polishedSaltrock");
    	//GameRegistry.registerBlock((Block)(lantern = new BasicBlock("lantern", Material.rock, 1.5F, 10F, "pickaxe", 1, "lantern").setLightLevel(1F)), "lantern");
    	GameRegistry.registerBlock((Block)(magnetite = new BasicBlock("magnetite", Material.rock, 1.5F, 10F, "pickaxe", 0, "magnetite")), "magnetite");
    	GameRegistry.registerBlock((Block)(polishedMagnetite = new BasicBlock("polishedMagnetite", Material.rock, 1.5F, 10F, "pickaxe", 0, "polishedMagnetite")), "polishedMagnetite");
    	GameRegistry.registerBlock((Block)(igneousRock = new BasicBlock("igneousRock", Material.rock, 1.F, 10F, "pickaxe", 0, "igneousRock")), "igneousRock");
    	GameRegistry.registerBlock((Block)(polishedIgneousRock = new BasicBlock("polishedIgneousRock", Material.rock, 1.5F, 10F, "pickaxe", 0, "polishedIgneousRock")), "polishedIgneousRock");
    	GameRegistry.registerBlock((Block)(hardenedLava = new BasicBlock("hardenedLava", Material.rock, 1.5F, 10F, "pickaxe", 1, "hardenedLava")), "hardenedLava");
    	GameRegistry.registerBlock((Block)(tadanite = new BasicBlock("tadanite", Material.rock, 35F, 750F, "pickaxe", 2, "tadanite")), "tadanite");
    	GameRegistry.registerBlock((Block)(seashell = new BlockSeashell("seashell", Material.rock)), "seashell");
    	GameRegistry.registerBlock((Block)(lantern = new BlockLantern("lantern", Material.rock).setLightLevel(1F)), "lantern");
    	GameRegistry.registerBlock((Block)(lanternFloor = new BlockLantern("lanternFloor", Material.rock).setLightLevel(1F)), "lanternFloor");
    	GameRegistry.registerBlock(diamondDoor = new BlockDiamondDoor(Material.iron, "diamondDoor"), null, "diamondDoor_block");
    	ModItems.registerItem(ModItems.diamondDoorItem = new ItemDiamondDoor(diamondDoor), "diamondDoor");
    	GameRegistry.registerBlock(cobbleDoor = new BlockDiamondDoor(Material.rock, "cobbleDoor"), null, "cobbleDoor_block");
    	ModItems.registerItem(ModItems.cobbleDoorItem = new ItemDiamondDoor(cobbleDoor), "cobbleDoor");
    	GameRegistry.registerBlock(goldDoor = new BlockDiamondDoor(Material.iron, "goldDoor"), null, "goldDoor_block");
    	ModItems.registerItem(ModItems.goldDoorItem = new ItemDiamondDoor(goldDoor), "goldDoor");
    	GameRegistry.registerBlock(lumiteDoor = new BlockDiamondDoor(Material.iron, "lumiteDoor"), null, "lumiteDoor_block");
    	ModItems.registerItem(ModItems.lumiteDoorItem = new ItemDiamondDoor(lumiteDoor), "lumiteDoor");
    	GameRegistry.registerBlock(palmDoor = new BlockDiamondDoor(Material.wood, "palmDoor"), null, "palmDoor_block");
    	ModItems.registerItem(ModItems.palmDoorItem = new ItemDiamondDoor(palmDoor), "palmDoor");
    	GameRegistry.registerBlock(sequoiaDoor = new BlockDiamondDoor(Material.wood, "sequoiaDoor"), null, "sequoiaDoor_block");
    	ModItems.registerItem(ModItems.sequoiaDoorItem = new ItemDiamondDoor(sequoiaDoor), "sequoiaDoor");
    	GameRegistry.registerBlock(cedarDoor = new BlockDiamondDoor(Material.wood, "cedarDoor"), null, "cedarDoor_block");
    	ModItems.registerItem(ModItems.cedarDoorItem = new ItemDiamondDoor(cedarDoor), "cedarDoor");
    	GameRegistry.registerBlock(dreadDoor = new BlockDiamondDoor(Material.wood, "dreadDoor"), null, "dreadDoor_block");
    	ModItems.registerItem(ModItems.dreadDoorItem = new ItemDiamondDoor(dreadDoor), "dreadDoor");
    	GameRegistry.registerBlock((Block)(largeSeashell = new BlockLargeSeashell("largeSeashell", Material.rock)), "largeSeashell");
    	GameRegistry.registerBlock(tadaniteOre = new ModBlockOre("tadaniteOre", Material.rock, ModItems.tadaniteShard, 40F, 2000F, "pickaxe", 4, 0, 1, 3, "tadaniteOre"), "tadaniteOre");
    	GameRegistry.registerBlock((Block)(leatherBlock = new BasicBlock("leatherBlock", Material.cake, 0.5F, 50F, "axe", 0, "leatherBlock")).setStepSound(Block.soundTypeCloth), "leatherBlock");
    	GameRegistry.registerBlock((Block)(limestoneBlock = new BasicBlock("limestoneBlock", Material.iron, 3F, 100F, "pickaxe", 1, "limestoneBlock")).setStepSound(Block.soundTypeMetal), "limestoneBlock");
    	GameRegistry.registerBlock((Block)(carrotBlock = new BasicBlock("carrotBlock", Material.cake, 0.5F, 30F, "axe", 0, "carrotBlock")).setStepSound(Block.soundTypeWood), "carrotBlock");
    	GameRegistry.registerBlock((Block)(quicksilverBlock = new BasicBlock("quicksilverBlock", Material.iron, 3F, 100F, "pickaxe", 1, "quicksilverBlock")).setStepSound(Block.soundTypeMetal), "quicksilverBlock");
    	GameRegistry.registerBlock((Block)(sulphurBlock = new BasicBlock("sulphurBlock", Material.iron, 3F, 200F, "pickaxe", 1, "sulphurBlock")).setStepSound(Block.soundTypeMetal), "sulphurBlock");
    	GameRegistry.registerBlock((Block)(lumiteBlock = new BasicBlock("lumiteBlock", Material.iron, 5F, 150F, "pickaxe", 1, "lumiteBlock")).setStepSound(Block.soundTypeMetal), "lumiteBlock");
    	GameRegistry.registerBlock((Block)(netherIceBrick = new BasicBlock("netherIceBrick", Material.rock, 8F, 150F, "pickaxe", 1, "netherIceBrick")).setStepSound(Block.soundTypeStone), "netherIceBrick");
    	GameRegistry.registerBlock((Block)(chiseledDreadSandstone = new BasicBlock("chiseledDreadSandstone", Material.rock, 2F, 30F, "pickaxe", 1, "chiseledDreadSandstone")).setStepSound(Block.soundTypeStone), "chiseledDreadSandstone");
    	GameRegistry.registerBlock(limestoneOre = new ModBlockOre("limestoneOre", Material.rock, ModItems.limestone, 3.5F, 100F, "pickaxe", 1, 0, 1, 2, "limestoneOre"), "limestoneOre");
    	GameRegistry.registerBlock((Block)(coconut = new BlockCoconut("coconut", Material.rock)), "coconut");
    	GameRegistry.registerBlock((Block)(groundCoconut = new BlockCoconut("coconutGround", Material.rock)), "coconutGround");
    	GameRegistry.registerBlock(coalOre = new ModBlockOre("coalOre", Material.rock, Items.coal, 3.5F, 10F, "pickaxe", 0, 0, 1, 1, "coalOre"), "coalOre");
    	GameRegistry.registerBlock((Block)(ironOre = new BasicBlock("ironOre", Material.rock, 1.5F, 10F, "pickaxe", 1, "ironOre")), "ironOre");
    	GameRegistry.registerBlock((Block)(goldOre = new BasicBlock("goldOre", Material.rock, 1.5F, 10F, "pickaxe", 2, "goldOre")), "goldOre");
    	GameRegistry.registerBlock(sulphurOre = new ModBlockOre("sulphurOre", Material.rock, ModItems.sulphur2, 3F, 200F, "pickaxe", 2, 0, 1, 2, "sulphurOre"), "sulphurOre");
    	GameRegistry.registerBlock(sulphurOre2 = new ModBlockOre("sulphurOre2", Material.rock, ModItems.sulphur2, 3F, 200F, "pickaxe", 2, 0, 1, 2, "sulphurOre2"), "sulphurOre2");
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
    	GameRegistry.registerBlock((Block)(palmPlanks = new BasicBlock("palmPlanks", Material.wood, 2F, 5F, "hand", 0, "palmPlanks")).setStepSound(Block.soundTypeWood), "palmPlanks");
    	GameRegistry.registerBlock((Block)(cedarPlanks = new BasicBlock("cedarPlanks", Material.wood, 2F, 5F, "hand", 0, "cedarPlanks")).setStepSound(Block.soundTypeWood), "cedarPlanks");
    	GameRegistry.registerBlock((Block)(deadPlanks = new BasicBlock("deadPlanks", Material.wood, 2F, 5F, "hand", 0, "deadPlanks")).setStepSound(Block.soundTypeWood), "deadPlanks");
		GameRegistry.registerBlock((Block)(prefabSapling = new ModBlockPrefabSapling("prefabSapling", 1)), "prefabSapling");
		GameRegistry.registerBlock((Block)(sequoiaSapling = new ModBlockSequoiaSapling("sequoiaSapling", 2)), "sequoiaSapling");
		GameRegistry.registerBlock((Block)(dreadSapling = new ModBlockDreadSapling("dreadSapling", 2)), "dreadSapling");
		GameRegistry.registerBlock((Block)(sequoiaLog = new ModBlockLog("sequoiaLog")), "sequoiaLog");
		GameRegistry.registerBlock((Block)(sequoiaLeaves = new ModBlockLeaves("sequoiaLeaves")), "sequoiaLeaves");
		GameRegistry.registerBlock((Block)(palmSapling = new ModBlockPalmSapling("palmSapling", 2)), "palmSapling");
		GameRegistry.registerBlock((Block)(cedarSapling = new ModBlockCedarSapling("cedarSapling", 2)), "cedarSapling");
		GameRegistry.registerBlock((Block)(palmLog = new ModBlockPalmLog("palmLog")), "palmLog");
		GameRegistry.registerBlock((Block)(palmLeaves = new BlockPalmLeaves("palmLeaves")), "palmLeaves");
		GameRegistry.registerBlock((Block)(cedarLog = new ModBlockCedarLog("cedarLog")), "cedarLog");
		GameRegistry.registerBlock((Block)(dreadLog = new ModBlockDreadLog("dreadLog")), "dreadLog");
		GameRegistry.registerBlock((Block)(cedarLeaves = new BlockCedarLeaves("cedarLeaves")), "cedarLeaves");
		GameRegistry.registerBlock((Block)(tadaniteSmeltery = new BlockInventoryFurnace()), ItemSmelteryBlock.class, "tadaniteSmeltery");
		GameRegistry.registerBlock((Block)(reinforcedGlass = new ModBlockGlass("reinforcedGlass", Material.glass, 1F, 8F, "pickaxe", 1, "reinforcedGlass")).setStepSound(Block.soundTypeGlass), "reinforcedGlass");
		GameRegistry.registerBlock((Block)(imperviousBrick = new BasicBlock("imperviousBrick", Material.rock, 1F, 8F, "pickaxe", 1, "imperviousBrick")), "imperviousBrick");
		GameRegistry.registerBlock((Block)(blackSand = new BasicBlock("blackSand", Material.sand, 0.5F, 0F, "Shovel", 1, "blackSand")).setStepSound(Block.soundTypeSand), "blackSand");
		GameRegistry.registerBlock((Block)(blackSandstone = new BasicBlock("blackSandstone", Material.rock, 1F, 8F, "pickaxe", 1, "blackSandstone")).setStepSound(Block.soundTypeStone), "blackSandstone");
		GameRegistry.registerBlock((Block)(tropicCobblestone = new BasicBlock("tropicCobblestone", Material.rock, 1F, 8F, "pickaxe", 1, "tropicCobblestone")).setStepSound(Block.soundTypeStone), "tropicCobblestone");
		GameRegistry.registerBlock((Block)(tropicMud = new BasicBlock("tropicMud", Material.clay, 0.5F, 0F, "shovel", 0, "tropicMud")).setStepSound(Block.soundTypeSand), "tropicMud");
		GameRegistry.registerBlock(tropicStone = new ModBlockOre("tropicStone", Material.rock, Item.getItemFromBlock(ModBlocks.tropicCobblestone), 1.5F, 10F, "pickaxe", 0, 0, 1, 1, "tropicStone"), "tropicStone");
		GameRegistry.registerBlock(cedarFence = new ModBlockFence(Material.wood, "cedarFence"), "cedarFence");
		GameRegistry.registerBlock(dreadFence = new ModBlockFence(Material.wood, "dreadFence"), "dreadFence");
		GameRegistry.registerBlock(sequoiaFence = new ModBlockFence(Material.wood, "sequoiaFence"), "sequoiaFence");
		GameRegistry.registerBlock(palmFence = new ModBlockFence(Material.wood, "palmFence"), "palmFence");
		GameRegistry.registerBlock(cedarFenceGate = new ModBlockFenceGate("cedarFenceGate"), "cedarFenceGate");
		GameRegistry.registerBlock(dreadFenceGate = new ModBlockFenceGate("dreadFenceGate"), "dreadFenceGate");
		GameRegistry.registerBlock(sequoiaFenceGate = new ModBlockFenceGate("sequoiaFenceGate"), "sequoiaFenceGate");
		GameRegistry.registerBlock(palmFenceGate = new ModBlockFenceGate("palmFenceGate"), "palmFenceGate");
		GameRegistry.registerBlock(petrifiedWoodWall = new ModBlockWall(petrifiedWood, "petrifiedWoodWall"), "petrifiedWoodWall");
		GameRegistry.registerBlock(petrifiedWoodStairs = new ModBlockStairs(petrifiedWood.getDefaultState(), "petrifiedWoodStairs"), "petrifiedWoodStairs");
		GameRegistry.registerBlock(cedarStairs = new ModBlockStairs(cedarPlanks.getDefaultState(), "cedarStairs"), "cedarStairs");
		GameRegistry.registerBlock(dreadStairs = new ModBlockStairs(deadPlanks.getDefaultState(), "dreadStairs"), "dreadStairs");
		GameRegistry.registerBlock(palmStairs = new ModBlockStairs(palmPlanks.getDefaultState(), "palmStairs"), "palmStairs");
		GameRegistry.registerBlock(sequoiaStairs = new ModBlockStairs(sequoiaPlanks.getDefaultState(), "sequoiaStairs"), "sequoiaStairs");
		GameRegistry.registerBlock(cementStairs = new ModBlockStairs(cement.getDefaultState(), "cementStairs"), "cementStairs");
		GameRegistry.registerBlock(tropicStoneBrickStairs = new ModBlockStairs(tropicStoneBrick.getDefaultState(), "tropicStoneBrickStairs"), "tropicStoneBrickStairs");
		GameRegistry.registerBlock(netherIceBrickStairs = new ModBlockStairs(netherIceBrick.getDefaultState(), "netherIceBrickStairs"), "netherIceBrickStairs");
		/*sequoiaLog = new ModBlockLog("sequoiaLog");
	    RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	    GameRegistry.registerBlock(sequoiaLog, ItemLog.class, renderItem, "sequoiaLog");
	    ModelBakery.addVariantName(Item.getItemFromBlock(sequoiaLog), new String[]{Main.MODID + ":" + "sequoiaLog"});*/
    	GameRegistry.registerBlock((Block)(blazeBrick = new BasicBlock("blazeBrick", Material.rock, 2F, 100F, "pickaxe", 1, "blazeBrick")).setLightLevel(1F), "blazeBrick");
    	GameRegistry.registerBlock((Block)(obsidianBrick = new BasicBlock("obsidianBrick", Material.rock, 2F, 50F, "pickaxe", 2, "obsidianBrick")), "obsidianBrick");
    	GameRegistry.registerBlock((Block)(netherIce = new BasicBlock("netherIce", Material.ice, 1.5F, 10F, "pickaxe", 0, "netherIce")).setStepSound(Block.soundTypeGlass), "netherIce");
    	GameRegistry.registerBlock(uraniumTorch = new ModBlockTorch(3F, "uraniumTorch"), "uraniumTorch");
    	GameRegistry.registerBlock(clayOre = new ModBlockOre("clayOre", Material.grass, Items.clay_ball, 1F, 30F, "Shovel", 0, 0, 3, 6, "clayOre").setStepSound(Block.soundTypeGrass), "clayOre");
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
    	GameRegistry.registerBlock((Block)(zirconBlock = new BasicBlock("zirconBlock", Material.iron, 2F, 100F, "pickaxe", 2, "zirconBlock")), "zirconBlock");
    	GameRegistry.registerBlock(rubyOre = new ModBlockOre("rubyOre", Material.rock, ModItems.gems[0], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "rubyOre"), "rubyOre");
    	
    	GameRegistry.registerBlock(zirconOre = new ModBlockOre("zirconOre", Material.rock, ModItems.zircon, 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "zirconOre"), "zirconOre");
    	
    	GameRegistry.registerBlock(citrineOre = new ModBlockOre("citrineOre", Material.rock, ModItems.gems[1], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "citrineOre"), "citrineOre");
    	GameRegistry.registerBlock(topazOre = new ModBlockOre("topazOre", Material.rock, ModItems.gems[2], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "topazOre"), "topazOre");
    	GameRegistry.registerBlock(sapphireOre = new ModBlockOre("sapphireOre", Material.rock, ModItems.gems[3], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "sapphireOre"), "sapphireOre");
    	GameRegistry.registerBlock(amethystOre = new ModBlockOre("amethystOre", Material.rock, ModItems.gems[4], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "amethystOre"), "amethystOre");
    	GameRegistry.registerBlock(rubyOreTrop = new ModBlockOre("rubyOreTrop", Material.rock, ModItems.gems[0], 2.5F, 100F, "pickaxe", 1, 0, 1, 2, "rubyOreTrop"), "rubyOreTrop");
    	slabs[0] = new ModBlockSlabHalf("woolSlab", Material.cloth);
    	slabs[1] = new ModBlockSlabHalf("ironSlab", Material.iron);
    	slabs[2] = new ModBlockSlabHalf("goldSlab", Material.iron);
    	slabs[3] = new ModBlockSlabHalf("diamondSlab", Material.iron);
    	slabs[4] = new ModBlockSlabHalf("emeraldSlab", Material.iron);
    	slabs[5] = new ModBlockSlabHalf("sulphurSlab", Material.iron);
    	slabs[6] = new ModBlockSlabHalf("limestoneSlab", Material.iron);
    	slabs[7] = new ModBlockSlabHalf("uraniumSlab", Material.iron);
    	
    	doubleSlabs[0] = new ModBlockSlabDouble("double_woolSlab", Material.cloth, slabs[0]);
    	doubleSlabs[1] = new ModBlockSlabDouble("double_ironSlab", Material.iron, slabs[1]);
    	doubleSlabs[2] = new ModBlockSlabDouble("double_goldSlab", Material.iron, slabs[2]);
    	doubleSlabs[3] = new ModBlockSlabDouble("double_diamondSlab", Material.iron, slabs[3]);
    	doubleSlabs[4] = new ModBlockSlabDouble("double_emeraldSlab", Material.iron, slabs[4]);
    	doubleSlabs[5] = new ModBlockSlabDouble("double_sulphurSlab", Material.iron, slabs[5]);
    	doubleSlabs[6] = new ModBlockSlabDouble("double_limestoneSlab", Material.iron, slabs[6]);
    	doubleSlabs[7] = new ModBlockSlabDouble("double_uraniumSlab", Material.iron, slabs[7]);
    	
    	slabs2[0] = new ModBlockSlabHalf("dirtSlab", Material.ground);
    	slabs2[1] = new ModBlockSlabHalf("grassSlab", Material.grass);
    	slabs2[2] = new ModBlockSlabHalf("leatherSlab", Material.cloth);
    	slabs2[3] = new ModBlockSlabHalf("lapisSlab", Material.iron);
    	slabs2[4] = new ModBlockSlabHalf("obsidianSlab", Material.rock);
    	slabs2[5] = new ModBlockSlabHalf("mossSlab", Material.rock);
    	slabs2[6] = new ModBlockSlabHalf("endStoneBrickSlab", Material.rock);
    	slabs2[7] = new ModBlockSlabHalf("tadaniteSlab", Material.iron);
    	
    	doubleSlabs2[0] = new ModBlockSlabDouble("double_dirtSlab", Material.ground, slabs2[0]);
    	doubleSlabs2[1] = new ModBlockSlabDouble("double_grassSlab", Material.grass, slabs2[1]);
    	doubleSlabs2[2] = new ModBlockSlabDouble("double_leatherSlab", Material.cloth, slabs2[2]);
    	doubleSlabs2[3] = new ModBlockSlabDouble("double_lapisSlab", Material.iron, slabs2[3]);
    	doubleSlabs2[4] = new ModBlockSlabDouble("double_obsidianSlab", Material.rock, slabs2[4]);
    	doubleSlabs2[5] = new ModBlockSlabDouble("double_mossSlab", Material.rock, slabs2[5]);
    	doubleSlabs2[6] = new ModBlockSlabDouble("double_endStoneBrickSlab", Material.rock, slabs2[6]);
    	doubleSlabs2[7] = new ModBlockSlabDouble("double_tadaniteSlab", Material.iron, slabs2[7]);
    	
    	woodSlabs[0] = new ModBlockSlabHalf("sequoiaSlab", Material.wood);
    	woodSlabs[1] = new ModBlockSlabHalf("palmSlab", Material.wood);
    	woodSlabs[2] = new ModBlockSlabHalf("cedarSlab", Material.wood);
    	woodSlabs[3] = new ModBlockSlabHalf("petrifiedWoodSlab", Material.rock);
    	woodSlabs[4] = new ModBlockSlabHalf("dreadSlab", Material.wood);
    	woodSlabs[5] = new ModBlockSlabHalf("dreadSandSlab", Material.rock);
    	woodSlabs[6] = new ModBlockSlabHalf("blackSandSlab", Material.rock);
    	
    	doubleWoodSlabs[0] = new ModBlockSlabDouble("double_sequoiaSlab", Material.wood, woodSlabs[0]);
    	doubleWoodSlabs[1] = new ModBlockSlabDouble("double_palmSlab", Material.wood, woodSlabs[1]);
    	doubleWoodSlabs[2] = new ModBlockSlabDouble("double_cedarSlab", Material.wood, woodSlabs[2]);
    	doubleWoodSlabs[3] = new ModBlockSlabDouble("double_petrifiedWoodSlab", Material.rock, woodSlabs[3]);
    	doubleWoodSlabs[4] = new ModBlockSlabDouble("double_dreadSlab", Material.wood, woodSlabs[4]);
    	doubleWoodSlabs[5] = new ModBlockSlabDouble("double_dreadSandSlab", Material.wood, woodSlabs[5]);
    	doubleWoodSlabs[6] = new ModBlockSlabDouble("double_blackSandSlab", Material.wood, woodSlabs[6]);
    	
    	for (int i = 0; i < 8; i++)
    	{
    		GameRegistry.registerBlock(slabs[i], ModItemBlockSlab.class, slabs[i].name, slabs[i], doubleSlabs[i], false);
    		GameRegistry.registerBlock(doubleSlabs[i], ModItemBlockSlab.class, doubleSlabs[i].name, slabs[i], doubleSlabs[i], false);
    		
    		GameRegistry.registerBlock(slabs2[i], ModItemBlockSlab.class, slabs2[i].name, slabs2[i], doubleSlabs2[i], false);
    		GameRegistry.registerBlock(doubleSlabs2[i], ModItemBlockSlab.class, doubleSlabs2[i].name, slabs2[i], doubleSlabs2[i], false);
    	}
    	for (int i = 0; i < 7; i++)
    	{
    		GameRegistry.registerBlock(woodSlabs[i], ModItemBlockSlab.class, woodSlabs[i].name, woodSlabs[i], doubleWoodSlabs[i], false);
    		GameRegistry.registerBlock(doubleWoodSlabs[i], ModItemBlockSlab.class, doubleWoodSlabs[i].name, woodSlabs[i], doubleWoodSlabs[i], false);
    	}
    	acidFluid = AcidFluid.instance;
        FluidRegistry.registerFluid(acidFluid);
        acid = registerFluidBlock(acidFluid, new BlockAcidFluid(acidFluid), "acid");
        acidBucket = ModItems.registerItem((new ItemBucket(acid)).setContainerItem(Items.bucket), "acidBucket");
        
        iceFluid = IceFluid.instance;
        FluidRegistry.registerFluid(iceFluid);
        moltenIce = registerFluidBlock(iceFluid, new BlockIceFluid(iceFluid), "ice");
        iceBucket = ModItems.registerItem((new ItemBucket(moltenIce)).setContainerItem(Items.bucket), "iceBucket");
        
    }
    public static Block registerFluidBlock(Fluid fluid, BlockFluidBase fluidBlock, String name)
    {
        Block block = GameRegistry.registerBlock(fluidBlock, null, name);
        Main.proxy.registerFluidBlockRendering(block, name);
        fluid.setBlock(fluidBlock);
        return block;
    }
}