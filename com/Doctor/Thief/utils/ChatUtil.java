package com.Doctor.Thief.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChatUtil {


	public static Server server = Bukkit.getServer();
	public static ConsoleCommandSender console = server.getConsoleSender();
	
	public static void broadcast(String msg){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.sendMessage(starter() + " " + msg);
		}

	}

	private static String starter(){
		return Constants.PREFIX;
	}
	
	public static void sendMessageToConsole(String msg){

		console.sendMessage(starter() + " " + ChatColor.RED + msg);
	}
	
	public static void sendMessage(Player player, String message){
		
		player.sendMessage(starter() + " " + message);
	}

}
