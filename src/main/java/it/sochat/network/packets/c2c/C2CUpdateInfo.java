package it.sochat.network.packets.c2c;

import it.sochat.objects.UserInfo;

public class C2CUpdateInfo extends C2CPacket {

    private UserInfo newInfo;
    private UserInfo oldInfo;

    public C2CUpdateInfo() {
        super.packetType = C2CUpdateInfo.class;
        super.packetCategory = C2CPacket.class;

        super.categoryID = 1;
        super.packetID = 2;
    }

    public C2CUpdateInfo(UserInfo newInfo, UserInfo oldInfo) {
        this();
        this.newInfo = newInfo;
        this.oldInfo = oldInfo;
    }

    @Override
    public byte[] encode() {

        return new byte[0];
    }

    @Override
    public void decode(byte[] buffer) {

    }
}
