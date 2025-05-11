package com.andrew.andrewservercompat.entity.render;

import com.andrew.andrewservercompat.AndrewServerCompat;
import com.andrew.andrewservercompat.entity.EntityCandyCreeper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCandyCreeper extends RenderCreeper {
    public RenderCandyCreeper(RenderManager p_i47187_1_) {
        super(p_i47187_1_);
    }

    public static final Factory FACTORY = new Factory();

    @Override
    protected ResourceLocation getEntityTexture(EntityCreeper entity) {
        return new ResourceLocation(AndrewServerCompat.MODID + ":textures/entity/candycreeper.png");
    }

    public static class Factory implements IRenderFactory<EntityCandyCreeper> {

        @Override
        public Render<? super EntityCandyCreeper> createRenderFor(RenderManager manager) {
            return new RenderCandyCreeper(manager);
        }
    }
}
