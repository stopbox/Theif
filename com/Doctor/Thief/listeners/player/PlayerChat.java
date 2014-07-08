package com.Doctor.Thief.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.utils.SpecUtil;


public class PlayerChat extends MGListener{

	public PlayerChat(Main pl) {
		super(pl);
	}


	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player talker = e.getPlayer();
		String msg = e.getMessage();
		String playerName = talker.getName();
		ChatColor Red = ChatColor.RED;
		ChatColor White = ChatColor.WHITE;
		ChatColor Green = ChatColor.GREEN;
		ChatColor Aqua = ChatColor.AQUA;
		ChatColor chatColor = ChatColor.GRAY;
		ChatColor nameColor = ChatColor.GRAY;
		ChatColor Blue = ChatColor.BLUE;
		String prefix;
		//DecalrePerms
		String playerPermissionWhite = "witherwars.white";
		String playerPermissionGreen = "witherwars.green";
		String playerPermissionAqua = "witherwars.aqua";
		//Test Perms
		if(talker.hasPermission(playerPermissionWhite)){
			chatColor = White;
		}
		if(talker.hasPermission(playerPermissionGreen)){
			chatColor = Green;
		}
		if(talker.hasPermission(playerPermissionAqua)){
			chatColor = Aqua;
		}
		e.setCancelled(true);

		nameColor = White;
		prefix = "";


		for(Player p1 : Bukkit.getOnlinePlayers()){
			if(SpecUtil.spec.contains(p1)){
				prefix = ChatColor.BLACK + "[" + ChatColor.RED + "Dead" + ChatColor.BLACK + "]";
			}
			p1.sendMessage(prefix + " " + nameColor + playerName + " " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "> " + chatColor + msg);

		}


	}
}
