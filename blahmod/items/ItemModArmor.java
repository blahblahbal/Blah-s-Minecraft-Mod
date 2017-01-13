package blahmod.items;

import blahmod.Main;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModArmor extends ItemArmor
{

    public ItemModArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType)
    {
        super(material, renderIndex, armorType);
        this.setCreativeTab(Main.blahTab);
        this.setUnlocalizedName(unlocalizedName);
    }
    @Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		if(player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null){
			ItemStack boots = player.getCurrentArmor(0);
			ItemStack legs = player.getCurrentArmor(1);
			ItemStack chest = player.getCurrentArmor(2);
			ItemStack helmet = player.getCurrentArmor(3);
			
			if(boots.getItem() == ModItems.tadaniteBoots &&
				legs.getItem() == ModItems.tadaniteLeggings &&
				chest.getItem() == ModItems.tadaniteChestplate &&
				helmet.getItem() == ModItems.tadaniteHelmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 100, 1));
				//player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 300, 1));
			}
			if(boots.getItem() == ModItems.obsidianBoots &&
				legs.getItem() == ModItems.obsidianLeggings &&
				chest.getItem() == ModItems.obsidianChestplate &&
				helmet.getItem() == ModItems.obsidianHelmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 100, 1));
			}
		}
	}
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Main.MODID + ":textures/armor/" + this.getArmorMaterial() + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }
}