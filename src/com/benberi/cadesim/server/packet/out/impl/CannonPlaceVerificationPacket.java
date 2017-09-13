package com.benberi.cadesim.server.packet.out.impl;

import com.benberi.cadesim.server.codec.OutGoingPackets;
import com.benberi.cadesim.server.codec.util.PacketLength;
import com.benberi.cadesim.server.packet.out.OutgoingPacket;

public class CannonPlaceVerificationPacket extends OutgoingPacket {

    private int slot;
    private int side;
    private int amount;

    public CannonPlaceVerificationPacket() {
        super(OutGoingPackets.CANNON_PLACE);
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void encode() {
        setPacketLengthType(PacketLength.BYTE);
        writeByte(slot);
        writeByte(side);
        writeByte(amount);

        setLength(getBuffer().readableBytes());
    }
}