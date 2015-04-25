package com.sm.Common.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Lifts extends Block
{
	public Lifts()
	{
		super(Material.wood);
		this.setHardness(20F);
		this.setResistance(150F);
		this.setHarvestLevel("pickaxe", 1);
	}
}
