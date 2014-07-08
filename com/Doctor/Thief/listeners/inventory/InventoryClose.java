package com.Doctor.Thief.listeners.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.utils.ChatUtil;

public class InventoryClose extends MGListener{

	public InventoryClose(Main pl) {
		super(pl);
	}
	
	@EventHandler	
	public void onClose(InventoryCloseEvent e){
	}
	
}
