package com.Doctor.Thief.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;

public class BlockBreak extends MGListener {
	
	
	public BlockBreak(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		e.setCancelled(true);
	}

}
