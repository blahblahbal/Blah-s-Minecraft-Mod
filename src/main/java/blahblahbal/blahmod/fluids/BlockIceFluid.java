package blahblahbal.blahmod.fluids;

import blahblahbal.blahmod.blocks.ModBlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockIceFluid extends ModBlockFluid
{
    public BlockIceFluid(Fluid fluid)
    {
        super(fluid.setDensity(1000).setViscosity(500).setLuminosity(15), Material.water, "ice");
        this.setLightOpacity(10);
        this.quantaPerBlock = 4;
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity)
    {
        if (entity instanceof EntityLivingBase)
        {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60));
        }
    }
}