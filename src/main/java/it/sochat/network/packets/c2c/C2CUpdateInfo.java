package it.sochat.network.packets.c2c;

import it.sochat.objects.ByteBuffer;
import it.sochat.objects.UserInfo;

import java.awt.*;

public class C2CUpdateInfo extends C2CPacket {

    private UserInfo newInfo;
    private UserInfo oldInfo;

    public C2CUpdateInfo() {
        super.packetType = C2CUpdateInfo.class;
        super.packetCategory = C2CPacket.class;

        super.categoryID = C2CPacket.CATID;
        super.packetID = 2;
    }

    public C2CUpdateInfo(UserInfo newInfo, UserInfo oldInfo) {
        this();
        this.newInfo = newInfo;
        this.oldInfo = oldInfo;
    }

    @Override
    public byte[] encode() {
        ByteBuffer buffer = new ByteBuffer(this);
        buffer.add(newInfo.getUsername());
        buffer.add(oldInfo.getUsername());
        buffer.add(newInfo.getColor().getRGB());
        buffer.add(oldInfo.getColor().getRGB());
        return buffer.getByteArr();
    }

    @Override
    public void decode(byte[] buffer) {
        ByteBuffer buf = new ByteBuffer(this, buffer);
        this.newInfo = new UserInfo(buf.getString(0), new Color(buf.getInteger(0)));
        this.oldInfo = new UserInfo(buf.getString(1), new Color(buf.getInteger(1)));
    }
}
