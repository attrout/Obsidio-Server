package com.benberi.cadesim.server.packet.in;

import com.benberi.cadesim.server.ServerContext;
import com.benberi.cadesim.server.codec.util.Packet;
import com.benberi.cadesim.server.model.player.Player;
import com.benberi.cadesim.server.model.player.PlayerLoginRequest;
import com.benberi.cadesim.server.packet.ServerPacketExecutor;

public class PlayerLoginPacket extends ServerPacketExecutor {

    public PlayerLoginPacket(ServerContext ctx) {
        super(ctx);
    }

    @Override
    public void execute(Player pl, Packet p) {
        String name = p.readByteString();
        getContext().getPlayerManager().queuePlayerLogin(new PlayerLoginRequest(pl, name));
    }
}
