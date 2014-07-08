package com.Doctor.Thief.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.utils.SpecUtil;

public class PlayerPickup extends MGListener {
	
	public PlayerPickup(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if (SpecUtil.spec.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

}
