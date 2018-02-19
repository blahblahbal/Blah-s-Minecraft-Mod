package blahblahbal.blahmod.entity;

import java.util.Calendar;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.ForgeModContainer;

import blahblahbal.blahmod.blocks.ModBlocks;

public class EntityEskimoZombie extends EntityZombie
{
	private static final UUID babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
	private static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost", 0.5D, 1);
	private static final UUID attackDamageBoostUUID = UUID.fromString("648D7064-6A60-4F59-8ABE-C2C23A6DD7A9");
	private static final AttributeModifier attackDamageBoost = new AttributeModifier(attackDamageBoostUUID, "Halloween Attack Damage Boost", 3.0D, 0);

	private float zombieWidth = -1.0F;
	private float zombieHeight;

	public EntityEskimoZombie(World par1World) {
		super(par1World);
		setSize(0.6F, 1.8F);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(42.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);

		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean isChild()
	{
		return getDataWatcher().getWatchableObjectByte(12) == 1;
	}

	@Override
	protected float getSoundPitch()
	{
		return isChild() ? rand.nextFloat() - rand.nextFloat() * 0.2F + 1.3F : 0.9F;
	}

	/**
	 * Set whether this zombie is a child.
	 */
	public void setChild(boolean par1)
	{
		getDataWatcher().updateObject(12, Byte.valueOf((byte)(par1 ? 1 : 0)));

		if (worldObj != null && !worldObj.isRemote)
		{
			IAttributeInstance attributeinstance = getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			attributeinstance.removeModifier(babySpeedBoostModifier);

			if (par1)
				attributeinstance.applyModifier(babySpeedBoostModifier);
		}

		setChildSize(par1);
	}

	@Override
	public int getTotalArmorValue()
	{
		int var1 = super.getTotalArmorValue() + 2;

		if (var1 > 20)
			var1 = 20;

		return var1;
	}

	public int getZombieType()
	{
		return dataWatcher.getWatchableObjectByte(14);
	}

	public void setZombieType(int par1)
	{
		dataWatcher.updateObject(14, Byte.valueOf((byte)par1));
	}

	@Override
	public void onLivingUpdate()
	{
		if(worldObj.isRemote)
			setChildSize(isChild());

		super.onLivingUpdate();
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		return super.attackEntityAsMob(par1Entity);
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.zombie.hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.zombie.death";
	}

	@Override
	protected void playStepSound(BlockPos pos, Block par4)
	{
		playSound("mob.zombie.step", 0.15F, 1.0F);
	}

	@Override
	protected Item getDropItem()
	{
		return Items.rotten_flesh;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	protected void addRandomDrop()
	{
		switch (rand.nextInt(2))
		{
		case 0:
			dropItem(Items.bone, 1);
			break;
		case 1:
			dropItem(new ItemStack(ModBlocks.netherSnow).getItem(), 1);
			break;
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if(par1NBTTagCompound.getBoolean("IsBaby"))
			setChild(true);;
			if (par1NBTTagCompound.hasKey("ZombieType"))
			{
				byte var2 = par1NBTTagCompound.getByte("ZombieType");
				setZombieType(var2);
			}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);

		if (isChild())
			par1NBTTagCompound.setBoolean("IsBaby", true);

		par1NBTTagCompound.setByte("ZombieType", (byte)getZombieType());
	}

	@Override
	protected void updateEquipmentIfNeeded(EntityItem itemEntity)
	{
	}

	@Override
	public void onKillEntity(EntityLivingBase par1EntityLivingBase)
	{
		super.onKillEntity(par1EntityLivingBase);

		if (worldObj.getDifficulty() == EnumDifficulty.NORMAL || worldObj.getDifficulty() == EnumDifficulty.HARD
				&& par1EntityLivingBase instanceof EntityZombie) {

			if (rand.nextBoolean())
				return;

			EntityEskimoZombie EntitysZombie = new EntityEskimoZombie(worldObj);
			EntitysZombie.copyLocationAndAnglesFrom(par1EntityLivingBase);
			worldObj.removeEntity(par1EntityLivingBase);
			EntitysZombie.onInitialSpawn(worldObj.getDifficultyForLocation(new BlockPos(EntitysZombie)), (IEntityLivingData)null);

			if (par1EntityLivingBase.isChild())
				EntitysZombie.setChild(true);

			worldObj.spawnEntityInWorld(EntitysZombie);
			worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, new BlockPos(posX, posY, posZ), 0);
		}
		else if (worldObj.getDifficulty() == EnumDifficulty.NORMAL || worldObj.getDifficulty() == EnumDifficulty.HARD
				&& par1EntityLivingBase instanceof EntityPlayer) {

			if (rand.nextBoolean())
				return;

			EntityEskimoZombie EntitysZombie = new EntityEskimoZombie(worldObj);
			EntitysZombie.copyLocationAndAnglesFrom(par1EntityLivingBase);
			worldObj.removeEntity(par1EntityLivingBase);
			EntitysZombie.onInitialSpawn(worldObj.getDifficultyForLocation(new BlockPos(EntitysZombie)), (IEntityLivingData)null);

			if (par1EntityLivingBase.isChild())
				EntitysZombie.setChild(true);

			worldObj.spawnEntityInWorld(EntitysZombie);
			worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, new BlockPos(posX, posY, posZ), 0);
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData par1EntityLivingData)
	{
		Object data = super.onInitialSpawn(difficulty, par1EntityLivingData);

		float f = difficulty.getClampedAdditionalDifficulty();
		setCanPickUpLoot(rand.nextFloat() < 0.55F * f);

		if (data == null)
			data = new EntityEskimoZombie.GroupData(worldObj.rand.nextFloat() < ForgeModContainer.zombieBabyChance, null);

		if (data instanceof EntityEskimoZombie.GroupData)
		{
			EntityEskimoZombie.GroupData groupdata = (EntityEskimoZombie.GroupData)data;

			if (groupdata.isBaby)
				setChild(true);
		}

		setEquipmentBasedOnDifficulty(difficulty);
		setEnchantmentBasedOnDifficulty(difficulty);

		if (getEquipmentInSlot(4) == null)
		{
			Calendar calendar = worldObj.getCurrentDate();

			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && rand.nextFloat() < 0.25F)
			{
				setCurrentItemOrArmor(4, new ItemStack(rand.nextFloat() < 0.1F ? Blocks.lit_pumpkin : Blocks.pumpkin));
				equipmentDropChances[4] = 0.0F;
			}
		}

		IAttributeInstance attribute = getEntityAttribute(SharedMonsterAttributes.attackDamage);
		Calendar calendar = worldObj.getCurrentDate();

		attribute.removeModifier(attackDamageBoost);

		if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
			attribute.applyModifier(attackDamageBoost);

		return (IEntityLivingData)data;
	}

	public void setChildSize(boolean p_146071_1_)
	{
		multiplySize(p_146071_1_ ? 0.5F : 1.0F);
	}

	class GroupData implements IEntityLivingData
	{
		public boolean isBaby;
		private GroupData(boolean par2)
		{
			isBaby = false;
			isBaby = par2;
		}

		GroupData(boolean par2, Object par4EntityZombieINNER1)
		{
			this(par2);
		}
	}
}