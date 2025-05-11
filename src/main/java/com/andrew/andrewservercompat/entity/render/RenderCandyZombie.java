package com.andrew.andrewservercompat.entity.render;

import com.andrew.andrewservercompat.AndrewServerCompat;
import com.andrew.andrewservercompat.entity.EntityCandyWolf;
import com.andrew.andrewservercompat.entity.EntityCandyZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCandyZombie extends RenderZombie {
    public RenderCandyZombie(RenderManager p_i47187_1_) {
        super(p_i47187_1_);
    }

    public static final Factory FACTORY = new Factory();

    @Override
    protected ResourceLocation getEntityTexture(EntityZombie entity) {
        return new ResourceLocation(AndrewServerCompat.MODID + ":textures/entity/candyzombie.png");
    }

    public static class Factory implements IRenderFactory<EntityCandyZombie> {

        @Override
        public Render<? super EntityCandyZombie> createRenderFor(RenderManager manager) {
            return new RenderCandyZombie(manager);
        }
    }
}
