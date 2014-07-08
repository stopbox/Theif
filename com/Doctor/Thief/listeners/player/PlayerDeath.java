package com.Doctor.Thief.listeners.player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;
import java.util.UUID;

import net.minecraft.server.v1_7_R3.MinecraftServer;
import net.minecraft.server.v1_7_R3.PlayerInteractManager;
import net.minecraft.server.v1_7_R3.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.nms.PlayerNPC;
import com.Doctor.Thief.nms.ProfileLoader;
import com.Doctor.Thief.utils.ChatUtil;
import com.Doctor.Thief.utils.EconomyUtil;
import com.Doctor.Thief.utils.FireworkUtil;
import com.Doctor.Thief.utils.Game;
import com.Doctor.Thief.utils.ScoreboardUtil;
import com.Doctor.Thief.utils.SpecUtil;

public class PlayerDeath extends MGListener{

	Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");

	public PlayerDeath(Main pl) {
		super(pl);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		final Player p = e.getEntity();
		for (PotionEffect pot : p.getActivePotionEffects()) {
			p.removePotionEffect(pot.getType());
		}
		p.setHealth(20.0);
		String name = substring(p.getName());
		int num = ScoreboardUtil.o.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + name)).getScore();
		ScoreboardUtil.sb.resetScores(Bukkit.getOfflinePlayer(ChatColor.GREEN + name));
		ScoreboardUtil.o.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + "" + ChatColor.STRIKETHROUGH + name)).setScore(num);
		ScoreboardUtil.alive.remove(p);
		if(p.getKiller() instanceof Player){
			Player killer = p.getKiller();
			SpecUtil.specPlayer(p);
			e.setDeathMessage(ChatColor.GREEN + p.getName() + " was Brutally murdered by " + killer.getName());
			EconomyUtil.giveBalance(killer, 5.0);
			ChatUtil.sendMessage(killer, " You have been given 5 coins from killing " + p.getName());
		}else{
			SpecUtil.specPlayer(p);
			e.setDeathMessage(ChatColor.GREEN + p.getName() + " Died of natural causes");
		}
		if (ScoreboardUtil.alive.size() == 1)  {
			ScoreboardUtil.alive.remove(p);
			StringBuilder str = new StringBuilder();
			for (Player op : ScoreboardUtil.alive) {
				str.append(op.getName());
				ChatUtil.broadcast("Player " + str.toString() + " has won the game!");
				//200
				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
					int time = 10;
					public void run() {
						if (time != 1) {
							ChatUtil.broadcast("The server will restart in " + time);
							time--;
						} else {
							for (Player p : Bukkit.getOnlinePlayers()) {
								ByteArrayOutputStream b = new ByteArrayOutputStream();
								DataOutputStream out = new DataOutputStream(b);

								try {
									out.writeUTF("Connect");
									out.writeUTF("hub");
									p.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
								} catch (Exception ex) {

								}
								Game.stop();
							}

						}
					}
				}, 0, 20);
				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
					int time = 12;
					public void run() {
						if (time != 1) {
							time--;
						} else {

							Bukkit.getServer().shutdown();
						}
					}
				}, 0, 20);
				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
					public void run() {
						Random rand = new Random();
						World w = Bukkit.getWorld(plugin.getConfig().getString("center.world"));
						double x = plugin.getConfig().getDouble("center.x");
						double y = plugin.getConfig().getDouble("center.y");
						double z = plugin.getConfig().getDouble("center.z");
						double xDiff = rand.nextInt(20) + -rand.nextInt(20);
						double zDiff = rand.nextInt(20) + -rand.nextInt(20);
						x = x + xDiff;
						z = z + zDiff;
						Location loc = new Location(w, x, y, z);
						FireworkUtil.endFirework(loc);

					}
				}, 0L, 20L);
 
			}
		}

		if(p.getKiller() instanceof Player){
			Player killer = p.getKiller();
			for(int i = 0; i < 11; i++) {
				FireworkUtil.endFirework(killer.getLocation());
			}
			SpecUtil.specPlayer(p);
		}
	}

	@EventHandler
	public void updateArmor(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof LivingEntity) {
			LivingEntity ent = (LivingEntity)e.getEntity();
			if (e.getEntity() instanceof Player && e.getDamager() instanceof Player && e.getDamage() <= ent.getHealth()) {
				Player player = (Player) e.getEntity();
				Player dmgr = (Player)e.getDamager();
				if (player.getInventory().getHelmet().getDurability() <= dmgr.getInventory().getHelmet().getDurability() && player.getInventory().getHelmet().getType() != Material.AIR) {
				}
			}
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
