package com.sm.Common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLifts extends Block
{
	public BlockLifts()
	{
		super(Material.wood);
		this.setHardness(20F);
		this.setResistance(150F);
		this.setHarvestLevel("pickaxe", 1);
	}
}
