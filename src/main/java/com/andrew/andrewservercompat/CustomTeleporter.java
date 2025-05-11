package com.andrew.andrewservercompat;

import fr.cyrilneveu.transit.command.TransitCommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CustomTeleporter extends Teleporter {
    public CustomTeleporter(WorldServer worldIn) {
        super(worldIn);
    }

    public void teleport(Entity entity, WorldServer world) {
        if (entity.isEntityAlive()) {
            entity.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
            world.spawnEntity(entity);
            world.updateEntityWithOptionalForce(entity, false);
        }

        entity.setWorld(world);
    }

    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
        double x = entityIn.posX;
        double y = entityIn.posY;
        double z = entityIn.posZ;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for(int yy = (int)y; yy < this.world.getHeight(); ++yy) {
            pos.setPos(x, (double)yy, z);
            if (this.world.isAirBlock(pos) && this.world.isAirBlock(pos.add(0, 1, 0))) {
                y = (double)yy;
                break;
            }
        }

        if (entityIn instanceof EntityPlayerMP) {
            ((EntityPlayerMP)entityIn).connection.setPlayerLocation(x, y, z, entityIn.rotationYaw, entityIn.rotationPitch);
        } else {
            entityIn.setLocationAndAngles(x, y, z, entityIn.rotationYaw, entityIn.rotationPitch);
        }

        return true;
    }

    public void removeStalePortalLocations(long par1) {
    }

    public boolean makePortal(Entity entity) {
        return true;
    }
}