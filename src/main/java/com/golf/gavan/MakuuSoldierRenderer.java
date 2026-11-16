package com.golf.gavan;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MakuuSoldierRenderer extends HumanoidMobRenderer<MakuuSoldier, HumanoidModel<MakuuSoldier>> {
    private static final ResourceLocation TEXTURE =
        new ResourceLocation(GavanMod.MODID, "textures/entity/makuu_soldier.png");

    public MakuuSoldierRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.ZOMBIE)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MakuuSoldier entity) { return TEXTURE; }
}
