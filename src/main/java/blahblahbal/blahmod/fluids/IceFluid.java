package blahblahbal.blahmod.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class IceFluid extends Fluid
{
    public static final String name = "ice";
    public static final IceFluid instance = new IceFluid();

    public IceFluid()
    {
        super(name, new ResourceLocation("blahmod:blocks/ice_still"), new ResourceLocation("blahmod:blocks/ice_flowing"));
    }
}