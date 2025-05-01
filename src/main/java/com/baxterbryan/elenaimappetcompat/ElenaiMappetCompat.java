package com.baxterbryan.elenaimappetcompat;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ElenaiMappetCompat.MODID, name = ElenaiMappetCompat.NAME, version = ElenaiMappetCompat.VERSION,
        dependencies = "required:forge@[14.23.5.2847,);" + "required-after:mixinbooter@[10.6,);" +
                "required-after:mappet;required-after:elenaidodge2;"
) //, dependencies = ")
public class ElenaiMappetCompat
{
    public static final String MODID = "elenaimappetcompat";
    public static final String NAME = "Elenai-Mappet Compat";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
