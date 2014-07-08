package com.Doctor.Thief.listeners.player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.utils.ChatUtil;
import com.Doctor.Thief.utils.ShopUtil;

public class PlayerInteract extends MGListener{

	public PlayerInteract(Main pl) {
		super(pl);
	}
	private static Plugin pl = Bukkit.getPluginManager().getPlugin("Thief");
	int num = 1;
	Inventory inv = Bukkit.createInventory(null, 9, ChatColor.BLACK + "Shop");
	Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");

	@EventHandler
	public void onClick(PlayerInteractEvent e){

		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if (e.getPlayer().getItemInHand().getType() == Material.EYE_OF_ENDER) {
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
			Player player = e.getPlayer();
			if(player.getItemInHand().getType().equals(Material.NETHER_STAR)){

				player.openInventory(ShopUtil.getInventory());		

			}
		}
		
	}




}
