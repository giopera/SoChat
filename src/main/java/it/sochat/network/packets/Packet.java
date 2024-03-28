package it.sochat.network.packets;

import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class Packet implements Serializable {

    protected Class<?> packetType;
    protected Class<?> packetCategory;

    public Class<?> getPacketType() {
        return packetType;
    }

    public Class<?> getPacketCategory() {
        return packetCategory;
    }

    public abstract byte[] encode();

    public abstract void decode(byte[] buffer);
}
