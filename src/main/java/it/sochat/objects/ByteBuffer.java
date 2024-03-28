package it.sochat.objects;

import it.sochat.network.packets.Packet;
import it.sochat.network.packets.c2c.C2CMessageSend;
import it.sochat.network.packets.c2c.C2CUpdateInfo;

import java.sql.Timestamp;

public class ByteBuffer {

    static final int INTEGER = 4;
    static final int CHAR = 5;
    static final int TIMESTAMP = 6;

    byte[] buf = new byte[7];

    byte closeChar = 0;

    Class<?> packetType;

    public ByteBuffer(Packet p) {
        this.packetType = p.getPacketType();
        buf[0] = p.getCategoryID();
        buf[1] = p.getPacketID();
        buf[6] = (byte) (buf[0]^buf[1]);
    }

    public void addInteger(Integer i){
        byte[] res = new byte[buf.length + Integer.BYTES + 2];

        System.arraycopy(buf, 0, res, 0, buf.length);
        res[buf.length] = ByteBuffer.INTEGER;
        closeChar ^= res[buf.length];
        res[buf.length + 1] = Integer.BYTES;

        res[buf.length + 2] = (byte)(i >>> 24);
        res[buf.length + 3] = (byte)(i >>> 16);
        res[buf.length + 4] = (byte)(i >>> 8);
        res[buf.length + 5] = i.byteValue();

        buf = res;
    }
    public void addInteger(Integer[] i){
        byte[] res = new byte[buf.length + (Integer.BYTES * i.length) + 2];
        System.arraycopy(buf, 0, res, 0, buf.length);

        res[buf.length] = ByteBuffer.INTEGER;
        closeChar ^= res[buf.length];
        res[buf.length + 1] = (byte) (Integer.BYTES * i.length);

        for(int j = 0; j < i.length; j++) {
            Integer integer = i[j];
            res[buf.length + 2 + (j * Integer.BYTES)] = (byte) (integer >>> 24);
            res[buf.length + 3 + (j * Integer.BYTES)] = (byte) (integer >>> 16);
            res[buf.length + 4 + (j * Integer.BYTES)] = (byte) (integer >>> 8);
            res[buf.length + 5 + (j * Integer.BYTES)] = integer.byteValue();
        }

        buf = res;
    }

    public void addChar(Character c){
        byte[] res = new byte[buf.length + Character.BYTES + 2];
        System.arraycopy(buf, 0, res, 0, buf.length);

        short s = (short) c.charValue();

        res[buf.length] = ByteBuffer.CHAR;
        closeChar ^= res[buf.length];
        res[buf.length + 1] = (byte) (Character.BYTES);

        res[buf.length + 4] = (byte) (s >>> 8);
        res[buf.length + 5] = (byte) s;

        buf = res;
    }

    public void addString(String c){
        byte[] res = new byte[buf.length + (Character.BYTES * c.length()) + 2];
        System.arraycopy(buf, 0, res, 0, buf.length);

        res[buf.length] = ByteBuffer.CHAR;
        closeChar ^= res[buf.length];
        res[buf.length + 1] = (byte) (Character.BYTES * c.length());

        for(int j = 0; j < c.length(); j++) {
            char s = c.charAt(j);
            res[buf.length + 2 + (j * Character.BYTES)] = (byte) (s >>> 8);
            res[buf.length + 3 + (j * Character.BYTES)] = (byte) s;
        }
        buf = res;
    }

    public void addTimestamp(Timestamp i){
        byte[] res = new byte[buf.length + Long.BYTES + 2];
        System.arraycopy(buf, 0, res, 0, buf.length);

        long l = i.getTime();


        res[buf.length] = ByteBuffer.TIMESTAMP;
        closeChar ^= res[buf.length];
        res[buf.length + 1] = Long.BYTES;

        res[buf.length + 2] = (byte)(l >>> 56);
        res[buf.length + 3] = (byte)(l >>> 48);
        res[buf.length + 4] = (byte)(l >>> 40);
        res[buf.length + 5] = (byte)(l >>> 32);
        res[buf.length + 6] = (byte)(l >>> 24);
        res[buf.length + 7] = (byte)(l >>> 16);
        res[buf.length + 8] = (byte)(l >>> 8);
        res[buf.length + 9] = (byte) l;

        buf = res;
    }

    public byte[] getByteArr(){
        byte[] res = new byte[buf.length + 1];
        int i = res.length + 1;
        System.arraycopy(buf, 0, res, 0, buf.length);
        res[buf.length] = closeChar;
        res[2] = (byte)(i >>> 24);
        res[3] = (byte)(i >>> 16);
        res[4] = (byte)(i >>> 8);
        res[5] = (byte) i;
        return res;
    }

}
