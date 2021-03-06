package com.sm.Common.Entity.ski;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Ski extends ModelBase
{
	  //fields
	    ModelRenderer Board;
	    ModelRenderer Shape2;
	    ModelRenderer Shape3;
	    ModelRenderer Shape4;
	    ModelRenderer Shape5;
	  
	  public Ski()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      Board = new ModelRenderer(this, 0, 0);
	      Board.addBox(0F, 0F, 0F, 16, 1, 4);
	      Board.setRotationPoint(-8F, 23F, -2F);
	      Board.setTextureSize(64, 32);
	      Board.mirror = true;
	      setRotation(Board, 0F, 0F, 0F);
	      Shape2 = new ModelRenderer(this, 0, 0);
	      Shape2.addBox(0F, 0F, 0F, 1, 1, 4);
	      Shape2.setRotationPoint(8F, 22F, -2F);
	      Shape2.setTextureSize(64, 32);
	      Shape2.mirror = true;
	      setRotation(Shape2, 0F, 0F, 0F);
	      Shape3 = new ModelRenderer(this, 0, 0);
	      Shape3.addBox(0F, 0F, 0F, 1, 1, 4);
	      Shape3.setRotationPoint(-9F, 22F, -2F);
	      Shape3.setTextureSize(64, 32);
	      Shape3.mirror = true;
	      setRotation(Shape3, 0F, 0F, 0F);
	      Shape4 = new ModelRenderer(this, 0, 0);
	      Shape4.addBox(0F, 0F, 0F, 1, 2, 4);
	      Shape4.setRotationPoint(3F, 22.6F, -2F);
	      Shape4.setTextureSize(64, 32);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0F, 0F);
	      Shape5 = new ModelRenderer(this, 0, 0);
	      Shape5.addBox(0F, 0F, 0F, 1, 2, 4);
	      Shape5.setRotationPoint(-3F, 22.6F, -2F);
	      Shape5.setTextureSize(64, 32);
	      Shape5.mirror = true;
	      setRotation(Shape5, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    Board.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape4.render(f5);
	    Shape5.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	  }

	}
