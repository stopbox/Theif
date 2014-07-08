package com.Doctor.Thief.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;


public class PlayerScoreboardManager {
	
	@SuppressWarnings("deprecation")
	public static void sendScoreboard(Player p, int bal) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective o = sb.registerNewObjective(p.getName(), "dummy");
		o.setDisplayName(ChatColor.DARK_RED + "     Theif    ");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Coins")).setScore(15);
		o.getScore(Bukkit.getOfflinePlayer(String.valueOf(bal))).setScore(14);
		p.setScoreboard(sb);
	}
}
