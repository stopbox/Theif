package com.Doctor.Thief.listeners.player;


import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;

public class PlayerDrop extends MGListener{

	
	public PlayerDrop(Main pl) {
		super(pl);
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		e.getPlayer().getInventory().setItem(e.getPlayer().getInventory().getHeldItemSlot(), e.getItemDrop().getItemStack());
		e.getItemDrop().remove();
	}
}
