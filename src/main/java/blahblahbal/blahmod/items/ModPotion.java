package blahblahbal.blahmod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModPotion extends Potion
{
    public static ResourceLocation spelunkerPotionEffectTexture = new ResourceLocation("blahmod:textures/potions/status-icons.png");
    
    public ModPotion(int potionId, ResourceLocation location, boolean badEffect, int color)
    {
        super(potionId, location, badEffect, color);
        // status icon in position 2 row 0
        this.setIconIndex(1, 0);
    }
    
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getStatusIconIndex()
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(spelunkerPotionEffectTexture);
        return super.getStatusIconIndex();
    }

    @Override
    public boolean isReady(int duration, int amplifier)
    {
        return duration >= 1;
    }

}
