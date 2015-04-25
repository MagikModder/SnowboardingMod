package com.sm.Client.Renderer;

import com.sm.Common.Entity.SnowBoard.EntitySnowboard;
import com.sm.Common.Entity.SnowBoard.Snowboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class RenderSnowboard extends Render
{

	private static final ResourceLocation minecartTextures = new ResourceLocation("sm:textures/entity/snowboard.png");
	private ModelBase modelSnowboard = new Snowboard();

	public RenderSnowboard(Minecraft minecraft)
	{
		
		this.shadowSize = 0.0F;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
	{
		this.doRender((EntitySnowboard) entity, x, y, z, p_76986_8_, partialTicks);
	}

	public void doRender(EntitySnowboard entity, double x, double y, double z, float p_76986_8_, float partialTicks)
	{
		
		if (entity.riddenByEntity != null)
		{
			if (entity.riddenByEntity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) entity.riddenByEntity;
				if (player.getUniqueID().toString().equals(Minecraft.getMinecraft().thePlayer.getUniqueID().toString()))
				{
					x = 0;
					y = 0;
					z = 0;
				}
				
			}
		}
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return minecartTextures;
	}
}