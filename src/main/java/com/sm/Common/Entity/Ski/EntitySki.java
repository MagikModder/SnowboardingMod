package com.sm.Common.Entity.Ski;

import com.sm.Common.Items.Snowboarditems;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class EntitySki extends EntityHorse
{
	public static void mainRegistry(){
		registerEntity();
	}

public static void registerEntity(){
		
		createEntity(EntitySki.class, "Ski", 0xDEF22C, 0x707070);
		
	}
public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
	int randomId = EntityRegistry.findGlobalUniqueEntityId();
	EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
	EntityRegistry.registerModEntity(entityClass, entityName, randomId, com.sm.Client.main.mainRegistry.modInstance, 64, 1, true);
	EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.forest);
	
	createEgg(randomId, solidColor, spotColor);
	
}
	

@SuppressWarnings("unchecked")
private static void createEgg(int randomId, int solidColor, int spotColor){
	EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	
}

	private boolean pushed = false;
	public double currentSpeed = 0.2;
	public double maxSpeed = 15.0;
	private boolean allowOnce = false;

	private boolean jumping = false;
	

	public EntitySki(World worldIn, String string)
	{
		super(worldIn);
		this.preventEntitySpawning = true;
		this.setSize(1.0F, 0.5F);
		this.createEntity(EntitySki.class, "Snowboard", 0xDEF22C, 0x707070);
		this.playSound(string, 1, 1);
		this.forceSpawn = true;
		this.dropItem(Snowboarditems.Snowboard, life);
	}

	
	

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	

	@Override
	public boolean isRiding()
	{
		return this.ridingEntity != null;
	}

	@Override
	protected void entityInit()
	{

	}

	@Override
	public double getMountedYOffset()
	{
		return 0.5F;
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entityIn)
	{
		return null;
	}

	
	@Override
	public boolean canBePushed()
	{
		return false;
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_)
	{
		if (this.riddenByEntity != null)
		{
			this.prevPosX = this.posX = p_180426_1_;
			this.prevPosY = this.posY = p_180426_3_;
			this.prevPosZ = this.posZ = p_180426_5_;
			this.rotationYaw = p_180426_7_;
			this.rotationPitch = p_180426_8_;
			this.setPosition(p_180426_1_, p_180426_3_, p_180426_5_);
		
		}
		else
		{
			
		}
	}

	
	private int life;

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		

		if (this.riddenByEntity instanceof EntityLivingBase)
		{
			EntityLivingBase entity = (EntityLivingBase) this.riddenByEntity;

			/** Handles pushing */
			if (entity.moveForward > 0 && this.isCollidedVertically && !isPushed() )
			{
				currentSpeed += 1.0D;
				if (currentSpeed > maxSpeed)
				{
					currentSpeed = maxSpeed;
				}
				pushed = true;
			}
			else if (entity.moveForward == 0.0)
			{
				pushed = false;
			}

						if (!jumping | allowOnce)
			{
				float f = this.riddenByEntity.rotationYaw;

				/** If grinding, set direction to direction of grinding. */
				
				this.motionX = -Math.sin((double) (f * (float) Math.PI / 180.0F)) * currentSpeed / 16D;
				this.motionZ = Math.cos((double) (f * (float) Math.PI / 180.0F)) * currentSpeed / 16D;
				allowOnce = false;
			}
		}
		else
		{
			/** If no player riding, make the board stop */
			this.motionX = 0.0D;
			this.motionZ = 0.0D;

		}}

	

		
	public void onUpdateServer()
	{
		life++;
		if (life >= 10000)
		{
			this.setDead();
		}
	}

	

	
	

	public int getDifferenceWithFix(int initAngle, int newAngle)
	{
		if (initAngle == 0 && newAngle == 270)
		{
			return 90;
		}
		if (initAngle == 270 && newAngle == 0)
		{
			return -90;
		}
		return initAngle - newAngle;
	}

	public void performStack()
	{
		if (!worldObj.isRemote && riddenByEntity != null)
		{
		
			if (riddenByEntity instanceof EntityLivingBase)
			{
				((EntityLivingBase) riddenByEntity).mountEntity((Entity) null);
			}
		}
	}

	public boolean isPushed()
	{
		return pushed;
	}

	public void setPushed(boolean pushed)
	{
		this.pushed = pushed;
	}

	public boolean isJumping()
	{
		return jumping;
	}

	public void setJumping(boolean jumping)
	{
		this.jumping = jumping;
	}

}