// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package com.example.mod;
   
public class Barnacle extends EntityModel<Entity> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tentacle;
	private final ModelPart topLeftMouth;
	private final ModelPart topRightMouth;
	private final ModelPart bottomLeftMouth;
	private final ModelPart bottomRightMouth;
	private final ModelPart grass;
	public Barnacle(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.tentacle = root.getChild("tentacle");
		this.topLeftMouth = root.getChild("topLeftMouth");
		this.topRightMouth = root.getChild("topRightMouth");
		this.bottomLeftMouth = root.getChild("bottomLeftMouth");
		this.bottomRightMouth = root.getChild("bottomRightMouth");
		this.grass = root.getChild("grass");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 28).cuboid(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 9.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, -6.0F, 11.0F));

		ModelPartData tentacle = body.addChild("tentacle", ModelPartBuilder.create().uv(31, 62).cuboid(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 11.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData topLeftMouth = body.addChild("topLeftMouth", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, -4.0F, -22.0F, 6.0F, 6.0F, 22.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(4.0F, -6.0F, 11.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData topRightMouth = body.addChild("topRightMouth", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -4.0F, -22.0F, 6.0F, 6.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -6.0F, 11.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData bottomLeftMouth = body.addChild("bottomLeftMouth", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, 0.0F, -22.0F, 6.0F, 6.0F, 22.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -6.0F, 11.0F));

		ModelPartData bottomRightMouth = body.addChild("bottomRightMouth", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -22.0F, 6.0F, 6.0F, 22.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -6.0F, 11.0F));

		ModelPartData grass = body.addChild("grass", ModelPartBuilder.create().uv(0, 45).cuboid(-4.0F, -4.0F, 1.0F, 8.0F, 0.0F, 10.0F, new Dilation(0.0F))
		.uv(-6, 45).cuboid(-4.0F, 4.0F, 1.0F, 8.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 19.0F));

		ModelPartData grassRight_r1 = grass.addChild("grassRight_r1", ModelPartBuilder.create().uv(-4, 45).cuboid(2.0F, -4.0F, 20.0F, 8.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -19.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData grassLeft_r1 = grass.addChild("grassLeft_r1", ModelPartBuilder.create().uv(-2, 45).cuboid(-10.0F, -4.0F, 20.0F, 8.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -19.0F, 0.0F, 0.0F, 1.5708F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}