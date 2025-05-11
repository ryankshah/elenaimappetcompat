package com.andrew.andrewservercompat;

import com.andrew.andrewservercompat.network.C2STransitCandyDimension;
import com.andrew.andrewservercompat.network.Networking;
import com.ochotonida.candymod.ModConfig;
import net.mcreator.moremobss.MoreMobss;
import net.mcreator.moremobss.entity.EntityGhost;
import net.mcreator.moremobss.entity.EntityGhoul;
import net.mcreator.moremobss.entity.EntityStoneGolem;
import net.mcreator.moremobss.entity.EntityTroll;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod(modid = AndrewServerCompat.MODID, name = AndrewServerCompat.NAME, version = AndrewServerCompat.VERSION,
        dependencies = "required:forge@[14.23.5.2847,);" +
                "required-after:candymod;required-after:transit;required-after:moremobss;"
)
public class AndrewServerCompat
{
    public static final String MODID = "andrewservercompat";
    public static final String NAME = "Andrew Server Compat";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @Mod.Instance
    public static AndrewServerCompat instance;

    public AndrewServerCompat() {
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(this);
        Networking.register();
        ModEntities.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
    }

    @EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        for(Supplier<EntityEntry> entity : MoreMobss.instance.elements.entities) {
            Biomes.HELL.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityGhost.EntityCustom.class);
            Biomes.DESERT.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityGhoul.EntityCustom.class);
            Biomes.DESERT_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityGhoul.EntityCustom.class);
            Biomes.EXTREME_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityStoneGolem.EntityCustom.class);
            Biomes.EXTREME_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.PLAINS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.FOREST.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.TAIGA.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.SWAMPLAND.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.ICE_MOUNTAINS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.DESERT_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.FOREST_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.TAIGA_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.EXTREME_HILLS_EDGE.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.BIRCH_FOREST.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.BIRCH_FOREST_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.ROOFED_FOREST.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.COLD_TAIGA.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.COLD_TAIGA_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.REDWOOD_TAIGA_HILLS.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.EXTREME_HILLS_WITH_TREES.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.SAVANNA.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
            Biomes.SAVANNA_PLATEAU.getSpawnableList(EnumCreatureType.MONSTER).removeIf(
                    entry -> entry.entityClass == EntityTroll.EntityCustom.class);
        }
    }

//    @SubscribeEvent
//    public void preventSpawns(LivingSpawnEvent.SpecialSpawn event) {
//        System.out.println("Special spawns event running!");
//        if(event.getEntityLiving() instanceof EntityGhost.EntityCustom
//                || event.getEntityLiving() instanceof EntityGhoul.EntityCustom
//                || event.getEntityLiving() instanceof EntityStoneGolem.EntityCustom
//                || event.getEntityLiving() instanceof EntityTroll.EntityCustom) {
////            ((EntityLivingBase)event.getSpawner().getSpawnerEntity()).setDead();
//            event.setResult(Event.Result.DENY);
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent
//    public void preventSpawns2(LivingSpawnEvent event) {
//        System.out.println("Special spawns event running!");
//        if(event.getEntityLiving() instanceof EntityGhost.EntityCustom
//                || event.getEntityLiving() instanceof EntityGhoul.EntityCustom
//                || event.getEntityLiving() instanceof EntityStoneGolem.EntityCustom
//                || event.getEntityLiving() instanceof EntityTroll.EntityCustom) {
//            event.setResult(Event.Result.DENY);
////            event.setCanceled(true);
//        }
//    }

    @SubscribeEvent
    public void playerDeath(PlayerEvent.PlayerRespawnEvent event) {
        if(!event.isEndConquered()) {
//            event.player.getServer().
            Networking.INSTANCE.sendToServer(new C2STransitCandyDimension(ModConfig.dimensionId));
        }
    }
}
