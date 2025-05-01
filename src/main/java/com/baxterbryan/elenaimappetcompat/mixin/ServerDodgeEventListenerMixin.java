package com.baxterbryan.elenaimappetcompat.mixin;

import com.elenai.elenaidodge2.api.CheckFeatherEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = com.elenai.elenaidodge2.event.ServerDodgeEventListener.class, remap = false)
@Debug(export=true)
public class ServerDodgeEventListenerMixin
{
    @Redirect(
            method = "onServerDodge",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/fml/common/eventhandler/EventBus;post(Lnet/minecraftforge/fml/common/eventhandler/Event;)Z"
            )
    )
    private boolean redirectEventPost(EventBus eventBus, Event event) {
        if (event instanceof CheckFeatherEvent) {
            CheckFeatherEvent originalEvent = (CheckFeatherEvent)event;
            EntityPlayer player = originalEvent.getPlayer();
            CheckFeatherEvent newEvent = new CheckFeatherEvent(player);

            return eventBus.post(newEvent);
        }
        return eventBus.post(event);
    }
}