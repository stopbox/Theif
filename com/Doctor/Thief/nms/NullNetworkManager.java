package com.Doctor.Thief.nms;

import java.lang.reflect.Field;

import net.minecraft.server.v1_7_R3.NetworkManager;

public class NullNetworkManager extends NetworkManager {

	public NullNetworkManager() {
		super(false);
	}

	protected void swapFields() {
		Field channel;
		Field address;
		try {
			channel = NetworkManager.class.getDeclaredField("m");
			address = NetworkManager.class.getDeclaredField("n");

			channel.setAccessible(true);
			address.setAccessible(true);

			channel.set(this, new NullChannel(null));
			address.set(this, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
