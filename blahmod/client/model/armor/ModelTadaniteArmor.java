package blahmod.client.model.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;

public class ModelTadaniteArmor extends ModelBiped {
    
    private ModelRenderer helm_base;
    private ModelRenderer helm_mask;
    private ModelRenderer shoe_right;
    private ModelRenderer shoe_left;
    private ModelRenderer shell_top;
    private ModelRenderer shell_base;
    private ModelRenderer float_right;
    private ModelRenderer floater_left;
    
    /**
     * defining every modelpart in here : size, texture place, rotation point, adding child
     * parts, ...
     */
    public ModelTadaniteArmor(float scale) {
    
        super(scale, 0, 128, 64);
        
        helm_base = new ModelRenderer(this, 0, 52);
        helm_base.addBox(-5F, -1.5F, -5F, 10, 2, 10);
        helm_base.setTextureSize(128, 64);
        
        helm_mask = new ModelRenderer(this, 0, 32);
        helm_mask.addBox(-4.5F, -8.5F, -4.5F, 9, 8, 9);
        helm_mask.setTextureSize(128, 64);
        
        shoe_right = new ModelRenderer(this, 40, 53);
        shoe_right.addBox(-2.5F, 6F, -2.5F, 5, 6, 5);
        shoe_right.setTextureSize(128, 64);
        
        shoe_left = new ModelRenderer(this, 40, 53);
        shoe_left.addBox(-2.5F, 6F, -2.5F, 5, 6, 5);
        shoe_left.setTextureSize(128, 64);
        
        shell_top = new ModelRenderer(this, 56, 0);
        shell_top.addBox(-5.5F, -2F, 2F, 11, 14, 4);
        shell_top.setTextureSize(128, 64);
        
        shell_base = new ModelRenderer(this, 56, 18);
        shell_base.addBox(-6F, -2.5F, 2F, 12, 15, 1);
        shell_base.setTextureSize(128, 64);
        
        float_right = new ModelRenderer(this, 18, 32);
        float_right.addBox(-1.5F, 2F, -3F, 3, 3, 1);
        float_right.setTextureSize(128, 64);
        
        floater_left = new ModelRenderer(this, 18, 32);
        floater_left.addBox(-1.5F, 2F, -3F, 3, 3, 1);
        floater_left.setTextureSize(128, 64);
        
        bipedHead.addChild(helm_base);
        bipedHead.addChild(helm_mask);
        
        bipedBody.addChild(shell_base);
        bipedBody.addChild(shell_top);
        
        bipedRightLeg.addChild(float_right);
        bipedLeftLeg.addChild(floater_left);
        
        bipedRightLeg.addChild(shoe_right);
        bipedLeftLeg.addChild(shoe_left);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();// enables alpha in png textures
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z) {
    
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}