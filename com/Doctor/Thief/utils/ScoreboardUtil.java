package com.Doctor.Thief.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardUtil {

	private static Plugin plugin = Bukkit.getPluginManager().getPlugin("Thief");
	public static Scoreboard sb;
	public static Objective o;
	private static Team dev;
	public static int time = 60;
	public static boolean nodamage = true;
	public static int TaskID;
	public static ArrayList<Player> alive = new ArrayList<Player>();

	@SuppressWarnings("deprecation")
	public static void setup() {
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		o = sb.registerNewObjective("Theif", "dummy");
		o.setDisplayName(ChatColor.DARK_RED + "     Theif    ");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		dev = sb.registerNewTeam("dev");
		dev.setDisplayName(ChatColor.BLACK + "" + ChatColor.BOLD + "[" + ChatColor.GOLD + "Dev" + ChatColor.BLACK + "]" + ChatColor.RESET);
		dev.setPrefix(ChatColor.BOLD + "" + ChatColor.BLACK + "[" + ChatColor.GOLD + "Dev" + ChatColor.BLACK + "]" + ChatColor.RESET);
		dev.addPlayer(Bukkit.getOfflinePlayer("stopbox123"));
		dev.addPlayer(Bukkit.getOfflinePlayer("TheDoctor2014"));
	}

	public static void newGame() {
		TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				if (time != 0) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.setLevel(time);
					}
					time--;
					if (time == 0) {
						if (Bukkit.getOnlinePlayers().length < 3) {
							ChatUtil.broadcast("There are not enough players! restarting lobby mode.");
							time = 60;
						} else {
							for (Player p : Bukkit.getOnlinePlayers()) {
								p.setLevel(0);
								alive.add(p);
							}							
							ChatUtil.broadcast("Enough players");
							Bukkit.getScheduler().cancelTask(TaskID);
							o.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_RED + "Alive:")).setScore(Bukkit.getOnlinePlayers().length);
							Game.start();
							nodamage = false;
						}
					}
				}
				}
			}, 0L, 20L);
	}
	
	public static void forceStart() {
		Bukkit.getScheduler().cancelTask(TaskID);
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setLevel(0);
			alive.add(p);
		}	
	}
}
