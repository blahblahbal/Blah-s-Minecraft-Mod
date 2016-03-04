package blahmod.client.model.armor;

import blahmod.client.model.armor.ModelTadaniteArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class ModelHandler {
    
    public static ModelBiped runicScubaTop = new ModelTadaniteArmor(0.7f);
    public static ModelBiped runicScubaBottom = new ModelTadaniteArmor(0.3f);
    
    /**
     * Updates a ModelBiped to reflect the characteristics of an EntityLivingBase. This will
     * set the model up with the appropriate information, so that it can mirror that of an
     * associated entity. Example: Armor model which is being worn by a player.
     * 
     * @param model: The model which you want to set up.
     * @param living: The entity which you want the new model to match.
     */
    public static void updateModelToMatchEntity (ModelBiped model, EntityLivingBase living) {
    
        if (model != null && living != null) {
            
            model.isSneak = living.isSneaking();
            model.isRiding = living.isRiding();
            model.isChild = living.isChild();
            model.heldItemRight = living.getHeldItem() != null ? 1 : 0;
            
            if (living instanceof EntityPlayer)
                model.aimedBow = ((EntityPlayer) living).getItemInUseDuration() > 2;
        }
    }
    
    /**
     * Updates the status of a model to reflect a piece of armor. This will turn on the
     * specific parts of a model, to correspond with the type of armor that is being worn. If a
     * helm is worn, the head and headwear models will be shown. If the armor is a chestplate,
     * the body and arms will be shown. If the armor is leggings, the body and legs will be
     * shown. If the armor is boots, only the legs will be shown.
     * 
     * @param model: The model which you would like to update for an armors slot position.
     * @param armorSlot: The armor slot which this piece of armor is being used. 0:helm
     *            1:chestplate 2:leggings 3:boots
     */
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
}