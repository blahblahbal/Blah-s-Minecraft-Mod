package blahblahbal.blahmod.client.render.entity;

import org.lwjgl.opengl.GL11;

import blahblahbal.blahmod.Main;
import blahblahbal.blahmod.projectiles.EntityGemBolt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGemBolt extends Render
{
    public RenderGemBolt(RenderManager renderManagerIn, float scaleIn)
    {
        super(renderManagerIn);
    }
    /*@Override
    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
            this.doRender2((EntityGemBolt)entity, x, y, z, entityYaw, partialTicks);
    }*/
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(EntityGemBolt entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	this.bindEntityTexture(entity);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        int i = 0;
        float f = 0.0F;
        float f1 = 0.5F;
        float f2 = (float)(0 + i * 10) / 32.0F;
        float f3 = (float)(5 + i * 10) / 32.0F;
        float f4 = 0.0F;
        float f5 = 0.15625F;
        float f6 = (float)(5 + i * 10) / 32.0F;
        float f7 = (float)(10 + i * 10) / 32.0F;
        float f8 = 0.05625F;
        GlStateManager.enableRescaleNormal();

        GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(f8, f8, f8);
        GlStateManager.translate(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(f8, 0.0F, 0.0F);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(-7.0D, -2.0D, -2.0D).tex((double)f4, (double)f6).endVertex();
        worldrenderer.pos(-7.0D, -2.0D, 2.0D).tex((double)f5, (double)f6).endVertex();
        worldrenderer.pos(-7.0D, 2.0D, 2.0D).tex((double)f5, (double)f7).endVertex();
        worldrenderer.pos(-7.0D, 2.0D, -2.0D).tex((double)f4, (double)f7).endVertex();
        tessellator.draw();
        GL11.glNormal3f(-f8, 0.0F, 0.0F);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(-7.0D, 2.0D, -2.0D).tex((double)f4, (double)f6).endVertex();
        worldrenderer.pos(-7.0D, 2.0D, 2.0D).tex((double)f5, (double)f6).endVertex();
        worldrenderer.pos(-7.0D, -2.0D, 2.0D).tex((double)f5, (double)f7).endVertex();
        worldrenderer.pos(-7.0D, -2.0D, -2.0D).tex((double)f4, (double)f7).endVertex();
        tessellator.draw();

        for (int j = 0; j < 6; ++j)
        {
        	if (j < 4) GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
        	else if (j == 4) GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
        	else GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f8);
            worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
            worldrenderer.pos(-16.0D, -2.0D, 0.0D).tex((double)f, (double)f2).endVertex();
            worldrenderer.pos(16.0D, -2.0D, 0.0D).tex((double)f1, (double)f2).endVertex();
            worldrenderer.pos(16.0D, 2.0D, 0.0D).tex((double)f1, (double)f3).endVertex();
            worldrenderer.pos(-16.0D, 2.0D, 0.0D).tex((double)f, (double)f3).endVertex();
            tessellator.draw();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGemBolt entity)
    {
    	if (entity.bolt == 0) return new ResourceLocation(Main.MODID, "textures/entity/ruby.png");
    	else if (entity.bolt == 1) return new ResourceLocation(Main.MODID, "textures/entity/citrine.png");
    	else if (entity.bolt == 2) return new ResourceLocation(Main.MODID, "textures/entity/topaz.png");
    	else if (entity.bolt == 3) return new ResourceLocation(Main.MODID, "textures/entity/emerald.png");
    	else if (entity.bolt == 4) return new ResourceLocation(Main.MODID, "textures/entity/sapphire.png");
    	else if (entity.bolt == 5) return new ResourceLocation(Main.MODID, "textures/entity/amethyst.png");
    	else return new ResourceLocation(Main.MODID, "textures/entity/diamond.png");
    }
	@Override
	protected ResourceLocation getEntityTexture(Entity arg0) {
		return this.getEntityTexture((EntityGemBolt)arg0);
	}
}