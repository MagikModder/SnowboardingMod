package com.sm.Client.utils;

import com.sm.Common.Items.Snowboarditems;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
public class CreativeTabTC extends CreativeTabs {
 
    public CreativeTabTC(int id, String unlocalizedName) {
 
        super(id, unlocalizedName);
    }
 
   

	@Override
	public Item getTabIconItem() {
		
		return Snowboarditems.Snowboard;
	}
}