package com.andrew.andrewservercompat;

import com.andrew.andrewservercompat.entity.EntityCandyCreeper;
import com.andrew.andrewservercompat.entity.EntityCandySkeleton;
import com.andrew.andrewservercompat.entity.EntityCandyWolf;
import com.andrew.andrewservercompat.entity.EntityCandyZombie;
import com.andrew.andrewservercompat.entity.render.RenderCandyCreeper;
import com.andrew.andrewservercompat.entity.render.RenderCandySkeleton;
import com.andrew.andrewservercompat.entity.render.RenderCandyWolf;
import com.andrew.andrewservercompat.entity.render.RenderCandyZombie;
import com.ochotonida.candymod.ModBiomes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {

    public static void init() {
        // Every entities in our mod has an ID (local to this mod)
        int id = 1;
        EntityRegistry.registerModEntity(new ResourceLocation(AndrewServerCompat.MODID +":candycreeper"), EntityCandyCreeper.class, "candycreeper", id++, AndrewServerCompat.instance, 64, 3, true, 0xedb072, 0xb6567e);
        EntityRegistry.registerModEntity(new ResourceLocation(AndrewServerCompat.MODID +":candywolf"), EntityCandyWolf.class, "candywolf", id++, AndrewServerCompat.instance, 64, 3, true, 0xeab845, 0x65a8d1);
        EntityRegistry.registerModEntity(new ResourceLocation(AndrewServerCompat.MODID +":candyzombie"), EntityCandyZombie.class, "candyzombie", id++, AndrewServerCompat.instance, 64, 3, true, 0xe28a6c, 0x5f8858);
        EntityRegistry.registerModEntity(new ResourceLocation(AndrewServerCompat.MODID +":candyskeleton"), EntityCandySkeleton.class, "candyskeleton", id++, AndrewServerCompat.instance, 64, 3, true, 0xa2c5d1, 0x993134);

        // We want our mob to spawn in Plains and ice plains biomes. If you don't add this then it will not spawn automatically
        // but you can of course still make it spawn manually
        EntityRegistry.addSpawn(EntityCandyCreeper.class, 10, 1, 2, EnumCreatureType.MONSTER, ModBiomes.BIOME_CHOCOLATE, ModBiomes.BIOME_COTTON_CANDY, ModBiomes.BIOME_GUMMY);
        EntityRegistry.addSpawn(EntityCandyWolf.class, 10, 1, 4, EnumCreatureType.CREATURE, ModBiomes.BIOME_CHOCOLATE, ModBiomes.BIOME_COTTON_CANDY, ModBiomes.BIOME_GUMMY);
        EntityRegistry.addSpawn(EntityCandyZombie.class, 10, 1, 3, EnumCreatureType.MONSTER, ModBiomes.BIOME_CHOCOLATE, ModBiomes.BIOME_COTTON_CANDY, ModBiomes.BIOME_GUMMY);
        EntityRegistry.addSpawn(EntityCandySkeleton.class, 10, 1, 2, EnumCreatureType.MONSTER, ModBiomes.BIOME_CHOCOLATE, ModBiomes.BIOME_COTTON_CANDY, ModBiomes.BIOME_GUMMY);

        // This is the loot table for our mob
//        LootTableList.register(EntityCreeperWolf.LOOT);
    }

    private static Biome getRegisteredBiome(String id)
    {
        Biome biome = Biome.REGISTRY.getObject(new ResourceLocation(id));

        if (biome == null)
        {
            throw new IllegalStateException("Invalid Biome requested: " + id);
        }
        else
        {
            return biome;
        }
    }
}