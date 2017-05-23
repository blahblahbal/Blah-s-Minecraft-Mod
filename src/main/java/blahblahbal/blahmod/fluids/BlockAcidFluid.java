package main.java.blahblahbal.blahmod.fluids;

import main.java.blahblahbal.blahmod.blocks.ModBlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockAcidFluid extends ModBlockFluid
{
    public BlockAcidFluid(Fluid fluid)
    {
        super(fluid.setDensity(1000).setViscosity(500).setLuminosity(7), Material.water, "acid");
        this.setLightOpacity(3);
        this.quantaPerBlock = 4;
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity)
    {
        if (entity instanceof EntityLivingBase)
        {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 60));
        }
    }
}