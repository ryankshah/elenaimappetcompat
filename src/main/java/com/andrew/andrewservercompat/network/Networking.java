package com.andrew.andrewservercompat.network;

import com.andrew.andrewservercompat.AndrewServerCompat;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Networking
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(AndrewServerCompat.MODID);

    public static void register() {
        INSTANCE.registerMessage(C2STransitCandyDimension.TransitCandyDimensionMessageHandler.class, C2STransitCandyDimension.class, 0, Side.SERVER);
    }
}