package com.andrew.andrewservercompat.entity.render;

import com.andrew.andrewservercompat.AndrewServerCompat;
import com.andrew.andrewservercompat.entity.EntityCandySkeleton;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCandySkeleton extends RenderSkeleton {
    public RenderCandySkeleton(RenderManager p_i47187_1_) {
        super(p_i47187_1_);
    }

    public static final Factory FACTORY = new Factory();

    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return new ResourceLocation(AndrewServerCompat.MODID + ":textures/entity/candyskeleton.png");
    }

    public static class Factory implements IRenderFactory<EntityCandySkeleton> {

        @Override
        public Render<? super EntityCandySkeleton> createRenderFor(RenderManager manager) {
            return new RenderCandySkeleton(manager);
        }
    }
}
