package com.sm.Common.Items;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.sm.Common.Blocks.Salt;
import com.sm.Client.main.Strings;
import com.sm.Client.main.mainRegistry;
import com.sm.Common.Blocks.Lifts;
import com.sm.Common.Items.Snowboard.itemSnowBoard;

import cpw.mods.fml.common.registry.GameRegistry;

public class Snowboarditems {
	public static void mainRegistry(){
		register();
		
		
		
	}

public static Item Snowboard;

public static Block Salt;

public static Item Ski;

public static Item FiberGlassIngot;

public static Block FiberGlass;



	public static void register()
	{
		
		
		registerBlock(Salt, "Salt");
		
		Snowboard = new itemSnowBoard();
		registerTheItem(Snowboard, "snowboard");
	
		Snowboard = new itemSnowBoard();
		Salt = new Salt();

	
	}
	public static void registerRecipes()
	{
		
	}
	private static void addSmelting()
	{
		GameRegistry.addSmelting(Items.brick, new ItemStack(Snowboarditems.Snowboard, 1), 5.0F);
		
	}

	@SuppressWarnings("unused")
	private static void registerTheItem(Item item, String name)
	{
		String unlocalizedName = name.toLowerCase().replaceAll(" ", "_").replaceAll("'", "");
		item.setUnlocalizedName(unlocalizedName);
		item.setTextureName("sm" + ":" + unlocalizedName);
		item.setCreativeTab(com.sm.Client.main.mainRegistry.tabSM);
		
		GameRegistry.registerItem(item, unlocalizedName);
	}
	private static void registerBlock(Block block, String name)
	{
		String unlocalizedName = name.toLowerCase().replaceAll(" ", "_").replaceAll("'", "");
		block.setBlockName(unlocalizedName);
		block.setBlockTextureName("sm"+ ":" + unlocalizedName);
		block.setCreativeTab(com.sm.Client.main.mainRegistry.tabSM);
		
		GameRegistry.registerBlock(block, unlocalizedName);
	}

}
