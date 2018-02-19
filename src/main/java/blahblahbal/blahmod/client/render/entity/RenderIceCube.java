package blahblahbal.blahmod.client.render.entity;

import blahblahbal.blahmod.entity.EntityIceCube;
import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderIceCube extends RenderLiving<EntityIceCube>
{
    private static final ResourceLocation magmaCubeTextures = new ResourceLocation("blahmod:textures/entity/icecube.png");

    public RenderIceCube(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelMagmaCube(), 0.25F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityIceCube entity)
    {
        return magmaCubeTextures;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityIceCube entitylivingbaseIn, float partialTickTime)
    {
        int i = entitylivingbaseIn.getSlimeSize();
        float f = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        float f2 = (float)i;
        GlStateManager.scale(f1 * f2, 1.0F / f1 * f2, f1 * f2);
    }
}