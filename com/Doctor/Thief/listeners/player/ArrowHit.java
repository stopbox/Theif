package com.Doctor.Thief.listeners.player;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;

public class ArrowHit extends MGListener {
	
	public ArrowHit(Main pl){
		super(pl);
		
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			Arrow a =(Arrow)  e.getDamager();
			if (a.getShooter() instanceof Player) {
				e.setDamage(2.0D);
				Player p = (Player)a.getShooter();
				p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
			}
		}
	}

}
