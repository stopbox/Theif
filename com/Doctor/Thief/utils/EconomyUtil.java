package com.Doctor.Thief.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;

public class EconomyUtil {

	private static Economy econ;
	
	public static boolean setupEconomy() {
		  RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	        	econ = economyProvider.getProvider();
	        }

	        return (econ != null);
	}
	
	
	public static void giveBalance(Player p, double amount) {
		econ.depositPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()), amount);
	}
	
	public static double getBalance(Player p) {
		return econ.getBalance(Bukkit.getOfflinePlayer(p.getUniqueId()));
	}
	
	public static void takeBalance(Player p, double amount) {
		econ.withdrawPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()), amount);
	}
}
