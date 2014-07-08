package com.Doctor.Thief.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R3.event.CraftEventFactory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.states.GameState;
import com.Doctor.Thief.utils.ScoreboardUtil;
import com.Doctor.Thief.utils.SpecUtil;

public class PlayerDisconnect extends MGListener {

	public PlayerDisconnect(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		if (!SpecUtil.spec.contains(e.getPlayer()) && GameState.getState() == GameState.IN_GAME) {
			ScoreboardUtil.alive.remove(e.getPlayer());
			for (PotionEffect pot : e.getPlayer().getActivePotionEffects()) {
				e.getPlayer().removePotionEffect(pot.getType());
			}
			e.getPlayer().setHealth(20.0);
				CraftEventFactory.callPlayerDeathEvent(((CraftPlayer)e.getPlayer()).getHandle(), null, e.getPlayer().getName());
		}

	}
	
	private static String substring(String string) {
		if(string.length() > 10){
			string = string.substring(0, 10);
			return string;
		}
		return string;
	}
}
