package it.sochat.network.packets.c2c;

import java.sql.Timestamp;

public class C2CMessageSend extends C2CPacket{

    private String message;
    private Timestamp sendTimestamp;

    public C2CMessageSend() {
        super.packetCategory = C2CMessageSend.class;
        super.packetType = C2CPacket.class;
    }

    public C2CMessageSend(String message, Timestamp sendTimestamp) {
        this();
        this.message = message;
        this.sendTimestamp = sendTimestamp;
    }

    @Override
    public byte[] encode() {

        return new byte[0];
    }

    @Override
    public void decode(byte[] buffer) {

    }

    @Override
    public String toString() {
        return "C2CMessageSend{" +
                "message='" + message + '\'' +
                ", sendTimestamp=" + sendTimestamp +
                ", packetType=" + packetType +
                ", packetCategory=" + packetCategory +
                '}';
    }
}
