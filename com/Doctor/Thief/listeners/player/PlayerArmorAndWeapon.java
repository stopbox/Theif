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
	public void updateChestplate(PlayerPickupItemEvent e) {
		//leather chest
		if ((e.getItem().getItemStack().getType().equals(Material.LEATHER_CHESTPLATE)) && (e.getPlayer().getInventory().getChestplate().getType().equals(Material.AIR))){
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setChestplate(e.getItem().getItemStack());
		}
		//iron chest
		if ((e.getItem().getItemStack().getType().equals(Material.IRON_CHESTPLATE)) && 
				(e.getPlayer().getInventory().getChestplate().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getChestplate().getType().equals(Material.LEATHER_CHESTPLATE) || 
						e.getPlayer().getInventory().getChestplate().getType().equals(Material.GOLD_CHESTPLATE))){
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setChestplate(e.getItem().getItemStack());
		}
		//gold chest
		if ((e.getItem().getItemStack().getType().equals(Material.GOLD_CHESTPLATE)) && 
				(e.getPlayer().getInventory().getChestplate().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getChestplate().getType().equals(Material.LEATHER_CHESTPLATE))){ 
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setChestplate(e.getItem().getItemStack());
		}
		//Diamond chest
		if ((e.getItem().getItemStack().getType().equals(Material.IRON_CHESTPLATE)) && 
				(e.getPlayer().getInventory().getChestplate().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getChestplate().getType().equals(Material.LEATHER_CHESTPLATE) || 
						e.getPlayer().getInventory().getChestplate().getType().equals(Material.GOLD_CHESTPLATE) || 
						e.getPlayer().getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE))){						
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setChestplate(e.getItem().getItemStack());
		}
	}

	@EventHandler
	public void updatePants(PlayerPickupItemEvent e) {
		//leather pants
		if ((e.getItem().getItemStack().getType().equals(Material.LEATHER_LEGGINGS)) && (e.getPlayer().getInventory().getLeggings().getType().equals(Material.AIR))){
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setLeggings(e.getItem().getItemStack());
		}
		//iron pants
		if ((e.getItem().getItemStack().getType().equals(Material.IRON_LEGGINGS)) && 
				(e.getPlayer().getInventory().getLeggings().equals(Material.AIR) || 
						e.getPlayer().getInventory().getLeggings().getType().equals(Material.LEATHER_LEGGINGS) || 
						e.getPlayer().getInventory().getLeggings().getType().equals(Material.GOLD_LEGGINGS))){
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setLeggings(e.getItem().getItemStack());
		}
		//gold pants
		if ((e.getItem().getItemStack().getType().equals(Material.GOLD_LEGGINGS)) && 
				(e.getPlayer().getInventory().getLeggings().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getLeggings().getType().equals(Material.LEATHER_LEGGINGS))){ 
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setLeggings(e.getItem().getItemStack());
		}
		//Diamond pants
		if ((e.getItem().getItemStack().getType().equals(Material.IRON_LEGGINGS)) && 
				(e.getPlayer().getInventory().getLeggings().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getLeggings().getType().equals(Material.LEATHER_LEGGINGS) || 
						e.getPlayer().getInventory().getLeggings().getType().equals(Material.GOLD_LEGGINGS) || 
						e.getPlayer().getInventory().getLeggings().getType().equals(Material.IRON_LEGGINGS))){						
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setLeggings(e.getItem().getItemStack());
		}
	}

	@EventHandler
	public void updateBoots(PlayerPickupItemEvent e) {
		//leather boots
		if ((e.getItem().getItemStack().getType().equals(Material.LEATHER_BOOTS)) && (e.getPlayer().getInventory().getBoots().getType().equals(Material.AIR))){
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setBoots(e.getItem().getItemStack());
		}
		//iron boots
		if ((e.getItem().getItemStack().getType().equals(Material.IRON_BOOTS)) && 
				(e.getPlayer().getInventory().getBoots().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getBoots().getType().equals(Material.LEATHER_BOOTS) || 
						e.getPlayer().getInventory().getBoots().getType().equals(Material.GOLD_BOOTS))){
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setBoots(e.getItem().getItemStack());
		}
		//gold boots
		if ((e.getItem().getItemStack().getType().equals(Material.GOLD_BOOTS)) && 
				(e.getPlayer().getInventory().getBoots().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getBoots().getType().equals(Material.LEATHER_BOOTS))){ 
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setBoots(e.getItem().getItemStack());
		}
		//Diamond boots
		if ((e.getItem().getItemStack().getType().equals(Material.IRON_BOOTS)) && 
				(e.getPlayer().getInventory().getBoots().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getBoots().getType().equals(Material.LEATHER_BOOTS) || 
						e.getPlayer().getInventory().getBoots().getType().equals(Material.GOLD_BOOTS) || 
						e.getPlayer().getInventory().getBoots().getType().equals(Material.IRON_BOOTS))){						
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setBoots(e.getItem().getItemStack());
		}
	}

	@EventHandler
	public void updateHelment(PlayerPickupItemEvent e) {
		//leather HELMET
		if ((e.getItem().getItemStack().getType().equals(Material.LEATHER_HELMET)) && (e.getPlayer().getInventory().getHelmet().getType().equals(Material.AIR))){
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setHelmet(e.getItem().getItemStack());
		}
		//iron HELMET
		if ((e.getItem().getItemStack().getType().equals(Material.IRON_HELMET)) && 
				(e.getPlayer().getInventory().getHelmet().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getHelmet().getType().equals(Material.LEATHER_HELMET) || 
						e.getPlayer().getInventory().getHelmet().getType().equals(Material.GOLD_HELMET))){
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setHelmet(e.getItem().getItemStack());
		}
		//gold HELMET
		if ((e.getItem().getItemStack().getType().equals(Material.GOLD_HELMET)) && 
				(e.getPlayer().getInventory().getHelmet().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getHelmet().getType().equals(Material.LEATHER_HELMET))){ 
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setHelmet(e.getItem().getItemStack());
		}
		//Diamond HELMET
		if ((e.getItem().getItemStack().getType().equals(Material.IRON_HELMET)) && 
				(e.getPlayer().getInventory().getHelmet().getType().equals(Material.AIR) || 
						e.getPlayer().getInventory().getHelmet().getType().equals(Material.LEATHER_HELMET) || 
						e.getPlayer().getInventory().getHelmet().getType().equals(Material.GOLD_HELMET) || 
						e.getPlayer().getInventory().getHelmet().getType().equals(Material.IRON_HELMET))){						
			e.setCancelled(true);
			e.getItem().remove();
			e.getPlayer().getInventory().setHelmet(e.getItem().getItemStack());
		}
	}
}
