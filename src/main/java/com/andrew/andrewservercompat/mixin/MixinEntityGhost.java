package com.andrew.andrewservercompat.mixin;

import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.mcreator.moremobss.entity.EntityGhost;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mixin(EntityGhost.class)
public class MixinEntityGhost {

    /**
     * Modifies the lambda passed to the list.add() method to use a different entities name
     */
    @ModifyArg(
            method = "initElements",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;add(Ljava/lang/Object;)Z",
                    remap = false
            ),
            index = 0,
            remap = false
    )
    private Object modifyEntityRegistration(Object original) {
        // Cast to the correct type and wrap in our own lambda
        if (original instanceof Supplier) {
            @SuppressWarnings("unchecked")
            Supplier<EntityEntry> originalSupplier = (Supplier<EntityEntry>) original;

            // Return a new supplier that will modify the name when called
            return (Supplier<EntityEntry>) () -> {
                // First get the original EntityEntry that would be created
                EntityEntry originalEntry = originalSupplier.get();

                // If this is the first time it's called (during registration),
                // create a new EntityEntryBuilder with the modified name
                return EntityEntryBuilder.create()
                        .entity(EntityGhost.EntityCustom.class)
                        .id(new ResourceLocation("moremobss", "ghost"), 7)
                        .name("ghost-moremobss") // Changed name here
                        .tracker(64, 3, true)
                        .egg(-4934476, -3355444)
                        .build();
            };
        }

        // If not a supplier, return the original object
        return original;
    }
}