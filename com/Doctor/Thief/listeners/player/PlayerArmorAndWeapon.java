package com.Doctor.Thief.listeners.player;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;

public class PlayerArmorAndWeapon extends MGListener {
	
	public PlayerArmorAndWeapon(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void updateBoots(PlayerPickupItemEvent e) {
		if (e.getItem().getItemStack().getType() == Material.LEATHER_BOOTS && e.getPlayer().getInventory().getBoots().getType() == Material.AIR 
			|| e.getItem().getItemStack().getType() == Material.IRON_BOOTS && e.getPlayer().getInventory().getBoots().getType() == Material.AIR  ) {
			e.setCancelled(true);
			e.getPlayer().getInventory().setBoots(new ItemStack(e.getItem().getItemStack().getType(), 1));
			e.getItem().remove();
		}
	}

	@EventHandler
	public void updateChestplate(PlayerPickupItemEvent e) {
		if (e.getItem().getItemStack().getType() == Material.LEATHER_CHESTPLATE && e.getPlayer().getInventory().getBoots().getType() == Material.AIR) {
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
		}
	}
	
	@EventHandler
	public void updateLeggings(PlayerPickupItemEvent e) {
		if (e.getItem().getItemStack().getType() == Material.LEATHER_LEGGINGS && e.getPlayer().getInventory().getBoots().getType() == Material.AIR) {
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
		}
	}
	
	@EventHandler
	public void updateHelment(PlayerPickupItemEvent e) {
		if (e.getItem().getItemStack().getType() == Material.LEATHER_HELMET && e.getPlayer().getInventory().getBoots().getType() == Material.AIR) {
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
		}
	}
}
