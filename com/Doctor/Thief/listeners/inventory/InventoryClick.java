package com.Doctor.Thief.listeners.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.manager.PlayerScoreboardManager;
import com.Doctor.Thief.utils.ChatUtil;
import com.Doctor.Thief.utils.EconomyUtil;
import com.Doctor.Thief.utils.SpecUtil;

public class InventoryClick extends MGListener{

	Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");
	FileConfiguration config = plugin.getConfig();

	public InventoryClick(Main pl) {
		super(pl);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		ItemStack item = e.getCurrentItem();
		e.setCancelled(true);
		Player p = (Player)e.getWhoClicked();
		if (item.getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Double Jump") && EconomyUtil.getBalance(p) > 1999) {
			if (!plugin.getConfig().contains("player." + p.getName() + ".doublejump")) {
			plugin.getConfig().set("player." + e.getWhoClicked().getName() + ".doublejump", true);
			plugin.saveConfig();
			ChatUtil.sendMessage(p, "You bought the ability double jump!");
			EconomyUtil.takeBalance(p, 2000.0);
			PlayerScoreboardManager.sendScoreboard(p, (int) EconomyUtil.getBalance(p));
		} else if (!(EconomyUtil.getBalance(p) > 2000)) {
			ChatUtil.sendMessage(p, "You do not have the funds by this item!");
		} else if (plugin.getConfig().contains("player." + p.getName() + ".doublejump") && item.getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Double Jump")) {
			ChatUtil.sendMessage(p, "You already have this!");
		}
		if(SpecUtil.spec.contains(p)){
			e.setCancelled(true);
		}
		}
	}

	@EventHandler
	public void onClickSpeed(InventoryClickEvent e) {
		ItemStack item = e.getCurrentItem();
		e.setCancelled(true);
		Player p = (Player)e.getWhoClicked();
		if (item.getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Speed III Effect") && EconomyUtil.getBalance(p) > 2499) {
			if (!plugin.getConfig().contains("player." + p.getName() + ".speed")) {
					plugin.getConfig().set("player." + e.getWhoClicked().getName() + ".speed", true);
					plugin.saveConfig();
					ChatUtil.sendMessage(p, "You bought the perk speed!");
					EconomyUtil.takeBalance(p, 2500.0);
					PlayerScoreboardManager.sendScoreboard(p, (int) EconomyUtil.getBalance(p));
				}
			} else if (!(EconomyUtil.getBalance(p) > 2499)) {
				ChatUtil.sendMessage(p, "You do not have the funds by this item!");
			} else if (plugin.getConfig().contains("player." + p.getName() + ".speed") && item.getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Speed III Effect") && EconomyUtil.getBalance(p) > 2499) {
				ChatUtil.sendMessage(p, "You already have this!");
			}
		}
	}
