package com.Doctor.Thief.listeners.player;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.utils.BarUtil;
import com.Doctor.Thief.utils.ChatUtil;
import com.Doctor.Thief.utils.ParticleEffect;
import com.Doctor.Thief.utils.UnusedParticleEffects;

public class DoubleJump extends MGListener {

	Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");
	
	HashMap<Player, BukkitTask> recharge = new HashMap<Player, BukkitTask>();
	
	public DoubleJump(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onToggle(final PlayerToggleFlightEvent e) {
		if (!(e.getPlayer().getGameMode() == GameMode.CREATIVE) && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR || !(e.getPlayer().getGameMode() == GameMode.CREATIVE) && e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType() != Material.AIR) {
			e.getPlayer().setExp(0);
			e.getPlayer().setFlying(false);
			e.getPlayer().setAllowFlight(false);
			e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.2).setY(1.5));
			e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_WINGS, 100F, 1F);
			ParticleEffect.FIREWORKS_SPARK.display(e.getPlayer().getLocation(), 0, 0, 0, 0.1F, 1000);
			BukkitTask task = new BukkitRunnable() {
				float time = (float) 10.0;
				@Override
				public void run() {
					if (time > 0.1) {
						time = (float) (time + -0.1);
						BarUtil.setStatusBar(e.getPlayer(), ChatColor.YELLOW + "" + ChatColor.BOLD + "Double Jump " + ChatColor.WHITE + "- " + ChatColor.RED + String.valueOf(time).substring(0, 3), 1.0f);
					} else {
						e.getPlayer().setAllowFlight(true);
						this.cancel();
						BarUtil.removeStatusBar(e.getPlayer());
						recharge.remove(e.getPlayer());
					}
				}
			}.runTaskTimer(plugin, 1L, 1L);
			recharge.put(e.getPlayer(), task);
		}
	}

}
