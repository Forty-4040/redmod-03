package com.redmod.client;

import com.redmod.entity.RedButtonEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

public class RedButtonRenderer extends GeoEntityRenderer<RedButtonEntity> {

	// ===== Положение шлема (можно подгонять) =====
	/** Размер шлема: 1.0 = целый блок. */
	private static final float HELMET_SCALE = 0.3f;
	/** Сдвиг шлема в блоках относительно точки helmet из Blockbench. */
	private static final float HELMET_OFFSET_X = 0.0f;
	private static final float HELMET_OFFSET_Y = 0.05f;
	private static final float HELMET_OFFSET_Z = 0.0f;

	public RedButtonRenderer(EntityRendererFactory.Context context) {
		super(context, new RedButtonModel());
		this.shadowRadius = 0.15f;
		this.addRenderLayer(new HelmetLayer(this));
	}

	/** Рисует надетый шлем в кости «helmet» модели. */
	private static class HelmetLayer extends BlockAndItemGeoLayer<RedButtonEntity> {
		HelmetLayer(GeoRenderer<RedButtonEntity> renderer) {
			super(renderer);
		}

		@Nullable
		@Override
		protected ItemStack getStackForBone(GeoBone bone, RedButtonEntity animatable) {
			if ("helmet".equals(bone.getName())) {
				ItemStack stack = animatable.getEquippedStack(EquipmentSlot.HEAD);
				return stack.isEmpty() ? null : stack;
			}
			return null;
		}

		@Override
		protected ModelTransformationMode getTransformTypeForStack(GeoBone bone, ItemStack stack, RedButtonEntity animatable) {
			return ModelTransformationMode.FIXED;
		}

		@Override
		protected void renderStackForBone(MatrixStack poseStack, GeoBone bone, ItemStack stack, RedButtonEntity animatable,
										  VertexConsumerProvider bufferSource, float partialTick, int packedLight, int packedOverlay) {
			poseStack.push();
			poseStack.translate(HELMET_OFFSET_X, HELMET_OFFSET_Y, HELMET_OFFSET_Z);
			poseStack.scale(HELMET_SCALE, HELMET_SCALE, HELMET_SCALE);
			super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
			poseStack.pop();
		}
	}
}
