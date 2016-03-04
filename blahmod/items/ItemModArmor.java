package blahmod.items;

import blahmod.Main;
import blahmod.client.model.armor.ModelHandler;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModArmor extends ItemArmor
{

    public ItemModArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType)
    {
        super(material, renderIndex, armorType);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setUnlocalizedName(unlocalizedName);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel (EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
    
        ModelBiped armorModel = null;
        
        if (itemStack != null && itemStack.getItem() instanceof ItemModArmor) {
            
            armorModel = (armorSlot == 1 || armorSlot == 3) ? ModelHandler.runicScubaTop : ModelHandler.runicScubaBottom;
            updateModelForArmor(armorModel, armorSlot);
            //ModelHandler.updateModelToMatchEntity(armorModel, entityLiving);
        }
        
        return armorModel;
    }
    
    public static void updateModelForArmor (ModelBiped model, int armorSlot) {
        
        if (model != null) {
            
            model.bipedHead.showModel = armorSlot == 0;
            model.bipedHeadwear.showModel = armorSlot == 0;
            
            model.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
            
            model.bipedRightArm.showModel = armorSlot == 1;
            model.bipedLeftArm.showModel = armorSlot == 1;
            
            model.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
            model.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
        }
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Main.MODID + ":textures/armor/" + this.getArmorMaterial() + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }
}