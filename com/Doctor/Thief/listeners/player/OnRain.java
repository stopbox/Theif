package com.Doctor.Thief.listeners.player;

import org.bukkit.event.weather.WeatherChangeEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;

public class OnRain extends MGListener{

	public OnRain(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}
	public void onWaterDrop(WeatherChangeEvent e){
		e.setCancelled(true);
	}

}
