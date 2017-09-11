package com.benberi.cadesim.server.packet.in;

import com.benberi.cadesim.server.ServerContext;
import com.benberi.cadesim.server.codec.util.Packet;
import com.benberi.cadesim.server.model.Player;
import com.benberi.cadesim.server.model.vessel.Vessel;
import com.benberi.cadesim.server.packet.ServerPacketExecutor;

public class ManuaverSlotChanged extends ServerPacketExecutor {

    public ManuaverSlotChanged(ServerContext ctx) {
        super(ctx);
    }

    @Override
    public void execute(Player pl, Packet p) {
        int newSlot = p.readByte();
        Vessel v = pl.getVessel();
        if (v.isManuaver()) {
            pl.getMoves().setManuaverSlot(newSlot);
        }
    }
}