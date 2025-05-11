package com.andrew.andrewservercompat.entity.render;

import com.andrew.andrewservercompat.AndrewServerCompat;
import com.andrew.andrewservercompat.entity.EntityCandyWolf;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCandyWolf extends RenderWolf {
    public RenderCandyWolf(RenderManager p_i47187_1_) {
        super(p_i47187_1_);
    }

    public static final Factory FACTORY = new Factory();

    @Override
    protected ResourceLocation getEntityTexture(EntityWolf entity)
    {
        if (entity.isTamed())
        {
            return new ResourceLocation(AndrewServerCompat.MODID + ":textures/entity/candywolf_tame.png");
        }
        else
        {
            return entity.isAngry() ? new ResourceLocation(AndrewServerCompat.MODID + ":textures/entity/candywolf_angry.png") : new ResourceLocation(AndrewServerCompat.MODID + ":textures/entity/candywolf_neutral.png");
        }
    }

    public static class Factory implements IRenderFactory<EntityCandyWolf> {

        @Override
        public Render<? super EntityCandyWolf> createRenderFor(RenderManager manager) {
            return new RenderCandyWolf(manager);
        }
    }
}
