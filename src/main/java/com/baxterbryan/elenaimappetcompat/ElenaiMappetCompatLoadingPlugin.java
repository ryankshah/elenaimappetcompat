package com.baxterbryan.elenaimappetcompat;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("ElenaiMappetCompat")
public class ElenaiMappetCompatLoadingPlugin implements IFMLLoadingPlugin {
    public static final Logger LOGGER = LogManager.getLogger("ElenaiMappetCompat");

    public ElenaiMappetCompatLoadingPlugin() {
        LOGGER.info("ElenaiMappetCompat Loading Plugin constructed");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.elenaimappetcompat.json");
        LOGGER.info("ElenaiMappetCompat mixins registered");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}