package blahmod.projectiles;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityGemBolt extends EntityThrowable
{
	public EnumBoltType bolt;
	private Random r = new Random();
	public int ticksInAir;
	private double damage;
	public EntityGemBolt(World worldIn, EntityLivingBase throwerIn, EnumBoltType ebt)
	{
		super(worldIn, throwerIn);
		bolt = ebt;
	}

	@Override
	protected void onImpact(MovingObjectPosition arg0)
	{
		if (arg0.entityHit != null)
		{
			if (arg0.entityHit.isEntityAlive())
			{
				if (arg0.entityHit instanceof EntityLivingBase)
				{
					EntityLivingBase b = (EntityLivingBase)arg0.entityHit;
					if (this.bolt == EnumBoltType.RUBY)  arg0.entityHit.setFire(7);
					if (this.bolt == EnumBoltType.CITRINE) b.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 200, 1));
					if (this.bolt == EnumBoltType.TOPAZ) b.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 140, 1));
					if (this.bolt == EnumBoltType.EMERALD) b.addPotionEffect(new PotionEffect(Potion.poison.getId(), 200, 0));
					if (this.bolt == EnumBoltType.SAPPHIRE) b.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 160, 2));
					if (this.bolt == EnumBoltType.AMETHYST) b.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 200, 2));
					if (this.bolt == EnumBoltType.DIAMOND)
					{
						int rn = r.nextInt(6);
						if (rn == 0) arg0.entityHit.setFire(7);
						else if (rn == 1) b.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 200, 1));
						else if (rn == 2) b.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 200, 1));
						else if (rn == 3) b.addPotionEffect(new PotionEffect(Potion.poison.getId(), 200, 1));
						else if (rn == 4) b.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 200, 1));
						else if (rn == 5) b.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 200, 1));
					}
				}
			}
		}
	}
	public void setDamage(double damageIn)
    {
        this.damage = damageIn;
    }

    public double getDamage()
    {
        return this.damage;
    }
	
	@Override
	protected float getGravityVelocity()
    {
        return 0.01F;
    }
	@Override
	public void onUpdate()
	{
		if (this.inGround) this.setDead();
        else
        {
            ++this.ticksInAir;
        }

		if (this.ticksExisted >= 500) this.setDead();
        Vec3 vec3 = new Vec3(this.posX, this.posY, this.posZ);
        Vec3 vec31 = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31);
        vec3 = new Vec3(this.posX, this.posY, this.posZ);
        vec31 = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        if (movingobjectposition != null)
        {
            vec31 = new Vec3(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }

        if (!this.worldObj.isRemote)
        {
            Entity entity = null;
            List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            EntityLivingBase entitylivingbase = this.getThrower();

            for (int j = 0; j < list.size(); ++j)
            {
                Entity entity1 = (Entity)list.get(j);

                if (entity1.canBeCollidedWith() && (entity1 != entitylivingbase || this.ticksInAir >= 5))
                {
                    float f = 0.3F;
                    AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().expand((double)f, (double)f, (double)f);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);

                    if (movingobjectposition1 != null)
                    {
                        double d1 = vec3.squareDistanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D)
                        {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null)
            {
                movingobjectposition = new MovingObjectPosition(entity);
            }
        }

        if (movingobjectposition != null)
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.worldObj.getBlockState(movingobjectposition.getBlockPos()).getBlock() == Blocks.portal)
            {
                this.setPortal(movingobjectposition.getBlockPos());
            }
            else
            {
                this.onImpact(movingobjectposition);
            }
        }
	}
	
	public enum EnumBoltType
	{
		RUBY,
		CITRINE,
		TOPAZ,
		EMERALD,
		SAPPHIRE,
		AMETHYST,
		DIAMOND
	}
}
