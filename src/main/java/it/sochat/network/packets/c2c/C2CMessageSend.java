package it.sochat.network.packets.c2c;

import it.sochat.objects.ByteBuffer;

import java.sql.Timestamp;

public class C2CMessageSend extends C2CPacket{

    private String message;
    private Timestamp sendTimestamp;

    public C2CMessageSend() {
        super.packetCategory = C2CMessageSend.class;
        super.packetType = C2CPacket.class;
        super.categoryID = C2CPacket.CATID;
        super.packetID = 1;
    }

    public C2CMessageSend(String message, Timestamp sendTimestamp) {
        this();
        this.message = message;
        this.sendTimestamp = sendTimestamp;
    }

    @Override
    public byte[] encode() {
        ByteBuffer buffer  = new ByteBuffer(this);
        buffer.add(message);
        buffer.add(sendTimestamp.getTime());
        return buffer.getByteArr();
    }

    @Override
    public void decode(byte[] buffer) {
        ByteBuffer buf = new ByteBuffer(this, buffer);
        this.message = buf.getString(0);
        this.sendTimestamp = new Timestamp(buf.getLong(0));
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
