package com.Doctor.Thief.utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.states.GameState;

public class Game {

	static Random rand = new Random();
	static Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");
	static int num = 15;

	@SuppressWarnings("deprecation")
	public static void start() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					for (ItemStack i : p.getInventory().getArmorContents()) {
						i.setDurability((short) 0);
					}
				}
			}
		}, 0L, 1L);
		//		LocationUtil.teleportAllToCenter();
		for(Player p : Bukkit.getOnlinePlayers()){
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 15, 3, true));
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 15, 3, true));
			p.setNoDamageTicks(80);
			LocationUtil.spreadPlayer(p);
			GameState.setState(GameState.IN_GAME);
			p.setHealth(20D);
			p.setFoodLevel(20);
			p.setSaturation(200.0F);
			randomEquipment(p);
			GameState.setState(GameState.IN_GAME);
			String name = p.getName();
			p.setScoreboard(ScoreboardUtil.sb);
			if(p.getName().length() > 10){
				name = name.substring(0, 10);
			}
			
			ScoreboardUtil.o.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + name)).setScore(num);
			num--;
			if (plugin.getConfig().getBoolean("player." + p.getName() + ".doublejump")) {
				p.setAllowFlight(true);
			}
			if (plugin.getConfig().getBoolean("player." + p.getName() + ".speed")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000000, 2));
			}
		}
	}

	public static void stop(){
		for (Entity en: Bukkit.getWorld(plugin.getConfig().getString("center.world")).getEntities()) {
			if (!(en instanceof Player)) {
				en.remove();
			}
		}
	}

	private static void randomEquipment(Player p) {
		p.getInventory().clear();

		int type = rand.nextInt(4);
		ClassUtil.noob(p);
	}
}
