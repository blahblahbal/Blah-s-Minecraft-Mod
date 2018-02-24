package blahblahbal.blahmod.client.render.entity;

import blahblahbal.blahmod.entity.EntityFrostblaze;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFrostblaze extends RenderLiving<EntityFrostblaze>
{
    private static final ResourceLocation blazeTextures = new ResourceLocation("blahmod:textures/entity/frostblaze.png");

    public RenderFrostblaze(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBlaze(), 0.5F);
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityFrostblaze entity) {
		// TODO Auto-generated method stub
		return blazeTextures;
	}
}