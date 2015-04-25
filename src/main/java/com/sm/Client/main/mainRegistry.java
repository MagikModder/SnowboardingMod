package com.sm.Client.main;
import com.sm.Client.utils.CreativeTabTC;
import com.sm.Client.utils.SpawnEvent;
import com.sm.Common.Entity.ski.EntitySki;
import com.sm.Common.Entity.snowBoard.EntitySnowboard;
import com.sm.Common.Items.Snowboarditems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = Strings.MODID, name = Strings.name, version = Strings.version)
public class mainRegistry
{
	
	public static CreativeTabs tabSM = new CreativeTabTC(CreativeTabs.getNextID(), "standard");
	
	@SidedProxy(clientSide = "com.sm.Client.main.ClientProxy", serverSide = "com.sm.Client.main.ServerProxy")
	public static ServerProxy proxy;
    
    @Instance(Strings.MODID)
    public static mainRegistry modInstance;
    
    @EventHandler
    public void PreLoad(FMLPreInitializationEvent PreEvent)
    {
    	Snowboarditems.mainRegistry();
    	MinecraftForge.EVENT_BUS.register(new SpawnEvent());
    	
    	
    
    	
    	
    	proxy.registerRenderThings();
    	
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    		
    	
    }
    
    public void preInit(FMLPreInitializationEvent event)
	{
    	EntitySnowboard.mainRegistry();
    	EntitySki.mainRegistry();
		
	}
}