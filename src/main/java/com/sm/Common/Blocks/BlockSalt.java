package com.sm.Common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;

public class BlockSalt extends BlockFire
{
	public BlockSalt()
	{
		super();
		this.setHardness(20F);
		this.setResistance(150F);
		this.setHarvestLevel("pickaxe", 1);
		this.soundTypeMetal();
		this.setStepSound(soundTypeMetal);
		this.setBlockTextureName("Salt");
		this.quantityDropped(1, 0, null);
		this.canConnectRedstone(null, lightOpacity, lightValue, 0, lightValue);
	
	}

	private void soundTypeMetal() {
		// TODO Auto-generated method stub
		
	}
}
