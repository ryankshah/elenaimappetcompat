package com.baxterbryan.elenaimappetcompat.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    private static final Logger LOGGER = LogManager.getLogger("ElenaiMappetCompat");

    @Inject(method = "init", at = @At("HEAD"))
    private void onInit(CallbackInfo ci) {
        LOGGER.info("ElenaiMappetCompat mixin successfully applied to Minecraft!");
    }
}