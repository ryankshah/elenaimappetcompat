package com.andrew.andrewservercompat.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class C2STransitCandyDimension implements IMessage {
    // A default constructor is always required
    public C2STransitCandyDimension(){}

    private int toSend;
    public C2STransitCandyDimension(int toSend) {
        this.toSend = toSend;
    }

    @Override public void toBytes(ByteBuf buf) {
        // Writes the int into the buf
        buf.writeInt(toSend);
    }

    @Override public void fromBytes(ByteBuf buf) {
        // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
        toSend = buf.readInt();
    }

    public static class TransitCandyDimensionMessageHandler implements IMessageHandler<C2STransitCandyDimension, IMessage>
    {
        @Override public IMessage onMessage(C2STransitCandyDimension message, MessageContext ctx) {
            // This is the player the packet was sent to the server from
            EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
            // The value that was sent
            int amount = message.toSend;
            serverPlayer.changeDimension(amount);
            // No response packet
            return null;
        }
    }
}