package com.redmod.client;

import com.redmod.RedMod;
import com.redmod.entity.RedButtonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;


public class RedButtonModel extends GeoModel<RedButtonEntity> {
	private static final Identifier MODEL = new Identifier(RedMod.MOD_ID, "geo/entity/red_button.geo.json");
	private static final Identifier TEXTURE = new Identifier(RedMod.MOD_ID, "textures/entity/red_button.png");
	private static final Identifier ANIMATION = new Identifier(RedMod.MOD_ID, "animations/entity/red_button.animation.json");

	@Override
	public Identifier getModelResource(RedButtonEntity animatable) {
		return MODEL;
	}

	@Override
	public Identifier getTextureResource(RedButtonEntity animatable) {
		return TEXTURE;
	}

	@Override
	public Identifier getAnimationResource(RedButtonEntity animatable) {
		return ANIMATION;
	}
}
