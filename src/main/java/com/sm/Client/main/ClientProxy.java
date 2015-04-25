package com.sm.Client.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.sm.Client.renderer.RenderSnowboard;
import com.sm.Common.Entity.ski.EntitySki;
import com.sm.Common.Entity.snowBoard.EntitySnowboard;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends ServerProxy{

	public static Render Render = new RenderSnowboard(null);
	public void registerRenderThings(){
		

		EntityRegistry.registerGlobalEntityID(EntitySnowboard.class, "Snowboard", EntityRegistry.findGlobalUniqueEntityId());
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowboard.class, new RenderSnowboard(Minecraft.getMinecraft()));

		EntityRegistry.registerGlobalEntityID(EntitySnowboard.class, "ski", EntityRegistry.findGlobalUniqueEntityId());
		RenderingRegistry.registerEntityRenderingHandler(EntitySki.class, new RenderSnowboard(Minecraft.getMinecraft()));


	}

	



	@Override
	public World getClientWorld()
	{
		return Minecraft.getMinecraft().theWorld;
	}
}
