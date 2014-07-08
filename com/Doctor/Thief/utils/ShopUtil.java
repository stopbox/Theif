package com.Doctor.Thief.utils;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopUtil {

	private static Inventory inv;
	
	public static void setupInventory() {
		inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "" + ChatColor.UNDERLINE + "Shop");
		//11
		ItemStack doubleJump = new ItemStack(Material.POTION, 1, (short) 0);
		ItemMeta meta1 = doubleJump.getItemMeta();
		meta1.setLore(Arrays.asList(ChatColor.GOLD + "2000 Coins to buy double jump"));
		meta1.setDisplayName(ChatColor.GREEN + "Double Jump");
		doubleJump.setItemMeta(meta1);
		inv.setItem(11, doubleJump);
	
	
		ItemStack speedBoost = new ItemStack(Material.POTION, 1, (short) 8258);
		ItemMeta meta2 = speedBoost.getItemMeta();
		meta2.setLore(Arrays.asList(ChatColor.GOLD + "2500 Coins to buy Speed Effect"));
		meta2.setDisplayName(ChatColor.GREEN + "Speed III Effect");
		speedBoost.setItemMeta(meta2);
		inv.setItem(13, speedBoost);
	}
	
	public static Inventory getInventory() {
		return inv;
	}
}
