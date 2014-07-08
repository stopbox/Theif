package com.Doctor.Thief.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;

public class PingListener extends MGListener {
	
	public PingListener(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onPing(ServerListPingEvent e) {
		e.setMaxPlayers(15);
	}

}
