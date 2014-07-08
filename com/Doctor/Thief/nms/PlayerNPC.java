package com.Doctor.Thief.nms;

import net.minecraft.server.v1_7_R3.*;
import net.minecraft.util.com.mojang.authlib.GameProfile;

public class PlayerNPC extends EntityPlayer {

	public PlayerNPC(MinecraftServer MCServer, WorldServer WServer, GameProfile GProfile, PlayerInteractManager PIManager) {
		super(MCServer, WServer, GProfile, PIManager);
		NetworkManager NullManager = new NullNetworkManager();
		playerConnection = (PlayerConnection) new NullPlayerConnection(MCServer, NullManager, this);
		NullManager.a(playerConnection);
	}

	public void sleep() {
		PacketPlayOutBed bed = new PacketPlayOutBed(this, (int)this.locX, (int)this.locY, (int)this.locZ);
		((WorldServer)this.world).tracker.a(this, bed);
	}
}
