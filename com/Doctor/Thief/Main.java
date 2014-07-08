package com.Doctor.Thief;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R3.CraftServer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.listeners.enitty.EntityDamageByEntity;
import com.Doctor.Thief.listeners.inventory.*;
import com.Doctor.Thief.listeners.player.*;
import com.Doctor.Thief.listeners.server.PingListener;
import com.Doctor.Thief.states.GameState;
import com.Doctor.Thief.utils.BlockUtil;
import com.Doctor.Thief.utils.ChatUtil;
import com.Doctor.Thief.utils.EconomyUtil;
import com.Doctor.Thief.utils.Game;
import com.Doctor.Thief.utils.ScoreboardUtil;
import com.Doctor.Thief.utils.ShopUtil;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		EconomyUtil.setupEconomy();
		ShopUtil.setupInventory();
		for (Entity en: Bukkit.getWorld(getConfig().getString("center.world")).getEntities()) {
			if (!(en instanceof Player)) {
				en.remove();
			}
		}
		for (Player p1 : Bukkit.getOnlinePlayers()) {
			p1.setGameMode(GameMode.ADVENTURE);
			for (Player p2 : Bukkit.getOnlinePlayers()) {
				p1.showPlayer(p2);
				p2.showPlayer(p1);
			}
		}
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		ScoreboardUtil.setup();
		ScoreboardUtil.newGame();
		registerListeners();
		getConfig().options().copyDefaults(true);
		saveConfig();
	    reloadConfig();
	    GameState.setState(GameState.IN_LOBBY);
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
	    	public void run() {
	    		for (Player p : Bukkit.getOnlinePlayers()) {
	    			if (!(p.getGameMode() == GameMode.CREATIVE)) {
	    			p.setFlying(false);
	    			}
	    		}
	    	}
	    }, 0L, 1L);
	    
	}
	
	@Override
	public void onDisable() {
		BlockUtil.repair();
	}

	

	public void registerListeners(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerChat(this), this);
		pm.registerEvents(new PlayerDamage(this), this);
		pm.registerEvents(new PlayerDrop(this), this);
		pm.registerEvents(new AsyncPlayerPreLogin(this), this);
		pm.registerEvents(new PlayerDeath(this), this);
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(new DoubleJump(this), this);
		pm.registerEvents(new BlockBreak(this), this);
		pm.registerEvents(new PlayerPickup(this), this);
		pm.registerEvents(new PlayerInteract(this), this);
		pm.registerEvents(new InventoryClose(this), this);
		pm.registerEvents(new MGListener(this), this);
		pm.registerEvents(new EntityDamageByEntity(this), this);
		pm.registerEvents(new ArrowHit(this), this);
		pm.registerEvents(new PlayerArmorAndWeapon(this), this);
		pm.registerEvents(new PingListener(this), this);
		//pm.registerEvents(new BlockPound(this), this);
		pm.registerEvents(new EntityExplodeEvent(this), this);
		pm.registerEvents(new PlayerDisconnect(this), this);

	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("thief")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(args.length == 0){
					ChatUtil.sendMessage(player, "No arguments!");
					return true;
				}else if(args.length == 1){
					if(args[0].equalsIgnoreCase("setlobby")){
						Location loc = player.getLocation();
						World world = loc.getWorld();
						double x = (double) loc.getBlockX();
						x += 0.5;
						double y = (double) loc.getBlockY();
						y += 0.5;
						double z = (double) loc.getBlockZ();
						z += 0.5;
						getConfig().set("lobby.world", world.getName());
						getConfig().set("lobby.x", x);
						getConfig().set("lobby.y", y);
						getConfig().set("lobby.z", z);
						ChatUtil.sendMessage(player, "Lobby set at " + "x: " + x + " y: " + y + " z: " + z);
						saveConfig();
					}
					else if(args[0].equalsIgnoreCase("center")){
						Location loc = player.getLocation();
						World world = loc.getWorld();
						double x = (double) loc.getBlockX();
						x += 0.5;
						double y = (double) loc.getBlockY();
						y += 0.5;
						double z = (double) loc.getBlockZ();
						z += 0.5;
						getConfig().set("center.world", world.getName());
						getConfig().set("center.x", x);
						getConfig().set("center.y", y);
						getConfig().set("center.z", z); 
						ChatUtil.sendMessage(player, "Center set at " + "x: " + x + " y: " + y + " z: " + z);

						saveConfig();

					}
					if (args[0].equalsIgnoreCase("setspec")) {
						Location loc = player.getLocation();
						World world = loc.getWorld();
						double x = (double) loc.getBlockX();
						x += 0.5;
						double y = (double) loc.getBlockY();
						y += 0.5;
						double z = (double) loc.getBlockZ();
						z += 0.5;
						getConfig().set("spec.world", world.getName());
						getConfig().set("spec.x", x);
						getConfig().set("spec.y", y);
						getConfig().set("spec.z", z); 
						
						saveConfig();
						ChatUtil.sendMessage(player, "Spectator spawn set at " + "x: " + x + " y: " + y + " z: " + z);
					}
					if(args[0].equalsIgnoreCase("start")){
						ScoreboardUtil.forceStart();
						ScoreboardUtil.nodamage = false;
						GameState.setState(GameState.IN_GAME);
						Game.start();
					}
					if(args[0].equalsIgnoreCase("stop")){
						//TODO STOP
					}
					return true;
				}
				
			}

		}
		return false;
	}

}
