package com.Doctor.Thief.listeners.player;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.utils.BarUtil;

public class EntityExplodeEvent extends MGListener {
	
	public EntityExplodeEvent(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}
	
	HashMap<Player, BukkitTask> recharge = new HashMap<>();
	
	HashMap<Player, BukkitTask> ent = new HashMap<Player, BukkitTask>();
	Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");

	
	
	@EventHandler
	public void onClick(final PlayerInteractEvent e) {
		if (e.getPlayer().getItemInHand().getType() == Material.SULPHUR) {
			/*Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				int explodetime = 20;
				public void run() {
					if (explodetime != 0) {
						e.getPlayer().setVelocity(new Vector(0, 0, 0));
						e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.CREEPER_HISS, 1, 1);
						explodetime--;
						Bukkit.getServer().shutdown(
						vugkpo,adqw);
					} else {
						e.getPlayer().setNoDamageTicks(20);
						e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(), 4.0F);
					}
				}
			}, 0L, 1L);*/
			BukkitTask task = new BukkitRunnable() {
				int explodetime = 60;
				Location loc = e.getPlayer().getLocation();
				@Override
				public void run() {
					if (explodetime != 0) {
						e.getPlayer().setVelocity(new Vector(0, 0.04, 0));
						e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.CREEPER_HISS, 1, 1);
						explodetime--;
						e.getPlayer().setNoDamageTicks(20);
					} else if (explodetime == 0){
						e.getPlayer().setNoDamageTicks(20);
						e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(), 4.0F);
						e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(4.0));
						cancel();
						ent.remove(e.getPlayer());
					}
				}
			}.runTaskTimer(plugin, 1L, 1L);
			ent.put(e.getPlayer(), task);
			BukkitTask task1 = new BukkitRunnable() {
				float time = (float) 120.0;
				@Override
				public void run() {
					if (time > 0.1) {
						time = (float) (time + -0.1);
						BarUtil.setStatusBar(e.getPlayer(), ChatColor.YELLOW + "" + ChatColor.BOLD + "Explode " + ChatColor.WHITE + "- " + ChatColor.RED + String.valueOf(time).substring(0, 5), 1.0f);
						e.getPlayer().getInventory().remove(Material.SULPHUR);
					} else {
						e.getPlayer().getInventory().addItem(new ItemStack(Material.SULPHUR, 1));
						this.cancel();
						BarUtil.removeStatusBar(e.getPlayer());
						recharge.remove(e.getPlayer());
					}
				}
			}.runTaskTimer(plugin, 1L, 1L);
			recharge.put(e.getPlayer(), task1);
		}
	}

	@EventHandler
	public void onExplode(org.bukkit.event.entity.EntityExplodeEvent e) {
		e.blockList().clear();	
		}
	
	@EventHandler
	public void onHit(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player)e.getEntity();
			if (ent.containsKey(p)) {
				e.setCancelled(true);
			}
		}
	}
}
