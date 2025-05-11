package com.andrew.andrewservercompat;

import com.andrew.andrewservercompat.entity.EntityCandyCreeper;
import com.andrew.andrewservercompat.entity.EntityCandySkeleton;
import com.andrew.andrewservercompat.entity.EntityCandyWolf;
import com.andrew.andrewservercompat.entity.EntityCandyZombie;
import com.andrew.andrewservercompat.entity.render.RenderCandyCreeper;
import com.andrew.andrewservercompat.entity.render.RenderCandySkeleton;
import com.andrew.andrewservercompat.entity.render.RenderCandyWolf;
import com.andrew.andrewservercompat.entity.render.RenderCandyZombie;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderHandler
{
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCandyCreeper.class, RenderCandyCreeper.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCandyWolf.class, RenderCandyWolf.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCandyZombie.class, RenderCandyZombie.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCandySkeleton.class, RenderCandySkeleton.FACTORY);
    }
}
