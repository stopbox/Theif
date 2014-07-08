package com.Doctor.Thief.listeners.enitty;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.utils.SpecUtil;

public class EntityDamageByEntity extends MGListener{

	public EntityDamageByEntity(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player)e.getDamager();
		if (SpecUtil.spec.contains(p)) {
			e.setCancelled(true);
		}
		}
	}
}
