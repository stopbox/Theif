package com.Doctor.Thief.listeners.player;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.manager.PlayerScoreboardManager;
import com.Doctor.Thief.utils.Constants;
import com.Doctor.Thief.utils.EconomyUtil;
import com.Doctor.Thief.utils.LocationUtil;

public class PlayerJoin extends MGListener{


	public PlayerJoin(Main pl) {
		super(pl);
	}


	ArrayList<Player> ani = new ArrayList<Player>();
	Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(final PlayerJoinEvent e){
		ani.add(e.getPlayer());
		for (PotionEffect pot : e.getPlayer().getActivePotionEffects()) {
			e.getPlayer().removePotionEffect(pot.getType());
		}
		PlayerScoreboardManager.sendScoreboard(e.getPlayer(), (int) EconomyUtil.getBalance(e.getPlayer()));
		e.setJoinMessage(Constants.PREFIX + ChatColor.RED + e.getPlayer().getName() + ChatColor.GREEN + " Has Joined. " + ChatColor.GRAY + "(" +  Bukkit.getOnlinePlayers().length + "/" + Bukkit.getMaxPlayers() + ")");
		final Player p = e.getPlayer();
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 20, -1);
		//Shop item
		ItemStack shop = new ItemStack(Material.NETHER_STAR);
		ItemMeta shopMeta = shop.getItemMeta();
		shopMeta.setDisplayName(ChatColor.GREEN + "Shop");
		shopMeta.setLore(Arrays.asList("Click me to open The Shop!"));
		shop.setItemMeta(shopMeta);
		//Quit Item
		ItemStack quit = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta quitMeta = quit.getItemMeta();
		quitMeta.setDisplayName(ChatColor.RED + "Leave");
		quitMeta.setLore(Arrays.asList("Click me to quit!"));
		quit.setItemMeta(quitMeta);
		//Give items to players
		p.getInventory().setItem(4, shop);
		p.getInventory().setItem(8, quit);
		p.updateInventory();
		//Teleport
		LocationUtil.teleportToSpawn(p);


		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(" ");		
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
			}
		}, 10L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                                  &7Welcome to Thief"));
				p.sendMessage(" ");			
				p.sendMessage(" ");		
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
			}
		}, 20L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                                  &7Welcome to Thief"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThief is a gamemode where the player is put in deadly scenarios"));
				p.sendMessage(" ");		
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
			}
		}, 30L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                                  &7Welcome to Thief"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThief is a gamemode where the player is put in deadly scenarios"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThe player is equiped with random equipment and items"));
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
			}
		}, 40L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                                  &7Welcome to Thief"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThief is a gamemode where the player is put in deadly scenarios"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThe player is equiped with random equipment and items"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bNew Equipment and Item classes can be bought from the shop"));
				p.sendMessage(" ");			
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
			}
		}, 50L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                                  &7Welcome to Thief"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThief is a gamemode where the player is put in deadly scenarios"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThe player is equiped with random equipment and items"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bNew Equipment and Item classes can be bought from the shop"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bEach class contains better and luckier equipment then the last"));
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
			}
		}, 50L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                                  &7Welcome to Thief"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThief is a gamemode where the player is put in deadly scenarios"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThe player is equiped with random equipment and items"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bNew Equipment and Item classes can be bought from the shop"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bEach class contains better and luckier equipment then the last"));	
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
			}
		}, 60L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));
				p.sendMessage(" ");			
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "                                  &7Welcome to Thief"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThief is a gamemode where the player is put in deadly scenarios"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bThe player is equiped with random equipment and items"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bNew Equipment and Item classes can be bought from the shop"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0►&bEach class contains better and luckier equipment then the last"));		
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6«&m --------------------------------------------------&r&6»"));

			}
		}, 70L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				ani.remove(e.getPlayer());
			}
		}, 80L);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		for (Player p : e.getRecipients()) {
			if (ani.contains(p)) {
				e.getRecipients().remove(p);
			}
		}
	}
}
