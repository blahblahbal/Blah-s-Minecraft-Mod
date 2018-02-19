package blahblahbal.blahmod.client.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import blahblahbal.blahmod.entity.EntityEskimoZombie;

@SideOnly(Side.CLIENT)
public class RenderEskimoZombie extends RenderBiped<EntityEskimoZombie> {

	private static final ResourceLocation zombieTexture = new ResourceLocation("blahmod:textures/entity/eskimoZombie.png");

	public RenderEskimoZombie(RenderManager manager)
	{
		super(manager, new ModelBiped(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerBipedArmor(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEskimoZombie par1EntityLiving)
	{
		return zombieTexture;
	}
}