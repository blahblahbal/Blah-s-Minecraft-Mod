package blahblahbal.blahmod.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class AcidFluid extends Fluid
{
    public static final String name = "acid";
    public static final AcidFluid instance = new AcidFluid();

    public AcidFluid()
    {
        super(name, new ResourceLocation("blahmod:blocks/acid_still"), new ResourceLocation("blahmod:blocks/acid_flowing"));
    }
}