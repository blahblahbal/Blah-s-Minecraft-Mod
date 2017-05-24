package blahblahbal.blahmod.projectiles;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityGemBolt extends EntityThrowable
{
	public int bolt;
	/*public int xTile = -1;
	public int yTile = -1;
	public int zTile = -1;
	public Block inTile;*/
	private Random r = new Random();
	public int ticksInAir;
	private double damage;
	private int knockbackStrength;
	public EntityGemBolt(World worldIn)
    {
        super(worldIn);
        //this.setSize(0.25F, 0.25F);
    }
	public EntityGemBolt(World worldIn, EntityLivingBase throwerIn, int ebt)
	{
		super(worldIn, throwerIn);
		bolt = ebt;
	}
	/**
     * Sets the amount of knockback the arrow applies when it hits a mob.
     */
    public void setKnockbackStrength(int knockbackStrengthIn)
    {
        this.knockbackStrength = knockbackStrengthIn;
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
					float x = 10F;
					EntityLivingBase b = (EntityLivingBase)arg0.entityHit;
					if (this.bolt == 0)  arg0.entityHit.setFire(7);
					else if (this.bolt == 2) b.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 140, 1));
					else if (this.bolt == 3) b.addPotionEffect(new PotionEffect(Potion.poison.getId(), 200, 0));
					else if (this.bolt == 4)
					{
						x += 2F;
						b.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 160, 2));
					}
					else if (this.bolt == 5) b.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 200, 2));
					else if (this.bolt == 6)
					{
						x += 8F;
					}
					b.attackEntityFrom(DamageSource.causeMobDamage(b), x);
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
	/*@Override
	public void onUpdate()
	{
		this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
		if (this.inGround)
		{
			this.setDead();
		}
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
        	if (movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityLivingBase)
        	{
        		if (this.knockbackStrength > 0)
        		{
        			float f7 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

        			if (f7 > 0.0F)
        			{
        				movingobjectposition.entityHit.addVelocity(this.motionX * (double)this.knockbackStrength * 0.6000000238418579D / (double)f7, 0.1D, this.motionZ * (double)this.knockbackStrength * 0.6000000238418579D / (double)f7);
        			}
        		}
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
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

        for (this.rotationPitch = (float)(MathHelper.atan2(this.motionY, (double)f1) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
        {
            ;
        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        float f2 = 0.99F;
        float f3 = this.getGravityVelocity();
        
        this.motionX *= (double)f2;
        this.motionY *= (double)f2;
        this.motionZ *= (double)f2;
        this.motionY -= (double)f3;
        this.setPosition(this.posX, this.posY, this.posZ);
	}*/
}
