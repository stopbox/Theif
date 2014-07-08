package com.Doctor.Thief.listeners.player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;


public class PlayerLeave extends MGListener {

	public PlayerLeave(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}
	
	Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");
	
	@EventHandler
	public void onInter(PlayerInteractEvent e) {
		if (e.getPlayer().getItemInHand().getType() == Material.EYE_OF_ENDER && e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getPlayer().getItemInHand().getType() == Material.EYE_OF_ENDER && e.getAction() == Action.RIGHT_CLICK_AIR) {
			e.setCancelled(true);
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(b);
			 
			try {
			out.writeUTF("Connect");
			out.writeUTF("hub");
			e.getPlayer().sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
			} catch (Exception ex) {
			 
			}
		}
	}
}
