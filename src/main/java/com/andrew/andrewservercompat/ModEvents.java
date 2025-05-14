package com.andrew.andrewservercompat;

import com.andrew.andrewservercompat.network.C2STransitCandyDimension;
import com.andrew.andrewservercompat.network.Networking;
import com.ochotonida.candymod.ModConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber(modid = AndrewServerCompat.MODID)
public class ModEvents
{
    @SubscribeEvent
    public static void playerDeath(LivingDeathEvent event) {
        if(!event.getEntity().world.isRemote) {
            if(event.getEntity() instanceof EntityPlayer) {
                event.setCanceled(true);
                ((EntityPlayer) event.getEntity()).setHealth(((EntityPlayer) event.getEntity()).getMaxHealth());
                ((EntityPlayerMP)event.getEntity()).changeDimension(ModConfig.dimensionId, new CustomTeleporter(((EntityPlayerMP)event.getEntity()).getServerWorld()));
            }
        } else {
            event.setCanceled(true);
        }
    }

//    @SubscribeEvent
//    public static void playerDeath(PlayerEvent.PlayerRespawnEvent event) {
//        if(!event.isEndConquered()) {
////            event.player.getServer().
////            Networking.INSTANCE.sendToServer(new C2STransitCandyDimension(ModConfig.dimensionId));
//        }
//    }

    @SubscribeEvent
    public static void mobRegister(RegistryEvent.Register<EntityEntry> event) {
        ModEntities.init();
    }
}
