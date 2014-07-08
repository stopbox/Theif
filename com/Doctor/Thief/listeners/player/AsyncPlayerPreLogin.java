package com.Doctor.Thief.listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.data.GameData;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.states.GameState;

public class AsyncPlayerPreLogin extends MGListener{

	public AsyncPlayerPreLogin(Main pl) {
		super(pl);
	}

	@EventHandler
	public void playerPreLogin(AsyncPlayerPreLoginEvent e){
		if(!(GameState.IN_LOBBY == GameState.getState())){
			if(!(e.getName().equalsIgnoreCase("TheDoctor2014") || e.getName().equalsIgnoreCase("StopBox123"))){
				e.disallow(Result.KICK_OTHER, ChatColor.RED + "Game has Already started");
			}
		}
		if((e.getName().equalsIgnoreCase("TheDoctor2014") || e.getName().equalsIgnoreCase("StopBox123"))){
			e.allow();
		}
	}


}
