package it.sochat.network.packets;

import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class Packet implements Serializable {

    protected Class<?> packetType;
    protected Class<?> packetCategory;

    protected byte packetID;

    protected byte categoryID;

    public Class<?> getPacketType() {
        return packetType;
    }

    public Class<?> getPacketCategory() {
        return packetCategory;
    }

    public byte getPacketID() {
        return packetID;
    }

    public byte getCategoryID() {
        return categoryID;
    }

    public abstract byte[] encode();

    public abstract void decode(byte[] buffer);
}
