package com.andrew.andrewservercompat;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = AndrewServerCompat.MODID, value = Side.CLIENT)
public class ASCClient
{
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModEntities.initModels();
    }
}
