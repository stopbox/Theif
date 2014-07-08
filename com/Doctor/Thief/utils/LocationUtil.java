package com.Doctor.Thief.utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.Doctor.Thief.Main;

public class LocationUtil {

	private static Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");
	
	public static void teleportToSpawn(Player p) {
		Location loc = new Location(
				Bukkit.getWorld(plugin.getConfig().getString("lobby.world")),
				plugin.getConfig().getDouble("lobby.x"), 
				plugin.getConfig().getDouble("lobby.y"), 
				plugin.getConfig().getDouble("lobby.z"));
		p.teleport(loc);
		
	}
	public static void teleportAllToSpawn(){
		for(Player p : Bukkit.getOnlinePlayers())
			teleportToSpawn(p);
	}
	
	public static void spreadPlayer(Player p) {
		Random rand = new Random();
		World w = Bukkit.getWorld(plugin.getConfig().getString("center.world"));
		double x = plugin.getConfig().getDouble("center.x");
		double y = plugin.getConfig().getDouble("center.y");
		double z = plugin.getConfig().getDouble("center.z");
		double xDiff = rand.nextInt(10) + -rand.nextInt(10);
		double zDiff = rand.nextInt(10) + -rand.nextInt(10);
		x = x + xDiff;
		z = z + zDiff;
		p.teleport(new Location(w, x, y, z));
	}
	
	public static void teleportToCenter(Player p){
		Location loc = new Location(
				Bukkit.getWorld(plugin.getConfig().getString("center.world")),
				plugin.getConfig().getDouble("center.x"), 
				plugin.getConfig().getDouble("center.y"), 
				plugin.getConfig().getDouble("center.z"));
		p.teleport(loc);
	}
	
	public static void teleportAllToCenter(){
		for(Player p : Bukkit.getOnlinePlayers())
			teleportToCenter(p);
	}
	
}