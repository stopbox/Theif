package com.Doctor.Thief.listeners.player;

import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.states.GameState;
import com.Doctor.Thief.utils.ScoreboardUtil;
import com.Doctor.Thief.utils.SpecUtil;

public class PlayerDamage extends MGListener {

	public PlayerDamage(Main pl) {
		super(pl);
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if(ScoreboardUtil.nodamage || SpecUtil.spec.contains(p)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onFall(PlayerMoveEvent e) {
		e.getPlayer().setFallDistance(0.0F);
		if (e.getTo().getBlockY() < 77) {
			e.getPlayer().damage(500.0);
		}
	}

	@EventHandler
	public void onDamage2(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player)e.getEntity();
			if (!SpecUtil.spec.contains(p)) {
				if (e.getEntity() instanceof Player && !ScoreboardUtil.nodamage && !(SpecUtil.spec.contains(p))) { 
					e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
					e.getEntity().getWorld().playEffect(e.getEntity().getLocation().add(0, 1, 0), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
				}
			}
		}
	}
	
	@EventHandler
	public void cancelLightingDamage(EntityDamageEvent e) {
		if (e.getCause() == DamageCause.LIGHTNING) {
			e.setCancelled(true);
			e.getEntity().setFallDistance(0.0F);
		}
	}
	
	@EventHandler
	public void onBlockDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player victom = (Player)e.getEntity();
			Player dmgr = (Player)e.getDamager();
			Random random = new Random();
			int i = random.nextInt(7);
			if(i == 3 && victom.isBlocking()) {
				dmgr.damage(e.getDamage() / 2);
			}
			if (victom.isBlocking()) {
				if (i == 0 || i == 1 || i == 2 || i == 4 || i == 5 || i == 6) {
					e.setDamage(e.getDamage() / 2);
 
				}
			}
		}
	}
}


